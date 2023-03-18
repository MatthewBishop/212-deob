public class class279 {

	static IndexedSprite[] worldSelectFlagSprites;

	public static String readString(Buffer var0) {
		return GrandExchangeEvents.method1854(var0, 32767);
	}

	public static SpritePixels[] method1541(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return class70.method416(var0, var3, var4);
	}

	public static int Entity_unpackID(long var0) {
		return (int) (var0 >>> 17 & 4294967295L);
	}

	static final void method1540() {
		Client.field555 = Client.cycleCntr;
		ObjTypeCustomisation.field1453 = true;
	}
}
