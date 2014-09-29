import java.util.List;


public interface GradingSystem {

	/**
	 * This method registers a grade for a student. 
	 * @param studentId The ID of the student. 
	 * @param grade The grade obtained by the student. Should be
	 * 		between 0 and 100.
	 * @throws IllegalArgumentException if the grade is not
	 * 		in the valid range.
	 */
	public void registerGrade(String studentId, int grade);
	
	/**
	 * This method fetches the list of grades for a given student. 
	 * The grades are presented in the order they were registered.
	 * @param studentId The ID of the student.
	 * @return A list of grades for the student, or null if the
	 * 		student does not exist.
	 */
	public List<Integer> getGrades(String studentId);
	
	/**
	 * This method fetches the average grade for a student.
	 * @param studentId The ID of the student.
	 * @return The average grade of the student, or -1 if
	 * 		the student does not exist.
	 */
	public int getAverage(String studentId);
	
}
