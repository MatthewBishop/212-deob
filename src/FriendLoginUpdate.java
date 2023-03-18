public class FriendLoginUpdate extends Link {

	public int field3667 = (int) (WorldMapSection2.clockNow() / 1000L);

	public Username friendUsername;

	public short worldId;

	FriendLoginUpdate(Username var1, int var2) {
		this.friendUsername = var1;
		this.worldId = (short) var2;
	}
}
