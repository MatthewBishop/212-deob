import java.net.URL;

public class UrlRequest {

	static int field1140 = -1;

	static int field1141 = -2;

	final URL field1142;

	volatile int field1139;

	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.field1139 = field1140;
		this.field1142 = var1;
	}

	public boolean isDone() {
		return this.field1139 != field1140;
	}

	public byte[] getResponse() {
		return this.response0;
	}

	public String method644() {
		return this.field1142.toString();
	}

	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (class260.World_worlds != null) {
			class12.doWorldSorting(0, class260.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	public static void method645() {
		ParamComposition.ParamDefinition_cached.clear();
	}
}
