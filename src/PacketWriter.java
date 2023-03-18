import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PacketWriter {

	static int menuWidth;

	AbstractSocket socket;

	IterableNodeDeque packetBufferNodes = new IterableNodeDeque();

	int bufferSize = 0;

	Buffer buffer = new Buffer(5000);

	public IsaacCipher isaacCipher;

	PacketBuffer packetBuffer = new PacketBuffer(40000);

	ServerPacket serverPacket = null;

	int serverPacketLength = 0;

	boolean field1126 = true;

	int field1124 = 0;

	int pendingWrites = 0;

	ServerPacket field1129;

	ServerPacket field1130;

	ServerPacket field1131;

	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	final void flush() throws IOException {
		if (this.socket != null && this.bufferSize > 0) {
			this.buffer.offset = 0;

			while (true) {
				PacketBufferNode var1 = (PacketBufferNode) this.packetBufferNodes.last();
				if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
					this.socket.write(this.buffer.array, 0, this.buffer.offset);
					this.pendingWrites = 0;
					break;
				}

				this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
				this.bufferSize -= var1.index;
				var1.remove();
				var1.packetBuffer.releaseArray();
				var1.release();
			}
		}

	}

	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	void removeSocket() {
		this.socket = null;
	}

	AbstractSocket getSocket() {
		return this.socket;
	}

	static void method628(int var0) {
		SequenceDefinition var1 = Coord.SequenceDefinition_get(var0);
		if (var1.isCachedModelIdSet()) {
			int var3 = var1.SequenceDefinition_cachedModelId;
			class134 var5 = (class134) SequenceDefinition.SequenceDefinition_cachedModel.get((long) var3);
			class134 var4;
			if (var5 != null) {
				var4 = var5;
			} else {
				AbstractArchive var7 = SequenceDefinition.SequenceDefinition_animationsArchive;
				AbstractArchive var8 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
				boolean var9 = true;
				byte[] var10 = var7.getFile(var3 >> 16 & '\uffff', var3 & '\uffff');
				class134 var6;
				if (var10 == null) {
					var9 = false;
					var6 = null;
				} else {
					int var11 = (var10[1] & 255) << 8 | var10[2] & 255;
					byte[] var12 = var8.getFile(var11, 0);
					if (var12 == null) {
						var9 = false;
					}

					if (!var9) {
						var6 = null;
					} else {
						if (UserComparator7.field1146 == null) {
							class134.field1263 = Runtime.getRuntime().availableProcessors();
							UserComparator7.field1146 = new ThreadPoolExecutor(0, class134.field1263, 0L,
									TimeUnit.MILLISECONDS, new ArrayBlockingQueue(class134.field1263 * 100 + 100),
									new class60());
						}

						try {
							var6 = new class134(var7, var8, var3, false);
						} catch (Exception var14) {
							var6 = null;
						}
					}
				}

				if (var6 != null) {
					SequenceDefinition.SequenceDefinition_cachedModel.put(var6, (long) var3);
				}

				var4 = var6;
			}

			int var2;
			if (var4 == null) {
				var2 = 2;
			} else {
				var2 = var4.method725() ? 0 : 1;
			}

			if (var2 == 2) {
				Client.field617.add(var1.SequenceDefinition_cachedModelId);
			}

		}
	}
}
