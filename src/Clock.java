public abstract class Clock {

	static Archive archive11;

	public abstract void mark();

	public abstract int wait(int var1, int var2);

	public static int method920(int var0) {
		return (var0 & class473.field3965) - 1;
	}

	static Object[] method918(Buffer var0, int[] var1) {
		int var2 = var0.readUShortSmart();
		Object[] var3 = new Object[var1.length * var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			for (int var5 = 0; var5 < var1.length; ++var5) {
				int var6 = var1.length * var4 + var5;
				class467 var7 = class458.method2331(var1[var5]);
				var3[var6] = var7.method2362(var0);
			}
		}

		return var3;
	}

	public static boolean method919(int var0) {
		return (var0 >> 21 & 1) != 0;
	}
}
