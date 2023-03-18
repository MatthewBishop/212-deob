public final class Tile extends Node {

	int plane;

	int x;

	int y;

	int originalPlane;

	SceneTilePaint paint;

	SceneTileModel model;

	BoundaryObject boundaryObject;

	WallDecoration wallDecoration;

	FloorDecoration floorDecoration;

	ItemLayer itemLayer;

	int gameObjectsCount;

	GameObject[] gameObjects = new GameObject[5];

	int[] gameObjectEdgeMasks = new int[5];

	int gameObjectsEdgeMask = 0;

	int minPlane;

	boolean drawPrimary;

	boolean drawSecondary;

	boolean drawGameObjects;

	int drawGameObjectEdges;

	int field1940;

	int field1944;

	int field1950;

	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}
}
