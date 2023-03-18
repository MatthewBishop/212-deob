import java.util.HashSet;
import java.util.Set;

public enum ModeWhere implements class352 {

	field3514("", 0, new class351[] { class351.field3493 }),
	field3510("", 1, new class351[] { class351.field3492, class351.field3493 }),

	field3509("", 2, new class351[] { class351.field3492, class351.field3494, class351.field3493 }),

	field3521("", 3, new class351[] { class351.field3492 }), field3513("", 4),
	field3511("", 5, new class351[] { class351.field3492, class351.field3493 }),

	field3515("", 6, new class351[] { class351.field3493 }),
	field3520("", 8, new class351[] { class351.field3492, class351.field3493 }),

	field3517("", 9, new class351[] { class351.field3492, class351.field3494 }),

	field3518("", 10, new class351[] { class351.field3492 }), field3519("", 11, new class351[] { class351.field3492 }),
	field3522("", 12, new class351[] { class351.field3492, class351.field3493 }),

	field3516("", 13, new class351[] { class351.field3492 });

	final int id;

	final Set field3523 = new HashSet();

	ModeWhere(String var3, int var4, class351[] var5) {
		this.id = var4;
		class351[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class351 var8 = var6[var7];
			this.field3523.add(var8);
		}

	}

	ModeWhere(String var3, int var4) {
		this.id = var4;
	}

	public int rsOrdinal() {
		return this.id;
	}

	public static int method1900() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}

	static void method1899() {
		if (Login.clearLoginScreen) {
			WorldMapSprite.titleboxSprite = null;
			Login.titlebuttonSprite = null;
			Login.runesSprite = null;
			Login.leftTitleSprite = null;
			class419.rightTitleSprite = null;
			Login.logoSprite = null;
			class139.title_muteSprite = null;
			Login.options_buttons_0Sprite = null;
			Login.options_buttons_2Sprite = null;
			WorldMapSection2.worldSelectBackSprites = null;
			class279.worldSelectFlagSprites = null;
			class353.worldSelectArrows = null;
			class293.worldSelectStars = null;
			FriendSystem.field664 = null;
			ArchiveDiskActionHandler.field3410.method520();
			class293.musicPlayerStatus = 1;
			class364.musicTrackArchive = null;
			IntHashTable.musicTrackGroupId = -1;
			class293.musicTrackFileId = -1;
			class368.musicTrackVolume = 0;
			class293.musicTrackBoolean = false;
			AbstractRasterProvider.pcmSampleLength = 2;
			class166.method865(true);
			Login.clearLoginScreen = false;
		}
	}
}
