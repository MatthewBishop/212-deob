public enum WorldMapSectionType implements class352 {

	WORLDMAPSECTIONTYPE0(3, (byte) 0),

	WORLDMAPSECTIONTYPE1(1, (byte) 1),

	WORLDMAPSECTIONTYPE2(2, (byte) 2),

	WORLDMAPSECTIONTYPE3(0, (byte) 3);

	static ClientPreferences clientPreferences;

	static int cameraMoveToY;

	static Bounds field2332;

	final int type;

	final byte id;

	WorldMapSectionType(int var3, byte var4) {
		this.type = var3;
		this.id = var4;
	}

	public int rsOrdinal() {
		return this.id;
	}

	static WorldMapSectionType[] method1442() {
		return new WorldMapSectionType[] { WORLDMAPSECTIONTYPE0, WORLDMAPSECTIONTYPE1, WORLDMAPSECTIONTYPE3,
				WORLDMAPSECTIONTYPE2 };
	}

	static class129 method1444(int var0) {
		class129 var1 = (class129) SpriteMask.findEnumerated(class208.method1089(), var0);
		if (var1 == null) {
			var1 = class129.field1254;
		}

		return var1;
	}
}
