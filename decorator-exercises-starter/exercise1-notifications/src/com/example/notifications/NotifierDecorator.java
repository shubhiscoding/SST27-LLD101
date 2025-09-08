package com.example.notifications;

/**
 * Base decorator class that implements Notifier and wraps another Notifier.
 * This follows the Decorator pattern by maintaining a reference to a Notifier
 * and delegating the notify operation to it, while allowing subclasses to add behavior.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String text) {
        notifier.notify(text);
    }
}
