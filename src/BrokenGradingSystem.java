import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BrokenGradingSystem implements GradingSystem {

	private Map<String, List<Integer>> grades = new HashMap<String, List<Integer>>();
	
	public void registerGrade(String studentId, int grade) {
		// Validate the grade
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException();
		}
		
		// If the student does not exist, create a record.
		if (!grades.containsKey(studentId)) {
			grades.put(studentId, new ArrayList<Integer>());
		}
		
		// Add the grade to the record.
		grades.get(studentId).add(grade);
	};
	
	public List<Integer> getGrades(String studentId) {
		return grades.get(studentId);
	};
	
	public int getAverage(String studentId) {
		// Check for non-existing
		if (!grades.containsKey(studentId)) {
			return -1;
		}
		
		// Sum up the total number of grades
		int total = 0;
		for (int grade : grades.get(studentId)) {
			total += grade;
		}
		
		// Divide the total by the number of grades
		int average = total / grades.get(studentId).size();
		
		return average;
	};
}
