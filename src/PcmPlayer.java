import java.util.concurrent.ScheduledExecutorService;

public class PcmPlayer {

	public static int field194;

	static ScheduledExecutorService soundSystemExecutor;

	static AbstractSocket js5Socket;

	static GraphicsDefaults spriteIds;

	protected int[] samples;

	PcmStream stream;

	int field192 = 32;

	long timeMs = WorldMapSection2.clockNow();

	int capacity;

	int field189;

	int field195;

	long field196 = 0L;

	int field197 = 0;

	int field198 = 0;

	int field199 = 0;

	long field200 = 0L;

	boolean field190 = true;

	int field202 = 0;

	PcmStream[] field203 = new PcmStream[8];

	PcmStream[] field201 = new PcmStream[8];

	protected void init() throws Exception {
	}

	protected void open(int var1) throws Exception {
	}

	protected int position() throws Exception {
		return this.capacity;
	}

	protected void write() throws Exception {
	}

	protected void close() {
	}

	protected void discard() throws Exception {
	}

	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = WorldMapSection2.clockNow();

			try {
				if (this.field196 != 0L) {
					if (var1 < this.field196) {
						return;
					}

					this.open(this.capacity);
					this.field196 = 0L;
					this.field190 = true;
				}

				int var3 = this.position();
				if (this.field199 - var3 > this.field197) {
					this.field197 = this.field199 - var3;
				}

				int var4 = this.field189 + this.field195;
				if (var4 + 256 > 16384) {
					var4 = 16128;
				}

				if (var4 + 256 > this.capacity) {
					this.capacity += 1024;
					if (this.capacity > 16384) {
						this.capacity = 16384;
					}

					this.close();
					this.open(this.capacity);
					var3 = 0;
					this.field190 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field195 = var4 - this.field189;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field200) {
					if (!this.field190) {
						if (this.field197 == 0 && this.field198 == 0) {
							this.close();
							this.field196 = var1 + 2000L;
							return;
						}

						this.field195 = Math.min(this.field198, this.field197);
						this.field198 = this.field197;
					} else {
						this.field190 = false;
					}

					this.field197 = 0;
					this.field200 = var1 + 2000L;
				}

				this.field199 = var3;
			} catch (Exception var7) {
				this.close();
				this.field196 = var1 + 2000L;
			}

			try {
				if (var1 > this.timeMs + 500000L) {
					var1 = this.timeMs;
				}

				while (var1 > this.timeMs + 5000L) {
					this.skip(256);
					this.timeMs += (long) (256000 / field194);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	public final void method218() {
		this.field190 = true;
	}

	public final synchronized void tryDiscard() {
		this.field190 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field196 = WorldMapSection2.clockNow() + 2000L;
		}

	}

	public final synchronized void shutdown() {
		if (class291.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == class291.soundSystem.players[var2]) {
					class291.soundSystem.players[var2] = null;
				}

				if (class291.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				soundSystemExecutor.shutdownNow();
				soundSystemExecutor = null;
				class291.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	final void skip(int var1) {
		this.field202 -= var1;
		if (this.field202 < 0) {
			this.field202 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (ChatChannel.PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class380.clearIntArray(var1, 0, var3);
		this.field202 -= var2;
		if (this.stream != null && this.field202 <= 0) {
			this.field202 += field194 >> 4;
			AbstractWorldMapIcon.PcmStream_disable(this.stream);
			this.method210(this.stream, this.stream.vmethod1019());
			int var4 = 0;
			int var5 = 255;

			int var6;
			PcmStream var10;
			label105: for (var6 = 7; var5 != 0; --var6) {
				int var7;
				int var8;
				if (var6 < 0) {
					var7 = var6 & 3;
					var8 = -(var6 >> 2);
				} else {
					var7 = var6;
					var8 = 0;
				}

				for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
					if ((var9 & 1) != 0) {
						var5 &= ~(1 << var7);
						var10 = null;
						PcmStream var11 = this.field203[var7];

						label99: while (true) {
							while (true) {
								if (var11 == null) {
									break label99;
								}

								AbstractSound var12 = var11.sound;
								if (var12 != null && var12.position > var8) {
									var5 |= 1 << var7;
									var10 = var11;
									var11 = var11.after;
								} else {
									var11.active = true;
									int var13 = var11.vmethod5648();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field192) {
										break label105;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field249; var14 != null; var14 = var11.nextSubStream()) {
											this.method210(var14, var15 * var14.vmethod1019() >> 8);
										}
									}

									PcmStream var16 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field203[var7] = var16;
									} else {
										var10.after = var16;
									}

									if (var16 == null) {
										this.field201[var7] = var10;
									}

									var11 = var16;
								}
							}
						}
					}

					var7 += 4;
					++var8;
				}
			}

			for (var6 = 0; var6 < 8; ++var6) {
				PcmStream var17 = this.field203[var6];
				PcmStream[] var18 = this.field203;
				this.field201[var6] = null;

				for (var18[var6] = null; var17 != null; var17 = var10) {
					var10 = var17.after;
					var17.after = null;
				}
			}
		}

		if (this.field202 < 0) {
			this.field202 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = WorldMapSection2.clockNow();
	}

	final void method210(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field201[var3];
		if (var4 == null) {
			this.field203[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field201[var3] = var1;
		var1.field249 = var2;
	}

	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.field2973 * var0.height / var0.field2888;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.width * var0.field2888 / var0.field2973;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var0.type == 12) {
			var0.method1758().method1658(var0.width, var0.height);
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}
}
