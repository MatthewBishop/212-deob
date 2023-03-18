public class class158 extends class140 {

	static int[] BZip2Decompressor_block;

	int field1378;

	int field1377;
	// $FF: synthetic field

	final class143 this$0;

	class158(class143 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1378 = var1.readInt();
		this.field1377 = var1.readInt();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method808(this.field1378, this.field1377);
	}
}
