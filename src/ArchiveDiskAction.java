public class ArchiveDiskAction extends Node {

	int type;

	byte[] data;

	ArchiveDisk archiveDisk;

	Archive archive;

	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
