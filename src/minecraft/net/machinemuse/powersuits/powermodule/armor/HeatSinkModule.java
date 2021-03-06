package net.machinemuse.powersuits.powermodule.armor;

import java.util.List;

import net.machinemuse.api.IModularItem;
import net.machinemuse.api.MuseCommonStrings;
import net.machinemuse.api.MuseHeatUtils;
import net.machinemuse.api.MuseItemUtils;
import net.machinemuse.powersuits.item.ItemComponent;
import net.machinemuse.powersuits.powermodule.PowerModuleBase;

public class HeatSinkModule extends PowerModuleBase {
	public static final String THICKNESS = "Heatsink Thickness";

	public HeatSinkModule(List<IModularItem> validItems) {
		super(validItems);
		addInstallCost(MuseItemUtils.copyAndResize(ItemComponent.basicPlating, 1));
		addTradeoffProperty("Thickness", MuseCommonStrings.WEIGHT, 5000, "g");
		addTradeoffProperty("Thickness", MuseHeatUtils.MAXIMUM_HEAT, 150, "");
	}

	@Override
	public String getCategory() {
		return MuseCommonStrings.CATEGORY_ARMOR;
	}

	@Override
	public String getName() {
		return "Heat Sink";
	}

	@Override
	public String getDescription() {
		return "A thick layer of plating to soak up heat.";
	}

	@Override
	public String getTextureFile() {
		return "heatresistantplating2";
	}

}
