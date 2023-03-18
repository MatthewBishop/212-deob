public enum WorldMapDecorationType implements class352 {

	field3014(0, 0),

	field3003(1, 0),

	field3004(2, 0),

	field3022(3, 0),

	field3006(9, 2),

	field3007(4, 1),

	field3008(5, 1),

	field3009(6, 1),

	field3010(7, 1),

	field3011(8, 1),

	field3012(12, 2),

	field3013(13, 2),

	field3019(14, 2),

	field3025(15, 2),

	field3016(16, 2),

	field3015(17, 2),

	field3018(18, 2),

	field3021(19, 2),

	field3020(20, 2),

	field3005(21, 2),

	field3002(10, 2),

	field3017(11, 2),

	field3024(22, 3);

	public final int id;

	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	public int rsOrdinal() {
		return this.id;
	}

	public static int Widget_unpackTargetMask(int var0) {
		return var0 >> 11 & 63;
	}

	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4]
					+ Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1]
					+ Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var8 * (128 - var7) + var9 * var7 >> 7;
		} else {
			return 0;
		}
	}
}
