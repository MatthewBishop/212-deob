public enum StudioGame implements class352 {

	runescape("runescape", "RuneScape", 0),

	stellardawn("stellardawn", "Stellar Dawn", 1),

	game3("game3", "Game 3", 2),

	game4("game4", "Game 4", 3),

	game5("game5", "Game 5", 4),

	oldscape("oldscape", "RuneScape 2007", 5);

	static String[] cacheSubPaths;

	public static AbstractRasterProvider rasterProvider;

	public final String name;

	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	public int rsOrdinal() {
		return this.id;
	}

	static void method1799() {
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1129 = null;
		Client.packetWriter.field1130 = null;
		Client.packetWriter.field1131 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1124 = 0;
		Client.rebootTimer = 0;
		class60.method327();
		Client.minimapState = 0;
		Client.destinationX = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		BuddyRankComparator.localPlayer = null;

		for (var0 = 0; var0 < Client.npcs.length; ++var0) {
			NPC var1 = Client.npcs[var0];
			if (var1 != null) {
				var1.targetIndex = -1;
				var1.false0 = false;
			}
		}

		class206.method1080();
		class19.updateGameState(30);

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field594[var0] = true;
		}

		PacketBufferNode var2 = UserComparator9.getPacketBufferNode(ClientPacket.field2432,
				Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(class7.getWindowedMode());
		var2.packetBuffer.writeShort(GameEngine.canvasWidth);
		var2.packetBuffer.writeShort(class143.canvasHeight);
		Client.packetWriter.addNode(var2);
	}
}
