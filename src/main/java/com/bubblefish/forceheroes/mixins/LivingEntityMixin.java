package com.bubblefish.forceheroes.mixins;

import com.bubblefish.forceheroes.items.TheFlashArmor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
//    @Shadow @Final private DefaultedList<ItemStack> equippedArmor;

    @Shadow @Final private DefaultedList<ItemStack> equippedArmor;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        try {
            assert MinecraftClient.getInstance().player != null;
            if (MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD).getItem().equals(TheFlashArmor.THE_FLASH_HELMET)) {
//                changeMovementSpeed(10.0);
            } else {
                changeMovementSpeed(0.1);
            }
        } catch (NullPointerException ignore) {}
    }

    private static void changeMovementSpeed(double speed) {
        EntityAttributeInstance entityAttributeInstance;
        try {
            assert MinecraftClient.getInstance().player != null;
            entityAttributeInstance = MinecraftClient.getInstance().player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        } catch (NullPointerException e) {return;}

        assert entityAttributeInstance != null;
        System.out.println(entityAttributeInstance.getValue());
        if (entityAttributeInstance.getValue() != speed) {
            EntityAttributeModifier entityAttributeModifier = new EntityAttributeModifier("GENERIC_MOVEMENT_SPEED", speed , EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
            entityAttributeInstance.removeModifier(entityAttributeModifier);
            entityAttributeInstance.addPersistentModifier(entityAttributeModifier);
        }
    }
}

//        ItemStack helmetStack = equippedArmor.get(3);
//        ItemStack chestplateStack = equippedArmor.get(2);
//        ItemStack leggingsStack = equippedArmor.get(1);
//        ItemStack bootsStack = equippedArmor.get(0);
//
//        assert MinecraftClient.getInstance().player != null;
//        EntityAttributeModifier entityAttributeModifier;
//        if (helmetStack.getItem().equals(TheFlashArmor.THE_FLASH_HELMET) && chestplateStack.getItem().equals(TheFlashArmor.THE_FLASH_CHESTPLATE) && leggingsStack.getItem().equals(TheFlashArmor.THE_FLASH_LEGGINGS) && bootsStack.getItem().equals(TheFlashArmor.THE_FLASH_BOOTS)) {
//            entityAttributeModifier = new EntityAttributeModifier(MinecraftClient.getInstance().player.getUuid(), "GENERIC_MOVEMENT_SPEED", 228.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
//            System.out.println("Work with " + MinecraftClient.getInstance().player.getUuid());
//            EntityAttributeInstance entityAttributeInstance;
//            try {
//                assert MinecraftClient.getInstance().player != null;
//                entityAttributeInstance = MinecraftClient.getInstance().player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
//            } catch (NullPointerException exception) {return;}
//
//            assert entityAttributeInstance != null;
//            entityAttributeInstance.removeModifier(entityAttributeModifier);
//            entityAttributeInstance.addPersistentModifier(entityAttributeModifier);
//        } else {
//            entityAttributeModifier = new EntityAttributeModifier(MinecraftClient.getInstance().player.getUuid(), "GENERIC_MOVEMENT_SPEED", 0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
//            EntityAttributeInstance entityAttributeInstance;
//            try {
//                assert MinecraftClient.getInstance().player != null;
//                entityAttributeInstance = MinecraftClient.getInstance().player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
//            } catch (NullPointerException exception) {return;}
//
//            assert entityAttributeInstance != null;
//            entityAttributeInstance.removeModifier(entityAttributeModifier);
//            entityAttributeInstance.addPersistentModifier(entityAttributeModifier);
//        }