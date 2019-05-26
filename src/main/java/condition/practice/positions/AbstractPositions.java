package condition.practice.positions;

import java.util.Date;
import java.util.logging.Logger;

import condition.practice.rates.Rates;

public abstract class AbstractPositions implements Positions {
	public Date summerStart;
	public Date summerEnd;
	public Date winterStart;
	public Date winterEnd;
	private Rates rate;

	private Logger logger = Logger.getLogger(AbstractPositions.class.getSimpleName());

	public AbstractPositions(Date summerStart, Date summerEnd, Date winterStart, Date winterEnd, Rates rate) {
		super();
		this.summerStart = summerStart;
		this.summerEnd = summerEnd;
		this.winterStart = winterStart;
		this.winterEnd = winterEnd;
		this.rate = rate;
		PositionsFactory.getInstance().registerPositions(this.getClass().getSimpleName(), this);
		logger.info("Register Positions : " + this.getClass().getSimpleName() + " with values :" + this.toString());

	}

	@Override
	public double calculateRate(Date day) {
		double currentRate = 0.0;
		if (day.compareTo(summerStart) > 0 && day.compareTo(summerEnd) < 0) {
			currentRate = rate.getSummerRate();
			logger.info("It's summer : " + currentRate);

		} else if (day.compareTo(winterStart) > 0 && day.compareTo(winterEnd) < 0) {
			currentRate = rate.getWinterRate();
			logger.info("It's Winter : " + currentRate);
		} else {
			currentRate = rate.getRegularRate();
			logger.info("It's Regular : " + currentRate);
		}
		return currentRate;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((summerEnd == null) ? 0 : summerEnd.hashCode());
		result = prime * result + ((summerStart == null) ? 0 : summerStart.hashCode());
		result = prime * result + ((winterEnd == null) ? 0 : winterEnd.hashCode());
		result = prime * result + ((winterStart == null) ? 0 : winterStart.hashCode());
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
		AbstractPositions other = (AbstractPositions) obj;
		if (summerEnd == null) {
			if (other.summerEnd != null)
				return false;
		} else if (!summerEnd.equals(other.summerEnd))
			return false;
		if (summerStart == null) {
			if (other.summerStart != null)
				return false;
		} else if (!summerStart.equals(other.summerStart))
			return false;
		if (winterEnd == null) {
			if (other.winterEnd != null)
				return false;
		} else if (!winterEnd.equals(other.winterEnd))
			return false;
		if (winterStart == null) {
			if (other.winterStart != null)
				return false;
		} else if (!winterStart.equals(other.winterStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractPositions [summerStart=" + summerStart + ", summerEnd=" + summerEnd + ", winterStart="
				+ winterStart + ", winterEnd=" + winterEnd + ", rate=" + rate + "]";
	}
}
