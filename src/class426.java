public abstract class class426 extends class269 implements class485 {

	protected class426(StudioGame var1, Language var2, int var3) {
		super(var1, var2, var3);
	}

	protected abstract class428 vmethod8207(int var1);

	public int method2212() {
		return super.field2405;
	}

	public Object vmethod8697(int var1) {
		class428 var2 = this.vmethod8207(var1);
		return var2 != null && var2.method2216() ? var2.method2218() : null;
	}

	public class486 method2213(Buffer var1) {
		int var2 = var1.readUnsignedShort();
		class428 var3 = this.vmethod8207(var2);
		class486 var4 = new class486(var2);
		Class var5 = var3.field3769.field3944;
		if (var5 == Integer.class) {
			var4.field4026 = var1.readInt();
		} else if (var5 == Long.class) {
			var4.field4026 = var1.readLong();
		} else if (var5 == String.class) {
			var4.field4026 = var1.readStringCp1252NullCircumfixed();
		} else {
			if (!class481.class.isAssignableFrom(var5)) {
				throw new IllegalStateException();
			}

			try {
				class481 var6 = (class481) var5.newInstance();
				var6.method2482(var1);
				var4.field4026 = var6;
			} catch (InstantiationException var7) {
				;
			} catch (IllegalAccessException var8) {
				;
			}
		}

		return var4;
	}
}
