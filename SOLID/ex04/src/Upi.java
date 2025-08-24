public class Upi extends Payment{

    Upi(double a) {
        super(a);
    }

    @Override
    String paymentDetail() {
        return "Paid via UPI: " + this.amount;
    }
    
}
