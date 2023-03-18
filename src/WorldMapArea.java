import java.util.Iterator;
import java.util.LinkedList;

public class WorldMapArea {

	int id = -1;

	String internalName;

	String externalName;

	int backGroundColor = -1;

	int zoom = -1;

	Coord origin = null;

	int regionLowX = Integer.MAX_VALUE;

	int regionHighX = 0;

	int regionLowY = Integer.MAX_VALUE;

	int regionHighY = 0;

	boolean isMain = false;

	LinkedList sections;

	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType var3 = (WorldMapSectionType) SpriteMask.findEnumerated(WorldMapSectionType.method1442(),
				var2);
		Object var4 = null;
		switch (var3.type) {
		case 0:
			var4 = new class248();
			break;
		case 1:
			var4 = new WorldMapSection1();
			break;
		case 2:
			var4 = new WorldMapSection0();
			break;
		case 3:
			var4 = new WorldMapSection2();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection) var4).read(var1);
		return (WorldMapSection) var4;
	}

	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection) var4.next();
		} while (!var5.containsCoord(var1, var2, var3));

		return true;
	}

	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection) var5.next();
				} while (!var6.containsPosition(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection) var4.next();
		} while (!var5.containsCoord(var1, var2, var3));

		return var5.getBorderTileLengths(var1, var2, var3);
	}

	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection) var3.next();
		} while (!var4.containsPosition(var1, var2));

		return var4.coord(var1, var2);
	}

	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection) var1.next();
			var2.expandBounds(this);
		}

	}

	public int getId() {
		return this.id;
	}

	public boolean getIsMain() {
		return this.isMain;
	}

	public String getInternalName() {
		return this.internalName;
	}

	public String getExternalName() {
		return this.externalName;
	}

	int getBackGroundColor() {
		return this.backGroundColor;
	}

	public int getZoom() {
		return this.zoom;
	}

	public int getRegionLowX() {
		return this.regionLowX;
	}

	public int getRegionHighX() {
		return this.regionHighX;
	}

	public int getRegionLowY() {
		return this.regionLowY;
	}

	public int getRegionHighY() {
		return this.regionHighY;
	}

	public int getOriginX() {
		return this.origin.x;
	}

	public int getOriginPlane() {
		return this.origin.plane;
	}

	public int getOriginY() {
		return this.origin.y;
	}

	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	static LoginPacket[] method1359() {
		return new LoginPacket[] { LoginPacket.field2647, LoginPacket.RECONNECT_LOGIN_CONNECTION, LoginPacket.field2646,
				LoginPacket.NEW_LOGIN_CONNECTION, LoginPacket.field2651, LoginPacket.field2652 };
	}

	static void method1357(SpritePixels var0, int var1, int var2, int var3) {
		WorldMapRegion.WorldMapRegion_cachedSprites.put(var0, class122.method672(var1, var2, var3),
				var0.pixels.length * 4);
	}

	static final void method1358(int var0, int var1, boolean var2) {
		if (Client.currentClanChannels[var0] != null) {
			if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method843()) {
				ClanChannelMember var3 = (ClanChannelMember) Client.currentClanChannels[var0].members.get(var1);
				PacketBufferNode var4 = UserComparator9.getPacketBufferNode(ClientPacket.field2509,
						Client.packetWriter.isaacCipher);
				var4.packetBuffer
						.writeByte(4 + WorldMapLabel.stringCp1252NullTerminatedByteSize(var3.username.getName()));
				var4.packetBuffer.writeByte(var0);
				var4.packetBuffer.writeShort(var1);
				var4.packetBuffer.writeBoolean(var2);
				var4.packetBuffer.writeStringCp1252NullTerminated(var3.username.getName());
				Client.packetWriter.addNode(var4);
			}
		}
	}
}