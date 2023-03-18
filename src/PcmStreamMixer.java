public class PcmStreamMixer extends PcmStream {

	NodeDeque subStreams = new NodeDeque();

	NodeDeque field164 = new NodeDeque();

	int field163 = 0;

	int field166 = -1;

	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	void method183() {
		if (this.field163 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener) this.field164
					.last(); var1 != null; var1 = (PcmStreamMixerListener) this.field164.previous()) {
				var1.field296 -= this.field163;
			}

			this.field166 -= this.field163;
			this.field163 = 0;
		}

	}

	void method189(Node var1, PcmStreamMixerListener var2) {
		while (this.field164.sentinel != var1 && ((PcmStreamMixerListener) var1).field296 <= var2.field296) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field166 = ((PcmStreamMixerListener) this.field164.sentinel.previous).field296;
	}

	void method190(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field164.sentinel.previous;
		if (var2 == this.field164.sentinel) {
			this.field166 = -1;
		} else {
			this.field166 = ((PcmStreamMixerListener) var2).field296;
		}

	}

	protected PcmStream firstSubStream() {
		return (PcmStream) this.subStreams.last();
	}

	protected PcmStream nextSubStream() {
		return (PcmStream) this.subStreams.previous();
	}

	protected int vmethod5648() {
		return 0;
	}

	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field166 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field163 < this.field166) {
				this.field163 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field166 - this.field163;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field163 += var4;
			this.method183();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener) this.field164.last();
			synchronized (var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field296 = 0;
					this.method190(var5);
				} else {
					var5.field296 = var7;
					this.method189(var5.previous, var5);
				}
			}
		} while (var3 != 0);

	}

	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream) this.subStreams.last(); var4 != null; var4 = (PcmStream) this.subStreams
				.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	public final synchronized void skip(int var1) {
		do {
			if (this.field166 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field163 + var1 < this.field166) {
				this.field163 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field166 - this.field163;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field163 += var2;
			this.method183();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener) this.field164.last();
			synchronized (var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field296 = 0;
					this.method190(var3);
				} else {
					var3.field296 = var5;
					this.method189(var3.previous, var3);
				}
			}
		} while (var1 != 0);

	}

	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream) this.subStreams.last(); var2 != null; var2 = (PcmStream) this.subStreams
				.previous()) {
			var2.skip(var1);
		}

	}
}
