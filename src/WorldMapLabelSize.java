public class WorldMapLabelSize {

	public static final WorldMapLabelSize WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);

	public static final WorldMapLabelSize WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);

	public static final WorldMapLabelSize WorldMapLabelSize_large = new WorldMapLabelSize(0, 2, 0);

	final int field2236;

	final int field2237;

	final int field2233;

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field2236 = var1;
		this.field2237 = var2;
		this.field2233 = var3;
	}

	boolean method1314(float var1) {
		return var1 >= (float) this.field2233;
	}

	static WorldMapLabelSize[] method1315() {
		return new WorldMapLabelSize[] { WorldMapLabelSize_small, WorldMapLabelSize_medium, WorldMapLabelSize_large };
	}

	static int method1318(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 0) {
				var1 = 0;
			} else if (var1 > 127) {
				var1 = 127;
			}

			var1 = 127 - var1;
			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 'ﾀ') + var1;
		}
	}

	static WorldMapSprite method1316(byte[] var0) {
		return var0 == null ? new WorldMapSprite() : new WorldMapSprite(class139.method748(var0).pixels);
	}

	static VerticalAlignment[] method1317() {
		return new VerticalAlignment[] { VerticalAlignment.field1594, VerticalAlignment.field1592,
				VerticalAlignment.VerticalAlignment_centered };
	}

	public static int method1313(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}
}
