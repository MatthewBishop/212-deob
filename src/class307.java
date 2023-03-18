import java.net.MalformedURLException;
import java.net.URL;

public class class307 {

	static int field2776;

	UrlRequest field2775;

	SpritePixels field2774;

	class307(String var1, UrlRequester var2) {
		try {
			this.field2775 = var2.request(new URL(var1));
		} catch (MalformedURLException var4) {
			this.field2775 = null;
		}

	}

	class307(UrlRequest var1) {
		this.field2775 = var1;
	}

	SpritePixels method1639() {
		if (this.field2774 == null && this.field2775 != null && this.field2775.isDone()) {
			if (this.field2775.getResponse() != null) {
				this.field2774 = class139.method748(this.field2775.getResponse());
			}

			this.field2775 = null;
		}

		return this.field2774;
	}
}
