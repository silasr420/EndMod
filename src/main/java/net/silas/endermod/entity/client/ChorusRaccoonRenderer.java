package net.silas.endermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silas.endermod.EndMod;
import net.silas.endermod.entity.custom.ChorusRaccoonEntity;

public class ChorusRaccoonRenderer extends MobRenderer<ChorusRaccoonEntity, ChorusRaccoonModel> {
    public ChorusRaccoonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ChorusRaccoonModel(pContext.bakeLayer(ModModelLayers.CHORUS_RACCOON)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(ChorusRaccoonEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndMod.MOD_ID, "textures/entity/chorus_raccoon/chorus_raccoon.png");
    }

    @Override
    public void render(ChorusRaccoonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
