import java.util.Comparator;
import java.util.Map.Entry;

class class391 implements Comparator {

	static int field3637;
	// $FF: synthetic field

	final class390 this$0;

	class391(class390 var1) {
		this.this$0 = var1;
	}

	int method2062(Entry var1, Entry var2) {
		return ((Float) var2.getValue()).compareTo((Float) var1.getValue());
	}

	public int compare(Object var1, Object var2) {
		return this.method2062((Entry) var1, (Entry) var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
