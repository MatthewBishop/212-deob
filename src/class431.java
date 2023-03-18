public class class431 {

	public static final class431 field3770 = new class431("application/json");

	static final class431 field3771 = new class431("text/plain");

	String field3772;

	class431(String var1) {
		this.field3772 = var1;
	}

	public String method2220() {
		return this.field3772;
	}

	public static String method2221(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.'
					&& var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = class18.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char) (var6 + 55));
					} else {
						var2.append((char) (var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char) (var6 + 55));
					} else {
						var2.append((char) (var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}
}
