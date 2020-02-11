
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
     * @param assignmentWeights Assessment weights.
     * @param assignmentName Assessment names.
     * @param course Specific course.
     */
    public CourseGradeBook(double[] assignmentWeights, String[] assignmentName, Course course) {
        if (assignmentName.length != assignmentWeights.length)
            throw new IllegalArgumentException("Assignment Name and Assignment Weight aren't of equal length.");
        
        this.assignmentWeight = assignmentWeights;
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
    public void addGradeRecord(Student student, double grades) {
        
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
    public double findArraySum(double[] numbers) {
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
    public double findArrayMaximum(double[] numbers) {
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
    public double findArrayMinimum(double[] numbers) {
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
    public double findArrayAverage(double[] numbers) {
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
    public double findArrayStandardDev(double[] numbers) {
        double standardDev;
        double sum = 0;
        
        for (double numbers1 : numbers) 
            sum += numbers1 - findArrayAverage(numbers);
        
        standardDev = sum / numbers.length;
        return standardDev;
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
    
}
