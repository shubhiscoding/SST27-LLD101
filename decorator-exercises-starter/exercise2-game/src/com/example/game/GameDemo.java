package com.example.game;

import java.util.Arrays;

public class GameDemo {
    public static void main(String[] args) {
        System.out.println("\n--- Factory: Speedy Character ---");
        Character speedy = CharacterFactory.createSpeedyCharacter(8);
        speedy.move();
        speedy.attack();

        System.out.println("\n--- Factory: Strong Character ---");
        Character strong = CharacterFactory.createStrongCharacter(20);
        strong.move();
        strong.attack();

        System.out.println("\n--- Factory: Balanced Character ---");
        Character balanced = CharacterFactory.createBalancedCharacter(5, 12);
        balanced.move();
        balanced.attack();

        System.out.println("\n--- Factory: Golden Character ---");
        Character golden = CharacterFactory.createGoldenCharacter();
        golden.move();
        golden.attack();

        System.out.println("\n--- Factory: Ultimate Character ---");
        Character ultimate = CharacterFactory.createUltimateCharacter(10, 25);
        ultimate.move();
        ultimate.attack();

        System.out.println("\n--- Factory: Custom Boosts ---");
        Character custom = CharacterFactory.createCharacterWithBoosts(
            Arrays.asList(
                CharacterBoost.speed(7),
                CharacterBoost.damage(18),
                CharacterBoost.goldenAura()
            )
        );
        custom.move();
        custom.attack();

        System.out.println("\n=== Demo Complete ===");
    }
}
