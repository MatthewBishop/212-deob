import java.util.zip.CRC32;

public class NetCache {

	public static AbstractSocket NetCache_socket;

	public static int NetCache_loadTime = 0;

	public static long field3445;

	public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);

	public static int NetCache_pendingPriorityWritesCount = 0;

	public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);

	public static int NetCache_pendingPriorityResponsesCount = 0;

	public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();

	public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);

	public static int NetCache_pendingWritesCount = 0;

	public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);

	public static int NetCache_pendingResponsesCount = 0;

	public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);

	public static Buffer NetCache_responseArchiveBuffer;

	public static int field3457 = 0;

	public static CRC32 NetCache_crc = new CRC32();

	public static Archive[] NetCache_archives = new Archive[256];

	static int field3459 = -1;

	static int field3460 = 255;

	public static byte field3454 = 0;

	public static int NetCache_crcMismatches = 0;

	public static int NetCache_ioExceptions = 0;

	static final int method1853() {
		float var0 = 200.0F * ((float) WorldMapSectionType.clientPreferences.getBrightness() - 0.5F);
		return 100 - Math.round(var0);
	}
}
