/*
 * Activity 4.9.3
 */
public class Boot extends LakeObject
{
  /* Constructor
   * calls super()
   */
  public Boot()
  {
    super();
    super.setCost(0);
  }

  // Methods
  @Override
  public String say()
  {
    return "You got a boot!";
  }

  @Override
  public boolean wasCaught(Hook h)
  {
    return true;
  }
}
