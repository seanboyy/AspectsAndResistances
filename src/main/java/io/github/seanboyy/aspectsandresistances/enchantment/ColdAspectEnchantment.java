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

public class ColdAspectEnchantment extends Enchantment {
    public ColdAspectEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 10 + 20 * (enchantmentLevel - 1);
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
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
                int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.COLD_ASPECT.get(), source.getHeldItemMainhand());
                if(level >= Enchantments.COLD_ASPECT.get().getMinLevel()) {
                    EnchantmentUtilities.applyColdDebuffs(target, level);
                }
            }
        }
    }
}
