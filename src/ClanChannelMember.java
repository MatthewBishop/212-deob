import java.io.File;

public class ClanChannelMember {

	static File JagexCache_locationFile;

	public byte rank;

	public int world;

	public Username username;

	static final void Clan_leaveChat() {
		PacketBufferNode var0 = UserComparator9.getPacketBufferNode(ClientPacket.field2467,
				Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}
}
