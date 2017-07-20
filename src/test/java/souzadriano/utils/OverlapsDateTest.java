package souzadriano.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import souzadriano.utils.Overlaps;

public class OverlapsDateTest {
	
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
    public void A_EQUALS_B() {
        Date startA = getDate("2017-01-10 01:01:01");
        Date finishA = getDate("2017-01-12 01:01:01");

        Date startB = getDate("2017-01-10 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_INSIDE_B() {
        Date startA = getDate("2017-01-10 01:01:01");
        Date finishA = getDate("2017-01-11 01:01:01");

        Date startB = getDate("2017-01-09 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_INSIDE_A() {
        Date startA = getDate("2017-01-09 01:01:01");
        Date finishA = getDate("2017-01-12 01:01:01");

        Date startB = getDate("2017-01-10 01:01:01");
        Date finishB = getDate("2017-01-11 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_BEFORE_AND_FINISH_INSIDE_B() {
        Date startA = getDate("2017-01-09 01:01:01");
        Date finishA = getDate("2017-01-11 01:01:01");

        Date startB = getDate("2017-01-10 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_BEFORE_AND_FINISH_INSIDE_A() {
        Date startA = getDate("2017-01-10 01:01:01");
        Date finishA = getDate("2017-01-12 01:01:01");

        Date startB = getDate("2017-01-09 01:01:01");
        Date finishB = getDate("2017-01-11 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_BEFORE_START_A() {
        Date startA = getDate("2017-01-08 01:01:01");
        Date finishA = getDate("2017-01-11 01:01:01");

        Date startB = getDate("2017-01-08 01:01:01");
        Date finishB = getDate("2017-01-10 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_AFTER_START_A() {
        Date startA = getDate("2017-01-08 01:01:01");
        Date finishA = getDate("2017-01-11 01:01:01");

        Date startB = getDate("2017-01-08 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_AFTER_START_B_FINISH_B_EQUALS_FINISH_A() {
        Date startA = getDate("2017-01-09 01:01:01");
        Date finishA = getDate("2017-01-12 01:01:01");

        Date startB = getDate("2017-01-08 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_AFTER_START_A_FINISH_B_EQUALS_FINISH_A() {
        Date startA = getDate("2017-01-08 01:01:01");
        Date finishA = getDate("2017-01-12 01:01:01");

        Date startB = getDate("2017-01-09 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_BEFORE_B() {
        Date startA = getDate("2017-01-09 01:01:01");
        Date finishA = getDate("2017-01-10 01:01:01");

        Date startB = getDate("2017-01-11 01:01:01");
        Date finishB = getDate("2017-01-12 01:01:01");

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }
 
    @Test
    public void A_BEFORE_B_SECONDS() {
    	Date startA = getDate("2017-01-01 01:01:01");
    	Date finishA = getDate("2017-01-01 01:01:02");
    	
    	Date startB = getDate("2017-01-01 01:01:03");
    	Date finishB = getDate("2017-01-01 01:01:04");
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_BEFORE_A() {
        Date startA = getDate("2017-01-11 01:01:01");
        Date finishA = getDate("2017-01-12 01:01:01");

        Date startB = getDate("2017-01-09 01:01:01");
        Date finishB = getDate("2017-01-10 01:01:01");

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_A_EQUALS_START_B() {
        Date startA = getDate("2017-01-08 01:01:01");
        Date finishA = getDate("2017-01-09 01:01:01");

        Date startB = getDate("2017-01-09 01:01:01");
        Date finishB = getDate("2017-01-10 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_B_EQUALS_START_A() {
        Date startA = getDate("2017-01-10 01:01:01");
        Date finishA = getDate("2017-01-11 01:01:01");

        Date startB = getDate("2017-01-09 01:01:01");
        Date finishB = getDate("2017-01-10 01:01:01");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }
 
    @Test
    public void FINISH_A_EQUALS_START_B_EXCLUSIVE() {
    	Date startA = getDate("2017-01-08 01:01:01");
    	Date finishA = getDate("2017-01-09 01:01:01");
    	
    	Date startB = getDate("2017-01-09 01:01:01");
    	Date finishB = getDate("2017-01-10 01:01:01");
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
    
    @Test
    public void FINISH_B_EQUALS_START_A_EXCLUSIVE() {
    	Date startA = getDate("2017-01-10 01:01:01");
    	Date finishA = getDate("2017-01-11 01:01:01");
    	
    	Date startB = getDate("2017-01-09 01:01:01");
    	Date finishB = getDate("2017-01-10 01:01:01");
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
    
    private Date getDate(String date) {
    	try {
			return DF.parse(date);
		} catch (ParseException e) {
			Assert.fail(e.getMessage());
			throw new RuntimeException(e);
		}
    }
}
