public enum PlayerType implements class352 {

	PlayerType_normal(0, -1, true, false, true),

	PlayerType_playerModerator(1, 0, true, true, true),

	PlayerType_jagexModerator(2, 1, true, true, false),

	PlayerType_ironman(3, 2, false, false, true),

	PlayerType_ultimateIronman(4, 3, false, false, true),

	PlayerType_hardcoreIronman(5, 10, false, false, true),

	field3392(6, 22, false, false, true),

	field3387(7, 41, false, false, true),

	field3390(8, 42, false, false, true),

	field3389(9, 43, false, false, true),

	field3395(10, 44, false, false, true),

	field3391(11, 45, false, false, true),

	field3397(12, 46, false, false, true),

	field3393(13, 47, false, false, true),

	field3394(14, 48, false, false, true),

	field3380(15, 49, false, false, true),

	field3388(16, 52, false, false, true);

	final int id;

	public final int modIcon;

	public final boolean isPrivileged;

	public final boolean isUser;

	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3;
		this.modIcon = var4;
		this.isPrivileged = var6;
		this.isUser = var7;
	}

	public int rsOrdinal() {
		return this.id;
	}

	static final int method1808(LoginType var0) {
		if (var0 == null) {
			return 12;
		} else {
			switch (var0.field3919) {
			case 2:
				return 20;
			default:
				return 12;
			}
		}
	}
}
