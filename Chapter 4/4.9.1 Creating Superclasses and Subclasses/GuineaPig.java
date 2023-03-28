public class GuineaPig extends Rodent
{
  private boolean hostile;

  public void scratch()
  {
    if (hostile)
      System.out.println(getName() + ": tastes goods.");
    else
      System.out.println(getName() + ": I'm sorry!");
  }

  public void travel()
  {
    System.out.println(getName() + ": searching for a house!");
  }

  public void setHostile(boolean hostile)
  {
    this.hostile = hostile;
  }
}
