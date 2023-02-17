public class Person
{
    private int age;
    private int birthYear;
    private String name;

    public Person(int age, int birthYear, String name)
    {
        this.age = age;
        this.birthYear = birthYear;
        this.name = name;
    }

    public String toString()
    {
        String result = "Their name is " + this.name + " and they're " + this.age + " years old because they were born in " + this.birthYear + "!";
        return result;
    }
}