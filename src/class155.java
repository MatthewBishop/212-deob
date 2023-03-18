public class class155 extends class140 {

	public static Widget[][] Widget_interfaceComponents;

	long field1369;

	String field1371;

	int field1370;
	// $FF: synthetic field

	final class143 this$0;

	class155(class143 var1) {
		this.this$0 = var1;
		this.field1369 = -1L;
		this.field1371 = null;
		this.field1370 = 0;
	}

	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1369 = var1.readLong();
		}

		this.field1371 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1370 = var1.readUnsignedShort();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method793(this.field1369, this.field1371, this.field1370);
	}

	public static void method825() {
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
	}
}
