/*
 * Activity 4.9.1
 */
public class InheritedPet
{
  public static void main(String[] args)
  {
    System.out.println("my cat");
    Cat myCat = new Cat();
    myCat.setName("Romeo");
    myCat.purr();
    myCat.eat();
    myCat.sleep();
    
    System.out.println("my dog");
    Dog myDog = new Dog();
    myDog.setName("Juliette");
    myDog.walk();
    myDog.eat();
    myDog.sleep();

    // It's Your Turn
    Canary canary = new Canary();
    canary.setName("Dave");
    canary.explore();
    canary.setSong("Rick Roll");
    canary.sing();

    Parakeet parakeet = new Parakeet();
    parakeet.setName("Alex");
    parakeet.play();
    parakeet.setPhrase("I love to be alone all day!");
    parakeet.speak();

    GuineaPig guineaPig = new GuineaPig();
    guineaPig.setName("Britany");
    guineaPig.setHostile(true);
    guineaPig.scratch();
    guineaPig.travel();

    Gerbil gerbil = new Gerbil();
    gerbil.setName("Victoria");
    gerbil.eatRoots();
    gerbil.setDarkMarking(false);
    gerbil.sleepInBurrow();
  }
}