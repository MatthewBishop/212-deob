final class class102 implements class304 {

	public static AbstractArchive HitSplatDefinition_archive;
	// $FF: synthetic field

	final Widget val$cc;

	class102(Widget var1) {
		this.val$cc = var1;
	}

	public void vmethod5708() {
		if (this.val$cc != null && this.val$cc.method1768().field2777 != null) {
			ScriptEvent var1 = new ScriptEvent();
			var1.method467(this.val$cc);
			var1.setArgs(this.val$cc.method1768().field2777);
			class144.getScriptEvents().addFirst(var1);
		}

	}

	static float method598(float[] var0, int var1, float var2) {
		float var3 = var0[var1];

		for (int var4 = var1 - 1; var4 >= 0; --var4) {
			var3 = var0[var4] + var3 * var2;
		}

		return var3;
	}

	static int method597(int var0) {
		return (int) Math.pow(2.0D, (double) (7.0F + (float) var0 / 256.0F));
	}
}
