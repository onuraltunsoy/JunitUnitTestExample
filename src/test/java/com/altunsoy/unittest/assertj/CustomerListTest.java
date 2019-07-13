package com.altunsoy.unittest.assertj;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
public class CustomerListTest {
	@Test
	public void testListeler(){
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1, "john"));
		items.add(new Item(2, "jeniffer"));
		items.add(new Item(3, "marc"));
		
		Assertions.assertThat(items)
					.extracting("name")
					.contains("john","marc");
		
		Assertions.assertThat(items)
					.extracting("name","id")
					.contains(
							Tuple.tuple("john",1),
							Tuple.tuple("marc",3)
							///Tuple.tuple("marc",4)
							);
		
		Assertions.assertThat(
								Assertions.extractProperty("id",Integer.class).from(items)
							 )
							.containsExactly(1,2,3);

	}
	@Data
	@AllArgsConstructor
	static class Item{
		private Integer id;
		private String name;
	}
	

}
