import java.util.Comparator;

public class UserComparator2 implements Comparator {

	final boolean reversed;

	public UserComparator2(boolean var1) {
		this.reversed = var1;
	}

	int compare_bridged(User var1, User var2) {
		return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername())
				: var2.getUsername().compareToTyped(var1.getUsername());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((User) var1, (User) var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	static final void method2487() {
		int var0 = class20.menuX;
		int var1 = Login.menuY;
		int var2 = PacketWriter.menuWidth;
		int var3 = class30.menuHeight;
		int var4 = 6116423;
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
		Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
		class7.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
		int var5 = MouseHandler.MouseHandler_x;
		int var6 = MouseHandler.MouseHandler_y;

		for (int var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
			int var8 = (Client.menuOptionsCount - 1 - var7) * 15 + var1 + 31;
			int var9 = 16777215;
			if (var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
				var9 = 16776960;
			}

			class7.fontBold12.draw(SceneTilePaint.method1297(var7), var0 + 3, var8, var9, 0);
		}

		VarbitComposition.method992(class20.menuX, Login.menuY, PacketWriter.menuWidth, class30.menuHeight);
	}
}
