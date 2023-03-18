public class class248 implements WorldMapSection {

	static Varcs varcs;

	int field2309;

	int field2300;

	int field2301;

	int field2302;

	int field2299;

	int field2304;

	int field2305;

	int field2306;

	int field2307;

	int field2303;

	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2299) {
			var1.regionLowX = this.field2299;
		}

		if (var1.regionHighX < this.field2299) {
			var1.regionHighX = this.field2299;
		}

		if (var1.regionLowY > this.field2304) {
			var1.regionLowY = this.field2304;
		}

		if (var1.regionHighY < this.field2304) {
			var1.regionHighY = this.field2304;
		}

	}

	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2309 && var1 < this.field2300 + this.field2309) {
			return var2 >= (this.field2301 << 6) + (this.field2305 << 3)
					&& var2 <= (this.field2301 << 6) + (this.field2305 << 3) + 7
					&& var3 >= (this.field2302 << 6) + (this.field2306 << 3)
					&& var3 <= (this.field2302 << 6) + (this.field2306 << 3) + 7;
		} else {
			return false;
		}
	}

	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2299 << 6) + (this.field2307 << 3)
				&& var1 <= (this.field2299 << 6) + (this.field2307 << 3) + 7
				&& var2 >= (this.field2304 << 6) + (this.field2303 << 3)
				&& var2 <= (this.field2304 << 6) + (this.field2303 << 3) + 7;
	}

	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] {
					var2 + (this.field2299 * 64 - this.field2301 * 64) + (this.field2307 * 8 - this.field2305 * 8),
					var3 + (this.field2304 * 64 - this.field2302 * 64) + (this.field2303 * 8 - this.field2306 * 8) };
			return var4;
		}
	}

	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field2301 * 64 - this.field2299 * 64 + (this.field2305 * 8 - this.field2307 * 8) + var1;
			int var4 = var2 + (this.field2302 * 64 - this.field2304 * 64) + (this.field2306 * 8 - this.field2303 * 8);
			return new Coord(this.field2309, var3, var4);
		}
	}

	public void read(Buffer var1) {
		this.field2309 = var1.readUnsignedByte();
		this.field2300 = var1.readUnsignedByte();
		this.field2301 = var1.readUnsignedShort();
		this.field2305 = var1.readUnsignedByte();
		this.field2302 = var1.readUnsignedShort();
		this.field2306 = var1.readUnsignedByte();
		this.field2299 = var1.readUnsignedShort();
		this.field2307 = var1.readUnsignedByte();
		this.field2304 = var1.readUnsignedShort();
		this.field2303 = var1.readUnsignedByte();
		this.method1420();
	}

	void method1420() {
	}

	public static void method1423(AbstractArchive var0) {
		VarbitComposition.VarbitDefinition_archive = var0;
	}

	public static void method1422() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < class188.idxCount; ++var0) {
				JagexCache.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
			;
		}

	}
}
