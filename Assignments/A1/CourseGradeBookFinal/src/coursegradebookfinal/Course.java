
package coursegradebookfinal;

/**
 * Class of a Course.
 * 
 * @author Alex Vasil
 */
public class Course {
    
    private String name; //Name of the course.
    private String number; //ID number of the course.
    private String section; //Section of a course.
    private String semester; //Semester of a course.
    private String teacher; //Teacher of the course.
    private String room; //Classroom of the course.
    private int year; //Year of the course.
    

    
    /**
     * Constructor of a course with all values.
     * 
     * @param name Name of the course.
     * @param number ID of the course.
     * @param section Section of the course.
     * @param semester Semester of the course.
     * @param teacher Teacher of the course.
     * @param room Classroom of the course.
     * @param year Year of the course.
     */
    public Course(String name, String number, String section, String semester, String teacher, String room, int year) {
        this.name = name;
        this.number = number;
        this.section = section;
        this.semester = semester;
        this.teacher = teacher;
        this.room = room;
        this.year = year;
    }

    /**
     * Copy constructor of a Course.
     * 
     * @param anotherCourse Constructor being copied from.
     */
    public Course(Course anotherCourse) {
        this.name = anotherCourse.name;
        this.number = anotherCourse.number;
        this.section = anotherCourse.section;
        this.semester = anotherCourse.semester;
        this.teacher = anotherCourse.teacher;
        this.room = anotherCourse.room;
        this.year = anotherCourse.year; 
    }
    
    /**
     * Formated string of all data in Course class.
     * 
     * @return Formated string.
     */
    @Override
    public String toString() {
        String strOut = "";
        
        strOut += String.format("Course Information\n");
        strOut += String.format("------------------\n");
        strOut += String.format("%-12s: %s\n", "Title", name);
        strOut += String.format("%-12s: %s\n", "Number", number);
        strOut += String.format("%-12s: %s\n", "Section", section);
        strOut += String.format("%-12s: %s\n", "Semester", semester);
        strOut += String.format("%-12s: %s\n", "Year", year);
        strOut += String.format("%-12s: %s\n", "Teacher", teacher);
        strOut += String.format("%-12s: %s\n", "Room", room);
        
        return strOut;
    }

    /**
     * Compares two Courses and sees if they are equal to each other.
     * 
     * @param obj Course object being compared.
     * @return if both Course objects have the same values.
     */
    @Override
    public boolean equals(Object obj) {
        Course course = (Course) obj;
        
        if (!(obj instanceof Course))
            return false;
        
        return name.equals(course.name)
                && number.equals(course.number)
                && section.equals(course.section)
                && semester.equals(course.semester)
                && teacher.equals(course.teacher)
                && room.equals(course.room)
                && year == course.year;
    }
    
    /**
     * Gets the name.
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name Name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the course number.
     * 
     * @return The course number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the course number.
     * 
     * @param number The course number.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets the course section.
     * 
     * @return The course section.
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets the course section.
     * 
     * @param section The course section.
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets the semester of the course.
     * 
     * @return The semester.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester of the course.
     * 
     * @param semester The semester.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets the teacher of the course.
     * 
     * @return The teacher.
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Sets the teacher of the course.
     * 
     * @param teacher The teacher.
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * Gets the room of the course.
     * 
     * @return The room.
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets the room of the course.
     * 
     * @param room The room.
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets the year of the course.
     * 
     * @return The year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the course.
     * 
     * @param year The year.
     */
    public void setYear(int year) {
        this.year = year;
    }
}
