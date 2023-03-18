import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ClientPreferences {

	static Archive archive9;

	boolean roofsHidden;

	boolean hideUsername = false;

	boolean titleMusicDisabled;

	boolean displayFps = false;

	int field1032;

	double brightness = 0.8D;

	int musicVolume = 127;

	int soundEffectsVolume = 127;

	int areaSoundEffectsVolume = 127;

	int field1039 = -1;

	String rememberedUsername = null;

	int windowMode = 1;

	final Map parameters = new LinkedHashMap();

	ClientPreferences() {
		this.method521(true);
	}

	ClientPreferences(Buffer var1) {
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= 10) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}

				if (var2 > 6) {
					this.brightness = (double) var1.readUnsignedByte() / 100.0D;
					this.musicVolume = var1.readUnsignedByte();
					this.soundEffectsVolume = var1.readUnsignedByte();
					this.areaSoundEffectsVolume = var1.readUnsignedByte();
				}

				if (var2 > 7) {
					this.field1039 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1032 = var1.readInt();
				}
			} else {
				this.method521(true);
			}
		} else {
			this.method521(true);
		}

	}

	void method521(boolean var1) {
	}

	Buffer toBuffer() {
		Buffer var1 = new Buffer(417, true);
		var1.writeByte(10);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.writeInt((Integer) var3.getKey());
			var1.writeInt((Integer) var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		var1.writeByte((int) (this.brightness * 100.0D));
		var1.writeByte(this.musicVolume);
		var1.writeByte(this.soundEffectsVolume);
		var1.writeByte(this.areaSoundEffectsVolume);
		var1.writeByte(this.field1039);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1032);
		return var1;
	}

	void setRoofsHidden(boolean var1) {
		this.roofsHidden = var1;
		class146.savePreferences();
	}

	boolean getRoofsHidden() {
		return this.roofsHidden;
	}

	void setIsUsernameHidden(boolean var1) {
		this.hideUsername = var1;
		class146.savePreferences();
	}

	boolean getIsUsernameHidden() {
		return this.hideUsername;
	}

	void getTitleMusicDisabled(boolean var1) {
		this.titleMusicDisabled = var1;
		class146.savePreferences();
	}

	boolean getTitleMusicDisabled() {
		return this.titleMusicDisabled;
	}

	void method550(boolean var1) {
		this.displayFps = var1;
		class146.savePreferences();
	}

	void method526() {
		this.method550(!this.displayFps);
	}

	boolean method522() {
		return this.displayFps;
	}

	void method527(int var1) {
		this.field1032 = var1;
		class146.savePreferences();
	}

	int method551() {
		return this.field1032;
	}

	void setBrightness(double var1) {
		this.brightness = var1;
		class146.savePreferences();
	}

	double getBrightness() {
		return this.brightness;
	}

	void setCurrentMusicVolume(int var1) {
		this.musicVolume = var1;
		class146.savePreferences();
	}

	int getCurrentMusicVolume() {
		return this.musicVolume;
	}

	void setCurrentSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		class146.savePreferences();
	}

	int getCurrentSoundEffectsVolume() {
		return this.soundEffectsVolume;
	}

	void setAreaSoundEffectsVolume(int var1) {
		this.areaSoundEffectsVolume = var1;
		class146.savePreferences();
	}

	int getAreaSoundEffectsVolume() {
		return this.areaSoundEffectsVolume;
	}

	void setUsernameToRemember(String var1) {
		this.rememberedUsername = var1;
		class146.savePreferences();
	}

	String getUsernameToRemember() {
		return this.rememberedUsername;
	}

	void method536(int var1) {
		this.field1039 = var1;
		class146.savePreferences();
	}

	int method537() {
		return this.field1039;
	}

	void method547(int var1) {
		this.windowMode = var1;
		class146.savePreferences();
	}

	int method538() {
		return this.windowMode;
	}

	void method545(String var1, int var2) {
		int var3 = this.method541(var1);
		if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
			Iterator var4 = this.parameters.entrySet().iterator();
			var4.next();
			var4.remove();
		}

		this.parameters.put(var3, var2);
		class146.savePreferences();
	}

	boolean method539(String var1) {
		int var2 = this.method541(var1);
		return this.parameters.containsKey(var2);
	}

	int method540(String var1) {
		int var2 = this.method541(var1);
		return !this.parameters.containsKey(var2) ? 0 : (Integer) this.parameters.get(var2);
	}

	int method541(String var1) {
		String var3 = var1.toLowerCase();
		int var4 = var3.length();
		int var5 = 0;

		for (int var6 = 0; var6 < var4; ++var6) {
			var5 = (var5 << 5) - var5 + var3.charAt(var6);
		}

		return var5;
	}

	static String method552(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class366.field3546[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class366.field3546[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class366.field3546[(var6 & 15) << 2 | var7 >>> 6])
							.append(class366.field3546[var7 & 63]);
				} else {
					var3.append(class366.field3546[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class366.field3546[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}
}
