import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
public class CourseCatalog {

    private static CourseCatalog instance;

    private ArrayList<Course> courseCatalog = new ArrayList<>();
    private ArrayList<Course> searchResults = new ArrayList<>();

    public void add(Course course){
        courseCatalog.add(course);
    }
    public ArrayList<Course> getAllCourses(){
        return courseCatalog;
    }

    private CourseCatalog(){



        ArrayList<TimetableEvent> courseSchedule = new ArrayList<TimetableEvent>();
        TimetableEvent lec = new TimetableEvent(LocalDateTime.parse("2014-04-28T16:00:00.00"), 1, TimetableEvent.EventType.Lecture);
        TimetableEvent tut = new TimetableEvent(LocalDateTime.parse("2014-04-29T16:00:00.00"), 1, TimetableEvent.EventType.Tutorial);
        TimetableEvent lab = new TimetableEvent(LocalDateTime.parse("2014-04-30T16:00:00.00"), 1, TimetableEvent.EventType.Lab);

        courseSchedule.add(lec);
        courseSchedule.add(tut);
        courseSchedule.add(lab);

        ArrayList<TimetableEvent> courseSchedule1 = new ArrayList<TimetableEvent>();
        TimetableEvent lec1 = new TimetableEvent(LocalDateTime.parse("2020-04-28T10:00:00.00"), 1, TimetableEvent.EventType.Lecture);
        TimetableEvent tut1 = new TimetableEvent(LocalDateTime.parse("2020-04-29T10:00:00.00"), 1, TimetableEvent.EventType.Tutorial);
        TimetableEvent lab1 = new TimetableEvent(LocalDateTime.parse("2020-04-30T10:00:00.00"), 1, TimetableEvent.EventType.Lab);

        courseSchedule1.add(lec1);
        courseSchedule1.add(tut1);
        courseSchedule1.add(lab1);

        ArrayList<TimetableEvent> courseSchedule2 = new ArrayList<TimetableEvent>();
        TimetableEvent lec2 = new TimetableEvent(LocalDateTime.parse("2020-04-28T11:00:00.00"), 1, TimetableEvent.EventType.Lecture);
        TimetableEvent tut2 = new TimetableEvent(LocalDateTime.parse("2020-04-29T11:00:00.00"), 1, TimetableEvent.EventType.Tutorial);
        TimetableEvent lab2 = new TimetableEvent(LocalDateTime.parse("2020-04-30T11:00:00.00"), 1, TimetableEvent.EventType.Lab);

        courseSchedule2.add(lec2);
        courseSchedule2.add(tut2);
        courseSchedule2.add(lab2);

        Course c1 = new Course("SOFTENG 754", (LocalDateTime.parse("2020-05-28T16:00:00.00")), (LocalDateTime.parse("2020-07-28T16:00:00.00")), courseSchedule);
        Course c2 = new Course("SOFTENG 701", (LocalDateTime.parse("2020-05-28T16:00:00.00")), (LocalDateTime.parse("2020-07-28T16:00:00.00")), courseSchedule1);
        Course c3 = new Course("COMPSYS 726", (LocalDateTime.parse("2020-05-28T16:00:00.00")), (LocalDateTime.parse("2020-07-28T16:00:00.00")), courseSchedule2);

        courseCatalog.add(c1);
        courseCatalog.add(c2);
        courseCatalog.add(c3);
    }

    @GET
    public ArrayList<Course> search(@QueryParam("search") String userSearch){
        searchResults.clear();
        if (userSearch.length() == 0) {
            return searchResults;
        }
        for (Course course : courseCatalog){
            if (course.getCourseName().contains(userSearch)){
                searchResults.add(course);
            }
        }
        return searchResults;
    }

    public static CourseCatalog getInstance(){
        if (instance == null){
            instance = new CourseCatalog();
        }
        return instance;
    }
}
