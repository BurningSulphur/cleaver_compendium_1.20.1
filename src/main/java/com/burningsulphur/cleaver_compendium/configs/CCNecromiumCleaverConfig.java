package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class CCNecromiumCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public CCNecromiumCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.CCNECROMIUM_CLEAVER_DISABLE.get();
    }

    public static class Serializer implements IConditionSerializer<CCNecromiumCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "ccnecromium_cleaver_disable");
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public CCNecromiumCleaverConfig read(JsonObject json) {
            return new CCNecromiumCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, CCNecromiumCleaverConfig value) {

        }
    }
}