public class class144 extends class140 {

	public static int[] SpriteBuffer_spriteHeights;

	public static byte[][] SpriteBuffer_pixels;

	int field1308;

	byte field1309;
	// $FF: synthetic field

	final class143 this$0;

	class144(class143 var1) {
		this.this$0 = var1;
		this.field1308 = -1;
	}

	void vmethod3254(Buffer var1) {
		this.field1308 = var1.readUnsignedShort();
		this.field1309 = var1.readByte();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method795(this.field1308, this.field1309);
	}

	public static NodeDeque getScriptEvents() {
		return Client.scriptEvents;
	}
}
