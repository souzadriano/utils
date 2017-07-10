package utils;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import souzadriano.utils.Overlaps;

public class OverlapsBigDecimalTest {
	
	@Test
    public void A_EQUALS_B() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.2");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.2");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_INSIDE_B() {
        BigDecimal startA = new BigDecimal("0.2");
        BigDecimal finishA = new BigDecimal("0.3");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.4");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_INSIDE_A() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.2");
        BigDecimal finishB = new BigDecimal("0.3");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_BEFORE_AND_FINISH_INSIDE_B() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.3");

        BigDecimal startB = new BigDecimal("0.2");
        BigDecimal finishB = new BigDecimal("0.4");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_BEFORE_AND_FINISH_INSIDE_A() {
        BigDecimal startA = new BigDecimal("0.2");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.3");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_BEFORE_START_A() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.3");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_EQUALS_START_B_FINISH_B_AFTER_START_A() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.5");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_A_AFTER_START_B_FINISH_B_EQUALS_FINISH_A() {
        BigDecimal startA = new BigDecimal("0.2");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.4");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void START_B_AFTER_START_A_FINISH_B_EQUALS_FINISH_A() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.2");
        BigDecimal finishB = new BigDecimal("0.4");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void A_BEFORE_B() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.2");

        BigDecimal startB = new BigDecimal("0.3");
        BigDecimal finishB = new BigDecimal("0.4");

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void B_BEFORE_A() {
        BigDecimal startA = new BigDecimal("0.3");
        BigDecimal finishA = new BigDecimal("0.4");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.2");

        Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_A_EQUALS_START_B() {
        BigDecimal startA = new BigDecimal("0.1");
        BigDecimal finishA = new BigDecimal("0.2");

        BigDecimal startB = new BigDecimal("0.2");
        BigDecimal finishB = new BigDecimal("0.3");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }

    @Test
    public void FINISH_B_EQUALS_START_A() {
        BigDecimal startA = new BigDecimal("0.2");
        BigDecimal finishA = new BigDecimal("0.3");

        BigDecimal startB = new BigDecimal("0.1");
        BigDecimal finishB = new BigDecimal("0.2");

        Assert.assertTrue(Overlaps.overlaps(startA, finishA, startB, finishB));
    }
 
    @Test
    public void FINISH_A_EQUALS_START_B_EXCLUSIVE() {
    	BigDecimal startA = new BigDecimal("0.1");
    	BigDecimal finishA = new BigDecimal("0.2");
    	
    	BigDecimal startB = new BigDecimal("0.2");
    	BigDecimal finishB = new BigDecimal("0.3");
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
    
    @Test
    public void FINISH_B_EQUALS_START_A_EXCLUSIVE() {
    	BigDecimal startA = new BigDecimal("0.2");
    	BigDecimal finishA = new BigDecimal("0.3");
    	
    	BigDecimal startB = new BigDecimal("0.1");
    	BigDecimal finishB = new BigDecimal("0.2");
    	
    	Assert.assertFalse(Overlaps.overlaps(startA, finishA, startB, finishB, false));
    }
}
