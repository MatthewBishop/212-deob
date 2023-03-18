public class MusicPatchNode extends Node {

	static Archive archive19;

	int field2755;

	MusicPatch patch;

	RawSound rawSound;

	MusicPatchNode2 field2737;

	int field2734;

	int field2739;

	int field2754;

	int field2741;

	int field2742;

	int field2743;

	int field2744;

	int field2740;

	int field2746;

	int field2747;

	int field2751;

	int field2749;

	int field2750;

	int field2738;

	RawPcmStream stream;

	int field2753;

	int field2748;

	void method1624() {
		this.patch = null;
		this.rawSound = null;
		this.field2737 = null;
		this.stream = null;
	}

	static void addGameMessage(int var0, String var1, String var2) {
		class12.addChatMessage(var0, var1, var2, (String) null);
	}

	public static boolean method1625() {
		try {
			if (class293.musicPlayerStatus == 2) {
				if (BufferedNetSocket.musicTrack == null) {
					BufferedNetSocket.musicTrack = MusicTrack.readTrack(class364.musicTrackArchive,
							IntHashTable.musicTrackGroupId, class293.musicTrackFileId);
					if (BufferedNetSocket.musicTrack == null) {
						return false;
					}
				}

				if (class293.soundCache == null) {
					class293.soundCache = new SoundCache(class293.soundEffectsArchive, class293.musicSamplesArchive);
				}

				if (class293.midiPcmStream.loadMusicTrack(BufferedNetSocket.musicTrack, class293.musicPatchesArchive,
						class293.soundCache, 22050)) {
					class293.midiPcmStream.clearAll();
					class293.midiPcmStream.setPcmStreamVolume(class368.musicTrackVolume);
					class293.midiPcmStream.setMusicTrack(BufferedNetSocket.musicTrack, class293.musicTrackBoolean);
					class293.musicPlayerStatus = 0;
					BufferedNetSocket.musicTrack = null;
					class293.soundCache = null;
					class364.musicTrackArchive = null;
					return true;
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
			class293.midiPcmStream.clear();
			class293.musicPlayerStatus = 0;
			BufferedNetSocket.musicTrack = null;
			class293.soundCache = null;
			class364.musicTrackArchive = null;
		}

		return false;
	}

	public static void method1627() {
		ObjectComposition.ObjectDefinition_cached.clear();
		ObjectComposition.ObjectDefinition_cachedModelData.clear();
		ObjectComposition.ObjectDefinition_cachedEntities.clear();
		ObjectComposition.ObjectDefinition_cachedModels.clear();
	}
}
