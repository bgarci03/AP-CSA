/*
 * Activity 4.9.7
 */ 
public class Student 
{ 
  private String name = "";  
  private int grade;
  private double gpa;
  private int id;
  private int age;

  // Constructor 
  Student(String inputName, int id, int grade)
  { 
    this.name = inputName;
    this.id = id;
    this.grade = grade;
  } 
  
  Student(String name, int grade, double gpa)
  {
    this.name = name;
    this.grade = grade;
    this.gpa = gpa;
  }
  
  public String toString()
  {
    return this.name + " is in " + this.grade + " and their ID is " + this.id;
  }

  public boolean equals(Student other)
  {
    return this.id == other.id;
  }

} 