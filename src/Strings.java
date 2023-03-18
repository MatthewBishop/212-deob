public class Strings {

	public static String field3133 = "Please visit the support page for assistance.";

	public static String field3103 = "";

	public static String field3332 = "Page has opened in the browser.";

	public static String field3333 = "";

	protected static final void method1804() {
		GameEngine.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.clientTickTimes[var0] = 0L;
		}

		GameEngine.gameCyclesToDo = 0;
	}
}
