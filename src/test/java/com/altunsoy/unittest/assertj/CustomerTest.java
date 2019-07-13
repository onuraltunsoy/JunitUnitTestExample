package com.altunsoy.unittest.assertj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.Test;

public class CustomerTest {
	List<String> turkSehirler = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir","Bursa","Eskişehir"));
	List<String> yabancıSehirler = new ArrayList<String>(Arrays.asList("Amsterdam","Paris","Londra"));

	
	@Test
	public void testString()throws Exception{
		String text1 = "Istanbul";
		Assertions.assertThat(text1)
						.describedAs("****Bu bir Hata mesajı")
						.isEqualTo("Istanbul")
						.startsWith("Is")
						.endsWith("bul")
						.contains("tan")
						.isNotEmpty()
						.isNotNull()
						.doesNotContain("bs")
						.containsOnlyOnce("tan");
						
						
						
						
	}
	@Test
	public void  testDuzListeler() throws Exception {
		List<String> sehirler = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir","Bursa","Eskişehir","GaziAntep"));

		Assertions.assertThat(sehirler)
					.contains("Istanbul")
					.doesNotContain("Trabzon")
					////.containsExactly("Istanbul","Ankara","Izmir","Bursa","Eskişehir")
					.doesNotHaveDuplicates()
					;
		List<String> sehirler2 = new ArrayList<String>(Arrays.asList("Istanbul","Ankara"));

		Assertions.assertThat(sehirler2)
					.have(turkSehirleri());
		
		List<String> sehirler3 = new ArrayList<String>(Arrays.asList("Amsterdam","Paris","Londra"));
		Assertions.assertThat(sehirler3)
					.have(yabancıSehirler());
		
		List<String> sehirler4 = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Amsterdam","Paris","Londra"));
		Assertions.assertThat(sehirler4)
					.haveExactly(2, turkSehirleri())
					.haveExactly(3, yabancıSehirler());
	}
	
	private Condition<? super String> yabancıSehirler() {
		return new Condition<String>() {
			@Override
			public boolean matches(String s) {
				return yabancıSehirler.contains(s);
			}
		};
	}
	private Condition<? super String> turkSehirleri() {
		return new Condition<String>() {
			@Override
			public boolean matches(String s) {
				return turkSehirler.contains(s);
			}
		};
	}
}
