public class LoginType {

	public static final LoginType oldscape = new LoginType(7, 0, "", "");

	static final LoginType field3911 = new LoginType(4, 1, "", "");

	static final LoginType field3912 = new LoginType(6, 2, "", "");

	static final LoginType field3910 = new LoginType(0, 3, "", "");

	static final LoginType field3914 = new LoginType(5, 4, "", "");

	static final LoginType field3915 = new LoginType(2, 5, "", "");

	static final LoginType field3916 = new LoginType(3, 6, "", "");

	static final LoginType field3918 = new LoginType(1, 7, "", "");

	public static final LoginType field3913;

	final int field3919;

	final String field3917;

	static {
		field3913 = new LoginType(8, -1, "", "", true,
				new LoginType[] { oldscape, field3911, field3912, field3914, field3910 });
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field3919 = var1;
		this.field3917 = var4;
	}

	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field3919 = var1;
		this.field3917 = var4;
	}

	public String toString() {
		return this.field3917;
	}
}
