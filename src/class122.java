public class class122 {

	public static String formattedOperatingSystemName;

	int field1165;

	float field1158;

	float field1159 = Float.MAX_VALUE;

	float field1160 = Float.MAX_VALUE;

	float field1161 = Float.MAX_VALUE;

	float field1162 = Float.MAX_VALUE;

	class122 field1163;

	void method673(Buffer var1, int var2) {
		this.field1165 = var1.readShort();
		this.field1158 = var1.method2414();
		this.field1159 = var1.method2414();
		this.field1160 = var1.method2414();
		this.field1161 = var1.method2414();
		this.field1162 = var1.method2414();
	}

	static long method672(int var0, int var1, int var2) {
		return (long) (var2 << 16 | var0 << 8 | var1);
	}

	static class87[] method675() {
		return new class87[] { class87.field867, class87.field866, class87.field869, class87.field872,
				class87.field868 };
	}

	static final int method674(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			WorldMapSectionType.clientPreferences
					.setRoofsHidden(!WorldMapSectionType.clientPreferences.getRoofsHidden());
			if (WorldMapSectionType.clientPreferences.getRoofsHidden()) {
				MusicPatchNode.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				MusicPatchNode.addGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			WorldMapSectionType.clientPreferences.method526();
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.renderSelf = !Client.renderSelf;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText;
		}

		if (Client.staffModLevel >= 2) {
			if (var0.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				WorldMapData_1.worldMap.showCoord = !WorldMapData_1.worldMap.showCoord;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				WorldMapSectionType.clientPreferences.method550(true);
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				WorldMapSectionType.clientPreferences.method550(false);
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				PendingSpawn.method501();
			}
		}

		PacketBufferNode var1 = UserComparator9.getPacketBufferNode(ClientPacket.field2461,
				Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(var0.length() + 1);
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}
}
