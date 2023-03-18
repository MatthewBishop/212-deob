public class class478 {

	int[] field3975 = new int[8];

	short[] field3976 = new short[8];

	public class478(NPCComposition var1) {
		int var2 = 0;
		if (var1.method967()) {
			var2 = var1.method968().length;
			System.arraycopy(var1.method968(), 0, this.field3975, 0, var2);
			System.arraycopy(var1.method964(), 0, this.field3976, 0, var2);
		}

		for (int var3 = var2; var3 < 8; ++var3) {
			this.field3975[var3] = -1;
			this.field3976[var3] = -1;
		}

	}

	public int[] method2470() {
		return this.field3975;
	}

	public short[] method2471() {
		return this.field3976;
	}

	public void method2472(int var1, int var2, short var3) {
		this.field3975[var1] = var2;
		this.field3976[var1] = var3;
	}

	public void method2469(int[] var1, short[] var2) {
		this.field3975 = var1;
		this.field3976 = var2;
	}

	public static Font method2473(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		int var4 = var0.getGroupId(var2);
		int var5 = var0.getFileId(var4, var3);
		byte[] var8 = var0.takeFile(var4, var5);
		boolean var7;
		if (var8 == null) {
			var7 = false;
		} else {
			class212.SpriteBuffer_decode(var8);
			var7 = true;
		}

		Font var6;
		if (!var7) {
			var6 = null;
		} else {
			byte[] var9 = var1.takeFile(var4, var5);
			Font var11;
			if (var9 == null) {
				var11 = null;
			} else {
				Font var10 = new Font(var9, class492.SpriteBuffer_xOffsets, Canvas.SpriteBuffer_yOffsets,
						InterfaceParent.SpriteBuffer_spriteWidths, class144.SpriteBuffer_spriteHeights,
						class181.SpriteBuffer_spritePalette, class144.SpriteBuffer_pixels);
				FriendsList.method2086();
				var11 = var10;
			}

			var6 = var11;
		}

		return var6;
	}
}
