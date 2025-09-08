package com.example.notifications;

/**
 * SMS decorator that adds SMS notification capability to any existing notifier.
 */
public class SmsDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SmsDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        // First execute the wrapped notifier's behavior
        super.notify(text);
        // Then add SMS functionality
        sendSms(text);
    }

    private void sendSms(String text) {
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
    }
}
