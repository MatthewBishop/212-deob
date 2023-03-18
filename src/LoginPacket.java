public class LoginPacket implements class281 {

	public static final LoginPacket field2652 = new LoginPacket(14, 0);

	static final LoginPacket field2647 = new LoginPacket(15, 4);

	public static final LoginPacket NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);

	public static final LoginPacket RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);

	public static final LoginPacket field2651 = new LoginPacket(19, -2);

	static final LoginPacket field2646 = new LoginPacket(27, 0);

	static final LoginPacket[] field2653 = new LoginPacket[32];

	public final int id;

	static {
		LoginPacket[] var0 = WorldMapArea.method1359();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			field2653[var0[var1].id] = var0[var1];
		}

	}

	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	static int method1545(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
		if (var0 == 1600) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 1601) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else {
			class310 var7;
			if (var0 == 1602) {
				if (var3.type == 12) {
					var7 = var3.method1758();
					if (var7 != null) {
						Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var7
								.method1688().method1951();
						return 1;
					}
				}

				Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.text;
				return 1;
			} else if (var0 == 1603) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
				return 1;
			} else if (var0 == 1604) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
				return 1;
			} else if (var0 == 1605) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
				return 1;
			} else if (var0 == 1606) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
				return 1;
			} else if (var0 == 1607) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
				return 1;
			} else if (var0 == 1608) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
				return 1;
			} else if (var0 == 1609) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
				return 1;
			} else if (var0 == 1610) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
				return 1;
			} else if (var0 == 1611) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
				return 1;
			} else if (var0 == 1612) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
				return 1;
			} else if (var0 == 1613) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode
						.rsOrdinal();
				return 1;
			} else if (var0 == 1614) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency
						? 1
						: 0;
				return 1;
			} else {
				class305 var4;
				if (var0 == 1617) {
					var4 = var3.method1759();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null
							? var4.field2768 * -315144963 * -2107246507
							: 0;
				}

				if (var0 == 1618) {
					var4 = var3.method1759();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null
							? var4.field2769 * 437488265 * -1438315591
							: 0;
					return 1;
				} else if (var0 == 1619) {
					var7 = var3.method1758();
					Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var7 != null
							? var7.method1689().method1951()
							: "";
					return 1;
				} else if (var0 == 1620) {
					var4 = var3.method1759();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null
							? var4.field2771 * 1180023711 * -2020302753
							: 0;
					return 1;
				} else if (var0 == 1621) {
					var7 = var3.method1758();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
							? var7.method1696()
							: 0;
					return 1;
				} else if (var0 == 1622) {
					var7 = var3.method1758();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
							? var7.method1656()
							: 0;
					return 1;
				} else if (var0 == 1623) {
					var7 = var3.method1758();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
							? var7.method1699()
							: 0;
					return 1;
				} else if (var0 == 1624) {
					var7 = var3.method1758();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
							&& var7.method1721() ? 1 : 0;
					return 1;
				} else if (var0 != 1625) {
					if (var0 == 1626) {
						var7 = var3.method1758();
						Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var7 != null
								? var7.method1690().method2021()
								: "";
						return 1;
					} else if (var0 == 1627) {
						var7 = var3.method1758();
						int var5 = var7 != null ? var7.method1729() : 0;
						int var6 = var7 != null ? var7.method1693() : 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.min(var5,
								var6);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.max(var5,
								var6);
						return 1;
					} else if (var0 == 1628) {
						var7 = var3.method1758();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
								? var7.method1693()
								: 0;
						return 1;
					} else if (var0 == 1629) {
						var7 = var3.method1758();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
								? var7.method1712()
								: 0;
						return 1;
					} else if (var0 == 1630) {
						var7 = var3.method1758();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
								? var7.method1698()
								: 0;
						return 1;
					} else if (var0 == 1631) {
						var7 = var3.method1758();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
								? var7.method1700()
								: 0;
						return 1;
					} else if (var0 == 1632) {
						var7 = var3.method1758();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
								? var7.method1717()
								: 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 1633) {
							var8 = var3.method1760();
							Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null
									? var8.method111(
											Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1])
									: 0;
							return 1;
						} else if (var0 == 1634) {
							var8 = var3.method1760();
							Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null
									? var8.method112(
											(char) Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize
													- 1])
									: 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = var3.method1758();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null
							&& var7.method1715() ? 1 : 0;
					return 1;
				}
			}
		}
	}
}
