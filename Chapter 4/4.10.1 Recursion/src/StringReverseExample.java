public class StringReverseExample
{
  public static void main(String[] args)
  {
    String str = "abcdefg";
    // Reverses the string
    System.out.println(reverse(str));
  }

  static String reverse(String str)
  {
    String other = "";
    for (int i = str.length() - 1; i > 0; i--)
    {
      other += str.substring(i, i+1);
    }
    return other;
  }
}
