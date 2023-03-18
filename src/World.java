public class World {

	static int World_count = 0;

	static int World_listCount = 0;

	static int[] World_sortOption2 = new int[] { 1, 1, 1, 1 };

	static int[] World_sortOption1 = new int[] { 0, 1, 2, 3 };

	int id;

	int properties;

	int population;

	String host;

	String activity;

	int location;

	int index;

	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	boolean method395() {
		return (2 & this.properties) != 0;
	}

	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	boolean method388() {
		return (8 & this.properties) != 0;
	}

	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	boolean method393() {
		return (1073741824 & this.properties) != 0;
	}

	boolean method391() {
		return (256 & this.properties) != 0;
	}

	boolean method392() {
		return (134217728 & this.properties) != 0;
	}

	static int method394(Widget var0) {
		if (var0.type != 11) {
			--HealthBar.Interpreter_stringStackSize;
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			return 1;
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var0.method1750(var1);
			return 1;
		}
	}
}
