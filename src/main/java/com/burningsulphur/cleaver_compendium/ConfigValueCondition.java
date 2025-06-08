package com.burningsulphur.cleaver_compendium;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigValueCondition implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation("cleaver_compendium", "config_value");
    private final String configKey;

    public ConfigValueCondition(String configKey) {
        this.configKey = configKey;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test(IContext context) {
        // Retrieve the config value from your mod's configuration system
        ForgeConfigSpec.BooleanValue configOption = Config.getConfigOption(configKey);
        return configOption != null && configOption.get();
    }

    public static class Serializer implements IConditionSerializer<ConfigValueCondition> {
        @Override
        public void write(JsonObject json, ConfigValueCondition condition) {
            json.addProperty("configKey", condition.configKey);
        }

        @Override
        public ConfigValueCondition read(JsonObject json) {
            String configKey = json.get("configKey").getAsString();
            return new ConfigValueCondition(configKey);
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}
