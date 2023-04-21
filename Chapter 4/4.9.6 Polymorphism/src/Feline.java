public class Feline extends Animal
{
  public Feline()
  {

  }
  
  public Feline(String food, boolean nocturnal, double aveLifeSpan)
  {
    super(food, nocturnal, aveLifeSpan);
    System.out.println("A feline arrives.");
  }

  public void speak()
  {
    System.out.println("I'm a feline!");
  }
}
