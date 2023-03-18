public enum VerticalAlignment implements class352 {

	field1592(1, 0),

	VerticalAlignment_centered(2, 1), field1594(0, 2);

	public final int value;

	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	public int rsOrdinal() {
		return this.id;
	}

	public static void method976() {
		while (true) {
			NodeDeque var1 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
			ArchiveDiskAction var0;
			synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var0 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var0 == null) {
				return;
			}

			var0.archive.load(var0.archiveDisk, (int) var0.key, var0.data, false);
		}
	}
}
