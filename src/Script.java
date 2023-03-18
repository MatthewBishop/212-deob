public class Script extends DualNode {

	static EvictingDualNodeHashTable Script_cached = new EvictingDualNodeHashTable(128);

	public static class50 pcmPlayerProvider;

	static Widget field803;

	String field793;

	int[] opcodes;

	int[] intOperands;

	String[] stringOperands;

	int localIntCount;

	int localStringCount;

	int intArgumentCount;

	int stringArgumentCount;

	IterableNodeHashTable[] switches;

	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				PcmPlayer.alignWidgetSize(var6, var2, var3, var4);
				Tiles.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					class278.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}
}
