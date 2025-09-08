package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private final String slackChannel;

    public SlackDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        sendSlack(text);
    }

    private void sendSlack(String text) {
        System.out.println("[SLACK -> #" + slackChannel + "]: " + text);
    }
}
