package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class CrystallineCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public CrystallineCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.CRYSTALLINE_CLEAVER_DISABLE.get(); //<---- Update this line here
    }

    public static class Serializer implements IConditionSerializer<CrystallineCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "crystalline_cleaver_disable"); // <----------update this line here
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public CrystallineCleaverConfig read(JsonObject json) {
            return new CrystallineCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, CrystallineCleaverConfig value) {

        }
    }
}