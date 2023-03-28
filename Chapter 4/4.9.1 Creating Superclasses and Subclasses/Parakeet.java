public class Parakeet extends Bird
{
  private String phrase;

  public void play()
  {
    System.out.println(getName() + ": searching for a seed!");
  }

  public void speak()
  {
    System.out.println(getName() + ": " + phrase);
  }

  public void setPhrase(String phrase)
  {
    this.phrase = phrase;
  }
}
