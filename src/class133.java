import java.security.SecureRandom;
import java.util.concurrent.Callable;

class class133 implements Callable {

	public static NetFileRequest NetCache_currentResponse;

	static SecureRandom secureRandom;
	// $FF: synthetic field

	final class134 this$0;
	// $FF: synthetic field

	final int val$workStart;
	// $FF: synthetic field

	final int val$workEnd;
	// $FF: synthetic field

	final class126[] val$curveLoadJobs;

	class133(class134 var1, int var2, int var3, class126[] var4) {
		this.this$0 = var1;
		this.val$workStart = var2;
		this.val$workEnd = var3;
		this.val$curveLoadJobs = var4;
	}

	public Object call() {
		for (int var1 = this.val$workStart; var1 < this.val$workEnd; ++var1) {
			this.val$curveLoadJobs[var1].call();
		}

		return null;
	}

	static class128[] method723() {
		return new class128[] { class128.field1225, class128.field1234, class128.field1226, class128.field1227,
				class128.field1228, class128.field1229 };
	}

	static void method722() {
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
	}

	static final void method721() {
		if (class18.ClanChat_inClanChat) {
			if (ReflectionCheck.friendsChat != null) {
				ReflectionCheck.friendsChat.sort();
			}

			class169.method899();
			class18.ClanChat_inClanChat = false;
		}

	}
}
