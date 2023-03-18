public class Timer {

	long field3630 = -1L;

	long field3622 = -1L;

	public boolean field3623 = false;

	long field3625 = 0L;

	long field3624 = 0L;

	long field3621 = 0L;

	int field3627 = 0;

	int field3628 = 0;

	int field3626 = 0;

	int field3629 = 0;

	public void method2040() {
		this.field3630 = WorldMapSection2.clockNow();
	}

	public void method2035() {
		if (this.field3630 != -1L) {
			this.field3624 = WorldMapSection2.clockNow() - this.field3630;
			this.field3630 = -1L;
		}

	}

	public void method2038(int var1) {
		this.field3622 = WorldMapSection2.clockNow();
		this.field3627 = var1;
	}

	public void method2039() {
		if (-1L != this.field3622) {
			this.field3625 = WorldMapSection2.clockNow() - this.field3622;
			this.field3622 = -1L;
		}

		++this.field3626;
		this.field3623 = true;
	}

	public void method2036() {
		this.field3623 = false;
		this.field3628 = 0;
	}

	public void method2037() {
		this.method2039();
	}

	public void write(Buffer var1) {
		long var2 = this.field3624;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int) var2);
		long var4 = this.field3625;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int) var4);
		long var6 = this.field3621;
		var6 /= 10L;
		if (var6 < 0L) {
			var6 = 0L;
		} else if (var6 > 65535L) {
			var6 = 65535L;
		}

		var1.writeShort((int) var6);
		var1.writeShort(this.field3627);
		var1.writeShort(this.field3628);
		var1.writeShort(this.field3626);
		var1.writeShort(this.field3629);
	}

	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2893 == null) {
			throw new RuntimeException();
		} else {
			var0.field2893[var1] = var2;
			var0.field2913[var1] = var3;
		}
	}

	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 >= 0 && (AbstractArchive.maximumContainerSize == 0 || var3 <= AbstractArchive.maximumContainerSize)) {
			if (var2 == 0) {
				byte[] var4 = new byte[var3];
				var1.readBytes(var4, 0, var3);
				return var4;
			} else {
				int var6 = var1.readInt();
				if (var6 < 0
						|| AbstractArchive.maximumContainerSize != 0 && var6 > AbstractArchive.maximumContainerSize) {
					throw new RuntimeException();
				} else {
					byte[] var5 = new byte[var6];
					if (var2 == 1) {
						BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
					} else {
						AbstractArchive.gzipDecompressor.decompress(var1, var5);
					}

					return var5;
				}
			}
		} else {
			throw new RuntimeException();
		}
	}
}
