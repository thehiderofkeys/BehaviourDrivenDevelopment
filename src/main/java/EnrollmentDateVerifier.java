import java.time.LocalDateTime;

public class EnrollmentDateVerifier {
    public boolean isEnrollmentOpen(Course course, LocalDateTime currentDateTime){
        if (currentDateTime.isBefore(course.getOpeningDate())){
            return false;
        }
        if (currentDateTime.isAfter(course.getClosingDate())){
            return false;
        }
        return true;
    }
}
