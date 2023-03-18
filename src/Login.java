import java.text.DecimalFormat;

public class Login {

	static boolean clearLoginScreen;

	static int xPadding = 0;

	static IndexedSprite[] runesSprite;

	static IndexedSprite titlebuttonSprite;

	static SpritePixels leftTitleSprite;

	static IndexedSprite logoSprite;

	static IndexedSprite options_buttons_0Sprite;

	static IndexedSprite options_buttons_2Sprite;

	static int loginBoxX;

	static int loginBoxCenter;

	static int Login_loadingPercent;

	static String Login_loadingText;

	static int field738;

	static int field725;

	static int loginIndex;

	static String Login_response0;

	static String Login_response1;

	static String Login_response2;

	static String Login_response3;

	static String Login_username;

	static String Login_password;

	static int field746;

	static String[] field745;

	static String field747;

	static boolean field737;

	static boolean field749;

	static boolean field750;

	static int currentLoginField;

	static boolean worldSelectOpen;

	static int hoveredWorldIndex;

	static int worldSelectPage;

	static int worldSelectPagesCount;

	static long field757;

	static long field758;

	static String[] field759;

	static String[] field760;

	static String[] field761;

	static int menuY;

	static {
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field738 = -1;
		field725 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field746 = 0;
		field745 = new String[8];
		field747 = "";
		field737 = false;
		field749 = false;
		field750 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class130();
		field757 = -1L;
		field758 = -1L;
		field759 = new String[] { "title.jpg" };
		field760 = new String[] { "logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton",
				"titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute",
				"options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4",
				"options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button" };
		field761 = new String[] { "logo_speedrunning" };
	}

	public static final void method429(long var0) {
		if (var0 > 0L) {
			if (0L == var0 % 10L) {
				class169.method900(var0 - 1L);
				class169.method900(1L);
			} else {
				class169.method900(var0);
			}

		}
	}

	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + class18.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	static int method430(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 3903) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == 3904) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == 3905) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == 3906) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == 3907) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == 3908) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == 3910) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == 3911) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == 3912) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == 3913) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == 3914) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (Projectile.grandExchangeEvents != null) {
						Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator,
								var13);
					}

					return 1;
				} else if (var0 == 3915) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (Projectile.grandExchangeEvents != null) {
						Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator,
								var13);
					}

					return 1;
				} else if (var0 == 3916) {
					Interpreter.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
					if (Projectile.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						Projectile.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == 3917) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (Projectile.grandExchangeEvents != null) {
						Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator,
								var13);
					}

					return 1;
				} else if (var0 == 3918) {
					var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					if (Projectile.grandExchangeEvents != null) {
						Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator,
								var13);
					}

					return 1;
				} else if (var0 == 3919) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
							- 1] = Projectile.grandExchangeEvents == null ? 0
									: Projectile.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == 3920) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == 3921) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var11
								.getOfferName();
						return 1;
					} else if (var0 == 3922) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var11
								.getPreviousOfferName();
						return 1;
					} else if (var0 == 3923) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						long var5 = WorldMapSection2.clockNow() - GrandExchangeOfferWorldComparator.field3473
								- var11.age;
						int var7 = (int) (var5 / 3600000L);
						int var8 = (int) ((var5 - (long) (var7 * 3600000)) / 60000L);
						int var9 = (int) ((var5 - (long) (var7 * 3600000) - (long) (var8 * '\uea60')) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == 3924) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
								- 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == 3925) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
								- 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == 3926) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) Projectile.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
								- 1] = var11.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}
