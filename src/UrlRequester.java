import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

public abstract class UrlRequester implements Runnable {

	final Thread field1134 = new Thread(this);

	volatile boolean isClosed;

	Queue requests = new LinkedList();

	int field1133;

	UrlRequester(int var1) {
		this.field1134.setPriority(1);
		this.field1134.start();
		this.field1133 = var1;
	}

	abstract void vmethod2700(UrlRequest var1) throws IOException;

	int method630(URLConnection var1) {
		int var2 = -1;
		if (var1 != null) {
			try {
				if (var1 instanceof HttpURLConnection) {
					var2 = ((HttpURLConnection) var1).getResponseCode();
				}
			} catch (IOException var4) {
				;
			}
		}

		return var2;
	}

	void method631(URLConnection var1) {
		var1.setConnectTimeout(5000);
		var1.setReadTimeout(5000);
		var1.setUseCaches(false);
		var1.setRequestProperty("Connection", "close");
		var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1133);
	}

	void method633(URLConnection var1, UrlRequest var2) {
		DataInputStream var3 = null;

		try {
			int var5 = var1.getContentLength();
			var3 = new DataInputStream(var1.getInputStream());
			byte[] var4;
			if (var5 >= 0) {
				var4 = new byte[var5];
				var3.readFully(var4);
			} else {
				var4 = new byte[0];
				byte[] var6 = Decimator.ByteArrayPool_getArray(5000);

				byte[] var8;
				for (int var7 = var3.read(var6, 0, var6.length); var7 > -1; var4 = var8) {
					var8 = new byte[var4.length + var7];
					System.arraycopy(var4, 0, var8, 0, var4.length);
					System.arraycopy(var6, 0, var8, var4.length, var7);
				}

				class366.ByteArrayPool_release(var6);
			}

			var2.response0 = var4;
		} catch (IOException var14) {
			var2.response0 = null;
		} finally {
			var2.field1139 = this.method630(var1);
		}

		if (var3 != null) {
			try {
				var3.close();
			} catch (IOException var13) {
				;
			}
		}

	}

	public UrlRequest request(URL var1) {
		UrlRequest var2 = new UrlRequest(var1);
		synchronized (this) {
			this.requests.add(var2);
			this.notify();
			return var2;
		}
	}

	public void close() {
		this.isClosed = true;

		try {
			synchronized (this) {
				this.notify();
			}

			this.field1134.join();
		} catch (InterruptedException var4) {
			;
		}

	}

	public void run() {
		while (!this.isClosed) {
			try {
				UrlRequest var1;
				synchronized (this) {
					var1 = (UrlRequest) this.requests.poll();
					if (var1 == null) {
						try {
							this.wait();
						} catch (InterruptedException var5) {
							;
						}
						continue;
					}
				}

				this.vmethod2700(var1);
			} catch (Exception var7) {
				class364.RunException_sendStackTrace((String) null, var7);
			}
		}

	}
}
