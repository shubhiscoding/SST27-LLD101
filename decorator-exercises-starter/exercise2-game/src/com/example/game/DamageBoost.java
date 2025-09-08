package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int damageBonus;

    public DamageBoost(Character character, int damageBonus) {
        super(character);
        this.damageBonus = damageBonus;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getDamage() {
        return character.getDamage() + damageBonus;
    }
}
