public class UserComparator8 extends AbstractUserComparator {

	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy) var1, (Buddy) var2);
	}

	public static int method653(int var0, int var1, int var2) {
		int var3 = class206.method1081(var2 - var1 + 1);
		var3 <<= var1;
		return var0 & ~var3;
	}

	static final void method652() {
		for (PendingSpawn var0 = (PendingSpawn) Client.pendingSpawns
				.last(); var0 != null; var0 = (PendingSpawn) Client.pendingSpawns.previous()) {
			if (var0.endCycle == -1) {
				var0.startCycle = 0;
				class27.method108(var0);
			} else {
				var0.remove();
			}
		}

	}
}
