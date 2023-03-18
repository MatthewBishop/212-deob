public class class36 {

	public static IterableNodeDeque reflectionChecks = new IterableNodeDeque();

	static Archive field149;

	static IndexedSprite[] modIconSprites;

	public static int method175(int var0) {
		return var0 >>> 12;
	}

	static void method176() {
		Tiles.Tiles_underlays = null;
		Tiles.Tiles_overlays = null;
		class16.Tiles_shapes = null;
		Tiles.field823 = null;
		class17.field51 = null;
		Decimator.field300 = null;
		class306.field2773 = null;
		Tiles.Tiles_hue = null;
		class134.Tiles_saturation = null;
		Language.Tiles_lightness = null;
		TileItem.Tiles_hueMultiplier = null;
		Interpreter.field696 = null;
	}

	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = WorldMapSection1.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}
}
