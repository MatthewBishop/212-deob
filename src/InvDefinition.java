import java.awt.Component;

public class InvDefinition extends DualNode {

	static AbstractArchive InvDefinition_archive;

	static EvictingDualNodeHashTable InvDefinition_cached = new EvictingDualNodeHashTable(64);

	static WorldMapEvent worldMapEvent;

	static String field1458;

	static Widget mousedOverWidgetIf1;

	public int size = 0;

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	static void method925(Component var0) {
		var0.removeMouseListener(MouseHandler.MouseHandler_instance);
		var0.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var0.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
	}
}
