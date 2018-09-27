package com.sample.tdd.test;



import org.junit.Test;

import com.sample.tdd.StringCalculator;

import org.junit.Assert;

public class StringCalculatorTest {

	/*@Test(expected=RuntimeException.class)
	public void whenMoreThan2NumbersPassedThenExceptionThrown() {
		
		StringCalculator.add("1,2,3");
	}*/
	@Test
	public void when2NumbersPassedNoExceptionThrown() {
		StringCalculator.add("1,2");
		Assert.assertTrue(true);
	}
	
	@Test(expected=RuntimeException.class)
	public void whenNonNumberPassedThenExceptionThrown() {
		StringCalculator.add("1,X");
	}
	
	@Test
	public void whenEmptyStringThenRetuern0() {
		Assert.assertEquals(0,StringCalculator.add(""));
	}
	@Test
	public void whenSingleNumberThenSameNumberIsResult() {
		Assert.assertEquals(2, StringCalculator.add("2"));
	}
	@Test
	public void whenTwoNumbersThenReturnTheirSum() {
		Assert.assertEquals(5, StringCalculator.add("3,2"));
	}
	@Test
	public void whenAnyNumberOfNumbersPassedReturnTheirSum() {
		Assert.assertEquals(3+4+18+19, StringCalculator.add("3,4,18,19"));
	}
	@Test
	public void whenNewLineIsUsedInBetweenTwoNumberReturnTheirSum() {
		Assert.assertEquals(3+5+15, StringCalculator.add("3,5n15"));
	}
	@Test
	public void whenDelimeterIsSpecifiedUseItToSeparateNumbers() {
		Assert.assertEquals(3+4+7+8, StringCalculator.add("//;n3;4;7;8"));
	}
	@Test(expected=RuntimeException.class)
	public void whenNegativeNumberThenThrowException() {
		StringCalculator.add("3,-7,10,8");
	}
	@Test
	public void whenNegativeNumbersPassedThenThrowExceptionAndMessage() {
		RuntimeException exception=null;
		try {
		StringCalculator.add("3,-7,10,8");
		}catch(RuntimeException e) {
			exception=e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-7]", exception.getMessage().toString());
	}
	@Test
	public void whenOneOrMoreNumbersGreaterThanThousandIgnoreThemInSum() {
		Assert.assertEquals(3+1000+12+12, StringCalculator.add("3,1000,1002,12,12,1098"));
	}
}

