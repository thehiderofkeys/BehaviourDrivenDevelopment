import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
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

        createCourse("SOFTENG 401",
                "2014-04-28T10:00:00.00","2014-04-29T10:00:00.00","2014-04-30T10:00:00.00",
                "2020-05-28T16:00:00.00","2020-07-28T16:00:00.00",50,new ArrayList<>());
        createCourse("SOFTENG 402",
                "2014-04-28T12:00:00.00","2014-04-29T12:00:00.00","2014-04-30T12:00:00.00",
                "2020-05-28T16:00:00.00","2020-07-28T16:00:00.00",50,new ArrayList<>());
        createCourse("SOFTENG 754",
                "2014-04-28T16:00:00.00","2014-04-29T16:00:00.00","2014-04-30T16:00:00.00",
                "2020-05-28T16:00:00.00","2020-07-28T16:00:00.00",50,new ArrayList<>());
        createCourse("SOFTENG 701",
                "2014-04-28T10:00:00.00","2014-04-29T10:00:00.00","2014-04-30T10:00:00.00",
                "2020-05-28T16:00:00.00","2020-07-28T16:00:00.00",50,new ArrayList<>());
        ArrayList<String> prereq = new ArrayList<>(Arrays.asList("SOFTENG 401", "SOFTENG 402"));
        createCourse("SOFTENG 702",
                "2014-04-28T12:00:00.00","2014-04-29T12:00:00.00","2014-04-30T12:00:00.00",
                "2020-05-28T16:00:00.00","2020-07-28T16:00:00.00",50, prereq);
        createCourse("COMPSYS 726",
                "2014-04-28T11:00:00.00","2014-04-29T11:00:00.00","2014-04-30T11:00:00.00",
                "2019-05-28T16:00:00.00","2019-07-28T16:00:00.00",50,new ArrayList<>());
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

    private void createCourse(String name,String lecTime,String tutTime,String labTime,String openTime, String closeTime,int seats, ArrayList<String> prereq){
        ArrayList<TimetableEvent> courseSchedule = new ArrayList<>();
        TimetableEvent lec = new TimetableEvent(LocalDateTime.parse(lecTime), 1, TimetableEvent.EventType.Lecture);
        TimetableEvent tut = new TimetableEvent(LocalDateTime.parse(tutTime), 1, TimetableEvent.EventType.Tutorial);
        TimetableEvent lab = new TimetableEvent(LocalDateTime.parse(labTime), 1, TimetableEvent.EventType.Lab);

        courseSchedule.add(lec);
        courseSchedule.add(tut);
        courseSchedule.add(lab);

        Course c = new Course(name, (LocalDateTime.parse(openTime)), (LocalDateTime.parse(closeTime)), courseSchedule,seats,prereq);
        courseCatalog.add(c);
    }

    public static CourseCatalog getInstance(){
        if (instance == null){
            instance = new CourseCatalog();
        }
        return instance;
    }
}
