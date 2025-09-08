package com.example.notifications;

/**
 * Represents a notification channel with its type and target (phone number, username, channel name, etc.).
 */
public class NotificationChannel {
    private final NotificationChannelType type;
    private final String target;

    public NotificationChannel(NotificationChannelType type, String target) {
        this.type = type;
        this.target = target;
    }

    public NotificationChannelType getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }

    // Convenience factory methods
    public static NotificationChannel sms(String phoneNumber) {
        return new NotificationChannel(NotificationChannelType.SMS, phoneNumber);
    }

    public static NotificationChannel whatsApp(String whatsAppId) {
        return new NotificationChannel(NotificationChannelType.WHATSAPP, whatsAppId);
    }

    public static NotificationChannel slack(String slackChannel) {
        return new NotificationChannel(NotificationChannelType.SLACK, slackChannel);
    }
}
