package io.github.seanboyy.aspectsandresistances.util;

import io.github.seanboyy.aspectsandresistances.AspectsAndResistances;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static int effect_duration;
    public static float shock_multiplier;

    public static void bakeConfig() {
        effect_duration = CLIENT.EFFECT_DURATION.get();
        shock_multiplier = CLIENT.SHOCK_MULTIPLIER.get();
    }

    public static class ClientConfig {
        public final ForgeConfigSpec.ConfigValue<Integer> EFFECT_DURATION;
        public final ForgeConfigSpec.ConfigValue<Float> SHOCK_MULTIPLIER;
        public ClientConfig(ForgeConfigSpec.Builder builder) {
            EFFECT_DURATION = builder.comment("Duration of effects applied by enchantments")
                    .translation(AspectsAndResistances.MOD_ID + ".config." + "effect_duration")
                    .define("effect_duration", 5);
            SHOCK_MULTIPLIER = builder.comment("The multiplier applied to damage when the entity that is being damaged has the shock effect" +
                    "\n0.25 = damage is multiplied by (0.25 * level of enchantment) + 1" +
                    "\nLevel 2 Lightning Aspect with shock effect of 0.25 = damage is multiplied by 1.5").translation(AspectsAndResistances.MOD_ID + ".config." + "shock_multiplier")
                    .define("shock_effect", 0.25F);
        }
    }
}
