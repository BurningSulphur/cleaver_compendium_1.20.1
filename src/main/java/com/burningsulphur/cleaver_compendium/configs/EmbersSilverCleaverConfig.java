package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class EmbersSilverCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public EmbersSilverCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.EMBERS_SILVER_CLEAVER_DISABLE.get();
    }

    public static class Serializer implements IConditionSerializer<EmbersSilverCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "esilver_cleaver_disable");
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public EmbersSilverCleaverConfig read(JsonObject json) {
            return new EmbersSilverCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, EmbersSilverCleaverConfig value) {

        }
    }
}