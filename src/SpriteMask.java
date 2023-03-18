public class SpriteMask extends DualNode {

	public final int width;

	public final int height;

	public final int[] xWidths;

	public final int[] xStarts;

	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1;
		this.height = var2;
		this.xWidths = var3;
		this.xStarts = var4;
	}

	public boolean contains(int var1, int var2) {
		if (var2 >= 0 && var2 < this.xStarts.length) {
			int var3 = this.xStarts[var2];
			if (var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
				return true;
			}
		}

		return false;
	}

	public static class352 findEnumerated(class352[] var0, int var1) {
		class352[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class352 var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	public static void method1629() {
		ByteArrayPool.field3616.clear();
		ByteArrayPool.field3616.add(100);
		ByteArrayPool.field3616.add(5000);
		ByteArrayPool.field3616.add(10000);
		ByteArrayPool.field3616.add(30000);
	}
}
