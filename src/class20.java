import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;

public class class20 {

	static Archive field63;

	static int menuX;

	final int field62;

	final Map field61;

	final String field65;

	class20(String var1) {
		this.field62 = 400;
		this.field61 = null;
		this.field65 = "";
	}

	class20(HttpURLConnection var1) throws IOException {
		this.field62 = var1.getResponseCode();
		var1.getResponseMessage();
		this.field61 = var1.getHeaderFields();
		StringBuilder var2 = new StringBuilder();
		InputStream var3 = this.field62 >= 300 ? var1.getErrorStream() : var1.getInputStream();
		if (var3 != null) {
			InputStreamReader var4 = new InputStreamReader(var3);
			BufferedReader var5 = new BufferedReader(var4);

			String var6;
			while ((var6 = var5.readLine()) != null) {
				var2.append(var6);
			}

			var3.close();
		}

		this.field65 = var2.toString();
	}

	public int method81() {
		return this.field62;
	}

	public Map method80() {
		return this.field61;
	}

	public String method82() {
		return this.field65;
	}

	static final void method83(int var0, int var1) {
		ClanChannel var2 = var0 >= 0 ? Client.currentClanChannels[var0] : class19.guestClanChannel;
		if (var2 != null && var1 >= 0 && var1 < var2.method843()) {
			ClanChannelMember var3 = (ClanChannelMember) var2.members.get(var1);
			if (var3.rank == -1) {
				String var4 = var3.username.getName();
				PacketBufferNode var5 = UserComparator9.getPacketBufferNode(ClientPacket.field2430,
						Client.packetWriter.isaacCipher);
				var5.packetBuffer.writeByte(3 + WorldMapLabel.stringCp1252NullTerminatedByteSize(var4));
				var5.packetBuffer.writeByte(var0);
				var5.packetBuffer.writeShort(var1);
				var5.packetBuffer.writeStringCp1252NullTerminated(var4);
				Client.packetWriter.addNode(var5);
			}
		}
	}
}
