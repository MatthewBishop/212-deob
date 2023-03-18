import java.io.IOException;

public final class BoundaryObject {

	int z;

	int x;

	int y;

	int orientationA;

	int orientationB;

	public Renderable renderable1;

	public Renderable renderable2;

	public long tag = 0L;

	int flags = 0;

	static final void method1298(boolean var0) {
		EnumComposition.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.hadNetworkError && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = UserComparator9.getPacketBufferNode(ClientPacket.field2456,
						Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.hadNetworkError = true;
				}
			}

		}
	}
}
