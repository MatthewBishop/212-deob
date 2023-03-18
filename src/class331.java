public class class331 {
	static {
		int var0 = 0;
		int var1 = 0;
		class326[] var2 = FontName.method2314();

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class326 var4 = var2[var3];
			if (var4.field3032 > var0) {
				var0 = var4.field3032;
			}

			if (var4.field3034 > var1) {
				var1 = var4.field3034;
			}
		}

	}

	static boolean method1802(int var0, int var1, int var2) {
		return var0 >= 0 && var0 < 4 && var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104;
	}

	public static int method1803(int var0, int var1, int var2) {
		int var3 = class206.method1081(var2 - var1 + 1);
		var3 <<= var1;
		var0 |= var3;
		return var0;
	}
}
