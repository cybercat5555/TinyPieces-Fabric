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
 * calefactor_protect - cybercat5555
 * Created using Tabula 8.0.0
 */
@Environment(EnvType.CLIENT)
public class CalefactorProtectEntityModel<T extends Entity> extends EntityModel<T> {
    public ModelPart largeRod;
    public ModelPart head;
    public ModelPart crown;
    public ModelPart shield01;
    public ModelPart shield02;
    public ModelPart shield03;
    public ModelPart shield03_1;
    public ModelPart rod01;
    public ModelPart rod02;
    public ModelPart rod03;
    public ModelPart rod04;
    public ModelPart rod05;
    public ModelPart rod06;
    public ModelPart rod07;
    public ModelPart rod08;

    public CalefactorProtectEntityModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shield02 = new ModelPart(this, 37, 0);
        this.shield02.mirror = true;
        this.shield02.setPivot(-7.0F, 4.5F, 0.0F);
        this.shield02.addCuboid(-1.0F, -8.5F, -5.5F, 2.0F, 17.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.rod08 = new ModelPart(this, 18, 23);
        this.rod08.setPivot(1.3F, -3.09F, 5.0F);
        this.rod08.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rod03 = new ModelPart(this, 18, 23);
        this.rod03.setPivot(-4.45F, 9.81F, -1.37F);
        this.rod03.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rod07 = new ModelPart(this, 18, 23);
        this.rod07.setPivot(-4.5F, -3.09F, 2.5F);
        this.rod07.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shield03_1 = new ModelPart(this, 37, 30);
        this.shield03_1.mirror = true;
        this.shield03_1.setPivot(0.0F, 4.5F, 7.0F);
        this.shield03_1.addCuboid(-5.5F, -8.5F, -1.0F, 11.0F, 17.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shield03_1, 0.0F, 3.141592653589793F, 0.0F);
        this.head = new ModelPart(this, 0, 0);
        this.head.setPivot(0.0F, -4.6F, 0.0F);
        this.head.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.rod02 = new ModelPart(this, 18, 23);
        this.rod02.setPivot(2.27F, 9.01F, 2.27F);
        this.rod02.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rod01 = new ModelPart(this, 18, 23);
        this.rod01.setPivot(0.27F, 7.91F, -2.25F);
        this.rod01.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shield01 = new ModelPart(this, 37, 0);
        this.shield01.setPivot(7.0F, 4.5F, 0.0F);
        this.shield01.addCuboid(-1.0F, -8.5F, -5.5F, 2.0F, 17.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.rod06 = new ModelPart(this, 18, 23);
        this.rod06.setPivot(4.4F, -0.19F, -1.1F);
        this.rod06.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.largeRod = new ModelPart(this, 0, 21);
        this.largeRod.setPivot(0.0F, 8.0F, 0.0F);
        this.largeRod.addCuboid(-2.0F, -11.5F, -2.0F, 4.0F, 23.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.crown = new ModelPart(this, 11, 43);
        this.crown.setPivot(0.0F, -4.6F, 0.0F);
        this.crown.addCuboid(-4.0F, -13.2F, -4.0F, 8.0F, 13.0F, 8.0F, 0.5F, 0.5F, 0.5F);
        this.rod04 = new ModelPart(this, 18, 23);
        this.rod04.setPivot(-2.27F, 7.61F, 4.45F);
        this.rod04.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rod05 = new ModelPart(this, 18, 23);
        this.rod05.setPivot(-2.8F, -2.69F, -5.8F);
        this.rod05.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shield03 = new ModelPart(this, 37, 30);
        this.shield03.setPivot(0.0F, 4.5F, -7.0F);
        this.shield03.addCuboid(-5.5F, -8.5F, -1.0F, 11.0F, 17.0F, 2.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.shield02, this.rod08, this.rod03, this.rod07, this.shield03_1, this.head, this.rod02, this.rod01, this.shield01, this.rod06, this.largeRod, this.crown, this.rod04, this.rod05, this.shield03).forEach((modelRenderer) -> { 
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
