import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class class456 implements class455 {

	Map field3908;

	final class485 field3909;

	public class456(class485 var1) {
		this.field3909 = var1;
	}

	public int vmethod8144(int var1) {
		if (this.field3908 != null) {
			class486 var2 = (class486) this.field3908.get(var1);
			if (var2 != null) {
				return (Integer) var2.field4026;
			}
		}

		return (Integer) this.field3909.vmethod8697(var1);
	}

	public void vmethod8143(int var1, Object var2) {
		if (this.field3908 == null) {
			this.field3908 = new HashMap();
			this.field3908.put(var1, new class486(var1, var2));
		} else {
			class486 var3 = (class486) this.field3908.get(var1);
			if (var3 == null) {
				this.field3908.put(var1, new class486(var1, var2));
			} else {
				var3.field4026 = var2;
			}
		}

	}

	public Iterator iterator() {
		return this.field3908 == null ? Collections.emptyList().iterator() : this.field3908.values().iterator();
	}

	public static IndexedSprite[] method2330(AbstractArchive var0, int var1, int var2) {
		byte[] var4 = var0.takeFile(var1, var2);
		boolean var3;
		if (var4 == null) {
			var3 = false;
		} else {
			class212.SpriteBuffer_decode(var4);
			var3 = true;
		}

		return !var3 ? null : class130.method717();
	}
}
