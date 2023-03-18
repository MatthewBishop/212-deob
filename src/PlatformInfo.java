public class PlatformInfo extends Node {

	int field3800;

	boolean field3801;

	int field3802;

	int field3796;

	int field3816;

	int field3805;

	int field3799;

	boolean field3806;

	int field3807;

	int field3810;

	int field3804;

	int field3808;

	String field3797;

	String field3809;

	String field3795;

	String field3811;

	int field3798;

	int field3813;

	int field3803;

	int field3814;

	String field3815;

	String field3812;

	int[] field3817 = new int[3];

	int field3818;

	String field3819;

	String field3820;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9,
			int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17,
			int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25,
			String var26) {
		this.field3800 = var1;
		this.field3801 = var2;
		this.field3802 = var3;
		this.field3796 = var4;
		this.field3816 = var5;
		this.field3805 = var6;
		this.field3799 = var7;
		this.field3806 = var8;
		this.field3807 = var9;
		this.field3810 = var10;
		this.field3804 = var11;
		this.field3808 = var12;
		this.field3797 = var13;
		this.field3809 = var14;
		this.field3795 = var15;
		this.field3811 = var16;
		this.field3798 = var17;
		this.field3813 = var18;
		this.field3803 = var19;
		this.field3814 = var20;
		this.field3815 = var21;
		this.field3812 = var22;
		this.field3817 = var23;
		this.field3818 = var24;
		this.field3819 = var25;
		this.field3820 = var26;
	}

	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field3800);
		var1.writeByte(this.field3801 ? 1 : 0);
		var1.writeShort(this.field3802);
		var1.writeByte(this.field3796);
		var1.writeByte(this.field3816);
		var1.writeByte(this.field3805);
		var1.writeByte(this.field3799);
		var1.writeByte(this.field3806 ? 1 : 0);
		var1.writeShort(this.field3807);
		var1.writeByte(this.field3810);
		var1.writeMedium(this.field3804);
		var1.writeShort(this.field3808);
		var1.writeStringCp1252NullCircumfixed(this.field3797);
		var1.writeStringCp1252NullCircumfixed(this.field3809);
		var1.writeStringCp1252NullCircumfixed(this.field3795);
		var1.writeStringCp1252NullCircumfixed(this.field3811);
		var1.writeByte(this.field3813);
		var1.writeShort(this.field3798);
		var1.writeStringCp1252NullCircumfixed(this.field3815);
		var1.writeStringCp1252NullCircumfixed(this.field3812);
		var1.writeByte(this.field3803);
		var1.writeByte(this.field3814);

		for (int var2 = 0; var2 < this.field3817.length; ++var2) {
			var1.writeInt(this.field3817[var2]);
		}

		var1.writeInt(this.field3818);
		var1.writeStringCp1252NullCircumfixed(this.field3819);
		var1.writeStringCp1252NullCircumfixed(this.field3820);
	}

	public int size() {
		byte var1 = 39;
		int var2 = var1 + class19.method79(this.field3797);
		var2 += class19.method79(this.field3809);
		var2 += class19.method79(this.field3795);
		var2 += class19.method79(this.field3811);
		var2 += class19.method79(this.field3815);
		var2 += class19.method79(this.field3812);
		var2 += class19.method79(this.field3819);
		var2 += class19.method79(this.field3820);
		return var2;
	}
}
