public class class132 {

	public static EnumComposition getEnum(int var0) {
		EnumComposition var1 = (EnumComposition) EnumComposition.EnumDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = EnumComposition.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumComposition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumComposition.EnumDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}

	public static int method720(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int) (var2 >>> 0 & 127L);
		return var1;
	}
}
