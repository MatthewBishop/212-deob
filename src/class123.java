public class class123 {

	public static final float field1167 = Math.ulp(1.0F);

	public static final float field1166;

	static float[] field1168;

	static float[] field1169;

	static boolean[] Widget_loadedInterfaces;

	static int[] regionLandArchiveIds;

	static {
		field1166 = field1167 * 2.0F;
		field1168 = new float[4];
		field1169 = new float[5];
	}

	public static void method677(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2,
			AbstractArchive var3) {
		MouseRecorder.Widget_archive = var0;
		MoveSpeed.field1844 = var1;
		MusicPatch.Widget_spritesArchive = var2;
		AbstractWorldMapData.Widget_fontsArchive = var3;
		class155.Widget_interfaceComponents = new Widget[MouseRecorder.Widget_archive.getGroupCount()][];
		Widget_loadedInterfaces = new boolean[MouseRecorder.Widget_archive.getGroupCount()];
	}

	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length
				&& WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0]
						: new WorldMapElement(var0);
	}

	static void method679() {
		for (class207 var0 = (class207) Client.field565.last(); var0 != null; var0 = (class207) Client.field565
				.previous()) {
			var0.remove();
		}

	}

	static final void method680(String var0, String var1, int var2, int var3, int var4, int var5, int var6) {
		class351.insertMenuItem(var0, var1, var2, var3, var4, var5, var6, false);
	}
}
