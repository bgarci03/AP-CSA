import java.awt.*;
import java.util.ArrayList;

public class Steganography
{
  public static void main(String[] args)
  {
    /* A1
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    Picture copy = testClearLow(beach);
    copy.explore();

    Picture beach2 = new Picture("beach.jpg");
    beach2.explore();
    Picture copy2 = testSetLow(beach2, Color.PINK);
    copy2.explore();

    Picture copy3 = revealPicture(copy2);
    copy3.explore();
    */


    /* A2
    Picture beach1 = new Picture("beach.jpg");
    Picture beach2 = new Picture("arch.jpg");

    if (canHide(beach1, beach2))
    {
      Picture hidden = hidePicture(beach1, beach2);
      hidden.explore();
      Picture revealed = revealPicture(hidden);
      revealed.explore();
    }
    */

    /* A3
    Picture beach = new Picture("beach.jpg");
    Picture robot = new Picture("robot.jpg");
    Picture flower1 = new Picture("flower1.jpg");
    beach.explore();

    // these lines hide 2 pictures
    Picture hidden1 = hidePicture(beach, robot, 65, 208);
    Picture hidden2 = hidePicture(hidden1, flower1, 280, 110);
    hidden2.explore();

    Picture unhidden = revealPicture(hidden2);
    unhidden.explore();

    Picture swan = new Picture("swan.jpg");
    Picture swan2 = new Picture("swan.jpg");
    System.out.println("Swan and swan2 are the same: " + isSame(swan, swan2));
    swan = testClearLow(swan);
    System.out.println("Swan and swan2 are the same (after clearLow run on swan): " + isSame(swan, swan2));

    Picture arch = new Picture("arch.jpg");
    Picture arch2 = new Picture("arch.jpg");
    Picture koala = new Picture("koala.jpg");
    Picture robot1 = new Picture("robot.jpg");
    ArrayList<Point> pointList = findDifferences(arch, arch2);
    System.out.println("PointList after comparing two identical pictures has a size of " + pointList.size());
    pointList = findDifferences(arch, koala);
    System.out.println("PointList after comparing two different sized picture has a size of " + pointList.size());
    arch2 = hidePicture(arch, robot1, 65, 102);
    pointList = findDifferences(arch, arch2);
    System.out.println("PointList after hiding a picture has a size of " + pointList.size());
    arch.show();
    arch2.show();

    Picture withArea = showDifferentArea(arch2, pointList);
    withArea.show();

    Picture hall = new Picture("FemaleLionAndHall.jpg");
    Picture robot2 = new Picture("robot.jpg");
    Picture flower2 = new Picture("flower1.jpg");

    // hide pictures
    Picture hall2 = hidePicture(hall, robot2, 50, 300);
    Picture hall3 = hidePicture(hall2, flower2, 115, 275);
    hall3.explore();
    if (!isSame(hall, hall3))
    {
      Picture hall4 = showDifferentArea(hall, findDifferences(hall, hall3));
      hall4.show();
      Picture unhiddenHall3 = revealPicture(hall3);
      unhiddenHall3.show();
    }
    */

    /* A4 */
    Picture gorge = new Picture("gorge.jpg");
    gorge.explore();

    hideText(gorge, "The pizza was delicious");
    gorge.explore();
    String revealed = revealText(gorge);
    System.out.println(revealed);

    hideText(gorge, "Pizzas are the best type of food");
    gorge.explore();
    revealed = revealText(gorge);
    System.out.println(revealed);
  }

  /**
   * Clear the lower (rightmost) two bits in a pixel.
   */
  public static void clearLow(Pixel a)
  {
    /* To be implemented */
    a.setRed(a.getRed()/4*4);
    a.setBlue(a.getBlue()/4*4);
    a.setGreen(a.getGreen()/4*4);
  }

  public static Picture testClearLow(Picture a)
  {
    Picture copy = new Picture(a);
    for (Pixel pixel: copy.getPixels())
      clearLow(pixel);
    return copy;
  }

  /**
   * Set the lower 2 bits in a pixel to the highest 2 bits in c
   */
  public static void setLow(Pixel p, Color c)
  {
    // Clear rightmost bits of p
    p.setRed(p.getRed()/4*4);
    p.setGreen(p.getGreen()/4*4);
    p.setBlue(p.getBlue()/4*4);

    // Set rightmost bits of p to leftmost bits of c
    p.setRed(p.getRed() + c.getRed()/64);
    p.setGreen(p.getGreen() + c.getGreen()/64);
    p.setBlue(p.getBlue() + c.getBlue()/64);
  }

  public static Picture testSetLow(Picture p, Color c)
  {
    Picture copy = new Picture(p);
    for (Pixel pixel: copy.getPixels())
      setLow(pixel, c);
    return copy;
  }

  /**
   * Sets the highest two bits of each pixel's colors
   * to the lowest two bits of each pixel's colors
   */
  public static Picture revealPicture(Picture hidden)
  {
    Picture copy = new Picture(hidden);
    Pixel[][] pixels = copy.getPixels2D();
    Pixel[][] source = hidden.getPixels2D();
    for (int r = 0; r < pixels.length; r++)
    {
      for (int c = 0; c < pixels[0].length; c++)
      {
        Color col = source[r][c].getColor();
        /* To be implemented */
        int red = col.getRed() * 64;
        int green = col.getGreen() * 64;
        int blue = col.getBlue() * 64;

        for (int sub = 8192; sub >= 256; sub /= 2)
        {
          if (red >= sub)
            red -= sub;
          if (green >= sub)
            green -= sub;
          if (blue >= sub)
            blue -= sub;
        }

        Pixel updated = pixels[r][c];
        updated.setRed(red);
        updated.setGreen(green);
        updated.setBlue(blue);
      }
    }
    return copy;
  }

  /**
   * Determines whether secret can be hidden in source, which is
   * true if source and secret are the same dimensions.
   * @param source is not null
   * @param secret is not null
   * @return true if secret can be hidden in source, false otherwise.
   */
  public static boolean canHide(Picture source, Picture secret)
  {
    /* CODE FROM A2
    if (source.getHeight() == secret.getHeight() && source.getWidth() == secret.getWidth())
      return true;
    return false;
    */
    if (secret.getHeight() <= source.getHeight() && secret.getWidth() <= source.getWidth())
      return true;
    return false;
  }

  /**
   * Creates a new Picture with data from secret hidden in data fro source
   * @param source is not null
   * @param secret is not null
   * @return combined Picture with secret hidden in source
   * precondition: source is same width and height as secret
   */
  public static Picture hidePicture(Picture source, Picture secret)
  {
    // New Picture that will have the image hideen
    Picture hidden = new Picture(source);

    // 2D Arrays of Pixels
    Pixel[][] pixelsSource = source.getPixels2D();
    Pixel[][] pixelsSecret = secret.getPixels2D();
    Pixel[][] pixelsHidden = hidden.getPixels2D();

    // Loops through each pixel
    for (int row = 0; row < pixelsSource.length; row++)
    {
      for (int col = 0; col < pixelsSource[0].length; col++)
      {
        Pixel sourcePixel = pixelsSource[row][col];
        Pixel secretPixel = pixelsSecret[row][col];
        Pixel hiddenPixel = pixelsHidden[row][col];

        // Get highest bits from secret then divide by 64 so it can replace the right bits in source
        int highRed = secretPixel.getRed() / 64;
        int highGreen = secretPixel.getGreen() / 64;
        int highBlue = secretPixel.getBlue() / 64;

        // Clear leftmost bits in source
        int replaceRed = sourcePixel.getRed() / 4 * 4;
        int replaceGreen = sourcePixel.getGreen() / 4 * 4;
        int replaceBlue = sourcePixel.getBlue() / 4 * 4;

        hiddenPixel.setRed(replaceRed + highRed);
        hiddenPixel.setGreen(replaceGreen + highGreen);
        hiddenPixel.setBlue(replaceBlue + highBlue);
      }
    }

    return hidden;
  }

  public static Picture hidePicture(Picture source, Picture secret, int startRow, int startColumn)
  {
    Picture hidden = new Picture(source);

    Pixel[][] pixelsSource = source.getPixels2D();
    Pixel[][] pixelsSecret = secret.getPixels2D();
    Pixel[][] pixelsHidden = hidden.getPixels2D();

    for (int r = 0; r < pixelsSecret.length; r++)
    {
      for (int c = 0; c < pixelsSecret[0].length; c++)
      {
        Pixel sourcePixel = pixelsSource[r + startRow][c + startColumn];
        Pixel secretPixel = pixelsSecret[r][c];
        Pixel hiddenPixel = pixelsHidden[r + startRow][c + startColumn];

        // Get highest bits from secret then divide by 64 so it can replace the right bits in source
        int highRed = secretPixel.getRed() / 64;
        int highGreen = secretPixel.getGreen() / 64;
        int highBlue = secretPixel.getBlue() / 64;

        // Clear leftmost bits in source
        int replaceRed = sourcePixel.getRed() / 4 * 4;
        int replaceGreen = sourcePixel.getGreen() / 4 * 4;
        int replaceBlue = sourcePixel.getBlue() / 4 * 4;

        hiddenPixel.setRed(replaceRed + highRed);
        hiddenPixel.setGreen(replaceGreen + highGreen);
        hiddenPixel.setBlue(replaceBlue + highBlue);
      }
    }
    return hidden;
  }

  public static boolean isSame(Picture p1, Picture p2)
  {
    if (p1.getWidth() != p2.getWidth())
      return false;
    if (p1.getHeight() != p2.getHeight())
      return false;

    Pixel[][] p1Pixels = p1.getPixels2D();
    Pixel[][] p2Pixels = p2.getPixels2D();

    boolean same = true;
    for (int r = 0; r < p1Pixels.length; r++)
    {
      for (int c = 0; c < p1Pixels[0].length; c++)
      {
        Pixel p1Pixel = p1Pixels[r][c];
        Pixel p2Pixel = p2Pixels[r][c];

        if (p1Pixel.getRed() != p2Pixel.getRed())
          same = false;
        else if (p1Pixel.getGreen() != p2Pixel.getGreen())
          same = false;
        else if (p1Pixel.getBlue() != p2Pixel.getBlue())
          same = false;
      }
    }
    return same;
  }

  public static ArrayList<Point> findDifferences(Picture p1, Picture p2)
  {
    ArrayList<Point> points = new ArrayList<Point>();
    if (p1.getHeight() != p2.getHeight())
      return points;
    if (p1.getWidth() != p2.getWidth())
      return points;

    Pixel[][] p1Pixels = p1.getPixels2D();
    Pixel[][] p2Pixels = p2.getPixels2D();

    for (int r = 0; r < p1Pixels.length; r++)
    {
      for (int c = 0; c < p1Pixels[0].length; c++)
      {
        Pixel p1Pixel = p1Pixels[r][c];
        Pixel p2Pixel = p2Pixels[r][c];

        if (p1Pixel.getRed() != p2Pixel.getRed())
          points.add(new Point(r, c));
        else if (p1Pixel.getGreen() != p2Pixel.getGreen())
          points.add(new Point(r, c));
        else if (p1Pixel.getBlue() != p2Pixel.getBlue())
          points.add(new Point(r, c));
      }
    }

    return points;
  }

  public static Picture showDifferentArea(Picture picture, ArrayList<Point> points)
  {
    Picture hasArea = new Picture(picture);
    Pixel[][] pixels = hasArea.getPixels2D();

    for (Point point: points)
    {
      double x = point.getX();
      double y = point.getY();

      Pixel pixel = pixels[(int) x][(int) y];
      pixel.setColor(new Color(0, 0, 0));
    }

    return hasArea;
  }

  /**
   * Takes a string consisting of letters and spaces and
   * encodes the string into an arraylist of integers.
   * The integers are 1-26 for A-Z, 27 for space, and 0 for end of
   * string. The arraylist of integers is returned.
   * @param s a string consisting of letters and spaces
   * @return ArrauList containing integer encoding of uppercase
   *      version of s
   */
  public static ArrayList<Integer> encodeString(String s)
  {
    s = s.toUpperCase();
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < s.length(); i++)
    {
      if (s.substring(i,i+1).equals(" "))
        result.add(27);
      else
        result.add(alpha.indexOf(s.substring(i,i+1))+1);
    }
    result.add(0);
    return result;
  }

  /**
   * Returns the string represented by the codes arraylist.
   * 1-26 = A-Z, 27 = space
   * @param codes encoded string
   * @return decoded string
   */
  private static String decodeString(ArrayList<Integer> codes)
  {
    String result = "";
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = 0; i < codes.size(); i++)
    {
      if (codes.get(i) == 27)
        result += " ";
      else
        result += alpha.substring(codes.get(i)-1, codes.get(i));
    }
    return result;
  }

  /**
   * Given a number from 0 to 63, creates and returns a 3-element
   * int array consisting of the integers representing the
   * pairs of bits in the number from right to left.
   * @param num number to be broken up
   * @return bit pairs in number
   */
  private static int[] getBitPairs(int num)
  {
    int[] bits = new int[3];
    int code = num;
    for (int i = 0; i < 3; i++)
    {
      bits[i] = code % 4;
      code /= 4;
    }
    return bits;
  }

  /**
   * Hide a string (must only be capital letters and spaces in a
   * picture.
   * The string always starts in upper left corner.
   * @param source source picture to hide in
   * @param s a string to hide
   * @return picture with hidden string
   */
  public static void hideText(Picture source, String s)
  {
    ArrayList<Integer> encoded = encodeString(s);

    for (int i = 0; i < encoded.size(); i++)
    {
      int[] bitPairs = getBitPairs(encoded.get(i));
      Pixel pixel = source.getPixel(i, 0);

      pixel.setRed(pixel.getRed() / 4 * 4 + bitPairs[0]);
      pixel.setGreen(pixel.getGreen() / 4 * 4 + bitPairs[1]);
      pixel.setBlue(pixel.getBlue() / 4 * 4 + bitPairs[2]);
    }
  }

  /**
   * Returns a string hidden in the picture
   * @param source picture with hidden string
   * @return revealed string
   */
  public static String revealText(Picture source)
  {
    ArrayList<Integer> codes = new ArrayList<Integer>();

    boolean end = false;
    int index = 0;

    while (!end)
    {
      Pixel pixel = source.getPixel(index, 0);
      int code = 0;

      int red = pixel.getRed();
      int green = pixel.getGreen();
      int blue = pixel.getBlue();

      for (int sub = 128; sub > 2; sub /= 2)
      {
        if (red >= sub)
          red -= sub;
        if (blue >= sub)
          blue -= sub;
        if (green >= sub)
          green -= sub;
      }

      if (red > 0)
      {
        code++;
        if (red > 2)
          code += 2;
        else if (red > 1)
          code++;

      }

      if (green > 0)
      {
        code += 4;
        if (green > 2)
          code += 8;
        else if (green > 1)
          code += 4;
      }

      if (blue > 0)
      {
        code += 16;
      }

      index++;
      if (code < 1)
        end = true;
      else
        codes.add(code);
    }

    return decodeString(codes);
  }
}
