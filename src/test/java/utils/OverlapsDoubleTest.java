package utils;

import org.junit.Assert;
import org.junit.Test;

import souzadriano.utils.Overlaps;

public class OverlapsDoubleTest {
	
	@Test
    public void A_EQUALS_B() {
        Double startA = 0.1;
        Double finishA = 0.2;

        Double startB = 0.1;
        Double finishB = 0.2;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_INSIDE_B() {
        Double startA = 0.2;
        Double finishA = 0.3;

        Double startB = 0.1;
        Double finishB = 0.4;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_INSIDE_A() {
        Double startA = 0.1;
        Double finishA = 0.4;

        Double startB = 0.2;
        Double finishB = 0.3;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_BEFORE_AND_FINISH_INSIDE_B() {
        Double startA = 0.1;
        Double finishA = 0.3;

        Double startB = 0.2;
        Double finishB = 0.4;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_BEFORE_AND_FINISH_INSIDE_A() {
        Double startA = 0.2;
        Double finishA = 0.4;

        Double startB = 0.1;
        Double finishB = 0.3;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_BEFORE_START_A() {
        Double startA = 0.1;
        Double finishA = 0.4;

        Double startB = 0.1;
        Double finishB = 0.3;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_AFTER_START_A() {
        Double startA = 0.1;
        Double finishA = 0.4;

        Double startB = 0.1;
        Double finishB = 0.5;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_AFTER_START_B_FINISH_B_EQUALS_FINISH_A() {
        Double startA = 0.2;
        Double finishA = 0.4;

        Double startB = 0.1;
        Double finishB = 0.4;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_AFTER_START_A_FINISH_B_EQUALS_FINISH_A() {
        Double startA = 0.1;
        Double finishA = 0.4;

        Double startB = 0.2;
        Double finishB = 0.4;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_BEFORE_B() {
        Double startA = 0.1;
        Double finishA = 0.2;

        Double startB = 0.3;
        Double finishB = 0.4;

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_BEFORE_A() {
        Double startA = 0.3;
        Double finishA = 0.4;

        Double startB = 0.1;
        Double finishB = 0.2;

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_A_EQUALS_START_B() {
        Double startA = 0.1;
        Double finishA = 0.2;

        Double startB = 0.2;
        Double finishB = 0.3;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_B_EQUALS_START_A() {
        Double startA = 0.2;
        Double finishA = 0.3;

        Double startB = 0.1;
        Double finishB = 0.2;

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }
 
    @Test
    public void FINISH_A_EQUALS_START_B_EXCLUSIVE() {
    	Double startA = 0.1;
    	Double finishA = 0.2;
    	
    	Double startB = 0.2;
    	Double finishB = 0.3;
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
    
    @Test
    public void FINISH_B_EQUALS_START_A_EXCLUSIVE() {
    	Double startA = 0.2;
    	Double finishA = 0.3;
    	
    	Double startB = 0.1;
    	Double finishB = 0.2;
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
}
