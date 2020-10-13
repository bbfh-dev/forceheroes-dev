package com.bubblefish.forceheroes.keybinds;

import com.bubblefish.forceheroes.ForceHeroes;

public class switchSpeedForceMode {

    public static boolean speedForceMode = false;

    public static void update() {
        if (ForceHeroes.switchSpeedForceMode.wasPressed()) {
            speedForceMode = !speedForceMode;
        }
    }
}
