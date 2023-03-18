public class ClanMate extends Buddy {

	TriBool friend;

	TriBool ignored;

	ClanMate() {
		this.friend = TriBool.TriBool_unknown;
		this.ignored = TriBool.TriBool_unknown;
	}

	void clearIsFriend() {
		this.friend = TriBool.TriBool_unknown;
	}

	public final boolean isFriend() {
		if (this.friend == TriBool.TriBool_unknown) {
			this.fillIsFriend();
		}

		return this.friend == TriBool.TriBool_true;
	}

	void fillIsFriend() {
		this.friend = class6.friendSystem.friendsList.contains(super.username) ? TriBool.TriBool_true
				: TriBool.TriBool_false;
	}

	void clearIsIgnored() {
		this.ignored = TriBool.TriBool_unknown;
	}

	public final boolean isIgnored() {
		if (this.ignored == TriBool.TriBool_unknown) {
			this.fillIsIgnored();
		}

		return this.ignored == TriBool.TriBool_true;
	}

	void fillIsIgnored() {
		this.ignored = class6.friendSystem.ignoreList.contains(super.username) ? TriBool.TriBool_true
				: TriBool.TriBool_false;
	}

	static void addCancelMenuEntry() {
		class60.method327();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
