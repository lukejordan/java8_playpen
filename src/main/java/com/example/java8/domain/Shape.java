package com.example.java8.domain;

public class Shape {
	
	private int width;
	
	private int height;
	
	public Shape (int width, int height) {
		this.width  = width;
		this.height = height;
	}
	
	public int area () {
		return width * height;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
