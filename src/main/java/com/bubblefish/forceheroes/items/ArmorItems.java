package com.bubblefish.forceheroes.items;

import com.bubblefish.forceheroes.ForceHeroes;
import com.bubblefish.forceheroes.util.enums.ModArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class ArmorItems extends ArmorItem {

    private final ModArmorMaterial material;

    public static final Item THE_FLASH_HELMET = new ArmorItem(material, EquipmentSlot.HEAD, new Item.Settings().group(ForceHeroes.GROUP));
    public static final Item THE_FLASH_CHESTPLATE = new ArmorItem(material, EquipmentSlot.CHEST, new Item.Settings().group(ForceHeroes.GROUP));
    public static final Item THE_FLASH_LEGGINGS = new ArmorItem(material, EquipmentSlot.LEGS, new Item.Settings().group(ForceHeroes.GROUP));
    public static final Item THE_FLASH_BOOTS = new ArmorItem(material, EquipmentSlot.FEET, new Item.Settings().group(ForceHeroes.GROUP));

    public ArmorItems(ArmorMaterial material, EquipmentSlot slot, Settings settings, ModArmorMaterial material1) {
        super(material, slot, settings);
        this.material = material1;
    }

    public ArmorMaterial getArmorMaterial() {
        return this.material;
    }
}
