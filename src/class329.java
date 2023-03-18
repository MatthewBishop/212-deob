import java.io.File;
import java.io.IOException;

public class class329 {

	static void method1801(File var0, File var1) {
		try {
			AccessFile var2 = new AccessFile(ClanChannelMember.JagexCache_locationFile, "rw", 10000L);
			Buffer var3 = new Buffer(500);
			var3.writeByte(3);
			var3.writeByte(var1 != null ? 1 : 0);
			var3.writeCESU8(var0.getPath());
			if (var1 != null) {
				var3.writeCESU8("");
			}

			var2.write(var3.array, 0, var3.offset);
			var2.close();
		} catch (IOException var4) {
			var4.printStackTrace();
		}

	}

	static int method1800(int var0) {
		Message var1 = (Message) Messages.Messages_hashTable.get((long) var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message) var1.nextDual).count;
		}
	}
}
