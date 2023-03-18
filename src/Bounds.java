public class Bounds {

	static long field3726;

	public int lowX;

	public int lowY;

	public int highX;

	public int highY;

	public Bounds(int var1, int var2, int var3, int var4) {
		this.setLow(var1, var2);
		this.setHigh(var3, var4);
	}

	public Bounds(int var1, int var2) {
		this(0, 0, var1, var2);
	}

	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	public boolean method2170(int var1, int var2) {
		return var1 >= this.lowX && var1 < this.lowX + this.highX && var2 >= this.lowY && var2 < this.highY + this.lowY;
	}

	public void method2175(Bounds var1, Bounds var2) {
		this.method2174(var1, var2);
		this.method2171(var1, var2);
	}

	void method2174(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX = (var2.highX * 148348815 - (var1.lowX * 148348815 - this.lowX * 148348815)) * -1491558545;
			var2.lowX = var1.lowX;
		}

		if (var2.method2172() > var1.method2172()) {
			var2.highX -= var2.method2172() - var1.method2172();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	void method2171(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY = (var2.highY * -1535895713 - (var1.lowY * -1535895713 - this.lowY * -1535895713)) * 1232602271;
			var2.lowY = var1.lowY;
		}

		if (var2.method2173() > var1.method2173()) {
			var2.highY -= var2.method2173() - var1.method2173();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	int method2172() {
		return this.highX + this.lowX;
	}

	int method2173() {
		return this.lowY + this.highY;
	}

	public String toString() {
		return null;
	}
}
