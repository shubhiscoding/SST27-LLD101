package com.example.game;

import java.util.List;

public class CharacterFactory {
    
    public static Character createBaseCharacter() {
        return new BaseCharacter();
    }
    
    public static Character createSpeedyCharacter(int speedBonus) {
        return new SpeedBoost(new BaseCharacter(), speedBonus);
    }
    
    public static Character createStrongCharacter(int damageBonus) {
        return new DamageBoost(new BaseCharacter(), damageBonus);
    }
    
    public static Character createBalancedCharacter(int speedBonus, int damageBonus) {
        Character character = new BaseCharacter();
        character = new SpeedBoost(character, speedBonus);
        character = new DamageBoost(character, damageBonus);
        return character;
    }
    
    public static Character createGoldenCharacter() {
        return new GoldenAura(new BaseCharacter());
    }
    
    public static Character createUltimateCharacter(int speedBonus, int damageBonus) {
        Character character = new BaseCharacter();
        character = new SpeedBoost(character, speedBonus);
        character = new DamageBoost(character, damageBonus);
        character = new GoldenAura(character);
        return character;
    }
    
    public static Character createCharacterWithBoosts(List<CharacterBoost> boosts) {
        Character character = new BaseCharacter();
        
        for (CharacterBoost boost : boosts) {
            character = applyBoost(character, boost);
        }
        
        return character;
    }
    
    private static Character applyBoost(Character character, CharacterBoost boost) {
        switch (boost.getType()) {
            case SPEED:
                return new SpeedBoost(character, boost.getValue());
            case DAMAGE:
                return new DamageBoost(character, boost.getValue());
            case GOLDEN_AURA:
                return new GoldenAura(character);
            default:
                return character;
        }
    }
}
