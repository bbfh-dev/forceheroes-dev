package com.bubblefish.forceheroes;

import com.bubblefish.forceheroes.items.TheFlashArmor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ForceHeroes implements ModInitializer {
    //Creating main project constants
    public static final String MOD_ID = "forceheroes";

    // Registry new stuff
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"),
            () -> new ItemStack(TheFlashArmor.THE_FLASH_CHESTPLATE));

    @Override
    public void onInitialize() {
        TheFlashArmor.init();
    }
}
