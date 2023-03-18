public final class ObjectSound extends Node {

	static NodeDeque objectSounds = new NodeDeque();

	int plane;

	int x;

	int y;

	int maxX;

	int maxY;

	int field672;

	int soundEffectId;

	RawPcmStream stream1;

	int field666;

	int field668;

	int[] soundEffectIds;

	int field678;

	RawPcmStream stream2;

	ObjectComposition obj;

	void set() {
		int var1 = this.soundEffectId;
		ObjectComposition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field672 = var2.int7 * 128;
			this.field666 = var2.int5;
			this.field668 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field672 = 0;
			this.field666 = 0;
			this.field668 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			class323.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}
}
