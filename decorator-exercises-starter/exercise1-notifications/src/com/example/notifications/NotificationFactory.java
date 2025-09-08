package com.example.notifications;

import java.util.List;

public class NotificationFactory {
    
    public static Notifier createNotifier(String email, List<NotificationChannel> channels) {
        Notifier notifier = new EmailNotifier(email);
        
        for (NotificationChannel channel : channels) {
            notifier = decorateWithChannel(notifier, channel);
        }
        
        return notifier;
    }
    
    public static Notifier createEmailOnlyNotifier(String email) {
        return new EmailNotifier(email);
    }
    
    public static Notifier createEmailAndSmsNotifier(String email, String phoneNumber) {
        return new SmsDecorator(new EmailNotifier(email), phoneNumber);
    }
    
    public static Notifier createEmailAndWhatsAppNotifier(String email, String whatsAppId) {
        return new WhatsAppDecorator(new EmailNotifier(email), whatsAppId);
    }
    
    public static Notifier createEmailAndSlackNotifier(String email, String slackChannel) {
        return new SlackDecorator(new EmailNotifier(email), slackChannel);
    }
    
    public static Notifier createFullNotifier(String email, String whatsAppId, String slackChannel) {
        Notifier notifier = new EmailNotifier(email);
        notifier = new WhatsAppDecorator(notifier, whatsAppId);
        notifier = new SlackDecorator(notifier, slackChannel);
        return notifier;
    }
    
    private static Notifier decorateWithChannel(Notifier notifier, NotificationChannel channel) {
        switch (channel.getType()) {
            case SMS:
                return new SmsDecorator(notifier, channel.getTarget());
            case WHATSAPP:
                return new WhatsAppDecorator(notifier, channel.getTarget());
            case SLACK:
                return new SlackDecorator(notifier, channel.getTarget());
            default:
                return notifier;
        }
    }
}
