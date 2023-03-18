public class class127 {

	static Archive archive17;

	boolean field1210;

	boolean field1200;

	class125 field1201;

	class125 field1214;

	class122[] field1203;

	boolean field1221;

	float field1207;

	float field1206;

	float field1223;

	float field1208;

	float field1209;

	float field1202;

	float field1211;

	float field1212;

	float field1213;

	float field1222;

	boolean field1215 = true;

	int field1205 = 0;

	float[] field1217;

	int field1218;

	int field1219;

	float field1220;

	float field1216;

	int method698(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort();
		class152.method814(var1.readUnsignedByte());
		this.field1201 = ApproximateRouteStrategy.method341(var1.readUnsignedByte());
		this.field1214 = ApproximateRouteStrategy.method341(var1.readUnsignedByte());
		this.field1210 = var1.readUnsignedByte() != 0;
		this.field1203 = new class122[var3];
		class122 var4 = null;

		for (int var5 = 0; var5 < var3; ++var5) {
			class122 var6 = new class122();
			var6.method673(var1, var2);
			this.field1203[var5] = var6;
			if (var4 != null) {
				var4.field1163 = var6;
			}

			var4 = var6;
		}

		return var3;
	}

	void method705() {
		this.field1218 = this.field1203[0].field1165;
		this.field1219 = this.field1203[this.method703() - 1].field1165;
		this.field1217 = new float[this.method701() + 1];

		for (int var1 = this.method704(); var1 <= this.method700(); ++var1) {
			this.field1217[var1 - this.method704()] = AttackOption.method590(this, (float) var1);
		}

		this.field1203 = null;
		this.field1220 = AttackOption.method590(this, (float) (this.method704() - 1));
		this.field1216 = AttackOption.method590(this, (float) (this.method700() + 1));
	}

	public float method699(int var1) {
		if (var1 < this.method704()) {
			return this.field1220;
		} else {
			return var1 > this.method700() ? this.field1216 : this.field1217[var1 - this.method704()];
		}
	}

	int method704() {
		return this.field1218;
	}

	int method700() {
		return this.field1219;
	}

	int method701() {
		return this.method700() - this.method704();
	}

	int method706(float var1) {
		if (this.field1205 < 0 || (float) this.field1203[this.field1205].field1165 > var1
				|| this.field1203[this.field1205].field1163 != null
						&& (float) this.field1203[this.field1205].field1163.field1165 <= var1) {
			if (var1 >= (float) this.method704() && var1 <= (float) this.method700()) {
				int var2 = this.method703();
				int var3 = this.field1205;
				if (var2 > 0) {
					int var4 = 0;
					int var5 = var2 - 1;

					do {
						int var6 = var4 + var5 >> 1;
						if (var1 < (float) this.field1203[var6].field1165) {
							if (var1 > (float) this.field1203[var6 - 1].field1165) {
								var3 = var6 - 1;
								break;
							}

							var5 = var6 - 1;
						} else {
							if (var1 <= (float) this.field1203[var6].field1165) {
								var3 = var6;
								break;
							}

							if (var1 < (float) this.field1203[var6 + 1].field1165) {
								var3 = var6;
								break;
							}

							var4 = var6 + 1;
						}
					} while (var4 <= var5);
				}

				if (var3 != this.field1205) {
					this.field1205 = var3;
					this.field1215 = true;
				}

				return this.field1205;
			} else {
				return -1;
			}
		} else {
			return this.field1205;
		}
	}

	class122 method702(float var1) {
		int var2 = this.method706(var1);
		return var2 >= 0 && var2 < this.field1203.length ? this.field1203[var2] : null;
	}

	int method703() {
		return this.field1203 == null ? 0 : this.field1203.length;
	}
}
