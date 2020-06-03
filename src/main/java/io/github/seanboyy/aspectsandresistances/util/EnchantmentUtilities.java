package io.github.seanboyy.aspectsandresistances.util;

import io.github.seanboyy.aspectsandresistances.registries.ModEffects;
import io.github.seanboyy.aspectsandresistances.registries.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;

import static io.github.seanboyy.aspectsandresistances.util.Constants.TimeScale.TPS;

public class EnchantmentUtilities {

    public static void applyElementalDebuffs(LivingEntity target, int enchantmentLevel) {
        applyFireDebuffs(target, enchantmentLevel);
        applyColdDebuffs(target, enchantmentLevel);
        applyLightningDebuffs(target, enchantmentLevel);
    }

    public static void applyLightningDebuffs(LivingEntity target, int enchantmentLevel) {
        if (!target.isPotionActive(ModEffects.SHOCK_RESISTANCE.get())) target.addPotionEffect(new EffectInstance(ModEffects.SHOCK.get(), enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static void applyFireDebuffs(LivingEntity target, int enchantmentLevel) {
        if(!target.isPotionActive(net.minecraft.potion.Effects.FIRE_RESISTANCE)) target.setFire(enchantmentLevel * Config.effect_duration);
    }

    public static void applyColdDebuffs(LivingEntity target, int enchantmentLevel) {
        if (!target.isPotionActive(ModEffects.FREEZE_RESISTANCE.get()) && target.isPotionActive(net.minecraft.potion.Effects.SLOWNESS)) target.addPotionEffect(new EffectInstance(ModEffects.FREEZE.get(), enchantmentLevel * TPS * Config.effect_duration));
        else target.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.SLOWNESS, enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static void applyPoisonDebuffs(LivingEntity target, int enchantmentLevel) {
        if (!target.isPotionActive(ModEffects.POISON_RESISTANCE.get())) target.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.POISON, enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static void applyWitherDebuffs(LivingEntity target, int enchantmentLevel) {
        if(!target.isPotionActive(ModEffects.WITHER_RESISTANCE.get())) target.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.WITHER, enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static boolean enchantmentExclusion(Enchantment ench) {
        return !(ench.equals(ModEnchantments.FLAME.get()) ||
                ench.equals(ModEnchantments.COLD.get()) ||
                ench.equals(ModEnchantments.LIGHTNING.get()) ||
                ench.equals(ModEnchantments.ELEMENTAL.get()) ||
                ench.equals(ModEnchantments.POISON.get()) ||
                ench.equals(ModEnchantments.WITHER.get()) ||
                ench.equals(ModEnchantments.FIRE_ASPECT.get()) ||
                ench.equals(ModEnchantments.COLD_ASPECT.get()) ||
                ench.equals(ModEnchantments.POISON_ASPECT.get()) ||
                ench.equals(ModEnchantments.ELEMENTAL_ASPECT.get()) ||
                ench.equals(ModEnchantments.LIGHTNING_ASPECT.get()) ||
                ench.equals(ModEnchantments.WITHER_ASPECT.get()));
    }
}
