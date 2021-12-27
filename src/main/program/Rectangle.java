package main.epam;

public class Rectangle implements Shape {
	private float width;
	private float height;

	public Rectangle(float width, float height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

}
