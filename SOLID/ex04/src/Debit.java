public class Debit extends Payment {

    Debit(double a) {
        super(a);
    }

    @Override
    String paymentDetail() {
        return "Wallet debit: " + this.amount;
    }
    
}
