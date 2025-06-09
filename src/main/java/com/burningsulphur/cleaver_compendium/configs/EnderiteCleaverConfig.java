package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class EnderiteCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public EnderiteCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.ENDERITE_CLEAVER_DISABLE.get();
    }

    public static class Serializer implements IConditionSerializer<EnderiteCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "enderite_cleaver_disable");
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public EnderiteCleaverConfig read(JsonObject json) {
            return new EnderiteCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, EnderiteCleaverConfig value) {

        }
    }
}