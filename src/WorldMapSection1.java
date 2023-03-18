public class WorldMapSection1 implements WorldMapSection {

	int minPlane;

	int planes;

	int regionStartX;

	int regionStartY;

	int regionEndX;

	int regionEndY;

	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] { var2 + (this.regionEndX * 64 - this.regionStartX * 64),
					var3 + (this.regionEndY * 64 - this.regionStartY * 64) };
			return var4;
		}
	}

	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.regionEndY * 64);
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
		this.postRead();
	}

	void postRead() {
	}

	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & '\uffff';
		if (class155.Widget_interfaceComponents[var1] == null
				|| class155.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = GrandExchangeEvent.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return class155.Widget_interfaceComponents[var1][var2];
	}

	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (GrandExchangeEvent.loadInterface(var0)) {
				Widget[] var1 = class155.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						class14.runScript(var4, 5000000, 0);
					}
				}

			}
		}
	}
}
