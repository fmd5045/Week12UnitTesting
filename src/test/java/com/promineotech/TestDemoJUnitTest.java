package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;
 

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	static Stream<Arguments> argumentsForAddPositive(){
		//The method will throw an exception if the any of the value is less than 1
		// @formatter:off
		return Stream.of(
				arguments(4,5,9,false),
				arguments(40,50,90,false),
				arguments(5,4,9,false),
				arguments(0,5,35,true),
				arguments(-1,18,23,true)
				);
		// @formatter:on
	}
	
	static Stream<Arguments> argumentsForExponentFunction(){
		return Stream.of(
				arguments(3,2,9),
				arguments(5,3,125),
				arguments(-2,7,-128),
				arguments(10,4,10000),
				arguments(-25,3,-15625)
				);
	}
		
	
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectedException) {
		if(!expectedException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> 
	    testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(5,9)).isEqualTo(14);
		assertThat(testDemo.addPositive(12,23)).isEqualTo(35);
		assertThat(testDemo.addPositive(5,18)).isEqualTo(23);

	}
	
	
	@Test
	void assertThatPairOfPositiveNumbersAreExponentiallyRaisedCorrectly() {
		assertThat(testDemo.expontential(3,2)).isEqualTo(9);
		assertThat(testDemo.expontential(5,3)).isEqualTo(125);
		assertThat(testDemo.expontential(2,7)).isEqualTo(128);
		assertThat(testDemo.expontential(10,4)).isEqualTo(10000);
		assertThat(testDemo.expontential(25,3)).isEqualTo(15625);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForExponentFunction")
	void assertThatPairOfPositiveNumbersAreExponentiallyRaisedCorrectlyParameterized(int a, int b, int expected) {
			assertThat(testDemo.expontential(a, b)).isEqualTo(expected);
	}
			
			
	//Mocking problem
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
}
