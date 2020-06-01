import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/timetable")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
public class TimetableViewer {



    @POST
    public Response getAllTimetableEvents(List<String> givenCourseNameList){
        List<TimetableEvent> combinedTimetableEventList = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        for (String courseName:givenCourseNameList){
            courses.add(CourseCatalog.getInstance().search(courseName).get(0));
        }

        for (Course course : courses){
            List<TimetableEvent> timetableEventList = course.getCourseSchedule();
            for (TimetableEvent timetableEvent : timetableEventList){
                combinedTimetableEventList.add(timetableEvent);
            }
        }
        return Response.ok().entity(combinedTimetableEventList).build();
    }
}
