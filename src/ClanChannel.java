import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ClanChannel extends Node {

	boolean field1387;

	boolean field1381 = true;

	public List members;

	int[] sortedMembers;

	long field1384;

	public String name = null;

	public byte field1385;

	public byte field1388;

	static {
		new BitSet(65536);
	}

	public ClanChannel(Buffer var1) {
		this.method844(var1);
	}

	public int[] getSortedMembers() {
		if (this.sortedMembers == null) {
			String[] var1 = new String[this.members.size()];
			this.sortedMembers = new int[this.members.size()];

			for (int var2 = 0; var2 < this.members.size(); this.sortedMembers[var2] = var2++) {
				var1[var2] = ((ClanChannelMember) this.members.get(var2)).username.method2566();
			}

			Canvas.method91(var1, this.sortedMembers);
		}

		return this.sortedMembers;
	}

	void addMember(ClanChannelMember var1) {
		this.members.add(var1);
		this.sortedMembers = null;
	}

	void removeMember(int var1) {
		this.members.remove(var1);
		this.sortedMembers = null;
	}

	public int method843() {
		return this.members.size();
	}

	public int method846(String var1) {
		if (!this.field1381) {
			throw new RuntimeException("Displaynames not available");
		} else {
			for (int var2 = 0; var2 < this.members.size(); ++var2) {
				if (((ClanChannelMember) this.members.get(var2)).username.getName().equalsIgnoreCase(var1)) {
					return var2;
				}
			}

			return -1;
		}
	}

	void method844(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if ((var2 & 1) != 0) {
			this.field1387 = true;
		}

		if ((var2 & 2) != 0) {
			this.field1381 = true;
		}

		int var3 = 2;
		if ((var2 & 4) != 0) {
			var3 = var1.readUnsignedByte();
		}

		super.key = var1.readLong();
		this.field1384 = var1.readLong();
		this.name = var1.readStringCp1252NullTerminated();
		var1.readBoolean();
		this.field1388 = var1.readByte();
		this.field1385 = var1.readByte();
		int var4 = var1.readUnsignedShort();
		if (var4 > 0) {
			this.members = new ArrayList(var4);

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanChannelMember var6 = new ClanChannelMember();
				if (this.field1387) {
					var1.readLong();
				}

				if (this.field1381) {
					var6.username = new Username(var1.readStringCp1252NullTerminated());
				}

				var6.rank = var1.readByte();
				var6.world = var1.readUnsignedShort();
				if (var3 >= 3) {
					var1.readBoolean();
				}

				this.members.add(var5, var6);
			}
		}

	}

	public static int method840(Buffer var0, String var1) {
		int var2 = var0.offset;
		byte[] var3 = WorldMapSection0.method1438(var1);
		var0.writeSmartByteShort(var3.length);
		var0.offset += class315.huffman.compress(var3, 0, var3.length, var0.array, var0.offset);
		return var0.offset - var2;
	}
}
