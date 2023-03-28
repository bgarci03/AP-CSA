public class Bird extends Pet
{
  private String seedLikes;

  public void fly()
  {
    System.out.println(getName() + ": weeeeeeee!");
  }

  public void whistle()
  {
    System.out.println(getName() + ": (whistle)!");
  }

  public void setSeedLikes(String seedLikes)
  {
    this.seedLikes = seedLikes;
  }

  public String getSeedLikes()
  {
    return this.seedLikes;
  }
}
