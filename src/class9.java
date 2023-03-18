public class class9 implements class352 {

	public static final class9 field23 = new class9(0, "POST", true, true);

	public static final class9 field19 = new class9(1, "GET", true, false);

	static final class9 field20 = new class9(2, "PUT", false, true);

	static final class9 field21 = new class9(3, "PATCH", false, true);

	static final class9 field22 = new class9(4, "DELETE", false, true);

	int field25;

	String field24;

	boolean field27;

	boolean field26;

	class9(int var1, String var2, boolean var3, boolean var4) {
		this.field25 = var1;
		this.field24 = var2;
		this.field27 = var3;
		this.field26 = var4;
	}

	public int rsOrdinal() {
		return this.field25;
	}

	boolean method25() {
		return this.field27;
	}

	public String method26() {
		return this.field24;
	}

	boolean method27() {
		return this.field26;
	}

	public static void runScriptEvent(ScriptEvent var0) {
		class14.runScript(var0, 500000, 475000);
	}
}
