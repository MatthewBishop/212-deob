import java.util.Comparator;

class class393 implements Comparator {
	// $FF: synthetic field

	final class394 this$0;

	class393(class394 var1) {
		this.this$0 = var1;
	}

	int method2065(class395 var1, class395 var2) {
		if (var1.field3649 > var2.field3649) {
			return 1;
		} else {
			return var1.field3649 < var2.field3649 ? -1 : 0;
		}
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.method2065((class395) var1, (class395) var2);
	}

	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? RouteStrategy.method1110(var0, 10, var1) : Integer.toString(var0);
	}
}
