package com.bubblefish.forceheroes;

import com.bubblefish.forceheroes.util.enums.FHArmorMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ForceHeroes implements ModInitializer {
    //Creating main project constants
    public static final String MOD_ID = "forceheroes";

    // Registry new stuff
    public static final ItemGroup FHGROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main_group"),
            () -> new ItemStack(ForceHeroes.THEFLASH_CHESTPLATE));

    public static final Item THEFLASH_HELMET = new ArmorItem(FHArmorMaterial.THEFLASH, EquipmentSlot.HEAD, new Item.Settings().group(FHGROUP));
    public static final Item THEFLASH_CHESTPLATE = new ArmorItem(FHArmorMaterial.THEFLASH, EquipmentSlot.CHEST, new Item.Settings().group(FHGROUP));
    public static final Item THEFLASH_LEGGINGS = new ArmorItem(FHArmorMaterial.THEFLASH, EquipmentSlot.LEGS, new Item.Settings().group(FHGROUP));
    public static final Item THEFLASH_BOOTS = new ArmorItem(FHArmorMaterial.THEFLASH, EquipmentSlot.FEET, new Item.Settings().group(FHGROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "theflash_helmet"), THEFLASH_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "theflash_chestplate"), THEFLASH_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "theflash_leggings"), THEFLASH_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "theflash_boots"), THEFLASH_BOOTS);
    }
}
