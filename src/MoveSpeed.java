public enum MoveSpeed implements class352 {

	STATIONARY((byte) -1),

	CRAWL((byte) 0),

	WALK((byte) 1),

	RUN((byte) 2);

	static AbstractArchive field1844;

	static String field1841;

	public byte speed;

	MoveSpeed(byte var3) {
		this.speed = var3;
	}

	public int rsOrdinal() {
		return this.speed;
	}

	public static PlayerType[] PlayerType_values() {
		return new PlayerType[] { PlayerType.field3391, PlayerType.field3389, PlayerType.field3387,
				PlayerType.PlayerType_playerModerator, PlayerType.field3392, PlayerType.PlayerType_ultimateIronman,
				PlayerType.field3380, PlayerType.PlayerType_ironman, PlayerType.field3395, PlayerType.PlayerType_normal,
				PlayerType.field3394, PlayerType.field3393, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3388,
				PlayerType.PlayerType_jagexModerator, PlayerType.field3397, PlayerType.field3390 };
	}

	public static int method1114(long var0) {
		return (int) (var0 >>> 7 & 127L);
	}

	public static int method1115(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	static void method1113(int var0) {
		for (IntegerNode var1 = (IntegerNode) Client.widgetFlags
				.first(); var1 != null; var1 = (IntegerNode) Client.widgetFlags.next()) {
			if ((long) var0 == (var1.key >> 48 & 65535L)) {
				var1.remove();
			}
		}

	}
}
