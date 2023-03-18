public class ArchiveDiskActionHandler implements Runnable {

	static NodeDeque ArchiveDiskActionHandler_requestQueue = new NodeDeque();

	static NodeDeque ArchiveDiskActionHandler_responseQueue = new NodeDeque();

	static int field3409 = 0;

	static Object ArchiveDiskActionHandler_lock = new Object();

	static LoginScreenAnimation field3410;

	static int field3408;

	public void run() {
		try {
			while (true) {
				NodeDeque var2 = ArchiveDiskActionHandler_requestQueue;
				ArchiveDiskAction var1;
				synchronized (ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction) ArchiveDiskActionHandler_requestQueue.last();
				}

				Object var14;
				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.write((int) var1.key, var1.data, var1.data.length);
						var2 = ArchiveDiskActionHandler_requestQueue;
						synchronized (ArchiveDiskActionHandler_requestQueue) {
							var1.remove();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.read((int) var1.key);
						var2 = ArchiveDiskActionHandler_requestQueue;
						synchronized (ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.addFirst(var1);
						}
					}

					var14 = ArchiveDiskActionHandler_lock;
					synchronized (ArchiveDiskActionHandler_lock) {
						if (field3409 <= 1) {
							field3409 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3409 = 600;
					}
				} else {
					Login.method429(100L);
					var14 = ArchiveDiskActionHandler_lock;
					synchronized (ArchiveDiskActionHandler_lock) {
						if (field3409 <= 1) {
							field3409 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3409;
					}
				}
			}
		} catch (Exception var13) {
			class364.RunException_sendStackTrace((String) null, var13);
		}
	}
}
