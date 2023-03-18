import java.util.concurrent.Callable;

public class SecureRandomCallable implements Callable {

	static int field833;

	public Object call() {
		return class392.method2063();
	}

	static Script getScript(int var0) {
		Script var1 = (Script) Script.Script_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class167.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = class4.newScript(var2);
				Script.Script_cached.put(var1, (long) var0);
				return var1;
			}
		}
	}

	static int method454(int var0, int var1) {
		ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	public static DbRowType getDbRowType(int var0) {
		DbRowType var1 = (DbRowType) DbRowType.DBRowType_cache.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbRowType.field3960.takeFile(38, var0);
			var1 = new DbRowType();
			if (var2 != null) {
				var1.method2378(new Buffer(var2));
			}

			var1.method2380();
			DbRowType.DBRowType_cache.put(var1, (long) var0);
			return var1;
		}
	}

	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel) Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	static int method458(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
		if (var0 == 1800) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapDecorationType
					.Widget_unpackTargetMask(ParamComposition.getWidgetFlags(var3));
			return 1;
		} else if (var0 != 1801) {
			if (var0 == 1802) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
