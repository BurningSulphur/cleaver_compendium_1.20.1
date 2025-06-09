package com.burningsulphur.cleaver_compendium.configs;


import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import com.burningsulphur.cleaver_compendium.Config;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class KoboldIronCleaverConfig implements ICondition {

    private final ResourceLocation location;

    public KoboldIronCleaverConfig(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return !Config.KOBOLD_IRON_CLEAVER_DISABLE.get();
    }

    public static class Serializer implements IConditionSerializer<KoboldIronCleaverConfig> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(CleaverCompendium.MOD_ID, "kobold_iron_cleaver_disable");
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }

        @Override
        public KoboldIronCleaverConfig read(JsonObject json) {
            return new KoboldIronCleaverConfig(this.location);
        }

        @Override
        public void write(JsonObject json, KoboldIronCleaverConfig value) {

        }
    }
}