package com.altunsoy.junit;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class AssertTest {
	@Test
	public void testAssertArray()throws Exception{
		
		String[] arr1 = new String[] {"1","2"};
		String[] arr2 = new String[] {"1","2"};
		//String[] arr2 = new String[] {"1","3"};
		
		assertArrayEquals(arr1, arr2); 

	}

	@Test
	public void testAssertEquals()throws Exception{
		
		Dummy d1 = new Dummy(5);
		Dummy d2 = new Dummy(5);
		
		assertEquals(d1, d2); 

	}	
	@Test
	public void testAssertSame() {
		Dummy d1 = new Dummy(5);
		Dummy d2 = new Dummy(5);
		d2 = d1;
	    assertSame("err message",d1, d2);
	}
	@Test
	public void testAssertNull() {
		Dummy d3 = null;
		assertNull(d3);
	}
	@Test
	public void testAssertNotNull() {
		Dummy d1 = new Dummy(5);
		assertNotNull(d1);
	}
	@Test
	public void testAssertTrue() {
		Dummy d1 = new Dummy(5);
		assertTrue(d1.getId()==5);
	}
	@Test
	public void testAssertFalse() {
		Dummy d1 = new Dummy(5);
		assertFalse(d1.getId()==10); 
	}
	
	public static class Dummy{
		private int id;

		public Dummy(int id) {
			this.id = id; 
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.id == ((Dummy) obj).getId();
		}
		
		
	}
}
