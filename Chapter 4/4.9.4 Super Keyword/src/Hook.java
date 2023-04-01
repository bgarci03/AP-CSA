/**
 * Activity 4.9.3
 */
public class Hook extends LakeObject
{
  // Instance Variables
  private int strength;

  /* Constructor
   * calls super()
   */
  public Hook()
  {
    super();
    strength = 55;
    super.setCost(15);
  }

  // Methods
  /*---------- accessor ----------*/
  public int getStrength() 
  {
    return strength; // This return will be updated in the next activity
    //return strength;
  }

  @Override
  public String say()
  {
    return "You now have a hook!";
  }

}