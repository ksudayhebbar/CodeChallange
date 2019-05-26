package ConditionalsPractice;

import java.util.Date;

import condition.practice.positions.NorthAmericaPositions;
import condition.practice.positions.PositionsFactory;
import condition.practice.positions.SouthAmericaPositions;
import condition.practice.rates.Rates.RateBuilder;

public class App {

	public static double regularRate = 11.11;
	public static double summerRate = 22.22;
	public static double winterRate = 7.77;
	// North America Season Settings
	public static Date naSummerStart = new Date(2019, 5, 31);
	public static Date naSummerEnd = new Date(2019, 9, 1);
	public static Date naWinterStart = new Date(2019, 12, 1);
	public static Date naWinterEnd = new Date(2020, 2, 28);
	// South America Season Settings
	public static Date saSummerStart = new Date(2019, 12, 1);
	public static Date saSummerEnd = new Date(2020, 2, 28);
	public static Date saWinterStart = new Date(2019, 5, 31);
	public static Date saWinterEnd = new Date(2019, 9, 1);

	public static void main(String[] args) {

		double yourRate = 11.11;

		// Run the scenarios
		double naSummerScenario = calculateRate("North America", new Date(2019, 7, 04));
		double naWinterScenario = calculateRate("North America", new Date(2019, 12, 04));
		double regularScenario = calculateRate("North America", new Date(2019, 5, 04));

		double saSummerScenario = calculateRate("South America", new Date(2020, 1, 07));
		double saWinterScenario = calculateRate("South America", new Date(2019, 8, 17));

		System.out.println("--North America--");
		System.out.println("Summer scenario rate is: " + naSummerScenario);
		System.out.println("Winter scenario rate is: " + naWinterScenario);
		System.out.println("Regular scenario rate is: " + regularScenario);
		System.out.println("--South America--");
		System.out.println("Summer scenario rate is: " + saSummerScenario);
		System.out.println("Winter scenario rate is: " + saWinterScenario);
		System.out.println();

		System.out.println("***********************new code ********************************");

		NorthAmericaPositions northAmericaPositions = new NorthAmericaPositions(new Date(2019, 5, 31),
				new Date(2019, 9, 1), new Date(2019, 12, 1), new Date(2020, 2, 28), new RateBuilder().build());

		naSummerScenario = PositionsFactory.getInstance().getPositions(NorthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2019, 7, 04));

		naWinterScenario = PositionsFactory.getInstance().getPositions(NorthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2019, 12, 04));

		regularScenario = PositionsFactory.getInstance().getPositions(NorthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2019, 5, 04));

		System.out.println("--North America--");
		System.out.println("Summer scenario rate is: " + naSummerScenario);
		System.out.println("Winter scenario rate is: " + naWinterScenario);
		System.out.println("Regular scenario rate is: " + regularScenario);

		SouthAmericaPositions southAmericaPositions = new SouthAmericaPositions(new Date(2019, 12, 1),
				new Date(2020, 2, 28), new Date(2019, 5, 31), new Date(2019, 9, 1), new RateBuilder().build());

		saSummerScenario = PositionsFactory.getInstance().getPositions(SouthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2020, 1, 07));

		saWinterScenario = PositionsFactory.getInstance().getPositions(SouthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2019, 8, 17));

		System.out.println("Summer scenario rate is: " + saSummerScenario);
		System.out.println("Winter scenario rate is: " + saWinterScenario);
		System.out.println();

		southAmericaPositions = new SouthAmericaPositions(new Date(2019, 12, 1), new Date(2020, 2, 28),
				new Date(2019, 5, 31), new Date(2019, 9, 1), new RateBuilder().summerRate(33.67).build());

		saSummerScenario = PositionsFactory.getInstance().getPositions(SouthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2020, 1, 07));

		southAmericaPositions = new SouthAmericaPositions(new Date(2019, 12, 1), new Date(2020, 2, 28),
				new Date(2019, 5, 31), new Date(2019, 9, 1),
				new RateBuilder().winterRate(34.99).summerRate(33.67).build());

		saWinterScenario = PositionsFactory.getInstance().getPositions(SouthAmericaPositions.class.getSimpleName())
				.calculateRate(new Date(2019, 8, 17));

		System.out.println("Summer scenario rate is: " + saSummerScenario);
		System.out.println("Winter scenario rate is: " + saWinterScenario);
		System.out.println();

	}

	private static double calculateRate(String position, Date day) {
		double currentRate = 0.0;

		if (position == "North America") {

			if (day.compareTo(naSummerStart) > 0 && day.compareTo(naSummerEnd) < 0) {
				System.out.println("It's summer");
				currentRate = summerRate;
			} else if (day.compareTo(naWinterStart) > 0 && day.compareTo(naWinterEnd) < 0) {
				System.out.println("It's Winter");
				currentRate = winterRate;
			} else {
				return regularRate;
			}

		} else if (position == "South America") {

			if (day.compareTo(saSummerStart) > 0 && day.compareTo(saSummerEnd) < 0) {
				System.out.println("It's summer");
				currentRate = summerRate;
			} else if (day.compareTo(saWinterStart) > 0 && day.compareTo(saWinterEnd) < 0) {
				System.out.println("It's Winter");
				currentRate = winterRate;
			} else {
				return regularRate;
			}

		} else {
			System.exit(0);
		}

		return currentRate;
	}
}
