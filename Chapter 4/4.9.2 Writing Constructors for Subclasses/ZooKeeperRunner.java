/*
 * Activity 4.9.2
 */
public class ZooKeeperRunner
{
  public static void main(String[] args)
  { 
       Elephant elephant = new Elephant("leaves, grasses, roots", false, 60.0);
       elephant.trumpet();
       elephant.eat();
       elephant.isNocturnal();

       Tiger tiger = new Tiger("meat", true, 17.0);
       tiger.swim();
       tiger.huntAlone();
       tiger.eat();
       tiger.isNocturnal();

       Gorilla gorilla = new Gorilla();

       Giraffe giraffe = new Giraffe("leaves", false, 25.0);
       giraffe.eat();

       Hippo hippo = new Hippo();
       hippo.eat();

       Penguin penguin = new Penguin();
       penguin.fish();
       Owl owl = new Owl();
       owl.hunt();
       Owl owl2 = new Owl("mice,insects", true, 4.0);
       owl2.eat();
  }
}