import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradebookTester {
	GradeBook grade1;
	GradeBook grade2;
	@Before
	public void setUp() {
		 grade1 = new GradeBook(5);
		 grade2 = new GradeBook(5);
		
		grade1.addScore(20.0);
		grade1.addScore(100.0);
		
		grade2.addScore(80.0);
		grade2.addScore(30.0);
		grade2.addScore(100);
		
	}
	
	@After
	public void tearDown() {
		 grade1 = grade2 = null;
		
	}
	
	@Test
	public void testAddScore() {
		assertTrue(grade1.toString().equals("20.0 100.0 "));
		assertTrue(grade2.toString().equals("80.0 30.0 100.0 "));
		assertEquals(2, grade1.getScoreSize(), .0001);
		assertEquals(3, grade2.getScoreSize(), .0001);
	}
	@Test
	public void testSum() {
		assertEquals(120, grade1.sum(), 0.0001);
		assertEquals(210, grade2.sum(),0.0001);
	}
	@Test
	public void testMinimum() {
		
		assertEquals(20, grade1.minimum(), 0.0001);
		assertEquals(30, grade2.minimum(), 0.0001);
	}
	@Test
	public void testFinalScore() {
		assertEquals(100, grade1.finalScore(), 0.0001);
		assertEquals(180, grade2.finalScore(), 0.0001);
		
	}
}
