public class DbRowType extends DualNode {

	public static AbstractArchive field3960;

	public static EvictingDualNodeHashTable DBRowType_cache = new EvictingDualNodeHashTable(64);

	Object[][] columnTypes;

	int[][] field3959;

	public int tableId = -1;

	void method2378(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method2379(var1, var2);
		}
	}

	public Object[] getColumnType(int var1) {
		return this.columnTypes == null ? null : this.columnTypes[var1];
	}

	void method2379(Buffer var1, int var2) {
		if (var2 == 3) {
			int var3 = var1.readUnsignedByte();
			if (this.columnTypes == null) {
				this.columnTypes = new Object[var3][];
				this.field3959 = new int[var3][];
			}

			for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
				int var5 = var1.readUnsignedByte();
				int[] var6 = new int[var5];

				for (int var7 = 0; var7 < var5; ++var7) {
					var6[var7] = var1.readUShortSmart();
				}

				this.columnTypes[var4] = Clock.method918(var1, var6);
				this.field3959[var4] = var6;
			}
		} else if (var2 == 4) {
			this.tableId = var1.method2463();
		}

	}

	void method2380() {
	}
}
