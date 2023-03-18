public class class164 extends class140 {

	static String[] cacheParentPaths;

	int field1395;

	long field1394;
	// $FF: synthetic field

	final class143 this$0;

	class164(class143 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1395 = var1.readInt();
		this.field1394 = var1.readLong();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method801(this.field1395, this.field1394);
	}
}
