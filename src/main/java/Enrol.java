import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/enrollments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
public class Enrol {

    private EnrollmentDatabase enrollmentDatabase;
    private EnrollmentProcessor enrollmentProcessor;
    private EnrollmentRequestVerifier enrollmentRequestVerifier;

    public Enrol() {

        // init fields
        enrollmentDatabase = new EnrollmentDatabase();
        enrollmentProcessor = new EnrollmentProcessor(enrollmentDatabase);
        enrollmentRequestVerifier = new EnrollmentRequestVerifier(new EnrollmentDateVerifier(), new ClashVerifier(), new PrerequisitesVerifier());


        // mock user data for pre-enrolled course
        ArrayList<Course> enrolledCourses = new ArrayList<>();
        enrolledCourses.add(CourseCatalog.getInstance().search("SOFTENG 754").get(0));
        enrollmentDatabase.addEnrollment("rightUsrN", enrolledCourses);
    }

    @GET
    @Path("/{username}")
    public Response getEnrolledCourses(@PathParam("username") String username){
        return Response.ok().entity(enrollmentDatabase.getEnrolledCourses(username)).build();
    }
    
    @POST
    @Path("{username}/unenroll")
    public Response unenroll(@PathParam("username") String username, List<String> courseNames){

        ArrayList<Course> coursesToDrop = new ArrayList<>();
        for (String courseName:courseNames){
            coursesToDrop.add(CourseCatalog.getInstance().search(courseName).get(0));
        }

        return Response.ok().entity(enrollmentDatabase.unenroll(username, coursesToDrop)).build();
    }

    @POST
    @Path("/{username}/enroll")
    public Response enroll(@PathParam("username") String username, List<String> courseNames){
        ArrayList<Course> courses = new ArrayList<>();
        for (String courseName:courseNames){
            courses.add(CourseCatalog.getInstance().search(courseName).get(0));
        }
        
        // Check enrollment conditions are met
        EnrollmentRequestVerifier.EnrollmentResult result =
                enrollmentRequestVerifier.verify("username", courses, enrollmentDatabase,
                        LocalDateTime.parse("2020-06-10T16:00:00.00")
                );
        
        courses.removeAll(result.getCourses());
        
        enrollmentDatabase.addEnrollment(username,courses);
        return Response.ok(result.getResult()).build();
    }
}