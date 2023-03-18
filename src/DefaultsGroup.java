public class DefaultsGroup {

	static final DefaultsGroup field3713 = new DefaultsGroup(3);

	final int group;

	DefaultsGroup(int var1) {
		this.group = var1;
	}

	static void method2166() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.cachedAppearanceBuffer[var0] = null;
			Players.playerMovementSpeeds[var0] = MoveSpeed.WALK;
		}

	}
}
