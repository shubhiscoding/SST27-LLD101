package com.example.orders;

import java.util.List;
import java.util.Objects;

public final class Validation {
    private Validation() {}

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static void requireNonBlank(String val, String name) {
        if (isBlank(val)) throw new IllegalArgumentException(name + " must not be blank");
    }

    public static void requireEmail(String email) {
        Objects.requireNonNull(email, "email");
        if (!email.contains("@")) throw new IllegalArgumentException("invalid email");
    }

    public static void requireNumberInRange(int value, int min, int max, String name) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(name + " must be between " + min + " and " + max);
        }
    }

    public static void requireNonEmptyOrderLines(List<OrderLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one line item");
        }
    }
}
