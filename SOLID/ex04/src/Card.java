public class Card extends Payment{

    Card(double a) {
        super(a);
    }

    @Override
    String paymentDetail() {
        return "Charged card: " + this.amount;
    }
    
}
