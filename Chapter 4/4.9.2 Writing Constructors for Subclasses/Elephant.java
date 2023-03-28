public class Elephant extends Animal
{
  // Constructor
  public Elephant()
  {

  }
  public Elephant(String food, boolean nocturnal, double aveLifeSpan)
  {
    super(food, nocturnal, aveLifeSpan);
    System.out.println("A new elephant has arrived!");
  }

  public void trumpet()
  {
    System.out.println("Trumpet!");
  }
}
