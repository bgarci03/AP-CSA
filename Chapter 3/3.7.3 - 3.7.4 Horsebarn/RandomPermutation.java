import java.util.ArrayList;

public class RandomPermutation
{
    /*
     * Purpose:
     *  Create a random integer list with no duplicates and requires an integer as a parameter
     * Pre-Condition(s):
     *  The length cannot be negative or a decimal
     * Post-Condition(s):
     *  An array of random integers with no duplicates
     */
    static int[] next(int length)
    {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++)
            numbers[i] = i + 1;
        int[] result = new int[length];
        for (int i = result.length-1; i >= 0; i--)
        {
            int random = (int) (Math.random() * i);
            result[i] = numbers[random];
            numbers[random] = numbers[i];
        }
        return result;
    }

    static ArrayList<Horse> next(ArrayList<Horse> barnSpaces)
    {
        int[] randomNumbers = RandomPermutation.next(barnSpaces.size());
        ArrayList<Horse> randomOrder = new ArrayList<Horse>();
        for (int i = 0; i < barnSpaces.size(); i++)
            randomOrder.add(null);
        for (int i = 0; i < barnSpaces.size(); i++) {
            randomOrder.set(randomNumbers[i]-1, barnSpaces.get(i));
        }
        return randomOrder;
    }
}