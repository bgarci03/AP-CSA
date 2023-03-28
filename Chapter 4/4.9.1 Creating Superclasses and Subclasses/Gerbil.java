public class Gerbil extends Rodent
{
  private boolean darkMarking;

  public void sleepInBurrow()
  {
    if (darkMarking)
      System.out.println(getName() + ": where's my burrow! I need to sleep!");
    else
      System.out.println(getName() + ": this is nice!");
  }

  public void eatRoots()
  {
    System.out.println(getName() + ": I love plants' roots!");
  }

  public void setDarkMarking(boolean darkMarking)
  {
    this.darkMarking = darkMarking;
  }
}
