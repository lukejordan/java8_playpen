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
		shapes.add(new Shape (2, 2));
		shapes.add(new Shape (3, 3));
		

		assertEquals(19, shapes.stream().mapToInt(item -> item.area()).sum());
		
		assertEquals(15, shapes.stream().filter(item -> item.area() > 4).mapToInt(item -> item.area()).sum());
		
		int result = shapes.stream().filter(item -> item.area() < 9).mapToInt(item -> item.area())
				.reduce(0, 
						(a, b) -> a + b
				);
		
		assertEquals(10, result);
		
	}
}
