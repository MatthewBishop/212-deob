import java.util.concurrent.Callable;

public class class1 implements Callable {

	static Scene scene;

	final Buffer field1;

	final class3 field0;
	// $FF: synthetic field

	final class7 this$0;

	class1(class7 var1, Buffer var2, class3 var3) {
		this.this$0 = var1;
		this.field1 = var2;
		this.field0 = var3;
	}

	public Object call() {
		return this.field0.vmethod12(this.field1);
	}

	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message) Messages.Messages_hashTable.get((long) var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message) var1.previousDual).count;
		}
	}
}
