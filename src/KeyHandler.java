import java.awt.Component;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class KeyHandler implements KeyListener, FocusListener {

	Collection field77 = new ArrayList(100);

	Collection field78 = new ArrayList(100);

	class29[] field79 = new class29[3];

	boolean[] KeyHandler_pressedKeys = new boolean[112];

	volatile int KeyHandler_idleCycles = 0;

	void method98(class29 var1, int var2) {
		this.field79[var2] = var1;
	}

	public int getIdleCycles() {
		return this.KeyHandler_idleCycles;
	}

	void method100(Component var1) {
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(this);
		var1.addFocusListener(this);
	}

	synchronized void method102(Component var1) {
		var1.removeKeyListener(this);
		var1.removeFocusListener(this);
		synchronized (this) {
			this.field77.add(new class33(4, 0));
		}
	}

	void method101() {
		++this.KeyHandler_idleCycles;
		this.method103();
		Iterator var1 = this.field78.iterator();

		while (var1.hasNext()) {
			class33 var2 = (class33) var1.next();

			for (int var3 = 0; var3 < this.field79.length && !var2.method137(this.field79[var3]); ++var3) {
				;
			}
		}

		this.field78.clear();
	}

	synchronized void method103() {
		Collection var1 = this.field78;
		this.field78 = this.field77;
		this.field77 = var1;
	}

	public final synchronized void keyReleased(KeyEvent var1) {
		int var2 = var1.getKeyCode();
		if (var2 >= 0 && var2 < class365.method1939()) {
			int var3 = class28.KeyHandler_keyCodes[var2];
			var2 = var3 & -129;
		} else {
			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = false;
			this.field77.add(new class33(2, var2));
		}

		var1.consume();
	}

	public final synchronized void keyTyped(KeyEvent var1) {
		char var2 = var1.getKeyChar();
		if (var2 != 0 && var2 != '\uffff' && WorldMapSection2.method1332(var2)) {
			this.field77.add(new class33(3, var2));
		}

		var1.consume();
	}

	public final synchronized void focusGained(FocusEvent var1) {
		this.field77.add(new class33(4, 1));
	}

	public final synchronized void focusLost(FocusEvent var1) {
		for (int var2 = 0; var2 < 112; ++var2) {
			if (this.KeyHandler_pressedKeys[var2]) {
				this.KeyHandler_pressedKeys[var2] = false;
				this.field77.add(new class33(2, var2));
			}
		}

		this.field77.add(new class33(4, 0));
	}

	public final synchronized void keyPressed(KeyEvent var1) {
		int var2 = var1.getKeyCode();
		if (var2 >= 0 && var2 < class365.method1939()) {
			int var3 = class28.KeyHandler_keyCodes[var2];
			var2 = var3;
			if (class385.method2043(var3)) {
				var2 = -1;
			}
		} else {
			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = true;
			this.field77.add(new class33(1, var2));
			this.KeyHandler_idleCycles = 0;
		}

		var1.consume();
	}

	public static void openURL(String var0, boolean var1, boolean var2) {
		if (var1) {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var4) {
					;
				}
			}

			if (class31.field86.startsWith("win")) {
				class166.method863(var0, 0, "openjs");
			} else if (class31.field86.startsWith("mac")) {
				class166.method863(var0, 1, "openjs");
			} else {
				class166.method863(var0, 2, "openjs");
			}
		} else {
			class166.method863(var0, 3, "openjs");
		}

	}
}
