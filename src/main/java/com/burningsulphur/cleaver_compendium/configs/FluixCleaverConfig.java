package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class FluixCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public FluixCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.FLUIX_CLEAVER_DISABLE.get();
    }

    public static class Serializer implements IConditionSerializer<FluixCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "fluix_cleaver_disable");
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public FluixCleaverConfig read(JsonObject json) {
            return new FluixCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, FluixCleaverConfig value) {

        }
    }
}