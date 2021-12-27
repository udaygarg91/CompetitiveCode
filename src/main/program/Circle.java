package main.epam;

public class Circle implements Shape{
	
	float radius;
	public Circle(float radius) {
		this.radius = radius;
	}
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return (22/7)*radius*radius;
	}

}
