package main.epam;

public interface Shape {
	public float getArea();

	static Shape getInstance(String type, float[] sides) {
		switch (type) {
		case "rectangle":
			if (sides.length == 2) {
				return new Rectangle(sides[0], sides[1]);
			}
			break;
//		case "rectangle":
//			if(sides.length==2)
//			{
//				return new Rectangle(sides[0], sides[1]);
//			}
//			break;
		default:
			break;
		}
		return null;
	}
}
