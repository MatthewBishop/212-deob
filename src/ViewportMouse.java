public class ViewportMouse {

	static PcmPlayer pcmPlayer1;

	public static boolean ViewportMouse_isInViewport = false;

	static int ViewportMouse_x = 0;

	static int ViewportMouse_y = 0;

	static boolean ViewportMouse_false0 = false;

	static int field2178;

	static int field2179;

	static int field2180;

	static int field2174;

	public static int ViewportMouse_entityCount = 0;

	public static long[] ViewportMouse_entityTags = new long[1000];

	static MenuAction tempMenuAction;

	public static PacketBufferNode method1295() {
		PacketBufferNode var0;
		if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
			var0 = new PacketBufferNode();
		} else {
			var0 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
		}

		var0.clientPacket = null;
		var0.clientPacketLength = 0;
		var0.packetBuffer = new PacketBuffer(5000);
		return var0;
	}

	static SpritePixels[] method1296() {
		SpritePixels[] var0 = new SpritePixels[class492.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class492.SpriteBuffer_spriteCount; ++var1) {
			SpritePixels var2 = var0[var1] = new SpritePixels();
			var2.width = class492.SpriteBuffer_spriteWidth;
			var2.height = class492.SpriteBuffer_spriteHeight;
			var2.xOffset = class492.SpriteBuffer_xOffsets[var1];
			var2.yOffset = Canvas.SpriteBuffer_yOffsets[var1];
			var2.subWidth = InterfaceParent.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class144.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subHeight * var2.subWidth;
			byte[] var4 = class144.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = class181.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		FriendsList.method2086();
		return var0;
	}
}
