public class Username implements Comparable {

	String name;

	String cleanName;

	public Username(String var1, LoginType var2) {
		this.name = var1;
		this.cleanName = AbstractWorldMapIcon.method1486(var1, var2);
	}

	public Username(String var1) {
		this.name = var1;
		this.cleanName = AbstractWorldMapIcon.method1486(var1, LoginType.oldscape);
	}

	public String getName() {
		return this.name;
	}

	public String method2566() {
		return this.cleanName;
	}

	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	public int compareToTyped(Username var1) {
		if (this.cleanName == null) {
			return var1.cleanName == null ? 0 : 1;
		} else {
			return var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName);
		}
	}

	public boolean equals(Object var1) {
		if (var1 instanceof Username) {
			Username var2 = (Username) var1;
			if (this.cleanName == null) {
				return var2.cleanName == null;
			} else if (var2.cleanName == null) {
				return false;
			} else {
				return this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName);
			}
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.cleanName == null ? 0 : this.cleanName.hashCode();
	}

	public String toString() {
		return this.getName();
	}

	public int compareTo(Object var1) {
		return this.compareToTyped((Username) var1);
	}

	public static boolean method2565(int var0) {
		return var0 >= WorldMapDecorationType.field3014.id && var0 <= WorldMapDecorationType.field3022.id
				|| var0 == WorldMapDecorationType.field3006.id;
	}
}
