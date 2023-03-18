import java.awt.Component;
import java.awt.Graphics;

public final class Canvas extends java.awt.Canvas {

	static int cameraLookAtY;

	public static int[] SpriteBuffer_yOffsets;

	static int field70;

	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public static void method91(String[] var0, int[] var1) {
		HealthBar.method557(var0, var1, 0, var0.length - 1);
	}

	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}
}
