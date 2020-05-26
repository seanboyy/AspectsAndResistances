package io.github.seanboyy.aspectsandresistances;

import io.github.seanboyy.aspectsandresistances.registries.Effects;
import io.github.seanboyy.aspectsandresistances.registries.Enchantments;
import io.github.seanboyy.aspectsandresistances.registries.Potions;
import io.github.seanboyy.aspectsandresistances.util.Config;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
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

import static net.minecraft.potion.Potions.*;

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
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(AWKWARD)), Ingredient.fromItems(Blocks.BLUE_ICE.asItem()), getType(Potions.FREEZE_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.FREEZE_RESISTANCE.get())), Ingredient.fromItems(Items.REDSTONE), getType(Potions.LONG_FREEZE_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(AWKWARD)), Ingredient.fromItems(Blocks.SPONGE.asItem()), getType(Potions.SHOCK_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.SHOCK_RESISTANCE.get())), Ingredient.fromItems(Items.REDSTONE), getType(Potions.LONG_SHOCK_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(POISON)), Ingredient.fromItems(Items.GLISTERING_MELON_SLICE), getType(Potions.POISON_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.POISON_RESISTANCE.get())), Ingredient.fromItems(Items.REDSTONE), getType(Potions.LONG_POISON_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(LONG_POISON)), Ingredient.fromItems(Items.GLISTERING_MELON_SLICE), getType(Potions.LONG_POISON_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.POISON_RESISTANCE.get())), Ingredient.fromItems(Items.WITHER_ROSE), getType(Potions.WITHER_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.LONG_POISON_RESISTANCE.get())), Ingredient.fromItems(Items.WITHER_ROSE), getType(Potions.LONG_WITHER_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.WITHER_RESISTANCE.get())), Ingredient.fromItems(Items.REDSTONE), getType(Potions.LONG_WITHER_RESISTANCE.get()));
        LOGGER.info("Registered potion recipes");
    }

    private static ItemStack getType(Potion potion) {
        return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion);
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if(configEvent.getConfig().getSpec() == Config.CLIENT_SPEC) Config.bakeConfig();
    }
}
