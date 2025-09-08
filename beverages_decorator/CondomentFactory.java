package beverages_decorator;

public class CondomentFactory {
    public static Beverage addMilk(Beverage beverage) {
        return new MilkDecorator(beverage);
    }
}
