public class GrandExchangeOffer {

	byte state;

	public int id;

	public int unitPrice;

	public int totalQuantity;

	public int currentQuantity;

	public int currentPrice;

	public GrandExchangeOffer() {
	}

	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	public int status() {
		return this.state & 7;
	}

	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	void method1871(int var1) {
		this.state &= -8;
		this.state = (byte) (this.state | var1 & 7);
	}

	void method1872(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte) (this.state | 8);
		}

	}

	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; var3 != 0L; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5;
				char var8;
				for (var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
					long var6 = var0;
					var0 /= 37L;
					var8 = class369.base37Table[(int) (var6 - var0 * 37L)];
					if (var8 == '_') {
						int var9 = var5.length() - 1;
						var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
						var8 = 160;
					}
				}

				var5.reverse();
				var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
				return var5.toString();
			}
		} else {
			return null;
		}
	}

	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2885 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2885 = new byte[11][];
			var0.field2911 = new byte[11][];
			var0.field2893 = new int[11];
			var0.field2913 = new int[11];
		}

		var0.field2885[var1] = var2;
		if (var2 != null) {
			var0.field2909 = true;
		} else {
			var0.field2909 = false;

			for (int var4 = 0; var4 < var0.field2885.length; ++var4) {
				if (var0.field2885[var4] != null) {
					var0.field2909 = true;
					break;
				}
			}
		}

		var0.field2911[var1] = var3;
	}
}
