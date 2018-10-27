public class Ch4Ex6Driver
{
	public static void main(String[]args)
	{	
		Ch4Ex6 studentRecords = new Ch4Ex6();
		studentRecords.readInput();
		studentRecords.studentRecord();
		System.out.println(studentRecords.toString());
		studentRecords.overallGrade();
		studentRecords.outputStudentRecord();
	}
}
	