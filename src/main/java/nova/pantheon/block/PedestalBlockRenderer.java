package nova.pantheon.block;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

public class PedestalBlockRenderer implements BlockEntityRenderer<PedestalBlockEntity> {

    public PedestalBlockRenderer(BlockEntityRendererFactory.Context renderContext) {

    }

    @Override
    public void render(PedestalBlockEntity blockEntity, float tickDelta, MatrixStack matrixStack,
            VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
        ItemStack itemStack = blockEntity.getStack(0);
        matrixStack.push();
        matrixStack.translate(0.5f, 1f, 0.3f);
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90));
        MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformation.Mode.GROUND, light, overlay, matrixStack,
                vertexConsumerProvider, 0);
        matrixStack.pop();
    }
}
