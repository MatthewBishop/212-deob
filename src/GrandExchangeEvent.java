public class GrandExchangeEvent {

	public final int world;

	public final long age;

	public final GrandExchangeOffer grandExchangeOffer;

	String offerName;

	String previousOfferName;

	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method1871(2);
		this.grandExchangeOffer.method1872(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	public String getOfferName() {
		return this.offerName;
	}

	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	public static boolean loadInterface(int var0) {
		if (class123.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!MouseRecorder.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = MouseRecorder.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				class123.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (class155.Widget_interfaceComponents[var0] == null) {
					class155.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (class155.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = MouseRecorder.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							class155.Widget_interfaceComponents[var0][var2] = new Widget();
							class155.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								class155.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								class155.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				class123.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	public static int method1867(CharSequence var0) {
		return class146.method771(var0, 10, true);
	}
}
