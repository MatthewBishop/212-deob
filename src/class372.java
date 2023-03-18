import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class class372 implements Iterator {

	static byte[][] regionMapArchives;

	class373 field3555;

	int field3554 = 0;

	int field3556;

	class372(class373 var1) {
		this.field3556 = this.field3555.field3562;
		this.field3555 = var1;
	}

	public boolean hasNext() {
		return this.field3554 < this.field3555.field3559;
	}

	public Object next() {
		if (this.field3555.field3562 != this.field3556) {
			throw new ConcurrentModificationException();
		} else if (this.field3554 < this.field3555.field3559) {
			Object var1 = this.field3555.field3560[this.field3554].field3553;
			++this.field3554;
			return var1;
		} else {
			throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
