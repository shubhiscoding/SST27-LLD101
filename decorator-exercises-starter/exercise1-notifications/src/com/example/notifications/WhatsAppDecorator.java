package com.example.notifications;

/**
 * WhatsApp decorator that adds WhatsApp notification capability to any existing notifier.
 */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsAppId;

    public WhatsAppDecorator(Notifier notifier, String whatsAppId) {
        super(notifier);
        this.whatsAppId = whatsAppId;
    }

    @Override
    public void notify(String text) {
        // First execute the wrapped notifier's behavior
        super.notify(text);
        // Then add WhatsApp functionality
        sendWhatsApp(text);
    }

    private void sendWhatsApp(String text) {
        System.out.println("[WHATSAPP -> " + whatsAppId + "]: " + text);
    }
}
