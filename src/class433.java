import java.io.UnsupportedEncodingException;

public class class433 implements class432 {

	static String field3773;

	JSONObject field3774;

	public class433(byte[] var1) throws UnsupportedEncodingException {
		this.method2224(var1);
	}

	public class433(JSONObject var1) {
		this.field3774 = var1;
	}

	public class433(String var1) throws UnsupportedEncodingException {
		this.method2225(var1);
	}

	public class431 vmethod2213() {
		return class431.field3770;
	}

	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.field3774 == null ? new byte[0] : this.field3774.toString().getBytes("UTF-8");
	}

	void method2224(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8");
		this.method2225(var2);
	}

	void method2225(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field3774 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var2 = new JSONArray(var1);
				this.field3774 = new JSONObject();
				this.field3774.method2575("arrayValues", var2);
			}

		} catch (JSONException var3) {
			throw new UnsupportedEncodingException(var3.getMessage());
		}
	}

	public JSONObject method2226() {
		return this.field3774;
	}
}
