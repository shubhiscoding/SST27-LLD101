package com.example.game;

public class CharacterBoost {
    private final BoostType type;
    private final int value;

    public CharacterBoost(BoostType type, int value) {
        this.type = type;
        this.value = value;
    }

    public BoostType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public static CharacterBoost speed(int speedBonus) {
        return new CharacterBoost(BoostType.SPEED, speedBonus);
    }

    public static CharacterBoost damage(int damageBonus) {
        return new CharacterBoost(BoostType.DAMAGE, damageBonus);
    }

    public static CharacterBoost goldenAura() {
        return new CharacterBoost(BoostType.GOLDEN_AURA, 0);
    }
}
