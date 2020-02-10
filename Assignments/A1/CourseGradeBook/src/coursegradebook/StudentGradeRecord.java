package coursegradebook;

/**
 *
 * @author Alex Vasil
 */
public class StudentGradeRecord {

    private double[] grade; //Grades of a student.
    private Student student;

    public StudentGradeRecord(double[] grade, Student student) {
        this.grade = grade;
        this.student = student;
    }

    /**
     * Calculates the final grade based on the existing grades and the weight of
     * the grades.
     *
     * @param assessmentWeights Weights of the grades.
     * @return Returns the final grade.
     */
    public double computeFinalGrade(double[] assessmentWeights) {
        
        return -1;
    }

    /**
     * Calculates the letter grade and returns the letter.
     *
     * @param grade the grade thats to be converted to a letter.
     * @return a letter based on the grade given.
     */
    public static double computeLetterGrades(char grade) {
        if (grade >= 90)
            return 'A';
        else if (grade >= 80)
            return 'B';
        else if (grade >= 70)
            return 'C';
        else if (grade >= 60)
            return 'D';
        else 
            return 'F';
    }

    /**
     * Gets the grade at K'th position.
     *
     * @param k position of the grade.
     * @return Returns the K'th grade.
     */
    public double getGrades(int k) {
        if (k > grade.length || k < grade.length) 
            throw new IllegalArgumentException("k is out of bounds of the array");
        
        return grade[k];
    }

    public void setGrades(double[] grades) {
        this.grade = grades;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
