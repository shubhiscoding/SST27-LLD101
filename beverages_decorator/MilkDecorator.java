package beverages_decorator;

public class MilkDecorator extends Decorator{

    MilkDecorator(Beverage beverage){
        super(beverage);
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 10;
    }
}
