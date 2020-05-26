package io.github.seanboyy.aspectsandresistances.util;

import io.github.seanboyy.aspectsandresistances.registries.Effects;
import io.github.seanboyy.aspectsandresistances.registries.Enchantments;
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
        if (!target.isPotionActive(Effects.SHOCK_RESISTANCE.get())) target.addPotionEffect(new EffectInstance(Effects.SHOCK.get(), enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static void applyFireDebuffs(LivingEntity target, int enchantmentLevel) {
        if(!target.isPotionActive(net.minecraft.potion.Effects.FIRE_RESISTANCE)) target.setFire(enchantmentLevel * Config.effect_duration);
    }

    public static void applyColdDebuffs(LivingEntity target, int enchantmentLevel) {
        if (!target.isPotionActive(Effects.FREEZE_RESISTANCE.get()) && target.isPotionActive(net.minecraft.potion.Effects.SLOWNESS)) target.addPotionEffect(new EffectInstance(Effects.FREEZE.get(), enchantmentLevel * TPS * Config.effect_duration));
        else target.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.SLOWNESS, enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static void applyPoisonDebuffs(LivingEntity target, int enchantmentLevel) {
        if (!target.isPotionActive(Effects.POISON_RESISTANCE.get())) target.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.POISON, enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static void applyWitherDebuffs(LivingEntity target, int enchantmentLevel) {
        if(!target.isPotionActive(Effects.WITHER_RESISTANCE.get())) target.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.WITHER, enchantmentLevel * TPS * Config.effect_duration, enchantmentLevel - 1));
    }

    public static boolean enchantmentExclusion(Enchantment ench) {
        return !(ench.equals(Enchantments.FLAME.get()) ||
                ench.equals(Enchantments.COLD.get()) ||
                ench.equals(Enchantments.LIGHTNING.get()) ||
                ench.equals(Enchantments.ELEMENTAL.get()) ||
                ench.equals(Enchantments.POISON.get()) ||
                ench.equals(Enchantments.WITHER.get()) ||
                ench.equals(Enchantments.FIRE_ASPECT.get()) ||
                ench.equals(Enchantments.COLD_ASPECT.get()) ||
                ench.equals(Enchantments.POISON_ASPECT.get()) ||
                ench.equals(Enchantments.ELEMENTAL_ASPECT.get()) ||
                ench.equals(Enchantments.LIGHTNING_ASPECT.get()) ||
                ench.equals(Enchantments.WITHER_ASPECT.get()));
    }
}
