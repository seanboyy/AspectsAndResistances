package io.github.seanboyy.aspectsandresistances.registries;

import io.github.seanboyy.aspectsandresistances.AspectsAndResistances;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Potions {
    public static final DeferredRegister<Potion> POTIONS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, AspectsAndResistances.MOD_ID);

    public static final RegistryObject<Potion> FREEZE_RESISTANCE = POTIONS.register("freeze_resistance", () -> new Potion(new EffectInstance(Effects.FREEZE_RESISTANCE.get(), 3600)));
    public static final RegistryObject<Potion> LONG_FREEZE_RESISTANCE = POTIONS.register("long_freeze_resistance", () -> new Potion("freeze_resistance", new EffectInstance(Effects.FREEZE_RESISTANCE.get(), 9600)));

    public static final RegistryObject<Potion> SHOCK_RESISTANCE = POTIONS.register("shock_resistance", () -> new Potion(new EffectInstance(Effects.SHOCK_RESISTANCE.get(), 3600)));
    public static final RegistryObject<Potion> LONG_SHOCK_RESISTANCE = POTIONS.register("long_shock_resistance", () -> new Potion("shock_resistance", new EffectInstance(Effects.SHOCK_RESISTANCE.get(), 9600)));

    public static final RegistryObject<Potion> POISON_RESISTANCE = POTIONS.register("poison_resistance", () -> new Potion(new EffectInstance(Effects.POISON_RESISTANCE.get(), 3600)));
    public static final RegistryObject<Potion> LONG_POISON_RESISTANCE = POTIONS.register("long_poison_resistance", () -> new Potion("poison_resistance", new EffectInstance(Effects.POISON_RESISTANCE.get(), 9600)));

    public static final RegistryObject<Potion> WITHER_RESISTANCE = POTIONS.register("wither_resistance", () -> new Potion(new EffectInstance(Effects.WITHER_RESISTANCE.get(), 3600)));
    public static final RegistryObject<Potion> LONG_WITHER_RESISTANCE = POTIONS.register("long_wither_resistance", () -> new Potion("wither_resistance", new EffectInstance(Effects.WITHER_RESISTANCE.get(), 9600)));
}
