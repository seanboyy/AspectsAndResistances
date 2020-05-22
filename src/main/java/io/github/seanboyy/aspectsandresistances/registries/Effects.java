package io.github.seanboyy.aspectsandresistances.registries;

import io.github.seanboyy.aspectsandresistances.AspectsAndResistances;
import io.github.seanboyy.aspectsandresistances.potion.effect.ModEffect;
import io.github.seanboyy.aspectsandresistances.util.Constants;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;

public class Effects {
    public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, AspectsAndResistances.MOD_ID);

    public static final RegistryObject<Effect> FREEZE = EFFECTS.register("freeze",
            () -> new ModEffect(EffectType.HARMFUL, 0xF5F5F5)
                    .addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED,
                            Constants.Effects.Freeze.MovementSpeedModifier.UUID, -1.0,
                            AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED,
                            Constants.Effects.Freeze.AttackSpeedModifier.UUID, -1.0,
                            AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<Effect> SHOCK = EFFECTS.register("shock",
            () -> new ModEffect(EffectType.HARMFUL, 0x90dede));
    public static final RegistryObject<Effect> FREEZE_RESISTANCE = EFFECTS.register("freeze_resistance",
            () -> new ModEffect(EffectType.BENEFICIAL, 0x00BAFF) {

                @Override
                public boolean isReady(int duration, int amplifier) {
                    return true;
                }

                @Override
                @ParametersAreNonnullByDefault
                public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
                    if(entityLivingBaseIn.isPotionActive(Effects.FREEZE.get())) {
                        entityLivingBaseIn.removePotionEffect(Effects.FREEZE.get());
                    }
                }
            });
    public static final RegistryObject<Effect> SHOCK_RESISTANCE = EFFECTS.register("shock_resistance",
            () -> new ModEffect(EffectType.BENEFICIAL, 0xE3E35B) {

                @Override
                public boolean isReady(int duration, int amplifier) {
                    return true;
                }

                @Override
                @ParametersAreNonnullByDefault
                public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
                    if(entityLivingBaseIn.isPotionActive(Effects.SHOCK.get())) {
                        entityLivingBaseIn.removePotionEffect(Effects.SHOCK.get());
                    }
                }
            });
    public static final RegistryObject<Effect> POISON_RESISTANCE = EFFECTS.register("poison_resistance",
            () -> new ModEffect(EffectType.BENEFICIAL, 0xC249FF) {

                @Override
                public boolean isReady(int duration, int amplifier) {
                    return true;
                }

                @Override
                @ParametersAreNonnullByDefault
                public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
                    if(entityLivingBaseIn.isPotionActive(net.minecraft.potion.Effects.POISON)) {
                        entityLivingBaseIn.removePotionEffect(net.minecraft.potion.Effects.POISON);
                    }
                }
            });
    public static final RegistryObject<Effect> WITHER_RESISTANCE = EFFECTS.register("wither_resistance",
            () -> new ModEffect(EffectType.BENEFICIAL, 0xFFFFFF){
                @Override
                public boolean isReady(int duration, int amplifier) {
                    return true;
                }

                @Override
                @ParametersAreNonnullByDefault
                public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
                    if(entityLivingBaseIn.isPotionActive(net.minecraft.potion.Effects.WITHER)) {
                        entityLivingBaseIn.removePotionEffect(net.minecraft.potion.Effects.WITHER);
                    };
                }
            });
}
