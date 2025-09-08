package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private final int speedBonus = 2;
    private final int damageBonus = 5;

    public GoldenAura(Character character) {
        super(character);
    }

    @Override
    public void move() {
        System.out.println("[Golden Aura] Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[Golden Aura] Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + speedBonus;
    }

    @Override
    public int getDamage() {
        return character.getDamage() + damageBonus;
    }

    @Override
    public String getSprite() {
        return "golden_" + character.getSprite();
    }
}
