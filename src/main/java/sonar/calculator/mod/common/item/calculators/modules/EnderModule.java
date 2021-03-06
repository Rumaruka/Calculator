package sonar.calculator.mod.common.item.calculators.modules;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sonar.calculator.mod.api.modules.IModuleClickable;
import sonar.core.api.utils.BlockInteraction;
import sonar.core.helpers.FontHelper;

public class EnderModule extends ModuleBase implements IModuleClickable {

	@Override
	public String getName() {
		return "Ender";
	}

	@Override
	public String getClientName() {
		return FontHelper.translate("flawless.mode5");
	}

	@Override
	public void onModuleActivated(ItemStack stack, NBTTagCompound tag, World world, EntityPlayer player) {
		if (this.isEnergyAvailable(stack, player, world, 1000)) {
			world.playSound(player, player.getPosition(), SoundEvent.REGISTRY.getObject(new ResourceLocation("random.bow")), SoundCategory.PLAYERS, 0.5F, 0.4F);
			if (!world.isRemote)
				world.spawnEntityInWorld(new EntityEnderPearl(world, player));
		}
	}

	@Override
	public boolean onBlockClicked(ItemStack stack, NBTTagCompound tag, EntityPlayer player, World world, BlockPos pos, BlockInteraction interaction) {
		return false;
	}

}
