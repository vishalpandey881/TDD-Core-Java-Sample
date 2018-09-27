package com.sample.tdd;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String numbers) {
		// TODO Auto-generated method stub
		// //;n3;4;7;8
		String delimeter = ",|n";
		String numberWithoutDelimeter = numbers;
		if (numbers.startsWith("//")) {
			int delimeterIndex = numbers.indexOf("//") + 2;
			delimeter = numbers.substring(delimeterIndex, delimeterIndex + 1);
			numberWithoutDelimeter = numbers.substring(numbers.indexOf("n") + 1);
		}
		return add(numberWithoutDelimeter, delimeter);
	}

	private static int add(String numbers, String delimeter) {
		int returnVal = 0;
		List negativeNumber = new ArrayList();
		String inputNumbers[] = numbers.split(delimeter);
		/*
		 * if(inputNumbers.length>2) { throw new
		 * RuntimeException("only 2 numbers , seaparated needed"); }
		 */
		for (String number : inputNumbers) {
			if (!number.trim().isEmpty()) {
				int inputNum = Integer.parseInt(number);
				if (inputNum < 0) {
					negativeNumber.add(inputNum);
				}else if(inputNum<=1000)
				returnVal += inputNum;
			}
		}
		if(negativeNumber.size()>0) {
			throw new RuntimeException("Negatives not allowed: "+negativeNumber.toString());
		}
		return returnVal;
	}

}
