package com.example.notifications;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Notification System Demo ===\n");
        
        Notifier factorySms = NotificationFactory.createEmailAndSmsNotifier(
            "dev@company.com", "+1-555-0123");
        factorySms.notify("Test suite passed ✅");
        

        Notifier factoryWhatsApp = NotificationFactory.createEmailAndWhatsAppNotifier(
            "dev@company.com", "dev_team");
        factoryWhatsApp.notify("Pull request merged 🔄");
        

        Notifier factoryFull = NotificationFactory.createFullNotifier(
            "admin@company.com", "admin_team", "alerts");
        factoryFull.notify("System maintenance scheduled 🔧");
        
        Notifier customNotifier = NotificationFactory.createNotifier(
            "user@company.com", 
            Arrays.asList(
                NotificationChannel.sms("+1-555-9999"),
                NotificationChannel.slack("general")
            )
        );
        customNotifier.notify("Custom notification setup 🎨");
        
        System.out.println("\n=== Demo Complete ===");
    }
}
