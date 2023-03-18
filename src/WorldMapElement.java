public class WorldMapElement extends DualNode {

	static AbstractArchive WorldMapElement_archive;

	static WorldMapElement[] WorldMapElement_cached;

	public static int WorldMapElement_count;

	public static EvictingDualNodeHashTable WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);

	public final int objectId;

	public int sprite1 = -1;

	int sprite2 = -1;

	public String name;

	public int field1468;

	public int textSize = 0;

	public boolean field1478 = true;

	public boolean field1487 = false;

	public String[] menuActions = new String[5];

	public String menuTargetName;

	int[] field1475;

	int field1483 = Integer.MAX_VALUE;

	int field1484 = Integer.MAX_VALUE;

	int field1485 = Integer.MIN_VALUE;

	int field1486 = Integer.MIN_VALUE;

	public HorizontalAlignment horizontalAlignment;

	public VerticalAlignment verticalAlignment;

	int[] field1488;

	byte[] field1489;

	public int category;

	WorldMapElement(int var1) {
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method2423();
		} else if (var2 == 2) {
			this.sprite2 = var1.method2423();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field1468 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
					this.field1478 = false;
				}

				if ((var3 & 2) == 2) {
					this.field1487 = true;
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field1475 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field1475[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field1488 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field1488.length; ++var5) {
					this.field1488[var5] = var1.readInt();
				}

				this.field1489 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field1489[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method2423();
				} else if (var2 == 19) {
					this.category = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method2423();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment) SpriteMask
							.findEnumerated(GrandExchangeOfferOwnWorldComparator.method345(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment) SpriteMask
							.findEnumerated(WorldMapLabelSize.method1317(), var1.readUnsignedByte());
				}
			}
		}

	}

	void method931() {
		if (this.field1475 != null) {
			for (int var1 = 0; var1 < this.field1475.length; var1 += 2) {
				if (this.field1475[var1] < this.field1483) {
					this.field1483 = this.field1475[var1];
				} else if (this.field1475[var1] > this.field1485) {
					this.field1485 = this.field1475[var1];
				}

				if (this.field1475[var1 + 1] < this.field1484) {
					this.field1484 = this.field1475[var1 + 1];
				} else if (this.field1475[var1 + 1] > this.field1486) {
					this.field1486 = this.field1475[var1 + 1];
				}
			}
		}

	}

	public SpritePixels getSpriteBool(boolean var1) {
		int var2 = this.sprite1 * -1011021077 * -2111287869;
		return this.getSprite(var2);
	}

	SpritePixels getSprite(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			SpritePixels var2 = (SpritePixels) WorldMapElement_cachedSprites.get((long) var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = WorldMapScaleHandler.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long) var1);
				}

				return var2;
			}
		}
	}

	public int getObjectId() {
		return this.objectId;
	}
}
