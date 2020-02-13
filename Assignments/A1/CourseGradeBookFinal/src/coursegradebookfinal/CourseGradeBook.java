
package coursegradebookfinal;

/**
 * Grade book of a course.
 * 
 * @author Alex Vasil
 */
public class CourseGradeBook {
    private String[] caNames;
    private double[] caWeights;
    private Course course;
    private StudentGradeRecord[] gradeList;
    private int gradesRecordCount;

    public CourseGradeBook(Course course, String[] caNames, double[] caWeights) {
        if (caNames.length != caWeights.length)
            throw new IllegalArgumentException("Assignment Name and Assignment Weight aren't of equal length.");
        
        gradeList = new StudentGradeRecord[1];
        gradesRecordCount = 0;
        
        this.caWeights = caWeights;
        this.caNames = caNames;
        this.course = course;
    }
    
    /**
     * Checks to see if the grade list is full.
     * 
     * @return If the grade list is full.
     */
    public boolean isFull() {
        return gradesRecordCount == gradeList.length;
    }
    
    /**
     * Adds a student grade into the record.
     * 
     * @param student The student to be added to the record.
     * @param grades The grade to be added to the record.
     */
    public void addGradeRecord(Student student, double... grades) {
        if (this.caNames.length != grades.length)
            throw new IllegalArgumentException("Length of grades does not equal length of assessment names.");
        
        if (isFull())
            doubleGradeListCapacity();
            
        gradeList[gradesRecordCount] = new StudentGradeRecord(grades, student);
        gradesRecordCount++;
    }
    
    /**
     * Doubles the capacity of the grade list.
     */
    private void doubleGradeListCapacity() {
        StudentGradeRecord[] newGradeList = new StudentGradeRecord[gradeList.length * 2];
        for (int i = 0; i < gradesRecordCount; i++) {
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
        double minNum = numbers[0];
        
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
     * @param numbers Array numbers used to find the standard deviation.
     * @return The standard deviation of the array.
     */
    public static double findArrayStandardDev(double[] numbers) {
        double standardDev;
        double sum = 0;
        double avg = findArrayAverage(numbers);
        
        for (double numbers1 : numbers) 
            sum += Math.pow(numbers1 - avg, 2);
        
        standardDev = Math.sqrt(sum / numbers.length);
        return standardDev;
    }
    
    /**
     * Calculates the total weights of all assignments combined.
     * 
     * @return The total weights.
     */
    public double computeTotalWeight() {
        double sum = 0;
        for (double caWeights1 : caWeights)
            sum += caWeights1;
        
        return sum;
    }
    
    /**
     * Calculates the final grade of each student.
     * 
     * @return The final grade of each student and adds it to the gradeList.
     */
    public double[] getFinalsArray() {
        double[] finalGrades = new double[gradesRecordCount];
        for (int i = 0; i < gradesRecordCount; i++)
            finalGrades[i] = gradeList[i].computeFinalGrade(caWeights);
        
        return finalGrades;
    }
    
    /**
     * Gets all grades of a certain assessment.
     * 
     * @param k Gets the K'th assessment.
     * @return All grades of K'th assessment.
     */
    public double[] getAssessmentArray(int k) {
        if (k < 0 || k > gradeList.length)
            throw new IllegalArgumentException("K is out of bounds of gradeList");
        
        double[] assGrades = new double[this.gradesRecordCount];
        for (int i = 0; i < this.gradesRecordCount; i++) {
            assGrades[i] = gradeList[i].getGrades(k);
        }
        
        return assGrades;
    }
    
    /**
     * Gets the highest grade from the k'th assessment.
     * 
     * @param k Assessment to find the highest grade.
     * @return The highest grade.
     */
    public double findMaxAssessment(int k) {
        double[] assessmentGrades = getAssessmentArray(k);
        
        if (k < 0 || k > assessmentGrades.length)
            throw new IllegalArgumentException("K is out of bounds of gradeList");
        
        double maxNum = 0;
        
        for (double assessmentGrades1 : assessmentGrades) 
            if (assessmentGrades1 > maxNum) 
                maxNum = assessmentGrades1;
        
        return maxNum;
    }
    
    /**
     * Gets the lowest grade from the k'th assessment.
     * 
     * @param k Assessment to find the lowest grade.
     * @return The lowest grade.
     */
    public double findMinAssessment(int k) {
        double[] assessmentGrades = getAssessmentArray(k);
        
        if (k < 0 || k > assessmentGrades.length)
            throw new IllegalArgumentException("K is out of bounds of gradeList");
        
        double minNum = assessmentGrades[0];
        
        for (double assessmentGrades1 : assessmentGrades) 
            if (assessmentGrades1 < minNum) 
                minNum = assessmentGrades1;
        
        return minNum;
    }
    
    /**
     * Gets the average grade from the k'th assessment.
     * 
     * @param k Assessment to find the average grade from.
     * @return The average grade.
     */
    public double findAvgAssessment(int k) {
        double[] assessmentGrades = getAssessmentArray(k);
        
        if (k < 0 || k > assessmentGrades.length)
            throw new IllegalArgumentException("K is out of bounds of gradeList");
        
        double sum = 0;
        for (double assessmentGrades1 : assessmentGrades) 
            sum += assessmentGrades1;
            
        double average = sum / assessmentGrades.length;
        return average;
    }
    
    /**
     * Gets the standard deviation of the k'th assessment.
     * 
     * @param k Assessment to find the standard deviation of.
     * @return The standard deviation.
     */
    public double findStdevAssessment(int k) {
        double[] assessmentGrades = getAssessmentArray(k);
        
        if (k < 0 || k > assessmentGrades.length)
            throw new IllegalArgumentException("K is out of bounds of gradeList");
        
        double standardDev;
        double sum = 0;
        double avg = findAvgAssessment(k);
        
        for (double assessmentGrades1 : assessmentGrades) 
            sum += Math.pow(assessmentGrades1 - avg, 2);
        
        standardDev = Math.sqrt(sum / assessmentGrades.length);
        return standardDev;
    }
    
    /**
     * Prints the max mark of each assessment.
     * 
     * @return A formated string of the max grades.
     */
    public String toStringMaxAssessments() {
        String strOut = String.format("%28s:   ", "Max");
        for (int i = 0; i < caWeights.length; i++)
            strOut += String.format("%-5.0f", findArrayMaximum(getAssessmentArray(i)));
        strOut += String.format("%-5.0f", findArrayMaximum(getFinalsArray()));
        strOut += String.format("%-5c", 
                StudentGradeRecord.computeLetterGrades(findArrayMaximum(getFinalsArray())));
        return strOut;
    }
    
    /**
     * Prints the minimum mark of each assessment.
     * 
     * @return A formated string of the minimum grades.
     */
    public String toStringMinAssessments() {
        String strOut = String.format("%28s:   ", "Min");
        for (int i = 0; i < caWeights.length; i++)
            strOut += String.format("%-5.0f", findArrayMinimum(getAssessmentArray(i)));
        strOut += String.format("%-5.0f", findArrayMinimum(getFinalsArray()));
        strOut += String.format("%-5c", 
                StudentGradeRecord.computeLetterGrades(findArrayMinimum(getFinalsArray())));
        return strOut;
    }
    
    /**
     * Prints the minimum mark of each assessment.
     * 
     * @return A formated string of the minimum grades.
     */
    public String toStringAvgAssessments() {
        String strOut = String.format("%28s:   ", "Average");
        for (int i = 0; i < caWeights.length; i++)
            strOut += String.format("%-5.0f", findArrayAverage(getAssessmentArray(i)));
        strOut += String.format("%-5.0f", findArrayAverage(getFinalsArray()));
        strOut += String.format("%-5c", 
                StudentGradeRecord.computeLetterGrades(findArrayAverage(getFinalsArray())));
        return strOut;
    }
    
    /**
     * Prints the minimum mark of each assessment.
     * 
     * @return A formated string of the minimum grades.
     */
    public String toStringStdevAssessments() {
        String strOut = String.format("%28s:   ", "Standard Deviation");
        for (int i = 0; i < caWeights.length; i++)
            strOut += String.format("%-5.0f", findArrayStandardDev(getAssessmentArray(i)));
        strOut += String.format("%-5.0f", findArrayStandardDev(getFinalsArray()));
        return strOut;
    }
    
    /**
     * Prints the legend of all assessment names, weights, and weights/50
     * 
     * @return the formated legend.
     */
    public String toStringAssessmentLegend() {
        String strOut = "-------------------------------------------\n";
        strOut += "Assessment       Name  Weight/50.0  Weight%\n";
        for (int i = 0; i < caNames.length; i++)
            strOut += String.format("%6s %14s %10.0f %8.1f%s\n", 
                    "A" + (i + 1), caNames[i], caWeights[i] / 2, caWeights[i], "%");
        
        strOut += "-------------------------------------------\n";
        strOut += String.format("%6s %14s\n", "fin", "final grade");
        strOut += String.format("%6s %14s\n", "grd", "letter grade");
        return strOut;
    }
    
    /**
     * Prints out the assignments with all grades and student names formated.
     * 
     * @return the formated string.
     */
    private String printAssignments() {        
        String strOut = "";
        for (int i = 0; i < this.caWeights.length; i++) {
            strOut += String.format("%s", gradeList[i].getStudent().toString());
            for (int j = 0; j < gradeList[i].getNumberOfAssessments(); j++)
                strOut += String.format("%-5.0f", gradeList[i].getGrades(j));
            strOut += String.format("%-5.0f", gradeList[i].computeFinalGrade(caWeights));
            strOut += StudentGradeRecord.computeLetterGrades(gradeList[i].computeFinalGrade(caWeights));
            strOut += "\n";
        }
            
        return strOut;
    }
    
    /**
     * Formated string of all the data in CourseGradeBook.
     * 
     * @return the formated string.
     */
    @Override
    public String toString() {
        String strOut = "";
        strOut += String.format("%50s\n", "Student Grade Table");
        strOut += "---------------------------------------------------------------------------------\n";
        strOut += String.format("%-11s %-19s A1   A2   A3   A4   A5   A6   A7   A8   fin   grd\n", "ID Number", "Student Name");
        strOut += "---------------------------------------------------------------------------------\n";
        strOut += String.format(printAssignments());
        strOut += "---------------------------------------------------------------------------------";
        return strOut;
    }
}
