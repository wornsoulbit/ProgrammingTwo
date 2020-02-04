
package coursegradebook;

/**
 * The courses available.
 * 
 * @author Alex Vasil
 */
public class Course {
    private String name;
    private String number;
    private String section;
    private String semester;
    private String teacher;
    private String room;
    private int year;

    public Course(String name, String number, String section, String semester, String teacher, String room, int year) {
        this.name = name;
        this.number = number;
        this.section = section;
        this.semester = semester;
        this.teacher = teacher;
        this.room = room;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", number=" + number + ", section=" + section + ", semester=" + semester + ", teacher=" + teacher + ", room=" + room + ", year=" + year + '}';
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
