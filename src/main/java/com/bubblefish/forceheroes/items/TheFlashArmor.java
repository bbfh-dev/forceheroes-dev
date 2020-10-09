package com.bubblefish.forceheroes.items;

import com.bubblefish.forceheroes.ForceHeroes;
import com.bubblefish.forceheroes.util.enums.ModArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TheFlashArmor {
    public static final Item THE_FLASH_HELMET = new ArmorItem(ModArmorMaterial.THE_FLASH, EquipmentSlot.HEAD, new Item.Settings().group(ForceHeroes.GROUP));
    public static final Item THE_FLASH_CHESTPLATE = new ArmorItem(ModArmorMaterial.THE_FLASH, EquipmentSlot.CHEST, new Item.Settings().group(ForceHeroes.GROUP));
    public static final Item THE_FLASH_LEGGINGS = new ArmorItem(ModArmorMaterial.THE_FLASH, EquipmentSlot.LEGS, new Item.Settings().group(ForceHeroes.GROUP));
    public static final Item THE_FLASH_BOOTS = new ArmorItem(ModArmorMaterial.THE_FLASH, EquipmentSlot.FEET, new Item.Settings().group(ForceHeroes.GROUP));

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(ForceHeroes.MOD_ID, "the_flash_helmet"), THE_FLASH_HELMET);
        Registry.register(Registry.ITEM, new Identifier(ForceHeroes.MOD_ID, "the_flash_chestplate"), THE_FLASH_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(ForceHeroes.MOD_ID, "the_flash_leggings"), THE_FLASH_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(ForceHeroes.MOD_ID, "the_flash_boots"), THE_FLASH_BOOTS);
    }
}
