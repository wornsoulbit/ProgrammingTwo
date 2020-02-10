
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
        double finalGrade = 0;
        
        //Calculates the weighted grade for that mark and adds it to the final grade.
        for (int i = 0; i < assessmentWeights.length; i++) {
            finalGrade += grades[i] * (assessmentWeights[i] / 100);
        }
        
        return finalGrade;
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

    /**
     * Compares two double[] arrays to each other and see if they have the same values.
     * 
     * @param x An array.
     * @param y Another array.
     * @return If both arrays have the same values.
     */
    public boolean compareArray(double[] x, double[] y) {
        if (x.length != y.length)
            return false;
        
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i])
                return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        String strOut = "";
        
        strOut += String.format("%-15s: %s", "Grades", );
        
        return strOut;
    }
    
    /**
     * Sees if two Student grade records have the same values.
     * 
     * @param obj Student grade record being compared.
     * @return If both Student grade records have the same values.
     */
    @Override
    public boolean equals(Object obj) {
        StudentGradeRecord studentGradeRecord = (StudentGradeRecord) obj;
        
        if (!(obj instanceof StudentGradeRecord))
            return false;
        
        return this.student.getName().equals(studentGradeRecord.student.getName())
                && this.student.getId() == studentGradeRecord.student.getId()
                && compareArray(this.grades, studentGradeRecord.grades);
        
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
