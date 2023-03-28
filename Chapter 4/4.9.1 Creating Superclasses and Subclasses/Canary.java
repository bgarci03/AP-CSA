public class Canary extends Bird
{
  private String song;

  public void explore()
  {
    System.out.println(getName() + ": I'm soaring through the air and seeing new thingS!");
  }

  public void sing()
  {
    System.out.println(getName() + ": sings " + this.song);
  }

  public void setSong(String song)
  {
    this.song = song;
  }
}
