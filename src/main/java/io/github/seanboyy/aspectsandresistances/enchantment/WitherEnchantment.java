package io.github.seanboyy.aspectsandresistances.enchantment;

import io.github.seanboyy.aspectsandresistances.AspectsAndResistances;
import io.github.seanboyy.aspectsandresistances.registries.Enchantments;
import io.github.seanboyy.aspectsandresistances.util.EnchantmentUtilities;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.ParametersAreNonnullByDefault;

public class WitherEnchantment extends Enchantment {
    public WitherEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.BOW, slots);
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 20;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 50;
    }

    @Override
    @ParametersAreNonnullByDefault
    protected boolean canApplyTogether(Enchantment ench) {
        return EnchantmentUtilities.enchantmentExclusion(ench);
    }

    @Mod.EventBusSubscriber(modid = AspectsAndResistances.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EnchantmentEquipped {
        @SubscribeEvent
        public static void doStuff(final LivingHurtEvent event){
            LivingEntity target = event.getEntityLiving();
            if(event.getSource().getTrueSource() instanceof LivingEntity) {
                LivingEntity source = (LivingEntity) event.getSource().getTrueSource();
                int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.WITHER.get(), source.getHeldItemMainhand());
                if(level >= Enchantments.WITHER.get().getMinLevel()) {
                    EnchantmentUtilities.applyWitherDebuffs(target, level);
                }
            }
        }
    }


}
