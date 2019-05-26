package condition.practice.rates;

public interface IRates {
	default double defaultRegularRate() {
		return 11.11;
	}

	default double defaultWinterRate() {
		return 22.22;
	}

	default double defaultSummerRate() {
		return 7.77;
	}

}
