package machinemuse.powersuits.powermodule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PowerModuleIronPlating extends PowerModule {

	@Override
	public NBTTagCompound newModuleTag() {
		NBTTagCompound newtag = new NBTTagCompound();
		newtag.setString("Name", getName());
		newtag.setFloat("Durability", 100f);
		newtag.setInteger("Level", 0);
		return newtag;
	}

	@Override
	public String getName() {
		return "Iron Armor Plating";
	}

	@Override
	public float getWeight(EntityPlayer player, NBTTagCompound moduleTag) {
		return 10;
	}

	@Override
	public int getLevel(EntityPlayer player, NBTTagCompound moduleTag) {
		return moduleTag.getInteger("Level");
	}

	@Override
	public int getMaxLevel(EntityPlayer player, NBTTagCompound moduleTag) {
		return 4;
	}

	@Override
	public int getArmorValue(EntityPlayer player, NBTTagCompound moduleTag) {
		return getLevel(player, moduleTag);
	}

	@Override
	public List<String> getTooltip(EntityPlayer player, NBTTagCompound moduleTag) {
		String[] strings = { "Hi", "Module" };
		return Arrays.asList(strings);
	}

	@Override
	public List<ItemStack> getRefund(EntityPlayer player,
			NBTTagCompound moduleTag) {
		List<ItemStack> stacks = new ArrayList<ItemStack>();
		stacks.add(new ItemStack(Item.redstone,
				(getLevel(player, moduleTag) + 1) * 4));
		return stacks;
	}

	@Override
	public List<ItemStack> getCost(EntityPlayer player, NBTTagCompound moduleTag) {
		List<ItemStack> stacks = new ArrayList<ItemStack>();
		stacks.add(new ItemStack(Item.redstone,
				(getLevel(player, moduleTag) + 1) * 4));
		return stacks;
	}

	@Override
	public List<PowerModule> getPrerequisites(EntityPlayer player,
			NBTTagCompound moduleTag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getValidSlots() {
		boolean[] slots = { true, true, true, true, false };
		return slots;
	}

	@Override
	public String getCategory() {
		return "Defense";
	}

	@Override
	public void onPlayerTick(EntityPlayer player, NBTTagCompound moduleTag) {
		/** Do nothing **/
	}

	@Override
	public void onDamageItem(EntityPlayer player, NBTTagCompound moduleTag,
			float damageAmount) {
		float durability = moduleTag.getFloat("Durability");
		moduleTag.setFloat("Durability", durability - damageAmount);
	}

	@Override
	public boolean onUpgrade(EntityPlayer player, NBTTagCompound moduleTag) {
		int level = moduleTag.getInteger("Level");
		if (level < getMaxLevel(player, moduleTag)) {
			moduleTag.setInteger("Level", level + 1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getIconIndex() {
		return 0;
	}

	@Override
	public int getItemOverlayIndex() {
		return 0;
	}

}