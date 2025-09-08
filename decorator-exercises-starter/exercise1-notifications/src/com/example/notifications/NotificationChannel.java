package com.example.notifications;

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
