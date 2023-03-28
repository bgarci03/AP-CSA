public class Rodent extends Pet
{
  private boolean sharpTeeth;

  public void chew()
  {
    if (this.sharpTeeth)
      System.out.println(getName() + ": mch...mch...mch!");
    else
      System.out.println(getName() + ": ow!");
  }

  public void excavate()
  {
    System.out.println(getName() + ": I dug a hole!");
  }

  public void setSharpTeeth(boolean sharpTeeth)
  {
    this.sharpTeeth = sharpTeeth;
  }

  public boolean getSharpTeeth()
  {
    return this.sharpTeeth;
  }
}
