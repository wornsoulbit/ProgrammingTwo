
package coursegradebookfinal;

/**
 * Class of a Student.
 * 
 * @author Alex Vasil
 */
public class Student {
    
    private String name; //Name of the student.
    private int id; //ID number of the student.

    /**
     * Initial Constructor with default values.
     * 
     * @param name Name of the student.
     * @param id ID number of the student.
     */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    /**
     * Copy constructor of a Student.
     * 
     * @param anotherStudent Student being copied from.
     */
    public Student(Student anotherStudent) {
        this.name = anotherStudent.name;
        this.id = anotherStudent.id;
    }

    /**
     * Formated string of a student.
     * 
     * @return Formated string of a student.
     */
    @Override
    public String toString() {
        String strOut = "";
        strOut += String.format("%-11d %-20s", id, name);
        return strOut;
    }
    
    /**
     * Sees if two Student Objects are equal to each other.
     * 
     * @param obj Student being compared to.
     * @return if both students are equal to each other.
     */
    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        
        if (!(obj instanceof Student))
            return false;
        
        return name.equals(student.name)
                && id == student.id;
    }
    
    /**
     * Gets the name of the student.
     * 
     * @return The student name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     * 
     * @param name The student name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the ID of the student.
     * 
     * @return The student ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the student ID.
     * 
     * @param id The student ID.
     */
    public void setId(int id) {
        this.id = id;
    }
}
