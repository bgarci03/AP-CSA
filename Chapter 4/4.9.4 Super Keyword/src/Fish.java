/*
 * Activity 4.9.3
 */
public class Fish extends LakeObject
{
  // Methods
  @Override
  public String say()
  {
    return "You got a fish!";
  }

  @Override
  public int getCost()
  {
    return super.getCost() * super.getWeight();
  }
}