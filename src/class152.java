public class class152 extends class156 {

	String field1362;

	int field1360;

	byte field1361;
	// $FF: synthetic field

	final class157 this$0;

	class152(class157 var1) {
		this.this$0 = var1;
		this.field1362 = null;
	}

	void vmethod3238(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

		this.field1362 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1360 = var1.readUnsignedShort();
		this.field1361 = var1.readByte();
		var1.readLong();
	}

	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = new ClanChannelMember();
		var2.username = new Username(this.field1362);
		var2.world = this.field1360;
		var2.rank = this.field1361;
		var1.addMember(var2);
	}

	static class135 method814(int var0) {
		class135[] var1 = new class135[] { class135.field1276, class135.field1267, class135.field1268,
				class135.field1269, class135.field1277, class135.field1271, class135.field1272, class135.field1273,
				class135.field1274 };
		class135 var2 = (class135) SpriteMask.findEnumerated(var1, var0);
		if (var2 == null) {
			var2 = class135.field1274;
		}

		return var2;
	}
}
