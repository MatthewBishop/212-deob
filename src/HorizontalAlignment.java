public enum HorizontalAlignment implements class352 {

	field1539(0, 0),

	HorizontalAlignment_centered(2, 1), field1537(1, 2);

	public final int value;

	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	public int rsOrdinal() {
		return this.id;
	}

	static Script method957(int var0, int var1) {
		Script var2 = (Script) Script.Script_cached.get((long) (var0 << 16));
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = class167.archive12.getGroupId(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = class167.archive12.takeFileFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = class4.newScript(var5);
					if (var2 != null) {
						Script.Script_cached.put(var2, (long) (var0 << 16));
						return var2;
					}
				}

				return null;
			}
		}
	}
}
