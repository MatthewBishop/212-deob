import java.io.IOException;
import java.io.OutputStream;

public class BufferedSink implements Runnable {

	Thread thread;

	OutputStream outputStream;

	int capacity;

	byte[] buffer;

	int position = 0;

	int limit = 0;

	IOException exception;

	boolean closed;

	BufferedSink(OutputStream var1, int var2) {
		this.outputStream = var1;
		this.capacity = var2 + 1;
		this.buffer = new byte[this.capacity];
		this.thread = new Thread(this);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	boolean isClosed() {
		if (this.closed) {
			try {
				this.outputStream.close();
				if (this.exception == null) {
					this.exception = new IOException("");
				}
			} catch (IOException var2) {
				if (this.exception == null) {
					this.exception = new IOException(var2);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	void write(byte[] var1, int var2, int var3) throws IOException {
		if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
			synchronized (this) {
				if (this.exception != null) {
					throw new IOException(this.exception.toString());
				} else {
					int var5;
					if (this.position <= this.limit) {
						var5 = this.capacity - this.limit + this.position - 1;
					} else {
						var5 = this.position - this.limit - 1;
					}

					if (var5 < var3) {
						throw new IOException("");
					} else {
						if (var3 + this.limit <= this.capacity) {
							System.arraycopy(var1, var2, this.buffer, this.limit, var3);
						} else {
							int var6 = this.capacity - this.limit;
							System.arraycopy(var1, var2, this.buffer, this.limit, var6);
							System.arraycopy(var1, var6 + var2, this.buffer, 0, var3 - var6);
						}

						this.limit = (var3 + this.limit) % this.capacity;
						this.notifyAll();
					}
				}
			}
		} else {
			throw new IOException();
		}
	}

	void close() {
		synchronized (this) {
			this.closed = true;
			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException var3) {
			;
		}

	}

	public void run() {
		do {
			int var1;
			synchronized (this) {
				while (true) {
					if (this.exception != null) {
						return;
					}

					if (this.position <= this.limit) {
						var1 = this.limit - this.position;
					} else {
						var1 = this.capacity - this.position + this.limit;
					}

					if (var1 > 0) {
						break;
					}

					try {
						this.outputStream.flush();
					} catch (IOException var11) {
						this.exception = var11;
						return;
					}

					if (this.isClosed()) {
						return;
					}

					try {
						this.wait();
					} catch (InterruptedException var12) {
						;
					}
				}
			}

			try {
				if (var1 + this.position <= this.capacity) {
					this.outputStream.write(this.buffer, this.position, var1);
				} else {
					int var7 = this.capacity - this.position;
					this.outputStream.write(this.buffer, this.position, var7);
					this.outputStream.write(this.buffer, 0, var1 - var7);
				}
			} catch (IOException var10) {
				IOException var2 = var10;
				synchronized (this) {
					this.exception = var2;
					return;
				}
			}

			synchronized (this) {
				this.position = (var1 + this.position) % this.capacity;
			}
		} while (!this.isClosed());

	}

	static final void method2162(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		var5 = Occluder.method1251(var5, var6);
		int var7 = 2048 - var3 & 2047;
		int var8 = 2048 - var4 & 2047;
		int var9 = 0;
		int var10 = 0;
		int var11 = var5;
		int var12;
		int var13;
		int var14;
		if (var7 != 0) {
			var12 = Rasterizer3D.Rasterizer3D_sine[var7];
			var13 = Rasterizer3D.Rasterizer3D_cosine[var7];
			var14 = var10 * var13 - var12 * var5 >> 16;
			var11 = var12 * var10 + var13 * var5 >> 16;
			var10 = var14;
		}

		if (var8 != 0) {
			var12 = Rasterizer3D.Rasterizer3D_sine[var8];
			var13 = Rasterizer3D.Rasterizer3D_cosine[var8];
			var14 = var12 * var11 + var9 * var13 >> 16;
			var11 = var13 * var11 - var12 * var9 >> 16;
			var9 = var14;
		}

		if (Client.isCameraLocked) {
			class364.field3540 = var0 - var9;
			Coord.field2766 = var1 - var10;
			class307.field2776 = var2 - var11;
			WorldMapRectangle.field2359 = var3;
			class28.field84 = var4;
		} else {
			class381.cameraX = var0 - var9;
			class351.cameraY = var1 - var10;
			class471.cameraZ = var2 - var11;
			class311.cameraPitch = var3;
			class110.cameraYaw = var4;
		}

		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0
				&& (GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX >> 7 != BuddyRankComparator.localPlayer.x >> 7
						|| ReflectionCheck.oculusOrbFocalPointY >> 7 != BuddyRankComparator.localPlayer.y >> 7)) {
			var12 = BuddyRankComparator.localPlayer.plane;
			var13 = (GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX >> 7) + GameEngine.baseX;
			var14 = (ReflectionCheck.oculusOrbFocalPointY >> 7) + class178.baseY;
			class163.method857(var13, var14, var12, true);
		}

	}
}
