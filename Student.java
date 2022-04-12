import java.util.ArrayList;

public class Student
{
   private String fullName;
   private String id; 
   private ArrayList<Assignment> grades;
   
   public Student(String fullName, String id)
   {
      this.fullName = fullName;
      this.id = id;
      grades = new ArrayList<>();
   }
   
   public void addAssignment(Assignment a)
   {
      grades.add(a);
   }
   
   public double getAverage()
   {
      double sum = 0.0;
      
      for(Assignment a : grades)
      {
         sum += a.getGrade();
      }
      
      return sum/grades.size();
   }
   
   public String toString()
   {
      double avg = getAverage();
   
      String s = "Name: " + fullName + "\n";
      s += "ID: " + id + "\n";
      s += "Grade Average: " +  String.format("%.2f%% [%s]",avg, Assignment.gradeToLetter(avg));
      s += "\n===============\n";
      s += "\n  ASSIGNMENTS  \n";
      s += "\n===============\n";
                  
      for(Assignment a : grades)
      {
         s += a.toString() + "\n";
      }
      
      return s;
   }
   
   
   
   
}