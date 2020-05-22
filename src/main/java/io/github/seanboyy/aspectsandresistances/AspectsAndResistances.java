package io.github.seanboyy.aspectsandresistances;

import io.github.seanboyy.aspectsandresistances.registries.Effects;
import io.github.seanboyy.aspectsandresistances.registries.Enchantments;
import io.github.seanboyy.aspectsandresistances.registries.Potions;
import io.github.seanboyy.aspectsandresistances.util.Config;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("aspectsandresistances")
@Mod.EventBusSubscriber(modid = AspectsAndResistances.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AspectsAndResistances {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "aspectsandresistances";

    public AspectsAndResistances() {
        LOGGER.info("Starting up Aspects and Resistances");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
        LOGGER.info("Loaded Config");
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        Effects.EFFECTS.register(modEventBus);
        LOGGER.info("Registered Effects");
        Potions.POTIONS.register(modEventBus);
        LOGGER.info("Registered Potions");
        Enchantments.ENCHANTMENTS.register(modEventBus);
        LOGGER.info("Registered Enchantments");
        Enchantments.OVERRIDE_ENCHANTMENTS.register(modEventBus);
        LOGGER.info("Registered Overridden Enchantments");
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    @SubscribeEvent
    public static void onPotionsRegisteredEvent(final RegistryEvent.Register<Potion> event) {
        PotionBrewing.addMix(net.minecraft.potion.Potions.AWKWARD, net.minecraft.block.Blocks.BLUE_ICE.asItem(), Potions.FREEZE_RESISTANCE.get());
        PotionBrewing.addMix(Potions.FREEZE_RESISTANCE.get(), Items.REDSTONE, Potions.LONG_FREEZE_RESISTANCE.get());
        PotionBrewing.addMix(net.minecraft.potion.Potions.AWKWARD, net.minecraft.block.Blocks.SPONGE.asItem(), Potions.SHOCK_RESISTANCE.get());
        PotionBrewing.addMix(Potions.SHOCK_RESISTANCE.get(), Items.REDSTONE, Potions.LONG_SHOCK_RESISTANCE.get());
        PotionBrewing.addMix(net.minecraft.potion.Potions.POISON, Items.GLISTERING_MELON_SLICE, Potions.POISON_RESISTANCE.get());
        PotionBrewing.addMix(Potions.POISON_RESISTANCE.get(), Items.REDSTONE, Potions.LONG_POISON_RESISTANCE.get());
        PotionBrewing.addMix(net.minecraft.potion.Potions.LONG_POISON, Items.GLISTERING_MELON_SLICE, Potions.LONG_POISON_RESISTANCE.get());
        PotionBrewing.addMix(Potions.POISON_RESISTANCE.get(), Items.WITHER_ROSE, Potions.WITHER_RESISTANCE.get());
        PotionBrewing.addMix(Potions.LONG_POISON_RESISTANCE.get(), Items.WITHER_ROSE, Potions.LONG_WITHER_RESISTANCE.get());
        PotionBrewing.addMix(Potions.WITHER_RESISTANCE.get(), Items.REDSTONE, Potions.LONG_WITHER_RESISTANCE.get());
        LOGGER.info("Registered potion recipes");
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if(configEvent.getConfig().getSpec() == Config.CLIENT_SPEC) Config.bakeConfig();
    }
}
