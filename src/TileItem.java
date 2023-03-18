public final class TileItem extends Renderable {

	static int field1075;

	static int[] Tiles_hueMultiplier;

	int id;

	int quantity;

	int field1076 = 31;

	void method592(int var1) {
		this.field1076 = var1;
	}

	protected final Model getModel() {
		return ParamComposition.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	boolean method593(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1076 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}
}
