public class class486 {

	public final int field4027;

	public Object field4026;

	public class486(int var1) {
		this.field4027 = var1;
	}

	public class486(int var1, Object var2) {
		this.field4027 = var1;
		this.field4026 = var2;
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class486)) {
			return false;
		} else {
			class486 var2 = (class486) var1;
			if (var2.field4026 == null && this.field4026 != null) {
				return false;
			} else if (this.field4026 == null && var2.field4026 != null) {
				return false;
			} else {
				return var2.field4027 == this.field4027 && var2.field4026.equals(this.field4026);
			}
		}
	}
}
