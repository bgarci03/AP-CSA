public class Cereal
{
    // Attributes
    private String name;
    private String type;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;
    private double fiber;
    private double carbs;
    private double sugar;
    private double k;
    private double vitamins;
    private double shelf;
    private double weight;
    private double cups;
    private double rating;

    // Constructors
    public Cereal(String name, String type, double calories, double protein, double fat, double sodium, double fiber, double carbs, double sugar, double k, double vitamins, double shelf, double weight, double cups, double rating)
    {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbs = carbs;
        this.sugar = sugar;
        this.k = k;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.rating = rating;
    }
    
    // Accessors
    public String getName() { return this.name; }
    public String getType() { return this.type;}
    public double getCalories() { return this.calories; }
    public double getProtein() { return this.protein; }
    public double getFat() { return this.fat; }   
    public double getSodium() { return this.sodium; }
    public double getFiber() { return this.fiber; }
    public double getCarbs() { return this.carbs; }
    public double getSugar() { return this.sugar; }
    public double getPotassium() { return this.k; }
    public double getVitamins() { return this.vitamins; }
    public double getShelf() { return this.shelf; }
    public double getWeight() { return this.weight; }
    public double getCups() { return this.cups; }
    public double getRating() { return this.rating; }

    // toString()
    public String toString()
    {
        return (this.name + " has " + this.calories + " calories at " + this.cups + " and has a rating of " + this.rating);
    }
}