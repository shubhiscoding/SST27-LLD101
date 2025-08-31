public abstract class Payment {
    double amount;
    Payment(double a){ amount=a; }

    abstract String paymentDetail();
}