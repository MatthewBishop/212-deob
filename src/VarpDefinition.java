public class VarpDefinition extends DualNode {

	static AbstractArchive VarpDefinition_archive;

	public static int field1461;

	public static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);

	public static boolean field1462;

	static int field1465;

	public int type = 0;

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	void decodeNext(Buffer var1, int var2) {
		if (var2 == 5) {
			this.type = var1.readUnsignedShort();
		}

	}
}
