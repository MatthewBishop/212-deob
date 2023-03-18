public class class162 extends class140 {

	long field1390;

	String field1389;
	// $FF: synthetic field

	final class143 this$0;

	class162(class143 var1) {
		this.this$0 = var1;
		this.field1390 = -1L;
		this.field1389 = null;
	}

	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1390 = var1.readLong();
		}

		this.field1389 = var1.readStringCp1252NullTerminatedOrNull();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method796(this.field1390, this.field1389);
	}

	public static GameBuild method851(int var0) {
		GameBuild[] var1 = SecureRandomFuture.method438();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			GameBuild var3 = var1[var2];
			if (var0 == var3.buildId) {
				return var3;
			}
		}

		return null;
	}

	public static boolean isNumber(CharSequence var0) {
		return class175.method907(var0, 10, true);
	}

	public static void method850() {
		VarbitComposition.VarbitDefinition_cached.clear();
	}
}
