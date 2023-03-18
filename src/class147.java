public class class147 extends class140 {

	boolean field1326;

	byte field1322;

	byte field1325;

	byte field1323;

	byte field1324;
	// $FF: synthetic field

	final class143 this$0;

	class147(class143 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1326 = var1.readUnsignedByte() == 1;
		this.field1322 = var1.readByte();
		this.field1325 = var1.readByte();
		this.field1323 = var1.readByte();
		this.field1324 = var1.readByte();
	}

	void vmethod3248(ClanSettings var1) {
		var1.allowGuests = this.field1326;
		var1.field1342 = this.field1322;
		var1.field1346 = this.field1325;
		var1.field1343 = this.field1323;
		var1.field1344 = this.field1324;
	}
}
