import java.lang.management.GarbageCollectorMXBean;

public enum class135 implements class352 {

	field1276(0, 0),

	field1267(1, 1),

	field1268(2, 2),

	field1269(3, 3),

	field1277(4, 4),

	field1271(5, 5),

	field1272(6, 6),

	field1273(7, 7),

	field1274(8, 8);

	static GarbageCollectorMXBean garbageCollector;

	static Archive archive4;

	final int field1270;

	final int field1278;

	class135(int var3, int var4) {
		this.field1270 = var3;
		this.field1278 = var4;
	}

	public int rsOrdinal() {
		return this.field1278;
	}

	static Object method734(int var0) {
		return class148.method778((class467) SpriteMask.findEnumerated(class467.method2367(), var0));
	}
}
