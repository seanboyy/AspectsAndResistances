package io.github.seanboyy.aspectsandresistances.util;

import io.github.seanboyy.aspectsandresistances.AspectsAndResistances;
import io.github.seanboyy.aspectsandresistances.registries.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = AspectsAndResistances.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {
    @SubscribeEvent
    public static void applyShockToDamage(final LivingHurtEvent event) {
        LivingEntity target = event.getEntityLiving();
        if(target.isPotionActive(Effects.SHOCK.get())) {
            event.setAmount(event.getAmount() * (((Objects.requireNonNull(target.getActivePotionEffect(Effects.SHOCK.get())).getAmplifier() + 1) * Config.shock_multiplier) + 1));
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void applyFreezeToAttacks(final LivingAttackEvent event) {
        if(event.getSource().getTrueSource() instanceof LivingEntity) {
            LivingEntity source = (LivingEntity) event.getSource().getTrueSource();
            if(source.isPotionActive(Effects.FREEZE.get())) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void applyFreezeToJumps(final LivingEvent.LivingJumpEvent event) {
        LivingEntity frozenEntity = event.getEntityLiving();
        if(frozenEntity.isPotionActive(Effects.FREEZE.get())) {
            frozenEntity.setMotion(0, 0, 0);
            frozenEntity.setVelocity(0, 0, 0);
        }
    }

    @SubscribeEvent
    public static void removeEffectsOnTick(final TickEvent.PlayerTickEvent event) {
        if(event.player.isPotionActive(Effects.FREEZE_RESISTANCE.get()) && event.player.isPotionActive(Effects.FREEZE.get())) {
            event.player.removePotionEffect(Effects.FREEZE.get());
        }
        if(event.player.isPotionActive(Effects.SHOCK_RESISTANCE.get()) && event.player.isPotionActive(Effects.SHOCK.get())) {
            event.player.removePotionEffect(Effects.SHOCK.get());
        }
        if(event.player.isPotionActive(Effects.POISON_RESISTANCE.get()) && event.player.isPotionActive(net.minecraft.potion.Effects.POISON)) {
            event.player.removePotionEffect(net.minecraft.potion.Effects.POISON);
        }
        if(event.player.isPotionActive(net.minecraft.potion.Effects.FIRE_RESISTANCE) && event.player.getFireTimer() > 0) {
            event.player.setFireTimer(0);
        }
        if(event.player.isPotionActive(Effects.WITHER_RESISTANCE.get()) && event.player.isPotionActive(net.minecraft.potion.Effects.WITHER)) {
            event.player.removePotionEffect(net.minecraft.potion.Effects.WITHER);
        }
    }

}
