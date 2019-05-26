package condition.practice.positions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PositionsFactory {

	private static PositionsFactory positionsFactory = null;
	private Map<String, Positions> positions = new ConcurrentHashMap<String, Positions>();

	private PositionsFactory() {

	}

	public static PositionsFactory getInstance() {
		if (positionsFactory == null) {
			synchronized (PositionsFactory.class) {
				if (positionsFactory == null) {
					positionsFactory = new PositionsFactory();
				}

			}
		}

		return positionsFactory;

	}

	public Positions getPositions(String positions) {

		return this.positions.get(positions);

	}

	protected void registerPositions(String positionsKey, Positions positions) {
		this.positions.put(positionsKey, positions);
	}

}
