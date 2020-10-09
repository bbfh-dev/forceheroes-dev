package com.bubblefish.forceheroes;

import com.bubblefish.forceheroes.items.ArmorItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ForceHeroes implements ModInitializer {
    //Creating main project constants
    public static final String MOD_ID = "forceheroes";

    // Registry new stuff
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"),
            () -> new ItemStack(ArmorItems.THE_FLASH_CHESTPLATE));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "the_flash_helmet"), ArmorItems.THE_FLASH_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "the_flash_chestplate"), ArmorItems.THE_FLASH_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "the_flash_leggings"), ArmorItems.THE_FLASH_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "the_flash_boots"), ArmorItems.THE_FLASH_BOOTS);
    }
}
