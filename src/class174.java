public class class174 {

	public String field1430;

	public float[] field1433;

	public int field1431;

	public int field1429;

	public int field1432;
	// $FF: synthetic field

	final class167 this$0;

	class174(class167 var1) {
		this.this$0 = var1;
		this.field1433 = new float[4];
		this.field1431 = 1;
		this.field1429 = 1;
		this.field1432 = 0;
	}

	static int method905(AbstractArchive var0) {
		int var1 = Login.field759.length + Login.field760.length;
		String[] var2 = Login.field761;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			String var4 = var2[var3];
			if (var0.getGroupId(var4) != -1) {
				++var1;
			}
		}

		return var1;
	}

	static final void method906() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsInClanChat();
		}

	}
}
