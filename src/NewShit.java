public class NewShit {

	public long field1545;

	int[] field1542;

	short[] field1543;

	short[] field1544;

	public NewShit(long var1, int[] var3, short[] var4, short[] var5) {
		this.field1545 = var1;
		this.field1542 = var3;
		this.field1543 = var4;
		this.field1544 = var5;
	}

	public static HitSplatDefinition method958(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition) HitSplatDefinition.HitSplatDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class102.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}
}
