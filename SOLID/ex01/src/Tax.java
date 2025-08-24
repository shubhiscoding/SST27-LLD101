public class Tax implements ITaxCalculator{
    private double taxRate;

    public Tax(double taxRate){
        this.taxRate = taxRate;
    }
    @Override
    public double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }
}
