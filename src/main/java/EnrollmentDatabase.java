import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Path("/enrollments")
public class EnrollmentDatabase {
    private HashMap<String,ArrayList<Course>> enrolledCourseDatabase = new HashMap<>();
    private HashMap<String,ArrayList<Concession>> concessionDatabase = new HashMap<>();
    private HashMap<String,ArrayList<Course>> completedCourseDatabase = new HashMap<>();
    private HashMap<String,ArrayList<Course>> courseRequirements = new HashMap<>();


    // This constructor adds a pre-enrolled course for the mocked user
    public EnrollmentDatabase(){
        ArrayList<Course> enrolledCourses = new ArrayList<>();

        ArrayList<TimetableEvent> courseSchedule = new ArrayList<TimetableEvent>();
        TimetableEvent lec = new TimetableEvent(LocalDateTime.parse("2014-04-28T16:00:00.00"), 1, TimetableEvent.EventType.Lecture);
        TimetableEvent tut = new TimetableEvent(LocalDateTime.parse("2014-04-29T16:00:00.00"), 1, TimetableEvent.EventType.Tutorial);
        TimetableEvent lab = new TimetableEvent(LocalDateTime.parse("2014-04-30T16:00:00.00"), 1, TimetableEvent.EventType.Lab);

        courseSchedule.add(lec);
        courseSchedule.add(tut);
        courseSchedule.add(lab);


        ArrayList<Person> teachingStaff = new ArrayList<Person>();
        Person.CourseRole[] roles1 =  {Person.CourseRole.Lecturer};
        Person p1 = new Person("Sam Neale", new ArrayList<Person.CourseRole>(Arrays.<Person.CourseRole>asList(roles1)));

        Person.CourseRole[] roles2 =  {Person.CourseRole.Lecturer};
        Person p2 = new Person("Ryan Lim", new ArrayList<Person.CourseRole>(Arrays.<Person.CourseRole>asList(roles2)));

        teachingStaff.add(p1);
        teachingStaff.add(p2);


        Course c1 = new Course("SOFTENG 754", (LocalDateTime.parse("2014-03-28T16:00:00.00")), (LocalDateTime.parse("2014-03-28T16:00:00.00")), courseSchedule);

        enrolledCourses.add(c1);
        this.addEnrollment("rightUsrN", enrolledCourses);
    }

    public void addEnrollment(String username, ArrayList<Course> enrollmentList){
        if (!enrolledCourseDatabase.containsKey(username)){
            enrolledCourseDatabase.put(username, new ArrayList<>());
        }
        ArrayList<Course> list = enrolledCourseDatabase.get(username);
        list.addAll(enrollmentList);
    }

    @GET
    @Path("/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEnrolledCourses(@PathParam("username") String username){
        return Response.ok().entity(enrolledCourseDatabase.get(username)).build();
    }

    public void addConcessions(String username, ArrayList<Concession> concessionList){
        if (!concessionDatabase.containsKey(username)){
            concessionDatabase.put(username, new ArrayList<>());
        }
        ArrayList<Concession> list = concessionDatabase.get(username);
        list.addAll(concessionList);
    }
    public ArrayList<Concession> getConcessions(String username){
        return concessionDatabase.get(username);
    }

    public ArrayList<Course> getCompletedCourses(String username) { return completedCourseDatabase.get(username); }

    public ArrayList<Course> getCourseRequirements(String username) { return completedCourseDatabase.get(username); }


    @POST
    @Path("{username}/unenroll")
    public Response unenroll(@PathParam("username") String username, ArrayList<Course> courseToDrop){
        ArrayList<Course> currentEnrollments = enrolledCourseDatabase.get(username);
        ArrayList<Course> coursesAfterUnenroll = (ArrayList<Course>) currentEnrollments.clone();

        for (Course c : currentEnrollments){
            for (Course drop : courseToDrop){
                if (c.getCourseName().equals(drop.getCourseName())){
                    coursesAfterUnenroll.remove(drop);
                }
            }
        }

        // Update the DB
        enrolledCourseDatabase.put(username, coursesAfterUnenroll);

        return Response.ok().entity(coursesAfterUnenroll).build();
    }
}
