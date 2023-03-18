public class GraphicsDefaults {

	public int compass = -1;

	public int field3719 = -1;

	public int mapScenes = -1;

	public int headIconsPk = -1;

	public int field3716 = -1;

	public int field3720 = -1;

	public int field3721 = -1;

	public int field3722 = -1;

	public int field3717 = -1;

	public int field3723 = -1;

	public int field3724 = -1;

	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3713.group);
		Buffer var3 = new Buffer(var2);

		while (true) {
			int var4 = var3.readUnsignedByte();
			if (var4 == 0) {
				return;
			}

			switch (var4) {
			case 1:
				var3.readMedium();
				break;
			case 2:
				this.compass = var3.method2423();
				this.field3719 = var3.method2423();
				this.mapScenes = var3.method2423();
				this.headIconsPk = var3.method2423();
				this.field3716 = var3.method2423();
				this.field3720 = var3.method2423();
				this.field3721 = var3.method2423();
				this.field3722 = var3.method2423();
				this.field3717 = var3.method2423();
				this.field3723 = var3.method2423();
				this.field3724 = var3.method2423();
			}
		}
	}
}
