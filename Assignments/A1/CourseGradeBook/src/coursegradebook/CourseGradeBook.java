
package coursegradebook;

/**
 *
 * @author Alex Vasil
 */
public class CourseGradeBook {
    private int gradeRecordCount;
    private double[] caWeights;
    private String[] caNames;
    private Course course;
    private StudentGradeRecord gradeList;

    public CourseGradeBook(double[] caWeights, String[] caNames, Course course) {
        this.caWeights = caWeights;
        this.caNames = caNames;
        this.course = course;
    }
    
    public boolean isFull() {
        return gradeRecordCount == gradeList.length;
    }
    
}
