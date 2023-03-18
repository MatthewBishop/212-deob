public class Message extends DualNode {

	static int field348;

	int count;

	int cycle;

	int type;

	String sender;

	Username senderUsername;

	TriBool isFromFriend0;

	TriBool isFromIgnored0;

	String prefix;

	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	void set(int var1, String var2, String var3, String var4) {
		this.count = class389.method2047();
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	void fillIsFromFriend() {
		this.isFromFriend0 = class6.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true
				: TriBool.TriBool_false;
	}

	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	void fillIsFromIgnored() {
		this.isFromIgnored0 = class6.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true
				: TriBool.TriBool_false;
	}

	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(ItemComposition.method1054(this.sender), Occluder.loginType);
		} else {
			this.senderUsername = null;
		}

	}

	static final void FriendSystem_invalidateIgnoreds() {
		class33.method138();
		if (ReflectionCheck.friendsChat != null) {
			ReflectionCheck.friendsChat.invalidateIgnoreds();
		}

	}
}
