package com.example.java8.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.java8.domain.Shape;

@RunWith(MockitoJUnitRunner.class)
public class ShapeTest {

	@Test
	public void test1 () {
		List<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(new Shape (2, 3));
		shapes.add(new Shape (2, 4));
		
		shapes.add(new Shape (2, 2));
		shapes.add(new Shape (3, 3));
		shapes.add(new Shape (4, 4));

		assertEquals(43, shapes.stream().mapToInt(item -> item.area()).sum());
		
		assertEquals(39, shapes.stream().filter(item -> item.area() > 4).mapToInt(item -> item.area()).sum());
		
		int result = shapes.stream().filter(item -> item.area() < 9).mapToInt(item -> item.area())
				.reduce(0, 
						(a, b) -> a + b
				);
		
		assertEquals(18, result);
		
		int result2 = shapes.stream()
				.filter(item -> item.getWidth() == item.getHeight())
				.mapToInt(item -> item.area())
				.sum();
		
		assertEquals(29, result2);
		
		int result3 = shapes.stream()
				.filter(item -> item.getWidth() != item.getHeight())
				.mapToInt(item -> item.area())
				.sum();
		assertEquals(14, result3);
		
	}
	
}
