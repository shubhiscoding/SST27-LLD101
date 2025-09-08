package com.example.notifications;

/**
 * Slack decorator that adds Slack notification capability to any existing notifier.
 */
public class SlackDecorator extends NotifierDecorator {
    private final String slackChannel;

    public SlackDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void notify(String text) {
        // First execute the wrapped notifier's behavior
        super.notify(text);
        // Then add Slack functionality
        sendSlack(text);
    }

    private void sendSlack(String text) {
        System.out.println("[SLACK -> #" + slackChannel + "]: " + text);
    }
}
