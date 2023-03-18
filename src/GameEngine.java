import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;

public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {

	protected static TaskHandler taskHandler;

	static GameEngine gameEngine = null;

	static int GameEngine_redundantStartThreadCount = 0;

	static long stopTimeMs = 0L;

	static boolean isKilled = false;

	static int gameCyclesToDo;

	static int cycleDurationMillis = 20;

	static int fiveOrOne = 1;

	protected static int fps = 0;

	static Clock clock;

	static long[] graphicsTickTimes = new long[32];

	static long[] clientTickTimes = new long[32];

	public static int canvasWidth;

	static int field114 = 500;

	static volatile boolean volatileFocus = true;

	protected static KeyHandler keyHandler = new KeyHandler();

	static long garbageCollectorLastCollectionTime = -1L;

	static long garbageCollectorLastCheckTimeMs = -1L;

	static int baseX;

	boolean hasErrored = false;

	protected int contentWidth;

	protected int contentHeight;

	int canvasX = 0;

	int canvasY = 0;

	int field128;

	int field112;

	int maxCanvasWidth;

	int maxCanvasHeight;

	Frame frame;

	java.awt.Canvas canvas;

	volatile boolean fullRedraw = true;

	boolean resizeCanvasNextFrame = false;

	volatile boolean isCanvasInvalid = false;

	volatile long field121 = 0L;

	MouseWheelHandler mouseWheelHandler;

	Clipboard clipboard;

	final EventQueue eventQueue;

	protected GameEngine() {
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
			;
		}

		this.eventQueue = var1;
		DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
		Script.pcmPlayerProvider = var2;
	}

	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method165();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				Login.method429(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	protected class171 mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	protected void method142(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner) null);
	}

	public Clipboard getClipboard() {
		return this.clipboard;
	}

	protected final void setUpKeyboard() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			class28.KeyHandler_keyCodes[186] = 57;
			class28.KeyHandler_keyCodes[187] = 27;
			class28.KeyHandler_keyCodes[188] = 71;
			class28.KeyHandler_keyCodes[189] = 26;
			class28.KeyHandler_keyCodes[190] = 72;
			class28.KeyHandler_keyCodes[191] = 73;
			class28.KeyHandler_keyCodes[192] = 58;
			class28.KeyHandler_keyCodes[219] = 42;
			class28.KeyHandler_keyCodes[220] = 74;
			class28.KeyHandler_keyCodes[221] = 43;
			class28.KeyHandler_keyCodes[222] = 59;
			class28.KeyHandler_keyCodes[223] = 28;
		} else {
			class28.KeyHandler_keyCodes[44] = 71;
			class28.KeyHandler_keyCodes[45] = 26;
			class28.KeyHandler_keyCodes[46] = 72;
			class28.KeyHandler_keyCodes[47] = 73;
			class28.KeyHandler_keyCodes[59] = 57;
			class28.KeyHandler_keyCodes[61] = 27;
			class28.KeyHandler_keyCodes[91] = 42;
			class28.KeyHandler_keyCodes[92] = 74;
			class28.KeyHandler_keyCodes[93] = 43;
			class28.KeyHandler_keyCodes[192] = 28;
			class28.KeyHandler_keyCodes[222] = 58;
			class28.KeyHandler_keyCodes[520] = 59;
		}

		keyHandler.method100(this.canvas);
	}

	protected final void method145() {
		keyHandler.method101();
	}

	protected void method139(class29 var1, int var2) {
		keyHandler.method98(var1, var2);
	}

	protected final void method146() {
		AABB.method1242(this.canvas);
	}

	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field128);
			this.contentHeight = Math.max(var2.highY, this.field112);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			class143.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(canvasWidth, class143.canvasHeight);
			StudioGame.rasterProvider = new RasterProvider(canvasWidth, class143.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var3.left, var3.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.fullRedraw = true;
			this.resizeGame();
		}
	}

	protected abstract void resizeGame();

	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - canvasWidth - var1;
		int var4 = this.contentHeight - class143.canvasHeight - var2;
		if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
			try {
				Container var5 = this.container();
				int var6 = 0;
				int var7 = 0;
				if (var5 == this.frame) {
					Insets var8 = this.frame.getInsets();
					var6 = var8.left;
					var7 = var8.top;
				}

				Graphics var10 = var5.getGraphics();
				var10.setColor(Color.black);
				if (var1 > 0) {
					var10.fillRect(var6, var7, var1, this.contentHeight);
				}

				if (var2 > 0) {
					var10.fillRect(var6, var7, this.contentWidth, var2);
				}

				if (var3 > 0) {
					var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
				}

				if (var4 > 0) {
					var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
				}
			} catch (Exception var9) {
				;
			}
		}

	}

	final void replaceCanvas() {
		keyHandler.method102(this.canvas);
		InvDefinition.method925(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.method86(this.canvas);
		}

		this.addCanvas();
		keyHandler.method100(this.canvas);
		AABB.method1242(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method165();
	}

	protected final void startThread(int var1, int var2, int var3, int var4) {
		try {
			if (gameEngine != null) {
				++GameEngine_redundantStartThreadCount;
				if (GameEngine_redundantStartThreadCount >= 3) {
					this.error("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			gameEngine = this;
			canvasWidth = var1;
			class143.canvasHeight = var2;
			RunException.RunException_revision = var3;
			class199.field1633 = var4;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var6) {
			class364.RunException_sendStackTrace((String) null, var6);
			this.error("crash");
		}

	}

	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		canvasWidth = Math.max(var1.getWidth(), this.field128);
		class143.canvasHeight = Math.max(var1.getHeight(), this.field112);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			canvasWidth -= var2.right + var2.left;
			class143.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager) null);
		var1.add(this.canvas);
		this.canvas.setSize(canvasWidth, class143.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(var2.left + this.canvasX, this.canvasY + var2.top);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.fullRedraw = true;
		if (StudioGame.rasterProvider != null && canvasWidth == StudioGame.rasterProvider.width
				&& class143.canvasHeight == StudioGame.rasterProvider.height) {
			((RasterProvider) StudioGame.rasterProvider).setComponent(this.canvas);
			StudioGame.rasterProvider.drawFull(0, 0);
		} else {
			StudioGame.rasterProvider = new RasterProvider(canvasWidth, class143.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field121 = WorldMapSection2.clockNow();
	}

	protected final boolean checkHost() {
		String var1 = this.getDocumentBase().getHost().toLowerCase();
		if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
			if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
				if (var1.endsWith("127.0.0.1")) {
					return true;
				} else {
					while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0'
							&& var1.charAt(var1.length() - 1) <= '9') {
						var1 = var1.substring(0, var1.length() - 1);
					}

					if (var1.endsWith("192.168.1.")) {
						return true;
					} else {
						this.error("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	void clientTick() {
		long var1 = WorldMapSection2.clockNow();
		long var3 = clientTickTimes[VarpDefinition.field1465];
		clientTickTimes[VarpDefinition.field1465] = var1;
		VarpDefinition.field1465 = VarpDefinition.field1465 + 1 & 31;
		if (var3 != 0L && var1 > var3) {
			;
		}

		synchronized (this) {
			Varps.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	void graphicsTick() {
		Container var1 = this.container();
		long var2 = WorldMapSection2.clockNow();
		long var4 = graphicsTickTimes[class212.field1850];
		graphicsTickTimes[class212.field1850] = var2;
		class212.field1850 = class212.field1850 + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int) (var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field114 - 1 > 50) {
			field114 -= 50;
			this.fullRedraw = true;
			this.canvas.setSize(canvasWidth, class143.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var7.left, var7.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method148();
		this.draw(this.fullRedraw);
		if (this.fullRedraw) {
			this.clearBackground();
		}

		this.fullRedraw = false;
	}

	final void method148() {
		Bounds var1 = this.getFrameContentBounds();
		if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	final void method165() {
		this.resizeCanvasNextFrame = true;
	}

	final synchronized void kill() {
		if (!isKilled) {
			isKilled = true;

			try {
				this.canvas.removeFocusListener(this);
			} catch (Exception var5) {
				;
			}

			try {
				this.kill0();
			} catch (Exception var4) {
				;
			}

			if (this.frame != null) {
				try {
					System.exit(0);
				} catch (Throwable var3) {
					;
				}
			}

			if (taskHandler != null) {
				try {
					taskHandler.close();
				} catch (Exception var2) {
					;
				}
			}

			this.vmethod1485();
		}
	}

	protected abstract void setUp();

	protected abstract void doCycle();

	protected abstract void draw(boolean var1);

	protected abstract void kill0();

	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (class306.fontHelvetica13 == null) {
				class306.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class139.loginScreenFontMetrics = this.canvas.getFontMetrics(class306.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, canvasWidth, class143.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (AbstractByteArrayCopier.field2987 == null) {
					AbstractByteArrayCopier.field2987 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = AbstractByteArrayCopier.field2987.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(class306.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class139.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(AbstractByteArrayCopier.field2987, canvasWidth / 2 - 152, class143.canvasHeight / 2 - 18,
						(ImageObserver) null);
			} catch (Exception var9) {
				int var7 = canvasWidth / 2 - 152;
				int var8 = class143.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(class306.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class139.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	protected final void method157() {
		AbstractByteArrayCopier.field2987 = null;
		class306.fontHelvetica13 = null;
		class139.loginScreenFontMetrics = null;
	}

	protected void error(String var1) {
		if (!this.hasErrored) {
			this.hasErrored = true;
			System.out.println("error_game_" + var1);

			try {
				this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"),
						"_self");
			} catch (Exception var3) {
				;
			}

		}
	}

	Container container() {
		return (Container) (this.frame != null ? this.frame : this);
	}

	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field128);
		int var3 = Math.max(var1.getHeight(), this.field112);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.top + var4.bottom;
		}

		return new Bounds(var2, var3);
	}

	protected final boolean hasFrame() {
		return this.frame != null;
	}

	protected abstract void vmethod1485();

	public final void destroy() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = WorldMapSection2.clockNow();
			Login.method429(5000L);
			this.kill();
		}
	}

	public final synchronized void paint(Graphics var1) {
		if (this == gameEngine && !isKilled) {
			this.fullRedraw = true;
			if (WorldMapSection2.clockNow() - this.field121 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= canvasWidth && var2.height >= class143.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public void run() {
		try {
			if (TaskHandler.javaVendor != null) {
				String var1 = TaskHandler.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = TaskHandler.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.")
							|| var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4")
							|| var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.")
							|| var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && class28.isDigit(var2.charAt(var3)); ++var3) {
							;
						}

						String var4 = var2.substring(6, var3);
						if (class162.isNumber(var4) && GrandExchangeEvent.method1867(var4) < 10) {
							this.error("wrongjava");
							return;
						}
					}

					fiveOrOne = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addCanvas();
			this.setUp();
			clock = class421.method2197();

			while (0L == stopTimeMs || WorldMapSection2.clockNow() < stopTimeMs) {
				gameCyclesToDo = clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class364.RunException_sendStackTrace((String) null, var6);
			this.error("crash");
		}

		this.kill();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void stop() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = WorldMapSection2.clockNow() + 4000L;
		}
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public abstract void init();

	public final void start() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.fullRedraw = true;
	}

	public static VarpDefinition VarpDefinition_get(int var0) {
		VarpDefinition var1 = (VarpDefinition) VarpDefinition.VarpDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}

	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = class36.getWidgetChild(class18.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				class9.runScriptEvent(var1);
			}

			Client.selectedSpellItemId = -1;
			Client.isSpellSelected = false;
			class69.invalidateWidget(var0);
		}
	}
}
