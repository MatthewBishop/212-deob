import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecureRandomFuture {

	public static AbstractArchive HitSplatDefinition_fontsArchive;

	ExecutorService executor = Executors.newSingleThreadExecutor();

	Future future;

	SecureRandomFuture() {
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	boolean isDone() {
		return this.future.isDone();
	}

	SecureRandom get() {
		try {
			return (SecureRandom) this.future.get();
		} catch (Exception var2) {
			return class392.method2063();
		}
	}

	static GameBuild[] method438() {
		return new GameBuild[] { GameBuild.WIP, GameBuild.BUILDLIVE, GameBuild.LIVE, GameBuild.RC };
	}

	public static StudioGame[] method439() {
		return new StudioGame[] { StudioGame.game5, StudioGame.oldscape, StudioGame.game3, StudioGame.runescape,
				StudioGame.game4, StudioGame.stellardawn };
	}
}
