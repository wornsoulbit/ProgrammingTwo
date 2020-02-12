
package coursegradebook;

public class GradeBookTestDriver {
   
    public static void main(String[] args) {

        String title         = "Programming 2";
        String courseNumber  = "420-201-VA";
        String section       = "0001 & 0002";
        String semester      = "Winter";
        int year             = 2020;
        String teacher       = "Sadegh Ghaderpanah";
        String room          = "B-502";

        Course course = new Course(title, courseNumber, section, semester, teacher, room, year);
        String[] assessmentNames =
        {
           "hw1", "hw2", "hw3", "hw4", "hw5", "midterm-1", "midterm-2", "final exam"
        };
        double[] assessmentPoints =
        {
           2,2,4,4,8,20,20,40
        };

        CourseGradeBook cgb = new CourseGradeBook(assessmentPoints, assessmentNames, course);

        cgb.addGradeRecord(new Student("Caden Olivia"  , 63989996), 60, 66, 37, 85, 87, 85, 73, 79);
        cgb.addGradeRecord(new Student("Ezra Colton"   , 75589670), 93, 86, 93, 88, 93, 58, 35, 69);
        cgb.addGradeRecord(new Student("Cameron Ryan"  , 38977699), 59, 87, 86, 99, 66, 97, 78, 55);
        cgb.addGradeRecord(new Student("Charlotte Aria", 88936308), 80, 67, 77, 63, 97, 77, 89, 95);
        cgb.addGradeRecord(new Student("Caleb Owen"    , 80970578), 99, 93, 90, 67, 53, 79, 79, 89);
        cgb.addGradeRecord(new Student("Lucas Jack"    , 86795367), 88, 86, 76, 90, 95, 89, 79, 77);
        cgb.addGradeRecord(new Student("Caleb Charlie" , 89099578), 75, 87, 86, 93, 78, 79, 93, 55);
        cgb.addGradeRecord(new Student("William Wyatt" , 75950969), 93, 69, 93, 79, 87, 77, 67, 78);
        cgb.addGradeRecord(new Student("Mila Charlotte", 78989969), 80, 98, 99, 56, 95, 89, 90, 78);
        cgb.addGradeRecord(new Student("Elena Aiden"   , 78798089), 77, 87, 79, 100, 88, 73, 73, 88);

        System.out.println(cgb);
        System.out.println(cgb.toStringMaxAssessment());
        System.out.println(cgb.toStringMinAssessment());
        System.out.println(cgb.toStringAvgAssessment());
        System.out.println(cgb.toStringStdevAssessment());
        System.out.println(cgb.toStringAssessmentLegend());
   }
}
