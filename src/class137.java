public class class137 extends class140 {

	int field1291;

	int field1289;

	int field1288;

	int field1290;
	// $FF: synthetic field

	final class143 this$0;

	class137(class143 var1) {
		this.this$0 = var1;
		this.field1291 = -1;
	}

	void vmethod3254(Buffer var1) {
		this.field1291 = var1.readUnsignedShort();
		this.field1289 = var1.readInt();
		this.field1288 = var1.readUnsignedByte();
		this.field1290 = var1.readUnsignedByte();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method794(this.field1291, this.field1289, this.field1288, this.field1290);
	}

	public static void method740(AbstractArchive var0) {
		StructComposition.StructDefinition_archive = var0;
	}

	static final int method738(int var0, int var1) {
		int var2 = class11.method40(var0 - 1, var1 - 1) + class11.method40(var0 + 1, var1 - 1)
				+ class11.method40(var0 - 1, var1 + 1) + class11.method40(var0 + 1, var1 + 1);
		int var3 = class11.method40(var0 - 1, var1) + class11.method40(var0 + 1, var1)
				+ class11.method40(var0, var1 - 1) + class11.method40(var0, var1 + 1);
		int var4 = class11.method40(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}
}
