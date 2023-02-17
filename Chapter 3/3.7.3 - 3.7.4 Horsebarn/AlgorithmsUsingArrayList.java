/*
 * Activity 3.7.4
 */
import java.util.ArrayList;

public class AlgorithmsUsingArrayList
{
    public static void main(String[] args)
    {
        HorseBarn barn = new HorseBarn();
        ArrayList<Horse> barnSpaces = new ArrayList<Horse>();
        barnSpaces = barn.getSpaces();

        int index = 0;
        while (index < barnSpaces.size())
        {
            Horse h = barnSpaces.get(index);
            if (h.getName().equals("Patches"))
            {
                System.out.println("Bye bye " + barnSpaces.remove(index));
                index--;
            }
            else if (h.getName().equals("Lady"))
            {
                System.out.println("Bye bye " + barnSpaces.remove(index));
                index--;
            }
            index++;
        }

        System.out.println(barnSpaces);

        // Step 2a
        double average = 0;
        for (Horse horse: barnSpaces)
            average += horse.getWeight();
        average /= barnSpaces.size();
        System.out.println("Average: " + average);

        // Step 2b
        System.out.println("Horses weighing more than average:");
        for (Horse horse: barnSpaces)
            if (horse.getWeight() > average)
                System.out.println(horse + " at " + horse.getWeight());

        // Step 2c
        if (barnSpaces.size() > 0)
        {
            Horse lightest = barnSpaces.get(0);
            Horse heaviest = barnSpaces.get(0);
            for (Horse horse : barnSpaces) {
                if (horse.getWeight() < lightest.getWeight())
                    lightest = horse;
                else if (horse.getWeight() > heaviest.getWeight())
                    heaviest = horse;
            }
            System.out.println("LIghtest horse: " + lightest + " at " + lightest.getWeight());
            System.out.println("Heaviest horse: " + heaviest + " at " + heaviest.getWeight());

            // Step 3
            for (int i = 0; i < barnSpaces.size(); i++) {
                // Step 3a
                if (barnSpaces.get(i).getName().equals("Duke"))
                    barnSpaces.set(i, new Horse("Princess", 1445));
                    // Step 3b
                else if (barnSpaces.get(i).getName().equals("Silver"))
                    barnSpaces.add(i + 1, new Horse("Chief", 1505));
                    // Step 3c
                else if (barnSpaces.get(i).getName().equals("Buddy")) {
                    barnSpaces.add(i + 1, new Horse("Gypsy", 1335));
                    barnSpaces.add(i, new Horse("Magic", 1425));
                    i++;
                }
            }
        }
        System.out.println(barnSpaces);

        // Step 4
        if (barnSpaces.size() > 0)
        {
            Horse lightest = barnSpaces.get(0);
            Horse heaviest = barnSpaces.get(0);
            for (Horse horse : barnSpaces) {
                if (horse.getWeight() < lightest.getWeight())
                    lightest = horse;
                else if (horse.getWeight() > heaviest.getWeight())
                    heaviest = horse;
            }
            System.out.println("LIghtest horse: " + lightest + " at " + lightest.getWeight());
            System.out.println("Heaviest horse: " + heaviest + " at " + heaviest.getWeight());
        }
        System.out.println("Added and Deleted:");
        for (Horse horse: barnSpaces)
            System.out.println(horse + ": " + horse.getWeight());

        // It's Your Turn
        ArrayList<Horse> random = RandomPermutation.next(barnSpaces);
        while (random.size() > 0)
        {
            String partners = "";
            partners += random.remove(0) + " and ";
            if (random.size() > 0)
                partners += random.remove(0);
            else
                partners += "NO PARTNER";
            System.out.println(partners);
        }
    }
}