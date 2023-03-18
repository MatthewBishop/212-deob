public class class173 {

	static int foundItemIndex;

	public UrlRequest field1427;

	public float[] field1426;
	// $FF: synthetic field

	final class167 this$0;

	class173(class167 var1) {
		this.this$0 = var1;
		this.field1426 = new float[4];
	}

	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2885 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2976 == null) {
				var0.field2976 = new int[var0.field2885.length];
			}

			var0.field2976[var1] = Integer.MAX_VALUE;
		}
	}
}
