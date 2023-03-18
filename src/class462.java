import java.util.Iterator;

public class class462 extends class426 implements class271 {

	final AbstractArchive field3939;

	final DemotingHashTable field3940 = new DemotingHashTable(64);

	final int field3941;

	public class462(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
		super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
		this.field3939 = var4;
		this.field3941 = var2;
	}

	protected class428 vmethod8207(int var1) {
		DemotingHashTable var3 = this.field3940;
		synchronized (this.field3940) {
			class427 var2 = (class427) this.field3940.get((long) var1);
			if (var2 == null) {
				var2 = this.method2350(var1);
				this.field3940.method1518(var2, (long) var1);
			}

			return var2;
		}
	}

	class427 method2350(int var1) {
		byte[] var2 = this.field3939.takeFile(this.field3941, var1);
		class427 var3 = new class427(var1);
		if (var2 != null) {
			var3.method2217(new Buffer(var2));
		}

		return var3;
	}

	public void method2348() {
		DemotingHashTable var1 = this.field3940;
		synchronized (this.field3940) {
			this.field3940.clear();
		}
	}

	public Iterator iterator() {
		return new class461(this);
	}

	static void method2351() {
		if (Language.field3504 != null) {
			Client.field447 = Client.cycle;
			Language.field3504.method1884();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					Language.field3504.method1881((Client.players[var0].x >> 7) + GameEngine.baseX,
							(Client.players[var0].y >> 7) + class178.baseY);
				}
			}
		}

	}
}
