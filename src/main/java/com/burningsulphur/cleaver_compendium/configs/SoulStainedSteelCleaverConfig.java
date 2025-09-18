package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class SoulStainedSteelCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public SoulStainedSteelCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.SOUL_STAINED_STEEL_CLEAVER_DISABLE.get(); //<---- Update this line here
    }

    public static class Serializer implements IConditionSerializer<SoulStainedSteelCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "soul_stained_steel_cleaver_disable"); // <----------update this line here
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public SoulStainedSteelCleaverConfig read(JsonObject json) {
            return new SoulStainedSteelCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, SoulStainedSteelCleaverConfig value) {

        }
    }
}