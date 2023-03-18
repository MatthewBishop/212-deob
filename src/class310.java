import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class class310 {

	class375 field2812 = new class375();

	class375 field2801 = new class375();

	boolean field2798 = false;

	boolean field2803 = true;

	int field2804 = 0;

	boolean field2805 = false;

	int field2806 = 0;

	int field2807 = 0;

	int field2808 = 0;

	int field2809 = 0;

	int field2800 = 0;

	int field2810 = 0;

	int field2799 = 0;

	int field2811 = Integer.MAX_VALUE;

	int field2817 = Integer.MAX_VALUE;

	int field2813 = 0;

	int field2802 = 0;

	int field2815 = 0;

	int field2816 = 0;

	class304 field2814;

	class304 field2818;

	class310() {
		this.field2812.method1988(1);
		this.field2801.method1988(1);
	}

	void method1654() {
		this.field2804 = (this.field2804 + 1) % 60;
		if (this.field2799 > 0) {
			--this.field2799;
		}

	}

	public boolean method1706(boolean var1) {
		var1 = var1 && this.field2803;
		boolean var2 = this.field2798 != var1;
		this.field2798 = var1;
		if (!this.field2798) {
			this.method1672(this.field2809, this.field2809);
		}

		return var2;
	}

	public void method1670(boolean var1) {
		this.field2803 = var1;
		this.field2798 = var1 && this.field2798;
	}

	boolean method1723(String var1) {
		String var2 = this.field2812.method1951();
		if (!var2.equals(var1)) {
			var1 = this.method1673(var1);
			this.field2812.method1960(var1);
			this.method1662(this.field2815, this.field2816);
			this.method1704();
			this.method1708();
			return true;
		} else {
			return false;
		}
	}

	boolean method1657(String var1) {
		this.field2801.method1960(var1);
		return true;
	}

	boolean method1727(AbstractFont var1) {
		boolean var2 = !this.field2805;
		this.field2812.method1955(var1);
		this.field2801.method1955(var1);
		this.field2805 = true;
		var2 |= this.method1662(this.field2815, this.field2816);
		var2 |= this.method1672(this.field2800, this.field2809);
		if (this.method1704()) {
			this.method1708();
			var2 = true;
		}

		return var2;
	}

	public boolean method1658(int var1, int var2) {
		boolean var3 = this.field2813 != var1 || var2 != this.field2802;
		this.field2813 = var1;
		this.field2802 = var2;
		var3 |= this.method1662(this.field2815, this.field2816);
		return var3;
	}

	public boolean method1653(int var1) {
		if (var1 < 0) {
			var1 = Integer.MAX_VALUE;
		}

		boolean var2 = var1 == this.field2812.method1970();
		this.field2812.method1952(var1);
		this.field2801.method1952(var1);
		if (this.method1704()) {
			this.method1708();
			var2 = true;
		}

		return var2;
	}

	public boolean method1660(int var1) {
		this.field2812.method1953(var1);
		if (this.method1704()) {
			this.method1708();
			return true;
		} else {
			return false;
		}
	}

	public boolean method1661(int var1) {
		this.field2817 = var1;
		if (this.method1704()) {
			this.method1708();
			return true;
		} else {
			return false;
		}
	}

	public boolean method1662(int var1, int var2) {
		if (!this.method1694()) {
			this.field2815 = var1;
			this.field2816 = var2;
			return false;
		} else {
			int var3 = this.field2815;
			int var4 = this.field2816;
			int var5 = Math.max(0, this.field2812.method1965() - this.field2813 + 2);
			int var6 = Math.max(0, this.field2812.method1966() - this.field2802 + 1);
			this.field2815 = Math.max(0, Math.min(var5, var1));
			this.field2816 = Math.max(0, Math.min(var6, var2));
			return var3 != this.field2815 || var4 != this.field2816;
		}
	}

	public boolean method1716(int var1, int var2) {
		boolean var3 = true;
		if (var1 < 0 || var1 > 2) {
			System.out.println("InputField.setAlignment: Invalid horizontal alignment. Given value: '" + var1 + "'.");
			var3 = false;
		}

		if (var2 < 0 || var2 > 2) {
			System.out.println("InputField.setAlignment: Invalid vertical alignment. Given value: '" + var2 + "'.");
			var3 = false;
		}

		return var3 ? this.field2812.method1956(var1, var2) : false;
	}

	public void method1663(int var1) {
		this.field2812.method1957(var1);
	}

	public void method1686(int var1) {
		this.field2806 = var1;
	}

	public void method1711(int var1) {
		this.field2812.method1988(var1);
	}

	public void method1664(int var1) {
		this.field2812.method1954(var1);
	}

	public boolean method1714(int var1) {
		this.field2808 = var1;
		String var2 = this.field2812.method1951();
		int var3 = var2.length();
		var2 = this.method1673(var2);
		if (var2.length() != var3) {
			this.field2812.method1960(var2);
			this.method1662(this.field2815, this.field2816);
			this.method1704();
			this.method1708();
			return true;
		} else {
			return false;
		}
	}

	public void method1665() {
		this.field2805 = false;
	}

	public boolean method1666(int var1) {
		if (this.method1655(var1)) {
			this.method1732();
			class376 var2 = this.field2812.method1983((char) var1, this.field2809, this.field2811);
			this.method1672(var2.method1989(), var2.method1989());
			this.method1704();
			this.method1708();
		}

		return true;
	}

	public void method1667() {
		if (!this.method1732() && this.field2809 > 0) {
			int var1 = this.field2812.method1962(this.field2809 - 1);
			this.method1708();
			this.method1672(var1, var1);
		}

	}

	public void method1668() {
		if (!this.method1732() && this.field2809 < this.field2812.method1950()) {
			int var1 = this.field2812.method1962(this.field2809);
			this.method1708();
			this.method1672(var1, var1);
		}

	}

	public void method1669() {
		if (!this.method1732() && this.field2809 > 0) {
			class451 var1 = this.method1702(this.field2809 - 1);
			int var2 = this.field2812.method1976((Integer) var1.field3892, this.field2809);
			this.method1708();
			this.method1672(var2, var2);
		}

	}

	public void method1691() {
		if (!this.method1732() && this.field2809 < this.field2812.method1950()) {
			class451 var1 = this.method1702(this.field2809);
			int var2 = this.field2812.method1976(this.field2809, (Integer) var1.field3893);
			this.method1708();
			this.method1672(var2, var2);
		}

	}

	boolean method1732() {
		if (!this.method1701()) {
			return false;
		} else {
			int var1 = this.field2812.method1976(this.field2800, this.field2809);
			this.method1708();
			this.method1672(var1, var1);
			return true;
		}
	}

	public void method1671() {
		this.method1672(0, this.field2812.method1950());
	}

	public boolean method1672(int var1, int var2) {
		if (!this.method1694()) {
			this.field2800 = var1;
			this.field2809 = var2;
			return false;
		} else {
			if (var1 > this.field2812.method1950()) {
				var1 = this.field2812.method1950();
			}

			if (var2 > this.field2812.method1950()) {
				var2 = this.field2812.method1950();
			}

			boolean var3 = this.field2800 != var1 || var2 != this.field2809;
			this.field2800 = var1;
			if (var2 != this.field2809) {
				this.field2809 = var2;
				this.field2804 = 0;
				this.method1726();
			}

			if (var3 && this.field2818 != null) {
				this.field2818.vmethod5708();
			}

			return var3;
		}
	}

	public void method1724(boolean var1) {
		class451 var2 = this.method1703(this.field2809);
		this.method1705((Integer) var2.field3892, var1);
	}

	public void method1730(boolean var1) {
		class451 var2 = this.method1703(this.field2809);
		this.method1705((Integer) var2.field3893, var1);
	}

	public void method1710(boolean var1) {
		this.method1705(0, var1);
	}

	public void method1674(boolean var1) {
		this.method1705(this.field2812.method1950(), var1);
	}

	public void method1675(boolean var1) {
		if (this.method1701() && !var1) {
			this.method1705(Math.min(this.field2800, this.field2809), var1);
		} else if (this.field2809 > 0) {
			this.method1705(this.field2809 - 1, var1);
		}

	}

	public void method1676(boolean var1) {
		if (this.method1701() && !var1) {
			this.method1705(Math.max(this.field2800, this.field2809), var1);
		} else if (this.field2809 < this.field2812.method1950()) {
			this.method1705(this.field2809 + 1, var1);
		}

	}

	public void method1677(boolean var1) {
		if (this.field2809 > 0) {
			class451 var2 = this.method1702(this.field2809 - 1);
			this.method1705((Integer) var2.field3892, var1);
		}

	}

	public void method1718(boolean var1) {
		if (this.field2809 < this.field2812.method1950()) {
			class451 var2 = this.method1702(this.field2809 + 1);
			this.method1705((Integer) var2.field3893, var1);
		}

	}

	public void method1659(boolean var1) {
		if (this.field2809 > 0) {
			this.method1705(this.field2812.method1964(this.field2809, -1), var1);
		}

	}

	public void method1720(boolean var1) {
		if (this.field2809 < this.field2812.method1950()) {
			this.method1705(this.field2812.method1964(this.field2809, 1), var1);
		}

	}

	public void method1697(boolean var1) {
		if (this.field2809 > 0) {
			int var2 = this.method1733();
			this.method1705(this.field2812.method1964(this.field2809, -var2), var1);
		}

	}

	public void method1713(boolean var1) {
		if (this.field2809 < this.field2812.method1950()) {
			int var2 = this.method1733();
			this.method1705(this.field2812.method1964(this.field2809, var2), var1);
		}

	}

	public void method1728(boolean var1) {
		class379 var2 = this.field2812.method1958(0, this.field2809);
		class451 var3 = var2.method2028();
		this.method1705(this.field2812.method1963((Integer) var3.field3892, this.field2816), var1);
	}

	public void method1679(boolean var1) {
		class379 var2 = this.field2812.method1958(0, this.field2809);
		class451 var3 = var2.method2028();
		this.method1705(this.field2812.method1963((Integer) var3.field3892, this.field2816 + this.field2802), var1);
	}

	public void method1680(int var1, int var2, boolean var3, boolean var4) {
		boolean var5 = false;
		class451 var6;
		int var8;
		if (!this.field2805) {
			var8 = 0;
		} else {
			var1 += this.field2815;
			var2 += this.field2816;
			var6 = this.method1709();
			var8 = this.field2812.method1963(var1 - (Integer) var6.field3892, var2 - (Integer) var6.field3893);
		}

		if (var3 && var4) {
			this.field2807 = 1;
			var6 = this.method1702(var8);
			class451 var7 = this.method1702(this.field2810);
			this.method1719(var7, var6);
		} else if (var3) {
			this.field2807 = 1;
			var6 = this.method1702(var8);
			this.method1672((Integer) var6.field3892, (Integer) var6.field3893);
			this.field2810 = (Integer) var6.field3892;
		} else if (var4) {
			this.method1672(this.field2810, var8);
		} else {
			if (this.field2799 > 0 && var8 == this.field2810) {
				if (this.field2809 == this.field2800) {
					this.field2807 = 1;
					var6 = this.method1702(var8);
					this.method1672((Integer) var6.field3892, (Integer) var6.field3893);
				} else {
					this.field2807 = 2;
					var6 = this.method1703(var8);
					this.method1672((Integer) var6.field3892, (Integer) var6.field3893);
				}
			} else {
				this.field2807 = 0;
				this.method1672(var8, var8);
				this.field2810 = var8;
			}

			this.field2799 = 25;
		}

	}

	public void method1681(int var1, int var2) {
		if (this.field2805 && this.method1721()) {
			var1 += this.field2815;
			var2 += this.field2816;
			class451 var3 = this.method1709();
			int var4 = this.field2812.method1963(var1 - (Integer) var3.field3892, var2 - (Integer) var3.field3893);
			class451 var5;
			class451 var6;
			switch (this.field2807) {
			case 0:
				this.method1672(this.field2800, var4);
				break;
			case 1:
				var5 = this.method1702(this.field2810);
				var6 = this.method1702(var4);
				this.method1719(var5, var6);
				break;
			case 2:
				var5 = this.method1703(this.field2810);
				var6 = this.method1703(var4);
				this.method1719(var5, var6);
			}
		}

	}

	public void method1682(Clipboard var1) {
		class379 var2 = this.field2812.method1958(this.field2800, this.field2809);
		if (!var2.method2023()) {
			String var3 = var2.method2021();
			if (!var3.isEmpty()) {
				var1.setContents(new StringSelection(var3), (ClipboardOwner) null);
			}
		}

	}

	public void method1731(Clipboard var1) {
		if (this.method1701()) {
			this.method1682(var1);
			this.method1732();
		}

	}

	public void method1684(Clipboard var1) {
		Transferable var2 = var1.getContents((Object) null);
		if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String var3 = this.method1673((String) var2.getTransferData(DataFlavor.stringFlavor));
				this.method1732();
				class376 var4 = this.field2812.method1971(var3, this.field2809, this.field2811);
				this.method1672(var4.method1989(), var4.method1989());
				this.method1704();
				this.method1708();
			} catch (Exception var5) {
				System.out.println("Error pasting clipboard to InputField.");
			}
		}

	}

	public void method1685() {
		this.field2816 = Math.max(0, this.field2816 - this.field2812.method1967());
	}

	public void method1683() {
		int var1 = Math.max(0, this.field2812.method1966() - this.field2802);
		this.field2816 = Math.min(var1, this.field2816 + this.field2812.method1967());
	}

	public void method1678(class304 var1) {
		this.field2814 = var1;
	}

	public void method1687(class304 var1) {
		this.field2818 = var1;
	}

	public class375 method1688() {
		return this.field2812;
	}

	public class375 method1689() {
		return this.field2801;
	}

	public class379 method1690() {
		return this.field2812.method1958(this.field2800, this.field2809);
	}

	public boolean method1721() {
		return this.field2798;
	}

	public boolean method1715() {
		return this.field2803;
	}

	public boolean method1692() {
		return this.method1721() && this.field2804 % 60 < 30;
	}

	public int method1693() {
		return this.field2809;
	}

	public int method1729() {
		return this.field2800;
	}

	public boolean method1694() {
		return this.field2805;
	}

	public int method1695() {
		return this.field2815;
	}

	public int method1722() {
		return this.field2816;
	}

	public int method1696() {
		return this.field2812.method1970();
	}

	public int method1656() {
		return this.field2812.method1981();
	}

	public int method1699() {
		return this.field2817;
	}

	public int method1698() {
		return this.field2806;
	}

	public int method1712() {
		return this.field2812.method1972();
	}

	public int method1700() {
		return this.field2808;
	}

	public int method1717() {
		return this.field2812.method1986();
	}

	public boolean method1707() {
		return this.method1656() > 1;
	}

	boolean method1701() {
		return this.field2800 != this.field2809;
	}

	String method1673(String var1) {
		StringBuilder var2 = new StringBuilder(var1.length());

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			char var4 = var1.charAt(var3);
			if (this.method1655(var4)) {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	void method1719(class451 var1, class451 var2) {
		if ((Integer) var2.field3892 < (Integer) var1.field3892) {
			this.method1672((Integer) var1.field3893, (Integer) var2.field3892);
		} else {
			this.method1672((Integer) var1.field3892, (Integer) var2.field3893);
		}

	}

	class451 method1702(int var1) {
		int var2 = this.field2812.method1950();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.method1725(this.field2812.method1987(var5 - 1).field3577)) {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.method1725(this.field2812.method1987(var5).field3577)) {
				var4 = var5;
				break;
			}
		}

		return new class451(var3, var4);
	}

	class451 method1703(int var1) {
		int var2 = this.field2812.method1950();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.field2812.method1987(var5 - 1).field3577 == '\n') {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.field2812.method1987(var5).field3577 == '\n') {
				var4 = var5;
				break;
			}
		}

		return new class451(var3, var4);
	}

	boolean method1704() {
		if (!this.method1694()) {
			return false;
		} else {
			boolean var1 = false;
			if (this.field2812.method1950() > this.field2817) {
				this.field2812.method1976(this.field2817, this.field2812.method1950());
				var1 = true;
			}

			int var2 = this.method1656();
			int var3;
			if (this.field2812.method1968() > var2) {
				var3 = this.field2812.method1964(0, var2) - 1;
				this.field2812.method1976(var3, this.field2812.method1950());
				var1 = true;
			}

			if (var1) {
				var3 = this.field2809;
				int var4 = this.field2800;
				int var5 = this.field2812.method1950();
				if (this.field2809 > var5) {
					var3 = var5;
				}

				if (this.field2800 > var5) {
					var4 = var5;
				}

				this.method1672(var4, var3);
			}

			return var1;
		}
	}

	void method1705(int var1, boolean var2) {
		if (var2) {
			this.method1672(this.field2800, var1);
		} else {
			this.method1672(var1, var1);
		}

	}

	int method1733() {
		return this.field2802 / this.field2812.method1967();
	}

	void method1726() {
		class379 var1 = this.field2812.method1958(0, this.field2809);
		class451 var2 = var1.method2028();
		int var3 = this.field2812.method1967();
		int var4 = (Integer) var2.field3892 - 10;
		int var5 = var4 + 20;
		int var6 = (Integer) var2.field3893 - 3;
		int var7 = var6 + var3 + 6;
		int var8 = this.field2815;
		int var9 = var8 + this.field2813;
		int var10 = this.field2816;
		int var11 = var10 + this.field2802;
		int var12 = this.field2815;
		int var13 = this.field2816;
		if (var4 < var8) {
			var12 = var4;
		} else if (var5 > var9) {
			var12 = var5 - this.field2813;
		}

		if (var6 < var10) {
			var13 = var6;
		} else if (var7 > var11) {
			var13 = var7 - this.field2802;
		}

		this.method1662(var12, var13);
	}

	boolean method1725(int var1) {
		return var1 == 32 || var1 == 10 || var1 == 9;
	}

	void method1708() {
		if (this.field2814 != null) {
			this.field2814.vmethod5708();
		}

	}

	boolean method1655(int var1) {
		switch (this.field2808) {
		case 1:
			return PlayerComposition.isAlphaNumeric((char) var1);
		case 2:
			return ArchiveDiskAction.isCharAlphabetic((char) var1);
		case 3:
			return class28.isDigit((char) var1);
		case 4:
			char var2 = (char) var1;
			if (class28.isDigit(var2)) {
				return true;
			} else {
				if (var2 != 'k' && var2 != 'K' && var2 != 'm' && var2 != 'M' && var2 != 'b' && var2 != 'B') {
					return false;
				}

				return true;
			}
		default:
			return true;
		}
	}

	class451 method1709() {
		int var1 = this.field2812.method1982(this.field2813);
		int var2 = this.field2812.method1977(this.field2802);
		return new class451(var1, var2);
	}
}
