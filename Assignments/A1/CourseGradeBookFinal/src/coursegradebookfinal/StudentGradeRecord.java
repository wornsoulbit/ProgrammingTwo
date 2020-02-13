
package coursegradebookfinal;

/**
 * Record of Student Grades.
 * 
 * @author Alex Vasil
 */
public class StudentGradeRecord {

    private double[] grades; //Grades of a student.
    private Student student;

    public StudentGradeRecord(double[] grade, Student student) {
        this.grades = grade;
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
    public static char computeLetterGrades(double grade) {
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
        if (k < 0 || k > grades.length) 
            throw new IllegalArgumentException("k is out of bounds of the array");
        
        return grades[k];
    }
    
    /**
     * Sets the grade at K'th position.
     * 
     * @param k the position of the grade to be set.
     * @param grade Grade.
     */
    public void setGrade(int k, double grade) {
         if (k < 0 || k > grades.length) 
            throw new IllegalArgumentException("k is out of bounds of the array");
         grades[k] = grade;
    }
    
    /**
     * Gets all the grades.
     * 
     * @return The set of grades.
     */
    public double[] getAllGrades() {
        double[] newGradesList = new double[this.grades.length];
        
        for (int i = 0; i < this.grades.length; i++) {
            newGradesList[i] = this.grades[i];
        }
        
        return newGradesList;
    }
    
    /**
     * Sets all the grades.
     * 
     * @param allGrades 
     */
    public void setAllGrades(double[] allGrades) {
        if (allGrades.length != getNumberOfAssessments())
            throw new IllegalArgumentException("The length of allGrades does not equal the number of assessments.");
            
        for (int i = 0; i < this.grades.length; i++) {
            this.grades[i] = allGrades[i];
        }
    }
    
    /**
     * Gets the number of assessments.
     * 
     * @return the number of assessments there are.
     */
    public int getNumberOfAssessments() {
       return grades.length;
    }
    
    /**
     * Compares two double[] arrays to each other and see if they have the same values.
     * 
     * @param x An array.
     * @param y Another array.
     * @return If both arrays have the same values.
     */
    private boolean compareArray(double[] x, double[] y) {
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
        
        strOut += String.format("%-15s: %s\n", "Student Name", student.getName());
        strOut += String.format("%-15s: %s\n", "Student ID", student.getId());
        strOut += String.format("%-15s:", "Grades");
        for (int i = 0; i < this.grades.length; i++)
            strOut += String.format("%.0f ", this.grades[i]);
        strOut += "\n";
        
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
        
        return this.student.equals(studentGradeRecord.student)
                && compareArray(this.grades, studentGradeRecord.grades);
        
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
