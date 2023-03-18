import java.util.Comparator;

final class GrandExchangeOfferNameComparator implements Comparator {

	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = class323.method1794(var1, var0);
		Script var4 = HorizontalAlignment.method957(var3, var0);
		if (var4 != null) {
			return var4;
		} else {
			int var5 = (-3 - var2 << 8) + var0;
			var4 = HorizontalAlignment.method957(var5, var0);
			return var4 != null ? var4 : null;
		}
	}

	static void process() {
		for (InterfaceParent var0 = (InterfaceParent) Client.interfaceParents
				.first(); var0 != null; var0 = (InterfaceParent) Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (GrandExchangeEvent.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = class155.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int) var0.key;
					Widget var5 = WorldMapSection1.getWidget(var4);
					if (var5 != null) {
						class69.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
