import java.util.ArrayList;

public class GradeBook
{

   private String studentName;
   private String courseName;
   private ArrayList<Assignment> grades;
   
   public GradeBook(String studentName, String courseName)
   {
      this.studentName = studentName;
      this.courseName = courseName;
      this.grades = new ArrayList<Assignment>();
   }
   
   public void addAssignment(Assignment a)
   {
      grades.add(a);  
   }
   
   public String courseGrade()
   {
      // Java streams solution
      double avg = grades.stream()
                         .mapToDouble(Assignment::getGrade)
                         .average()
                         .orElse(0.0); 
      
      return Assignment.gradeToLetter(avg);
   }

   public String toString()
   {
      String s  = "";
             s += "Student Name: " + this.studentName + "\n";
             s += "Course Name: " + this.courseName + "\n";
             s += "Final Grade: " + this.courseGrade();
      return s;
   }


}