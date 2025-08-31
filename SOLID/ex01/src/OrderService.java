public class OrderService {
    private final IEmailClient emailClient;
    private final ITaxCalculator taxCalculator;

    OrderService(IEmailClient email, ITaxCalculator taxClient){
        this.emailClient = email;
        this.taxCalculator = taxClient;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.totalWithTax(subtotal);
        emailClient.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}