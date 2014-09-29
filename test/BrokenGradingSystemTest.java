import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class BrokenGradingSystemTest {

	private BrokenGradingSystem system;
	
	@Before
	public void setUp() throws Exception {
		system = new BrokenGradingSystem();
	}

	@Test
	public void testGetGradesIsNullForNonExistingStudent() {
		assertNull(system.getGrades("I DON'T EXIST"));
	}

	@Test
	public void testGetGradesReturnsListOfGrades() {
		system.registerGrade("dominic", 80);
		system.registerGrade("dominic", 100);
		system.registerGrade("david", 90);
		
		List<Integer> grades = system.getGrades("dominic");
		
		assertEquals("There should be 2 registered grades for dominic.",
				2, grades.size());
		assertEquals(80, (int) grades.get(0));
		assertEquals(100, (int) grades.get(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRegisterGradeWithNegativeThrows() {
		system.registerGrade("dominic", -1);
	}
	
	@Test
	public void testRegisterGradeWithOver100() {
		try {
			system.registerGrade("dominic", 101);
			fail();
		} catch (Exception e) {}
	}
	
	@Test
	public void testGetAverage() {
		system.registerGrade("dominic", 25);
		system.registerGrade("dominic", 75);
		assertEquals(50, system.getAverage("dominic"));
	}
}
