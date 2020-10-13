package com.bubblefish.forceheroes.keybinds;

import com.bubblefish.forceheroes.ForceHeroes;

public class switchSlowmoMode {

    public static boolean slowmoMode = false;

    public static void update() {
        if (ForceHeroes.switchSlowmoMode.wasPressed()) {
            slowmoMode = !slowmoMode;
        }
    }
}
