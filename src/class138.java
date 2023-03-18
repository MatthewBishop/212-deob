public class class138 extends class140 {

	long field1293;

	String field1292;
	// $FF: synthetic field

	final class143 this$0;

	class138(class143 var1) {
		this.this$0 = var1;
		this.field1293 = -1L;
		this.field1292 = null;
	}

	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1293 = var1.readLong();
		}

		this.field1292 = var1.readStringCp1252NullTerminatedOrNull();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method793(this.field1293, this.field1292, 0);
	}

	static int method744(int var0, Script var1, boolean var2) {
		if (var0 == 5630) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	static long method743() {
		return Client.playerUUID;
	}
}
