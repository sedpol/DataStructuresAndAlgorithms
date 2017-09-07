package tr.com.sedatpolat.algorithms.clockangle;

import java.security.InvalidParameterException;

/**
 * 
 * @author sedpol
 *
 */
public class ClockAngle {

	private ClockAngle() {
	}
	
	public static int calculateMinuteAngle(int minute) {
		if (minute >= 60 || minute < 0) 
			throw new InvalidParameterException();
		
		return 6 * minute; // 360 / 60 * i
	}

	public static double calculateHourAngle(int hour, int minute) {
		if (hour > 12 || hour <= 0) 
			throw new InvalidParameterException();
		if (minute >= 60 || minute < 0) 
			throw new InvalidParameterException();

		return 30 * hour + 0.1 * minute; // 360 / 12 * hour + 360 / 60 / 60 * minute
	}

	public static double calculateAngle(int hour, int minute) {
		return Math.abs(calculateHourAngle(hour, minute) - calculateMinuteAngle(minute));
	}
}
