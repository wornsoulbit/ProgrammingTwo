
package coursegradebook;

/**
 *
 * @author Alex Vasil
 */
public class StudentGradeRecord {
    
    private double[] grades; //Grades of a student.
    private Student student; //

    public StudentGradeRecord(double[] grades, Student student) {
        this.grades = grades;
        this.student = student;
    }
    
    
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
    
    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
