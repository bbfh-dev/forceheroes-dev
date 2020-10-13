package com.bubblefish.forceheroes;

import com.bubblefish.forceheroes.extensions.StepUp;
import com.bubblefish.forceheroes.items.TheFlashArmor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class ForceHeroes implements ModInitializer {
    //Creating main project constants
    public static final String MOD_ID = "forceheroes";

    // Registry new stuff
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"),
            () -> new ItemStack(TheFlashArmor.THE_FLASH_CHESTPLATE));

    public static final KeyBinding switchSlowmoMode = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.forceheroes.switchSlowmoMode", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "category.forceheroes.control"));
    public static final KeyBinding switchSpeedForceMode = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.forceheroes.switchSpeedForceMode", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, "category.forceheroes.control"));

    @Override
    public void onInitialize() {
        TheFlashArmor.init();
        StepUp stepUp = new StepUp();
        ClientTickEvents.END_CLIENT_TICK.register(stepUp);
    }
}
