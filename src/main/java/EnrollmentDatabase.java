import java.util.ArrayList;;
import java.util.HashMap;

public class EnrollmentDatabase {
    private HashMap<String,ArrayList<Course>> enrolledCourseDatabase = new HashMap<>();
    private HashMap<String,ArrayList<Concession>> concessionDatabase = new HashMap<>();
    private HashMap<String,ArrayList<Course>> completedCourseDatabase = new HashMap<>();
    private HashMap<String,ArrayList<Course>> courseRequirements = new HashMap<>();


    public EnrollmentDatabase(){
    }

    public void addEnrollment(String username, ArrayList<Course> enrollmentList){
        if (!enrolledCourseDatabase.containsKey(username)){
            enrolledCourseDatabase.put(username, new ArrayList<>());
        }
        ArrayList<Course> list = enrolledCourseDatabase.get(username);
        list.addAll(enrollmentList);
    }


    public ArrayList<Course> getEnrolledCourses(String username){
        return enrolledCourseDatabase.get(username);
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

    public void addCompletedCourse(String username, Course c) {
        if (!completedCourseDatabase.containsKey(username)){
            completedCourseDatabase.put(username,new ArrayList<>());
        }
        completedCourseDatabase.get(username).add(c);
    }

    public ArrayList<Course> getCompletedCourses(String username) { return completedCourseDatabase.get(username); }

    public ArrayList<Course> getCourseRequirements(String username) { return completedCourseDatabase.get(username); }

    public ArrayList<Course> unenroll(String username, ArrayList<Course> courseToDrop){
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

        return coursesAfterUnenroll;
    }
}
