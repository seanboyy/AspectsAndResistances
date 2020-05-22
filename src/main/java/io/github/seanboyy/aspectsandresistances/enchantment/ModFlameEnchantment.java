package io.github.seanboyy.aspectsandresistances.enchantment;

import io.github.seanboyy.aspectsandresistances.util.EnchantmentUtilities;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.FlameEnchantment;
import net.minecraft.inventory.EquipmentSlotType;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModFlameEnchantment extends FlameEnchantment {
    public ModFlameEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, slots);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected boolean canApplyTogether(Enchantment ench) {
        return EnchantmentUtilities.enchantmentExclusion(ench);
    }
}
