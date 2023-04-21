/*
 * Activity 4.9.7
 */ 
public class StudentRunner
{ 
  public static void main(String args[]) 
  {
    /*
    Student s = new Student("TestName");
    Student t = new Student("Testname");
    Student r = new Student("New Name");

    // Below two statements are equivalent 
    System.out.println(s.equals(t));
    System.out.println(s.equals(r));
     */

    // It's Your Turn
    Student a = new Student("Dave", 909012, 9);
    Student b = new Student("Ava", 909012, 10);
    Student c = new Student("April", 239232, 11);

    System.out.println(a);
    System.out.println(b.toString());
    System.out.println(a.equals(b));
    System.out.println(a.equals(c));
  } 
} 