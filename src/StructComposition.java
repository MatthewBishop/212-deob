public class StructComposition extends DualNode {

	static AbstractArchive StructDefinition_archive;

	static EvictingDualNodeHashTable StructDefinition_cached = new EvictingDualNodeHashTable(64);

	IterableNodeHashTable params;

	void postDecode() {
	}

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
		if (var2 == 249) {
			this.params = AABB.readStringIntParameters(var1, this.params);
		}

	}

	public int getIntParam(int var1, int var2) {
		return class139.method747(this.params, var1, var2);
	}

	public String getStringParam(int var1, String var2) {
		return class428.method2219(this.params, var1, var2);
	}

	static void setOculusOrbState(int var0) {
		Client.oculusOrbState = var0;
	}
}
