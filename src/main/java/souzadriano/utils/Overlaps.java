package souzadriano.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Determines whether two range of Number, BigDecimal, Date or Calendar overlaps
 * 
 * @author Adriano de Souza
 *
 */
public final class Overlaps {
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @return The two ranges overlap (Includes conditions where the edges overlap exactly)
	 */
	public static boolean overlaps(Number startA, Number finishA, Number startB, Number finishB) {
		return overlaps(startA, finishA, startB, finishB, true);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @param includes Includes conditions where the edges overlap exactly
	 * @return The two ranges overlap
	 */
	public static boolean overlaps(Number startA, Number finishA, Number startB, Number finishB, boolean includes) {
		if (includes) {
			return (startA.doubleValue() <= finishB.doubleValue()) && (finishA.doubleValue() >= startB.doubleValue());
		} 
		return (startA.doubleValue() < finishB.doubleValue()) && (finishA.doubleValue() > startB.doubleValue());
	}

	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @return The two ranges overlap (Includes conditions where the edges overlap exactly)
	 */
	public static boolean overlaps(Date startA, Date finishA, Date startB, Date finishB) {
		return overlaps(startA, finishA, startB, finishB, true);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @param includes Includes conditions where the edges overlap exactly
	 * @return The two ranges overlap
	 */
	public static boolean overlaps(Date startA, Date finishA, Date startB, Date finishB, boolean includes) {
		return overlaps(startA.getTime(), finishA.getTime(), startB.getTime(), finishB.getTime(), includes);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @return The two ranges overlap (Includes conditions where the edges overlap exactly)
	 */
	public static boolean overlapsWithoutHours(Date startA, Date finishA, Date startB, Date finishB) {
		return overlaps(zeroHours(startA), zeroHours(finishA), zeroHours(startB), zeroHours(finishB), true);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @param includes Includes conditions where the edges overlap exactly
	 * @return The two ranges overlap
	 */
	public static boolean overlapsWithoutHours(Date startA, Date finishA, Date startB, Date finishB, boolean includes) {
		return overlaps(zeroHours(startA).getTime(), zeroHours(finishA).getTime(), zeroHours(startB).getTime(), zeroHours(finishB).getTime(), includes);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @return The two ranges overlap (Includes conditions where the edges overlap exactly)
	 */
	public static boolean overlaps(BigDecimal startA, BigDecimal finishA, BigDecimal startB, BigDecimal finishB) {
		return overlaps(startA, finishA, startB, finishB, true);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @param includes Includes conditions where the edges overlap exactly
	 * @return The two ranges overlap
	 */
	public static boolean overlaps(BigDecimal startA, BigDecimal finishA, BigDecimal startB, BigDecimal finishB, boolean includes) {
		if (includes) {
			return (startA.compareTo(finishB) != 1) && (finishA.compareTo(startB) != -1);
		} 
		return (startA.compareTo(finishB) == -1) && (finishA.compareTo(startB) == 1);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @return The two ranges overlap (Includes conditions where the edges overlap exactly)
	 */
	public static boolean overlaps(Calendar startA, Calendar finishA, Calendar startB, Calendar finishB) {
		return overlaps(startA, finishA, startB, finishB, true);
	}
	
	/**
	 * @param startA Start of range A
	 * @param finishA Finish of range A
	 * @param startB Start of range B
	 * @param finishB Finish of range B
	 * @param includes Includes conditions where the edges overlap exactly
	 * @return The two ranges overlap
	 */
	public static boolean overlaps(Calendar startA, Calendar finishA, Calendar startB, Calendar finishB, boolean includes) {
		return overlaps(startA.getTimeInMillis(), finishA.getTimeInMillis(), startB.getTimeInMillis(), finishB.getTimeInMillis(), includes);
	}
	
	private static Date zeroHours(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
