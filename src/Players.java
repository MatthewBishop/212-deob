public class Players {

	static byte[] activityFlags = new byte[2048];

	static MoveSpeed[] playerMovementSpeeds = new MoveSpeed[2048];

	static Buffer[] cachedAppearanceBuffer = new Buffer[2048];

	static int Players_count = 0;

	static int[] Players_indices = new int[2048];

	static int Players_emptyIdxCount = 0;

	static int[] Players_emptyIndices = new int[2048];

	static int[] Players_regions = new int[2048];

	static int[] Players_orientations = new int[2048];

	static int[] Players_targetIndices = new int[2048];

	static int Players_pendingUpdateCount = 0;

	static int[] Players_pendingUpdateIndices = new int[2048];

	static Buffer field1079 = new Buffer(new byte[5000]);

	static void method603(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field587 += var2.groupCount;
	}
}
