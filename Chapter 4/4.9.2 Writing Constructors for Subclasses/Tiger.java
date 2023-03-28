public class Tiger extends Feline
{
  public Tiger()
  {
    super();

  }

  public Tiger(String food, boolean nocturnal, double aveLifeSpan)
  {
    super(food, nocturnal, aveLifeSpan);
  }

  public void swim()
  {
    System.out.println("Swimming!");
  }

  public void huntAlone()
  {
    System.out.println("Hunting alone!");
  }
}
