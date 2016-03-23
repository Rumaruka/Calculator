package sonar.calculator.mod.client.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import sonar.core.common.block.properties.IItemRenderer;

public class ItemCrankHandle implements net.minecraftforge.client.IItemRenderer {
	TileEntitySpecialRenderer render;
	private TileEntity entity;

	public ItemCrankHandle(TileEntitySpecialRenderer render, TileEntity entity) {
		this.entity = entity;
		this.render = render;
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
		GL11.glScaled(1.2, 1.2, 1.2);
		if (type == IItemRenderer.ItemRenderType.ENTITY)
			org.lwjgl.opengl.GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		this.render.renderTileEntityAt(this.entity, 0.0D, -0.2D, 0.0D, 0.0F);
	}
}
