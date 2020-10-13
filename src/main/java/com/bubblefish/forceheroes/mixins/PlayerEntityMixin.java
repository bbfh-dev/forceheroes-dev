package com.bubblefish.forceheroes.mixins;

import com.bubblefish.forceheroes.extensions.StepUp;
import com.bubblefish.forceheroes.extensions.UtilityClass;
import com.bubblefish.forceheroes.items.TheFlashArmor;
import com.bubblefish.forceheroes.keybinds.switchSpeedForceMode;
import com.bubblefish.forceheroes.keybinds.switchSlowmoMode;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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
        switchSpeedForceMode.update();
        switchSlowmoMode.update();
        updateSpeedForce();
    }

    private void updateSpeedForce() {
        try {
            ItemStack equippedHelmet = this.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack equippedChestplate = this.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack equippedLeggings = this.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack equippedBoots = this.getEquippedStack(EquipmentSlot.FEET);
            if (equippedHelmet.getItem() == TheFlashArmor.THE_FLASH_HELMET && equippedChestplate.getItem() == TheFlashArmor.THE_FLASH_CHESTPLATE && equippedLeggings.getItem() == TheFlashArmor.THE_FLASH_LEGGINGS && equippedBoots.getItem() == TheFlashArmor.THE_FLASH_BOOTS) {
                if (switchSpeedForceMode.speedForceMode) {
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 200, false, false, false));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 1, false, false, false));
                    StepUp.autoJumpState = 0;
                } else {
                    StepUp.autoJumpState = 1;
                }

                if (switchSlowmoMode.slowmoMode) {
                    UtilityClass.changeTps(5F);
                } else {
                    UtilityClass.changeTps(20F);
                }
            } else {
                StepUp.autoJumpState = 1;
                UtilityClass.changeTps(20F);
            }
        } catch (AbstractMethodError ignore) {}
    }
}
