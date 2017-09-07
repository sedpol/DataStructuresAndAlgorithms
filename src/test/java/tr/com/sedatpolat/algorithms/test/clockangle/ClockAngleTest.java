package tr.com.sedatpolat.algorithms.test.clockangle;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import tr.com.sedatpolat.algorithms.clockangle.ClockAngle;

import java.security.InvalidParameterException;

import org.junit.Rule;

import static org.junit.Assert.*;

/**
 * 
 * @author sedpol
 *
 */
public class ClockAngleTest {
	
	private static final double DELTA = 0.01d;

	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	
	@Test
	public void checkMinuteAngle() {

		assertEquals(0, ClockAngle.calculateMinuteAngle(0));
		assertEquals(90, ClockAngle.calculateMinuteAngle(15));
		assertEquals(180, ClockAngle.calculateMinuteAngle(30));
		assertEquals(270, ClockAngle.calculateMinuteAngle(45));
		
		assertEquals(72, ClockAngle.calculateMinuteAngle(12));
	}
	
	@Test(expected = InvalidParameterException.class)
	public void checkMinuteAngleExceptionalCase() {
		ClockAngle.calculateMinuteAngle(60);
		ClockAngle.calculateMinuteAngle(65);
		ClockAngle.calculateMinuteAngle(-6);
	}
	
	@Test
	public void checkHourAngle() {
		assertEquals(360.0, ClockAngle.calculateHourAngle(12, 00), DELTA);
		assertEquals(183.0, ClockAngle.calculateHourAngle(6, 30), DELTA);
		assertEquals(30.0, ClockAngle.calculateHourAngle(1, 00), DELTA);
		assertEquals(30.5, ClockAngle.calculateHourAngle(1, 05), DELTA);
	}

	@Test(expected = InvalidParameterException.class)
	public void checkHourAngleExceptionalCase() {
		ClockAngle.calculateHourAngle(13, 00);
		ClockAngle.calculateHourAngle(10, 60);
		ClockAngle.calculateHourAngle(15, 70);
		ClockAngle.calculateHourAngle(-1, 45);
		ClockAngle.calculateHourAngle(12, -45);
	}
	
	@Test
	public void checkAngleCalculation() {
		assertEquals(360.0, ClockAngle.calculateAngle(12, 00), DELTA);
		assertEquals(183.0, ClockAngle.calculateAngle(12, 30), DELTA);
		assertEquals(35.0, ClockAngle.calculateAngle(11, 50), DELTA);
		assertEquals(11.89, ClockAngle.calculateAngle(12, 59), DELTA);
		assertEquals(22.19, ClockAngle.calculateAngle(9, 42), DELTA);
		assertEquals(181.9, ClockAngle.calculateAngle(2, 41), DELTA);
		assertEquals(3.4, ClockAngle.calculateAngle(5, 26), DELTA);
	}
}
