public class ObjTypeCustomisation {

	static boolean field1453;

	public short[] recol;

	public short[] retex;

	ObjTypeCustomisation(int var1) {
		ItemComposition var2 = ParamComposition.ItemDefinition_get(var1);
		if (var2.hasRecolor()) {
			this.recol = new short[var2.recolorTo.length];
			System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
		}

		if (var2.hasRetexture()) {
			this.retex = new short[var2.retextureTo.length];
			System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
		}

	}

	public static void method921(AbstractArchive var0) {
		EnumComposition.EnumDefinition_archive = var0;
	}
}
