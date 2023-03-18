public class class146 extends class156 {

	static Widget[] field1320;

	int field1321;

	byte field1317;

	int field1318;

	String field1319;
	// $FF: synthetic field

	final class157 this$0;

	class146(class157 var1) {
		this.this$0 = var1;
		this.field1321 = -1;
	}

	void vmethod3238(Buffer var1) {
		this.field1321 = var1.readUnsignedShort();
		this.field1317 = var1.readByte();
		this.field1318 = var1.readUnsignedShort();
		var1.readLong();
		this.field1319 = var1.readStringCp1252NullTerminated();
	}

	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember) var1.members.get(this.field1321);
		var2.rank = this.field1317;
		var2.world = this.field1318;
		var2.username = new Username(this.field1319);
	}

	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = class350.getPreferencesFile("", DbTableType.field3951.name, true);
			Buffer var1 = WorldMapSectionType.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
			;
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
			;
		}

	}

	static int method771(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - 48;
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - 55;
				} else {
					if (var8 < 'a' || var8 > 'z') {
						throw new NumberFormatException();
					}

					var10 = var8 - 87;
				}

				if (var10 >= var1) {
					throw new NumberFormatException();
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var10 + var5 * var1;
				if (var9 / var1 != var5) {
					throw new NumberFormatException();
				}

				var5 = var9;
				var4 = true;
			}

			if (!var4) {
				throw new NumberFormatException();
			} else {
				return var5;
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}
}
