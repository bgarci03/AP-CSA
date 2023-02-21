import java.util.ArrayList;

public class CustomaryConverter
{
  private ArrayList<String> customaryLengthNames;
  private double[] customaryLengthToMetric;

  public CustomaryConverter()
  {
    // ArrayList Dataset
    this.customaryLengthNames = new ArrayList<String>();
    this.customaryLengthNames.add("in");
    this.customaryLengthNames.add("ft");
    this.customaryLengthNames.add("yd");
    this.customaryLengthNames.add("mi");

    // Array Dataset
    this.customaryLengthToMetric = new double[4];
    this.customaryLengthToMetric[0] = 2.54;
    this.customaryLengthToMetric[1] = 30.48;
    this.customaryLengthToMetric[2] = 1.094;
    this.customaryLengthToMetric[3] = 1.60934;
  }

  public double convertLength(String unit, double length)
  {
    int index = this.customaryLengthNames.indexOf(unit);

    if (index < 2)
    {
      System.out.println("Converting to cm!");
      return length * this.customaryLengthToMetric[index];
    }
    else if (index < 3)
    {
      System.out.println("Converting to m!");
      return length / this.customaryLengthToMetric[index];
    }
    else
    {
      System.out.println("Converting to km!");
      return length * this.customaryLengthToMetric[index];
    }
  }

  public boolean validateUnit(String unit)
  {
    boolean isValid = false;
    for (String name: this.customaryLengthNames)
      if (unit.equals(name))
        isValid = true;

    return isValid;
  }
}
