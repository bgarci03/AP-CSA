/*
 * Activity 4.9.3
 */
public class Bait extends LakeObject
{
  /* Constructor
   * calls super()
   */
  public Bait()
  {
    super();
    super.setCost(10);
  }

  // Methods
  @Override
  public String say()
  {
    return "You now have bait!";
  }
}