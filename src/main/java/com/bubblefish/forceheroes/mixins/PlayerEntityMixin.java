package com.bubblefish.forceheroes.mixins;

import com.bubblefish.forceheroes.items.TheFlashArmor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void tick(CallbackInfo info) {
        updateSpeedForce();
    }

    private void updateSpeedForce() {
        try {
            ItemStack equippedHelmet = this.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack equippedChestplate = this.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack equippedLeggings = this.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack equippedBoots = this.getEquippedStack(EquipmentSlot.FEET);
            if (equippedHelmet.getItem() == TheFlashArmor.THE_FLASH_HELMET && equippedChestplate.getItem() == TheFlashArmor.THE_FLASH_CHESTPLATE && equippedLeggings.getItem() == TheFlashArmor.THE_FLASH_LEGGINGS && equippedBoots.getItem() == TheFlashArmor.THE_FLASH_BOOTS) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 200, false, false, false));
            }
        } catch (AbstractMethodError ignore) {}
    }
}
