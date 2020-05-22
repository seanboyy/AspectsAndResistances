package io.github.seanboyy.aspectsandresistances.enchantment;

import io.github.seanboyy.aspectsandresistances.util.EnchantmentUtilities;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.inventory.EquipmentSlotType;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModFireAspectEnchantment extends FireAspectEnchantment {
    public ModFireAspectEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, slots);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected boolean canApplyTogether(Enchantment ench) {
        return EnchantmentUtilities.enchantmentExclusion(ench);
    }
}
