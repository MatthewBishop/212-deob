public final class GameObject {

	static Widget scriptDotWidget;

	int plane;

	int z;

	int centerX;

	int centerY;

	int startX;

	public Renderable renderable;

	int orientation;

	int endX;

	int startY;

	int endY;

	int field2228;

	int lastDrawn;

	public long tag = 0L;

	int flags = 0;

	public static int method1307(int var0) {
		return var0 >>> 4 & class473.field3964;
	}

	public static FillMode[] FillMode_values() {
		return new FillMode[] { FillMode.field4040, FillMode.field4041, FillMode.SOLID };
	}
}
