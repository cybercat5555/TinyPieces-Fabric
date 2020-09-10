package tinypieces.tinypiecesfabric.client.entity.model;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

/**
 * calefactor_crown - cybecat5555
 * Created using Tabula 8.0.0
 */
@Environment(EnvType.CLIENT)
public class CalefactorCrownModel<T extends Entity> extends EntityModel<T> {
    public ModelPart rightArm;
    public ModelPart rightLeg;
    public ModelPart head;
    public ModelPart body;
    public ModelPart leftArm;
    public ModelPart leftLeg;
    public ModelPart crown;

    public CalefactorCrownModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rightArm = new ModelPart(this, 40, 16);
        this.rightArm.mirror = true;
        this.rightArm.setPivot(-5.0F, 2.0F, 0.0F);
        this.rightArm.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelPart(this, 0, 0);
        this.head.setPivot(0.0F, 0.0F, 0.0F);
        this.head.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.crown = new ModelPart(this, 72, 0);
        this.crown.setPivot(0.0F, 0.0F, 0.0F);
        this.crown.addCuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.6F, 0.6F, 0.6F);
        this.leftArm = new ModelPart(this, 40, 16);
        this.leftArm.setPivot(5.0F, 2.0F, 0.0F);
        this.leftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.rightLeg = new ModelPart(this, 0, 16);
        this.rightLeg.mirror = true;
        this.rightLeg.setPivot(-1.9F, 12.0F, 0.0F);
        this.rightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.leftLeg = new ModelPart(this, 0, 16);
        this.leftLeg.setPivot(1.9F, 12.0F, 0.0F);
        this.leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelPart(this, 16, 16);
        this.body.setPivot(0.0F, 0.0F, 0.0F);
        this.body.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.rightArm, this.head, this.crown, this.leftArm, this.rightLeg, this.leftLeg, this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pivotX = x;
        modelRenderer.pivotY = y;
        modelRenderer.pivotZ = z;
    }
}
