public class Concession {
    private Course course;
    private String username;
    private String reason;
    public Concession(String username, Course course) {
        this.username = username;
        this.course = course;
    }

    public Concession(String username, Course course,String reason) {
        this.username = username;
        this.course = course;
        this.reason = reason;
    }

    public String getUsername() {
        return username;
    }

    public Course getCourse() {
        return course;
    }

    public String getReason() {return reason;}

    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Concession))
            return false;
        Concession c = (Concession)o;
        return username.equals(c.getUsername()) && course.equals(c.course);
    }
}
