package condition.practice.rates;

public class Rates {

	private double regularRate;
	private double summerRate;
	private double winterRate;

	private Rates(double regularRate, double summerRate, double winterRate) {
		super();
		this.regularRate = regularRate;
		this.summerRate = summerRate;
		this.winterRate = winterRate;
	}

	public double getRegularRate() {
		return regularRate;
	}

	public double getSummerRate() {
		return summerRate;
	}

	public double getWinterRate() {
		return winterRate;
	}

	public static class RateBuilder implements IRates {
		protected double regularRate = defaultRegularRate();
		protected double summerRate = defaultSummerRate();
		protected double winterRate = defaultWinterRate();

		public RateBuilder regularRate(double regularRate) {
			this.regularRate = regularRate;
			return this;
		}

		public RateBuilder summerRate(double summerRate) {
			this.summerRate = summerRate;
			return this;
		}

		public RateBuilder winterRate(double winterRate) {
			this.winterRate = winterRate;
			return this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(regularRate);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(summerRate);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(winterRate);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RateBuilder other = (RateBuilder) obj;
			if (Double.doubleToLongBits(regularRate) != Double.doubleToLongBits(other.regularRate))
				return false;
			if (Double.doubleToLongBits(summerRate) != Double.doubleToLongBits(other.summerRate))
				return false;
			if (Double.doubleToLongBits(winterRate) != Double.doubleToLongBits(other.winterRate))
				return false;
			return true;
		}

		public Rates build() {
			Rates rates = new Rates(regularRate, summerRate, winterRate);
			return rates;

		}

	}

	@Override
	public String toString() {
		return "RateBuilder [regularRate=" + regularRate + ", summerRate=" + summerRate + ", winterRate=" + winterRate
				+ "]";
	}

}
