
package coursegradebook;

/**
 *
 * @author Alex Vasil
 */
public class CourseGradeBook {
    private int gradeRecordCount; //Number of students that's in the record.
    private double[] assignmentWeight; //Weights of the assessments.
    private String[] assignmentName; //Names of the assessments.
    private Course course; //Course of CourseGradeBook.
    private StudentGradeRecord[] gradeList; //Reference for each specific student.

    /**
     * Initial constructor of a course grade book with set values.
     * 
     * @param assignmentWeight Assessment weights.
     * @param assignmentName Assessment names.
     * @param course Specific course.
     */
    public CourseGradeBook(double[] assignmentWeight, String[] assignmentName, Course course) {
        if (assignmentName.length != assignmentWeight.length)
            throw new IllegalArgumentException("Assignment Name and Assignment Weight aren't of equal length.");
        
        gradeList = new StudentGradeRecord[1];
        gradeRecordCount = 0;
        
        this.assignmentWeight = assignmentWeight;
        this.assignmentName = assignmentName;
        this.course = course;
    }
    
    /**
     * Checks to see if student grade record is full.
     * 
     * @return If the grade record is full.
     */
    public boolean isFull() {
        return gradeRecordCount == gradeList.length;
    }
    
    /**
     * Adds a grade into the record.
     * 
     * @param student 
     * @param grades Grades to be added.
     */
    public void addGradeRecord(Student student, double... grades) {
        if (this.assignmentName.length != grades.length)
            throw new IllegalArgumentException("Length of grades does not equal length of assessment names.");
        
        if (isFull())
            doubleGradeListCapacity();
            
        gradeList[gradeRecordCount] = new StudentGradeRecord(grades, student);
        gradeRecordCount++;
    }
    
    /**
     * Doubles the capacity of the grade list.
     */
    private void doubleGradeListCapacity() {
        //Doubles the capcity of the gradelist
        StudentGradeRecord[] newGradeList = new StudentGradeRecord[gradeList.length * 2];
        
        //Writes the values of the existing grade list into the new one.
        for (int i = 0; i < gradeList.length; i++) {
            newGradeList[i] = gradeList[i];
        }
        
        gradeList = newGradeList;
    }
    
    /**
     * Finds the total sum of all numbers in a array.
     * 
     * @param numbers Array numbers to be added together.
     * @return Sum of all numbers in the array.
     */
    public static double findArraySum(double[] numbers) {
        double sum = 0;
        
        for (double numbers1 : numbers)
            sum += numbers1;
        
        return sum;
    }
    
    /**
     * Finds the maximum number in a array.
     * 
     * @param numbers Array to be searched for the maximum number.
     * @return The maximum number.
     */
    public static double findArrayMaximum(double[] numbers) {
        double maxNum = 0;
        
        for (double numbers1 : numbers) {
            if (numbers1 > maxNum)
                maxNum = numbers1;
        }
        
        return maxNum;
    }
    
    /**
     * Finds the minimum number in the array.
     * 
     * @param numbers Array to be searched for the minimum number.
     * @return The minimum number.
     */
    public static double findArrayMinimum(double[] numbers) {
        double minNum = 0;
        
        for (double numbers1 : numbers) {
            if (numbers1 < minNum)
                minNum = numbers1;
        }
        
        return minNum;
    }
    
    /**
     * Finds the average of the array.
     * 
     * @param numbers Array numbers to be added to find the average of the array.
     * @return The average of all numbers in the array.
     */
    public static double findArrayAverage(double[] numbers) {
        double sum = 0;
        
        for (double numbers1 : numbers) 
            sum += numbers1;
            
        double average = sum / numbers.length;
        return average;
    }
    
    /**
     * Finds the standard deviation of the array.
     * 
     * @param numbers
     * @return The standard deviation of the array.
     */
    public static double findArrayStandardDev(double[] numbers) {
        double standardDev;
        double sum = 0;
        double avg = findArrayAverage(numbers);
        
        for (double numbers1 : numbers) 
            sum += numbers1 - avg;
        
        standardDev = sum / numbers.length;
        return standardDev;
    }
    
    public String toStringMaxAssessment() {
        String strOut = "";
        return strOut;
    }
    
    public String toStringMinAssessment() {
        String strOut = "";
        return strOut;
    }
    
    public String toStringAvgAssessment() {
        String strOut = "";
        return strOut;
    }
    
    public String toStringStdevAssessment() {
        String strOut = "";
        return strOut;
    }
    
    public String toStringAssessmentLegend() {
        String strOut = "";
        return strOut;
    }
    
    /**
     * Calculates the total weights of all weights combined.
     * 
     * @return the total of all weights
     */
    public double computerTotalWeight() {
        double totalWeights = 0;
        
        for (int i = 0; i < assignmentWeight.length; i++) 
            totalWeights += assignmentWeight[i];
        
        return totalWeights;
    }
    
    /**
     * Gets all grades of a certain assessment.
     * 
     * @param k
     * @return 
     */
    public double[] getAssessmentArray(int k) {
        if (k > gradeList.length || k < gradeList.length)
            throw new IllegalArgumentException("K is out of bounds of gradeList");
        return gradeList[k].getAllGrades();
    }
    
}
