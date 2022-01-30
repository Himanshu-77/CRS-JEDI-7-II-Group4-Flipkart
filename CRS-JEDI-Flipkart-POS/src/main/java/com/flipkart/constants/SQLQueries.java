/**
 * 
 */
package com.flipkart.constants;

/**
 * @author Dell
 *
 */
public class SQLQueries {
	public static final String ADD_STUDENT = "insert into student(user_name, name, role, student_id, department, joining_year, password, contact_number) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_STUDENTS = "select * from student";
	public static final String GET_PENDING_STUDENT = "select * from student where account_approved = 0 ";

    public static final String ADMIN_ADD_PROFESSOR = "INSERT INTO professor(user_name, name, joining_year, contact_number, password, instructor_ID, designation, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String ADMIN_REMOVE_PROFESSOR = "DELETE FROM professor WHERE instructor_ID=?";
	public static final String ADMIN_REMOVE_COURSE = "DELETE FROM course_catalog WHERE courseID=?";
	public static final String ADMIN_ADD_COURSE = "INSERT INTO course_catalog(courseID, course_name,  offered_semester, available_seats) VALUES (?, ?, ?, ?)";

    public static final String REGISTRATION_ADD_COURSE = "INSERT INTO registered_courses VALUES (?,?,?,?,?,?,?)";
	public static final String REGISTRATION_GET_COURSES = "SELECT * FROM course_catalog WHERE courseID = ? AND offered_semester = ?";
	public static final String REGISTRATION_COURSE_EXISTS = "SELECT COUNT(1) FROM registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";
	public static final String REGISTRATION_UPDATE_SEATS = "UPDATE course_catalog SET available_seats = ? WHERE  courseID = ? AND offered_semester = ?";
	public static final String REGISTRATION_DROP_COURSE = "DELETE FROM registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";
	public static final String REGISTRATION_FINISH_REG = "SELECT * FROM registered_courses WHERE student_id = ? AND semester_id = ?";
	public static final String REGISTRATION_GET_ALL_COURSES = "SELECT * FROM course_catalog";

	public static final String GET_REPORT(int studentID, int semesterId) {
		 String qry="select * from registered_courses where student_id = "+studentID+" and semester_id = "+semesterId +" and is_primary=1";
		 return qry;
	}

	public static final String GET_COURSES(int studentID, int semesterId) {
		String qry="select course_id, is_primary from registered_courses where student_id = "+studentID+" and semester_id = "+semesterId +"";
		return qry;
	}

	public static String GET_COURSE_BY_ID(String courseId, int semesterId) {
		String qry="select * from course_catalog where courseID = '"+courseId+"' and offered_semester = "+semesterId;
	 return qry;
	}

	
	public static String GET_STUDENT_BY_ID(int studentId, int semesterId) {
		String qry="select * from registered_courses where student_id = '"+studentId+"' and semester_id = "+semesterId;
		 return qry;
	}

	public static String APPROVE_STUDENT(int studentId, int semesterId) {
		String qry="UPDATE registered_courses set is_approved=1 where student_id = '"+studentId+"' and semester_id = "+semesterId;
		 return qry;
	}

	public static String GET_ALL_COURSES(int semesterId) {
		String qry="select distinct course_id from registered_courses where semester_id = "+semesterId;
		 return qry;
	}

	public static String GET_COURSE_STUDENTS(String course_id,int semesterId) {
		return "select student_id from registered_courses where course_id = '"+course_id+"' and semester_id = "+semesterId;
	}

	public static String GET_STUDENT(int studentID) {
		String qry="select account_approved from student where student_id = "+studentID;
		 return qry;
	}

	public static String GENERATE_REPORT_CARD(int studentID,float spi) {
		String qry="update student set spi = "+spi+ " where student_id = "+studentID;
		 return qry;
	}

	public static String APPROVE_STUDENT_ACCOUNT(int studentId) {
		String qry="update student set account_approved = 1 where student_id = "+studentId;
		return qry;
	}
	
	public static final String CHECK_COURSE_VALIDITY(Integer studentID, Integer semesterID, String courseID) {
		String qry="SELECT is_approved from registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";
		return qry;
	}
	public static final String ADD_GRADE(Integer studentID, Integer semesterID, String courseID,Integer grade) {
		String qry="UPDATE registered_courses SET grade = ? WHERE student_id = ? AND course_id = ? AND semester_id = ?";
		return qry;
	}
	public static final String VIEW_REGISTERED_STUDENTS(String courseID, Integer semesterID) {
		String qry="SELECT * FROM registered_courses WHERE course_id = ? AND semester_id = ?";
		return qry;
	}
	public static final String VIEW_ASSOCIATED_PROFESSOR(Integer instructorID) {
		String qry="SELECT * FROM course_catalog WHERE instructor = ?";
		return qry;
	}
	public static final String VIEW_PROFESSOR_ID(String username) {
		String qry="select * from professor where user_name = ?";
		return qry;
	}
	public static final String VERIFY_PAYMENT(Integer studentId) {
		String qry="select isPaid from payments where studentId = ?";
		return qry;
	}
}
