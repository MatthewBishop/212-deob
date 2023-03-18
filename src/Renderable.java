public abstract class Renderable extends DualNode {

	public int height = 1000;

	protected Model getModel() {
		return null;
	}

	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	static int method1246(long var0) {
		return (int) (var0 >>> 14 & 3L);
	}
}
