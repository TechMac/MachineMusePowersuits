package net.machinemuse.powersuits.powermodule.misc;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import net.machinemuse.api.IModularItem;
import net.machinemuse.api.MuseCommonStrings;
import net.machinemuse.api.MuseItemUtils;
import net.machinemuse.api.electricity.ElectricItemUtils;
import net.machinemuse.powersuits.item.ItemComponent;
import net.machinemuse.powersuits.powermodule.PowerModuleBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ThaumGogglesModule extends PowerModuleBase {
	public static final String MODULE_THAUM_GOGGLES = "Aurameter";
	Class tcItems;
	ItemStack gogglesStack = null;

	public ThaumGogglesModule(List<IModularItem> validItems) {
		super(validItems);
		try {
			tcItems = Class.forName("thaumcraft.common.Config");
			Field itemGoggles = tcItems.getField("itemGoggles");
			Item goggles = (Item) itemGoggles.get(itemGoggles);
			gogglesStack = new ItemStack(goggles);
			addInstallCost(ItemComponent.laserHologram.copy()).addInstallCost(gogglesStack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getCategory() {
		return MuseCommonStrings.CATEGORY_SPECIAL;
	}

	@Override
	public String getName() {
		return MODULE_THAUM_GOGGLES;
	}

	@Override
	public String getDescription() {
		return "Connect up some Thaumic goggles to show the nearby aura values. (Does not reveal aura nodes, only shows the HUD)";
	}

	@Override
	public String getTextureFile() {
		return "bluestar";
	}
}
