public class Runner
{
    public static void main(String[] args)
    {
        int[] randNums = RandomPermutation.next(20);
        System.out.println("Data in randNums: " + java.util.Arrays.toString(randNums));
    }
}