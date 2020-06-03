package io.github.seanboyy.aspectsandresistances.registries;

import io.github.seanboyy.aspectsandresistances.AspectsAndResistances;
import io.github.seanboyy.aspectsandresistances.enchantment.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, AspectsAndResistances.MOD_ID);
    public static final DeferredRegister<Enchantment> OVERRIDE_ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, "minecraft");

    //Weapon ModEnchantments
    public static final RegistryObject<Enchantment> COLD_ASPECT = ENCHANTMENTS.register("cold_aspect", () -> new ColdAspectEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> LIGHTNING_ASPECT = ENCHANTMENTS.register("lightning_aspect", () -> new LightningAspectEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> POISON_ASPECT = ENCHANTMENTS.register("poison_aspect", () -> new PoisonAspectEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> ELEMENTAL_ASPECT = ENCHANTMENTS.register("elemental_aspect", () -> new ElementalAspectEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> WITHER_ASPECT = ENCHANTMENTS.register("wither_aspect", () -> new WitherAspectEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));

    //Bow ModEnchantments
    public static final RegistryObject<Enchantment> COLD = ENCHANTMENTS.register("cold_bow", () -> new ColdEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> LIGHTNING = ENCHANTMENTS.register("lightning_bow", () -> new LightningEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> POISON = ENCHANTMENTS.register("poison_bow", () -> new PoisonEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> ELEMENTAL = ENCHANTMENTS.register("elemental_bow", () -> new ElementalEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> WITHER = ENCHANTMENTS.register("wither_bow", () -> new WitherEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));

    //Overrides
    public static final RegistryObject<Enchantment> FIRE_ASPECT = OVERRIDE_ENCHANTMENTS.register("fire_aspect", () -> new ModFireAspectEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> FLAME = OVERRIDE_ENCHANTMENTS.register("flame", () -> new ModFlameEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
}
