package beverages_decorator;

public abstract class Decorator extends Beverage {
    protected beverages_decorator.Beverage beverage;

    public Decorator(beverages_decorator.Beverage beverage) {
        this.beverage = beverage;
    }
    
}
