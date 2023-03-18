public class VarcInt extends DualNode {

	public static AbstractArchive VarcInt_archive;

	public static EvictingDualNodeHashTable VarcInt_cached = new EvictingDualNodeHashTable(64);

	public static boolean ItemDefinition_inMembersWorld;

	public boolean persist = false;

	public void method936(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method937(var1, var2);
		}
	}

	void method937(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}

	public static MoveSpeed[] method938() {
		return new MoveSpeed[] { MoveSpeed.STATIONARY, MoveSpeed.WALK, MoveSpeed.CRAWL, MoveSpeed.RUN };
	}
}
