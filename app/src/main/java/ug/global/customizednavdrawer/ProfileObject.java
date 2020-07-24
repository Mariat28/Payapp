package ug.global.customizednavdrawer;

public class ProfileObject {
    private String name,course, university;

    public ProfileObject(String name,String course, String university) {
        this.name = name;
        this.course = course;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getUniversity() {
        return university;
    }
}
