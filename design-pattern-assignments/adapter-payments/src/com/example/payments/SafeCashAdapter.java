package com.example.payments;

public class SafeCashAdapter implements PaymentGateway {
    SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = client;
    }

    @Override
    public String charge(String customerId, int amountCents) {
        return this.client.createPayment(amountCents, customerId).confirm();
    }

}
