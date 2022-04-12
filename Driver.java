import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.net.URL;

public class Driver 
{

   public static void main(String[] args) throws Exception
   {
      // Get student info   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter student name: ");
      String tempName = keyboard.nextLine();
      System.out.print("Enter student ID: ");
      String tempID = keyboard.nextLine();

      // Get random assignment data
      System.out.println("\n--> Retrieving data from remote server, please be patient.\n");

      URL url = new URL("https://roan-equinox-chauffeur.glitch.me/grades");
      // This totally blocks, cool for discussion point
      Scanner s = new Scanner(url.openStream());
      String rawData = s.nextLine();
      
      // Print raw data for debugging purposes
      System.out.println(rawData);
      
      // Parse group of assignments into individual items 
      String[] rawAssignments = rawData.split(",");
      
      // Now create a student instance
      Student student = new Student(tempName,tempID);

      // Parse each individual assignment item into components and create assignment objects 
      for(String a : rawAssignments)
      {
         String[] components = a.split(":");
         GregorianCalendar gc = new GregorianCalendar();
         gc.setTimeInMillis(Long.parseLong(components[1]));
         
         Assignment temp = new Assignment(components[0], gc, Double.parseDouble(components[2]));
         
         student.addAssignment(temp);
      }
      
      System.out.println(student);
      
      
   }

}