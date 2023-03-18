public final class SceneTilePaint {

	int swColor;

	int seColor;

	int neColor;

	int nwColor;

	int texture;

	boolean isFlat = true;

	int rgb;

	SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	static String method1297(int var0) {
		if (var0 < 0) {
			return "";
		} else {
			return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0]
					: Client.menuActions[var0];
		}
	}
}
