public class WorldMapSection2 implements WorldMapSection {

	static SpritePixels[] worldSelectBackSprites;

	int minPlane;

	int planes;

	int regionStartX;

	int regionStartY;

	int regionEndX;

	int regionEndY;

	int field2252;

	int field2249;

	int field2253;

	int field2254;

	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2252) {
			var1.regionLowX = this.field2252;
		}

		if (var1.regionHighX < this.field2253) {
			var1.regionHighX = this.field2253;
		}

		if (var1.regionLowY > this.field2249) {
			var1.regionLowY = this.field2249;
		}

		if (var1.regionHighY < this.field2254) {
			var1.regionHighY = this.field2254;
		}

	}

	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY
					&& var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field2252 && var1 >> 6 <= this.field2253 && var2 >> 6 >= this.field2249
				&& var2 >> 6 <= this.field2254;
	}

	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] { var2 + (this.field2252 * 64 - this.regionStartX * 64),
					var3 + (this.field2249 * 64 - this.regionStartY * 64) };
			return var4;
		}
	}

	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field2252 * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.field2249 * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field2252 = var1.readUnsignedShort();
		this.field2249 = var1.readUnsignedShort();
		this.field2253 = var1.readUnsignedShort();
		this.field2254 = var1.readUnsignedShort();
		this.postRead();
	}

	void postRead() {
	}

	public static final synchronized long clockNow() {
		long var0 = System.currentTimeMillis();
		if (var0 < class289.field2656) {
			class289.field2657 += class289.field2656 - var0;
		}

		class289.field2656 = var0;
		return class289.field2657 + var0;
	}

	public static boolean method1332(char var0) {
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
			if (var0 != 0) {
				char[] var1 = class365.cp1252AsciiExtension;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		} else {
			return true;
		}
	}

	static void method1329() {
		for (ObjectSound var0 = (ObjectSound) ObjectSound.objectSounds
				.last(); var0 != null; var0 = (ObjectSound) ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}
}
