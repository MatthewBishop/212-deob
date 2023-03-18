import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class class139 extends class140 {

	static IndexedSprite[] title_muteSprite;

	static FontMetrics loginScreenFontMetrics;

	int field1294;
	// $FF: synthetic field

	final class143 this$0;

	class139(class143 var1) {
		this.this$0 = var1;
		this.field1294 = -1;
	}

	void vmethod3254(Buffer var1) {
		this.field1294 = var1.readUnsignedShort();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method799(this.field1294);
	}

	public static final SpritePixels method748(byte[] var0) {
		BufferedImage var1 = null;

		try {
			Class var2 = ImageIO.class;
			synchronized (ImageIO.class) {
				var1 = ImageIO.read(new ByteArrayInputStream(var0));
			}

			int var6 = var1.getWidth();
			int var7 = var1.getHeight();
			int[] var4 = new int[var7 * var6];
			PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var6, var7, var4, 0, var6);
			var5.grabPixels();
			return new SpritePixels(var4, var6, var7);
		} catch (IOException var9) {
			;
		} catch (InterruptedException var10) {
			;
		}

		return new SpritePixels(0, 0);
	}

	static int method747(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode) var0.get((long) var1);
			return var3 == null ? var2 : var3.integer;
		}
	}
}
