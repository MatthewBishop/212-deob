import java.awt.datatransfer.Clipboard;

public class class206 implements class29 {

	Widget field1804 = null;

	boolean field1805 = false;

	boolean field1806 = false;

	public boolean vmethod3949(int var1) {
		if (this.field1804 == null) {
			return false;
		} else {
			class27 var2 = this.field1804.method1760();
			if (var2 == null) {
				return false;
			} else {
				if (var2.method115(var1)) {
					switch (var1) {
					case 81:
						this.field1806 = true;
						break;
					case 82:
						this.field1805 = true;
						break;
					default:
						if (this.method1079(var1)) {
							class69.invalidateWidget(this.field1804);
						}
					}
				}

				return var2.method113(var1);
			}
		}
	}

	public boolean vmethod3989(int var1) {
		switch (var1) {
		case 81:
			this.field1806 = false;
			return false;
		case 82:
			this.field1805 = false;
			return false;
		default:
			return false;
		}
	}

	public boolean vmethod3951(char var1) {
		if (this.field1804 == null) {
			return false;
		} else if (!ReflectionCheck.method180(var1)) {
			return false;
		} else {
			class310 var2 = this.field1804.method1758();
			if (var2 != null && var2.method1694()) {
				class27 var3 = this.field1804.method1760();
				if (var3 == null) {
					return false;
				} else {
					if (var3.method116(var1) && var2.method1666(var1)) {
						class69.invalidateWidget(this.field1804);
					}

					return var3.method114(var1);
				}
			} else {
				return false;
			}
		}
	}

	public boolean vmethod3953(boolean var1) {
		return false;
	}

	public void method1073(Widget var1) {
		this.method1082();
		if (var1 != null) {
			this.field1804 = var1;
			class308 var2 = var1.method1768();
			if (var2 != null) {
				var2.field2784.method1706(true);
				if (var2.field2781 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method467(var1);
					var3.setArgs(var2.field2781);
					class144.getScriptEvents().addFirst(var3);
				}
			}
		}

	}

	public Widget method1074() {
		return this.field1804;
	}

	public void method1082() {
		if (this.field1804 != null) {
			class308 var1 = this.field1804.method1768();
			Widget var2 = this.field1804;
			this.field1804 = null;
			if (var1 != null) {
				var1.field2784.method1706(false);
				if (var1.field2781 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method467(var2);
					var3.setArgs(var1.field2781);
					class144.getScriptEvents().addFirst(var3);
				}

			}
		}
	}

	boolean method1079(int var1) {
		if (this.field1804 == null) {
			return false;
		} else {
			class310 var2 = this.field1804.method1758();
			if (var2 != null && var2.method1694()) {
				Clipboard var5;
				switch (var1) {
				case 13:
					this.method1082();
					return true;
				case 48:
					if (this.field1805) {
						var2.method1671();
					}

					return true;
				case 65:
					if (this.field1805) {
						var5 = class392.client.getClipboard();
						var2.method1731(var5);
					}

					return true;
				case 66:
					if (this.field1805) {
						var5 = class392.client.getClipboard();
						var2.method1682(var5);
					}

					return true;
				case 67:
					if (this.field1805) {
						var5 = class392.client.getClipboard();
						var2.method1684(var5);
					}

					return true;
				case 84:
					if (var2.method1698() == 0) {
						var2.method1666(10);
					} else if (this.field1806 && var2.method1707()) {
						var2.method1666(10);
					} else {
						class308 var3 = this.field1804.method1768();
						ScriptEvent var4 = new ScriptEvent();
						var4.method467(this.field1804);
						var4.setArgs(var3.field2780);
						class144.getScriptEvents().addFirst(var4);
						this.method1082();
					}

					return true;
				case 85:
					if (this.field1805) {
						var2.method1669();
					} else {
						var2.method1667();
					}

					return true;
				case 96:
					if (this.field1805) {
						var2.method1677(this.field1806);
					} else {
						var2.method1675(this.field1806);
					}

					return true;
				case 97:
					if (this.field1805) {
						var2.method1718(this.field1806);
					} else {
						var2.method1676(this.field1806);
					}

					return true;
				case 98:
					if (this.field1805) {
						var2.method1685();
					} else {
						var2.method1659(this.field1806);
					}

					return true;
				case 99:
					if (this.field1805) {
						var2.method1683();
					} else {
						var2.method1720(this.field1806);
					}

					return true;
				case 101:
					if (this.field1805) {
						var2.method1691();
					} else {
						var2.method1668();
					}

					return true;
				case 102:
					if (this.field1805) {
						var2.method1710(this.field1806);
					} else {
						var2.method1724(this.field1806);
					}

					return true;
				case 103:
					if (this.field1805) {
						var2.method1674(this.field1806);
					} else {
						var2.method1730(this.field1806);
					}

					return true;
				case 104:
					if (this.field1805) {
						var2.method1728(this.field1806);
					} else {
						var2.method1697(this.field1806);
					}

					return true;
				case 105:
					if (this.field1805) {
						var2.method1679(this.field1806);
					} else {
						var2.method1713(this.field1806);
					}

					return true;
				default:
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static int method1081(int var0) {
		return class291.field2661[var0];
	}

	static void method1080() {
		ItemContainer.itemContainers = new NodeHashTable(32);
	}
}
