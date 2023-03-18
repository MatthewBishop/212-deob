import java.util.Comparator;

public class UserComparator4 implements Comparator {

	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy) var1, (Buddy) var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public static void method649(AbstractArchive var0) {
		InvDefinition.InvDefinition_archive = var0;
	}

	public static int method650(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
		}
	}

	public static void method648() {
		StructComposition.StructDefinition_cached.clear();
	}
}
