package com.burningsulphur.cleaver_compendium.configs;


import com.google.gson.JsonObject;
import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class SilverCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public SilverCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(ICondition.IContext context) {
        return !Config.SILVER_CLEAVER_DISABLE.get();
    }

    public static class Serializer implements IConditionSerializer<SilverCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "silver_cleaver_disable");
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public SilverCleaverConfig read(JsonObject json) {
            return new SilverCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, SilverCleaverConfig value) {

        }
    }
}