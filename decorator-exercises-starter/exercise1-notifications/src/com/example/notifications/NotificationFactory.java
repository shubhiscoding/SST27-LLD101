package com.example.notifications;

import java.util.List;

/**
 * Factory class that provides a clean abstraction for creating notifiers with various channels.
 * This hides the complexity of decorator composition from the client.
 */
public class NotificationFactory {
    
    /**
     * Creates a notifier with the specified channels.
     * @param email The email address for email notifications
     * @param channels List of additional notification channels to add
     * @return A composed notifier with all requested channels
     */
    public static Notifier createNotifier(String email, List<NotificationChannel> channels) {
        Notifier notifier = new EmailNotifier(email);
        
        for (NotificationChannel channel : channels) {
            notifier = decorateWithChannel(notifier, channel);
        }
        
        return notifier;
    }
    
    /**
     * Creates a notifier with only email channel.
     */
    public static Notifier createEmailOnlyNotifier(String email) {
        return new EmailNotifier(email);
    }
    
    /**
     * Creates a notifier with email and SMS.
     */
    public static Notifier createEmailAndSmsNotifier(String email, String phoneNumber) {
        return new SmsDecorator(new EmailNotifier(email), phoneNumber);
    }
    
    /**
     * Creates a notifier with email and WhatsApp.
     */
    public static Notifier createEmailAndWhatsAppNotifier(String email, String whatsAppId) {
        return new WhatsAppDecorator(new EmailNotifier(email), whatsAppId);
    }
    
    /**
     * Creates a notifier with email and Slack.
     */
    public static Notifier createEmailAndSlackNotifier(String email, String slackChannel) {
        return new SlackDecorator(new EmailNotifier(email), slackChannel);
    }
    
    /**
     * Creates a notifier with all channels (email, WhatsApp, and Slack).
     */
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
