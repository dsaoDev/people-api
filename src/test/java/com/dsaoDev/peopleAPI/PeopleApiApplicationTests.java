package com.dsaoDev.peopleAPI;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeopleApiApplicationTests {
	  Calculator underTest = new Calculator();
	
	@Test
	void itShouldAddNumbers() {
		// dado 
		int numberOne = 20;
		int numberTwo = 30;
		
		//quando
		int result = underTest.add(numberOne, numberTwo);
		
		int expected = 51;
		//entao
		assertThat(result).isEqualTo(expected);
		
	}
	
	class Calculator{
		int add(int a , int b) {return a+b
				;
		}
	}

}
