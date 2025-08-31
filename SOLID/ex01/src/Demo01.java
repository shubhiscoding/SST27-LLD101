

public class Demo01 {
    public static void main(String[] args) {
        EmailClient email = new EmailClient();
        Tax taxClient = new Tax(0.18);
        OrderService orderProcessor = new OrderService(email, taxClient);
        orderProcessor.checkout("a@shop.com", 100.0);
    }
}
