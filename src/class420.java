public final class class420 {

	static class420[] field3741 = new class420[0];

	static int field3736 = 100;

	static int field3735;

	static Font fontPlain12;

	float field3737;

	float field3739;

	float field3740;

	float field3738;

	static {
		field3741 = new class420[100];
		field3735 = 0;
		new class420();
	}

	class420() {
		this.method2179();
	}

	public void method2183() {
		class420[] var1 = field3741;
		synchronized (field3741) {
			if (field3735 < field3736 - 1) {
				field3741[++field3735 - 1] = this;
			}

		}
	}

	void method2182(float var1, float var2, float var3, float var4) {
		this.field3737 = var1;
		this.field3739 = var2;
		this.field3740 = var3;
		this.field3738 = var4;
	}

	public void method2181(float var1, float var2, float var3, float var4) {
		float var5 = (float) Math.sin((double) (var4 * 0.5F));
		float var6 = (float) Math.cos((double) (var4 * 0.5F));
		this.field3737 = var1 * var5;
		this.field3739 = var5 * var2;
		this.field3740 = var5 * var3;
		this.field3738 = var6;
	}

	final void method2179() {
		this.field3740 = 0.0F;
		this.field3739 = 0.0F;
		this.field3737 = 0.0F;
		this.field3738 = 1.0F;
	}

	public final void method2180(class420 var1) {
		this.method2182(
				this.field3740 * var1.field3739 + this.field3738 * var1.field3737 + this.field3737 * var1.field3738
						- var1.field3740 * this.field3739,
				this.field3738 * var1.field3739 + (var1.field3738 * this.field3739 - this.field3740 * var1.field3737)
						+ this.field3737 * var1.field3740,
				this.field3739 * var1.field3737 + this.field3740 * var1.field3738 - var1.field3739 * this.field3737
						+ var1.field3740 * this.field3738,
				this.field3738 * var1.field3738 - var1.field3737 * this.field3737 - this.field3739 * var1.field3739
						- this.field3740 * var1.field3740);
	}

	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = var2 * 31.0F + this.field3737;
		var2 = var2 * 31.0F + this.field3739;
		var2 = this.field3740 + var2 * 31.0F;
		var2 = var2 * 31.0F + this.field3738;
		return (int) var2;
	}

	public String toString() {
		return this.field3737 + "," + this.field3739 + "," + this.field3740 + "," + this.field3738;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class420)) {
			return false;
		} else {
			class420 var2 = (class420) var1;
			return this.field3737 == var2.field3737 && this.field3739 == var2.field3739
					&& this.field3740 == var2.field3740 && this.field3738 == var2.field3738;
		}
	}

	static int method2184(Widget var0) {
		if (var0.type != 11) {
			Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize - 1] = "";
			return 1;
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
			Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var0.method1751(var1);
			return 1;
		}
	}
}
