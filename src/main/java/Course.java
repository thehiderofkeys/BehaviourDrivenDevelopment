

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class Course {

    private LocalDateTime openingDate;
    private LocalDateTime closingDate;
    private String courseName;
    private ArrayList<TimetableEvent> courseSchedule;
    private int remainingSeats = 0;
    private LinkedList<RequestObject> waitList;
    private ArrayList<String> prerequisites = new ArrayList<>();

    public Course (String courseName, LocalDateTime openingDate, LocalDateTime closingDate,  ArrayList<TimetableEvent> courseSchedule){
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.courseName = courseName;
        this.courseSchedule = courseSchedule;
        this.waitList = new LinkedList<>();
    }

    public Course(String courseName, LocalDateTime openingDate, LocalDateTime closingDate,  ArrayList<TimetableEvent> courseSchedule, int remainingSeats) {
        this(courseName, openingDate, closingDate, courseSchedule);
        this.remainingSeats = remainingSeats;
    }

    public Course(String courseName, LocalDateTime openingDate, LocalDateTime closingDate,
                  ArrayList<TimetableEvent> courseSchedule, int remainingSeats, ArrayList<String> prerequisites) {
        this(courseName, openingDate, closingDate, courseSchedule, remainingSeats);
        this.prerequisites = prerequisites;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getOpeningDate(){
        return this.openingDate;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getClosingDate(){
        return this.closingDate;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public ArrayList<TimetableEvent> getCourseSchedule(){
        return courseSchedule;
    }

    public ArrayList<String> getPrerequisites() { return prerequisites; }

    public boolean reserveSeat() {
        if (remainingSeats > 0){
            remainingSeats--;
            return true;
        }
        return false;
    }

    public void releaseSeat() {
        remainingSeats++;
    }

    public void addToWaitList(RequestObject request) {
        waitList.addLast(request);
    }

    public RequestObject popWaitList() {
        try {
            return waitList.removeFirst();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
