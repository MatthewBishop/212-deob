import java.util.ArrayList;

public class Interpreter {

	static PcmPlayer pcmPlayer0;

	static int[] Interpreter_intLocals;

	static String[] Interpreter_stringLocals;

	static int[] Interpreter_arrayLengths = new int[5];

	static int[][] Interpreter_arrays = new int[5][5000];

	static int[] Interpreter_intStack = new int[1000];

	static int Interpreter_intStackSize;

	static String[] Interpreter_stringStack = new String[1000];

	static int Interpreter_frameDepth = 0;

	static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];

	static int[] field696;

	static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();

	static final String[] Interpreter_MONTHS = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec" };

	static boolean field691 = false;

	static boolean field692 = false;

	static ArrayList field693 = new ArrayList();

	static int field694 = 0;

	static final double field695 = Math.log(2.0D);

	static int field699;

	static boolean method411(char var0) {
		for (int var1 = 0; var1 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| "
				.length(); ++var1) {
			if (var0 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| "
					.charAt(var1)) {
				return true;
			}
		}

		return false;
	}
}
