public final class Occluder {

	static LoginType loginType;

	int minTileX;

	int maxTileX;

	int minTileY;

	int maxTileY;

	int type;

	int minX;

	int maxX;

	int minZ;

	int maxZ;

	int minY;

	int maxY;

	int field2067;

	int field2068;

	int field2056;

	int field2070;

	int field2059;

	int field2072;

	int field2069;

	static class125[] method1252() {
		return new class125[] { class125.field1194, class125.field1193, class125.field1189, class125.field1188,
				class125.field1190 };
	}

	static int method1251(int var0, int var1) {
		int var2 = var1 - 334;
		if (var2 < 0) {
			var2 = 0;
		} else if (var2 > 100) {
			var2 = 100;
		}

		int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
		return var0 * var3 / 256;
	}
}
