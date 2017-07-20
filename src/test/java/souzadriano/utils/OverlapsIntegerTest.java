package souzadriano.utils;

import org.junit.Assert;
import org.junit.Test;

import souzadriano.utils.Overlaps;

public class OverlapsIntegerTest {
	
	@Test
    public void A_EQUALS_B() {
        Integer startA = 10;
        Integer finishA = 12;

        Integer startB = 10;
        Integer finishB = 12;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_INSIDE_B() {
        Integer startA = 10;
        Integer finishA = 11;

        Integer startB = 9;
        Integer finishB = 12;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_INSIDE_A() {
        Integer startA = 9;
        Integer finishA = 12;

        Integer startB = 10;
        Integer finishB = 11;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_BEFORE_AND_FINISH_INSIDE_B() {
        Integer startA = 9;
        Integer finishA = 11;

        Integer startB = 10;
        Integer finishB = 12;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_BEFORE_AND_FINISH_INSIDE_A() {
        Integer startA = 10;
        Integer finishA = 12;

        Integer startB = 9;
        Integer finishB = 11;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_BEFORE_START_A() {
        Integer startA = 8;
        Integer finishA = 11;

        Integer startB = 8;
        Integer finishB = 10;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_AFTER_START_A() {
        Integer startA = 8;
        Integer finishA = 11;

        Integer startB = 8;
        Integer finishB = 12;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_AFTER_START_B_FINISH_B_EQUALS_FINISH_A() {
        Integer startA = 9;
        Integer finishA = 12;

        Integer startB = 8;
        Integer finishB = 12;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_AFTER_START_A_FINISH_B_EQUALS_FINISH_A() {
        Integer startA = 8;
        Integer finishA = 12;

        Integer startB = 9;
        Integer finishB = 12;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_BEFORE_B() {
        Integer startA = 9;
        Integer finishA = 10;

        Integer startB = 11;
        Integer finishB = 12;

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_BEFORE_A() {
        Integer startA = 11;
        Integer finishA = 12;

        Integer startB = 9;
        Integer finishB = 10;

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_A_EQUALS_START_B() {
        Integer startA = 8;
        Integer finishA = 9;

        Integer startB = 9;
        Integer finishB = 10;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_B_EQUALS_START_A() {
        Integer startA = 10;
        Integer finishA = 11;

        Integer startB = 9;
        Integer finishB = 10;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }
 
    @Test
    public void FINISH_A_EQUALS_START_B_EXCLUSIVE() {
    	Integer startA = 8;
    	Integer finishA = 9;
    	
    	Integer startB = 9;
    	Integer finishB = 10;
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
    
    @Test
    public void FINISH_B_EQUALS_START_A_EXCLUSIVE() {
    	Integer startA = 10;
    	Integer finishA = 11;
    	
    	Integer startB = 9;
    	Integer finishB = 10;
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
}
