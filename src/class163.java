public class class163 extends class156 {

	String field1392;

	byte field1393;

	byte field1391;
	// $FF: synthetic field

	final class157 this$0;

	class163(class157 var1) {
		this.this$0 = var1;
	}

	void vmethod3238(Buffer var1) {
		this.field1392 = var1.readStringCp1252NullTerminatedOrNull();
		if (this.field1392 != null) {
			var1.readUnsignedByte();
			this.field1393 = var1.readByte();
			this.field1391 = var1.readByte();
		}

	}

	void vmethod3239(ClanChannel var1) {
		var1.name = this.field1392;
		if (this.field1392 != null) {
			var1.field1385 = this.field1393;
			var1.field1388 = this.field1391;
		}

	}

	public static void method853(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class293.musicPlayerStatus = 1;
		class364.musicTrackArchive = var0;
		IntHashTable.musicTrackGroupId = var1;
		class293.musicTrackFileId = var2;
		class368.musicTrackVolume = var3;
		class293.musicTrackBoolean = var4;
		AbstractRasterProvider.pcmSampleLength = 10000;
	}

	public static void method856() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	public static void method857(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = UserComparator9.getPacketBufferNode(ClientPacket.field2499,
				Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeShort(var0);
		var4.packetBuffer.writeByteSub(var2);
		var4.packetBuffer.writeIntME(var3 ? Client.field448 * -1978635877 * -1328687981 : 0);
		var4.packetBuffer.writeShortAdd(var1);
		Client.packetWriter.addNode(var4);
	}
}
