package com.bubblefish.forceheroes.extensions;

import net.minecraft.util.Identifier;

public class AbilitySlider {
    public static final Identifier SLIDER = new Identifier("forceheroes", "textures/gui/inventory.png");
    private int sliderX = 184;
    private int sliderY = 14;

    public AbilitySlider() {
    }

    public int getX() {
        return this.sliderX;
    }

    public int getY() {
        return this.sliderY;
    }
}
