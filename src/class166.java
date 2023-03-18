import java.io.IOException;
import java.net.URL;

public class class166 extends class178 {

	String field1398;
	// $FF: synthetic field

	final class167 this$0;

	class166(class167 var1, String var2, String var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1398 = var3;
	}

	public int vmethod3379() {
		return 1;
	}

	public String vmethod3380() {
		return this.field1398;
	}

	public static void method865(boolean var0) {
		if (NetCache.NetCache_socket != null) {
			try {
				Buffer var1 = new Buffer(4);
				var1.writeByte(var0 ? 2 : 3);
				var1.writeMedium(0);
				NetCache.NetCache_socket.write(var1.array, 0, 4);
			} catch (IOException var4) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var3) {
					;
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
			}

		}
	}

	static boolean method863(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class31.field86.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var10.indexOf(var0.charAt(var4)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var5) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Object var3 = class26.method106(class31.field88, var2,
						new Object[] { (new URL(class31.field88.getCodeBase(), var0)).toString() });
				return var3 != null;
			} catch (Throwable var6) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class31.field88.getAppletContext().showDocument(new URL(class31.field88.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var7) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				class26.method105(class31.field88, "loggedout");
			} catch (Throwable var9) {
				;
			}

			try {
				class31.field88.getAppletContext().showDocument(new URL(class31.field88.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var8) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static long method866(int var0) {
		return ViewportMouse.ViewportMouse_entityTags[var0];
	}
}
