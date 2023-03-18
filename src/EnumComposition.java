public class EnumComposition extends DualNode {

	static AbstractArchive EnumDefinition_archive;

	static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);

	static SpritePixels[] headIconHintSprites;

	public char inputType;

	public char outputType;

	public String defaultStr = "null";

	public int defaultInt;

	public int outputCount = 0;

	public int[] keys;

	public int[] intVals;

	public String[] strVals;

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.inputType = (char) var1.readUnsignedByte();
		} else if (var2 == 2) {
			this.outputType = (char) var1.readUnsignedByte();
		} else if (var2 == 3) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.defaultInt = var1.readInt();
		} else {
			int var3;
			if (var2 == 5) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.strVals = new String[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.strVals[var3] = var1.readStringCp1252NullTerminated();
				}
			} else if (var2 == 6) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.intVals = new int[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.intVals[var3] = var1.readInt();
				}
			}
		}

	}

	public int size() {
		return this.outputCount;
	}

	static final void playPcmPlayers() {
		if (ViewportMouse.pcmPlayer1 != null) {
			ViewportMouse.pcmPlayer1.run();
		}

		if (Interpreter.pcmPlayer0 != null) {
			Interpreter.pcmPlayer0.run();
		}

	}

	static final void method953() {
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			--Client.queuedSoundEffectDelays[var0];
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var9 = Client.soundEffects[var0];
				if (var9 == null) {
					Object var10000 = null;
					var9 = SoundEffect.readSoundEffect(class175.field1434, Client.soundEffectIds[var0], 0);
					if (var9 == null) {
						continue;
					}

					Client.queuedSoundEffectDelays[var0] += var9.calculateDelay();
					Client.soundEffects[var0] = var9;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					int var2;
					if (Client.soundLocations[var0] != 0) {
						int var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - BuddyRankComparator.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - BuddyRankComparator.localPlayer.y;
						if (var7 < 0) {
							var7 = -var7;
						}

						int var8 = var7 + var5 - 128;
						if (var8 > var3) {
							Client.queuedSoundEffectDelays[var0] = -100;
							continue;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						var2 = (var3 - var8) * WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume() / var3;
					} else {
						var2 = WorldMapSectionType.clientPreferences.getCurrentSoundEffectsVolume();
					}

					if (var2 > 0) {
						RawSound var10 = var9.toRawSound().resample(TaskHandler.decimator);
						RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
						var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
						class323.pcmStreamMixer.addSubStream(var11);
					}

					Client.queuedSoundEffectDelays[var0] = -100;
				}
			} else {
				--Client.soundEffectCount;

				for (int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
					Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
					Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
					Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
					Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
					Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
				}

				--var0;
			}
		}

		if (Client.playingJingle) {
			boolean var12;
			if (class293.musicPlayerStatus != 0) {
				var12 = true;
			} else {
				var12 = class293.midiPcmStream.isReady();
			}

			if (!var12) {
				if (WorldMapSectionType.clientPreferences.getCurrentMusicVolume() != 0
						&& Client.currentTrackGroupId != -1) {
					class163.method853(class308.archive6, Client.currentTrackGroupId, 0,
							WorldMapSectionType.clientPreferences.getCurrentMusicVolume(), false);
				}

				Client.playingJingle = false;
			}
		}

	}
}
