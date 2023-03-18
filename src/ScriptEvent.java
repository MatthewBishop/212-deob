public class ScriptEvent extends Node {

	Object[] args;

	boolean field848;

	Widget widget;

	int mouseX;

	int mouseY;

	int opIndex;

	Widget dragTarget;

	int keyTyped;

	int keyPressed;

	String targetName;

	int field853;

	int type = 76;

	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	public void setType(int var1) {
		this.type = var1;
	}

	public void method467(Widget var1) {
		this.widget = var1;
	}

	static final void updateActorSequence(Actor var0, int var1) {
		if (var0.exactMoveArrive1Cycle >= Client.cycle) {
			int var2 = Math.max(1, var0.exactMoveArrive1Cycle - Client.cycle);
			int var3 = var0.field931 * 64 + var0.exactMoveDeltaX1 * 128;
			int var4 = var0.field931 * 64 + var0.exactMoveDeltaY1 * 128;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1003 = 0;
			var0.orientation = var0.exactMoveDirection;
		} else if (var0.exactMoveArrive2Cycle >= Client.cycle) {
			class6.method11(var0);
		} else {
			class18.method73(var0);
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.exactMoveArrive1Cycle = 0;
			var0.exactMoveArrive2Cycle = 0;
			var0.x = var0.field931 * 64 + var0.pathX[0] * 128;
			var0.y = var0.field931 * 64 + var0.pathY[0] * 128;
			var0.method509();
		}

		if (BuddyRankComparator.localPlayer == var0
				&& (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.exactMoveArrive1Cycle = 0;
			var0.exactMoveArrive2Cycle = 0;
			var0.x = var0.field931 * 64 + var0.pathX[0] * 128;
			var0.y = var0.pathY[0] * 128 + var0.field931 * 64;
			var0.method509();
		}

		MenuAction.method422(var0);
		class13.method46(var0);
	}
}
