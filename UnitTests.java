import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Project4Test {
	
	Point pointCase = new Point(5, 10, Color.DARK_GRAY); 
	Point tCase = new Point(1, 1); 
	Point tCase2 = new Point(50, 50);
	
	@DisplayName("GetX() Test")
	@Test
	public void getXtest() {
		int letx = 5;
		assertEquals(pointCase.getX(), letx, "GetX() is not working properly");

	}
	
	@DisplayName("GetY() Test")
	@Test
	
	public void getYtest() {
		int lety = 10;
		assertEquals(pointCase.getY(), lety, "GetY() is not working properly");
	}
	
	@DisplayName("GetColor() Test")
	@Test
	public void getColorTest() { 
		
		Color colorTest = Color.DARK_GRAY; 
		assertEquals(pointCase.getColor(), colorTest, "getColor is not working properly");
	}
	
	@DisplayName("SetColor() Test")
	@Test
	public void setColorTest() { 
	
		Color colorTester = Color.RED; 
		pointCase.setColor(colorTester);
		assertEquals(pointCase.getColor(), colorTester, "SetColor() is not working properly"); 
		
	}
	
	
	@DisplayName("getEndPoint1() Test")
	@Test
	public void getEndPoint1Test() { 
		
		Line lineCase = new Line(tCase, tCase2); 
		assertEquals(lineCase.getEndPoint1(), tCase, "getEndPoint1 is not working properly");

	}
	
	
	@DisplayName("getEndPoint2() Test")
	@Test
	public void getEndPoint2Test() { 
	
	Line lineCase2 = new Line(tCase, tCase2); 
	assertEquals(lineCase2.getEndPoint2(), tCase2, "getEndPoint1 is not working properly");
	
	
	}
	
	@DisplayName("EqualsTest()")
	@Test
	public void EqualsTest() { 
		
		Point pointCase2 = new Point(1,1); 
		assertEquals(pointCase2, tCase, "Error in Equals()"); 
	
	
	}

	@DisplayName("DistanceTest()")
	@Test
	public void DistanceTest() { 
	
//	HandlerLine distanceCase = new HandlerLine();
//	
//	distance(tCase, tCase2);

	}
	
	
	
	
	
}
