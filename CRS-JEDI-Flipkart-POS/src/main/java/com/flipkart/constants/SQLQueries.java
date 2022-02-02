/**
 * 
 */
package com.flipkart.constants;

/**
 * @author Aeron
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

	public static final String GET_REPORT = "select * from registered_courses where student_id = ? and semester_id = ? and is_primary=1";
	public static final String GET_COURSES = "select course_id, is_primary from registered_courses where student_id = ? and semester_id = ?";
	public static String GET_COURSE_BY_ID = "select * from course_catalog where courseID = '?' and offered_semester = ?";

	public static String GET_STUDENT_BY_ID = "select * from registered_courses where student_id = ? and semester_id = ?";
	public static String APPROVE_STUDENT = "UPDATE registered_courses set is_approved=1 where student_id = ?' and semester_id = ?";
	public static String GET_ALL_COURSES = "select distinct course_id from registered_courses where semester_id = ?";
	public static String GET_COURSE_STUDENTS = "select student_id from registered_courses where course_id = '?' and semester_id = ?";
	public static String GET_STUDENT = "select account_approved from student where student_id = ?";
	public static String GENERATE_REPORT_CARD = "update student set spi = ? where student_id = ?";
	public static String APPROVE_STUDENT_ACCOUNT = "update student set account_approved = 1 where student_id = ?";
	
	public static final String CHECK_COURSE_VALIDITY = "SELECT is_approved from registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";
	public static final String ADD_GRADE = "UPDATE registered_courses SET grade = ? WHERE student_id = ? AND course_id = ? AND semester_id = ?";
	public static final String VIEW_REGISTERED_STUDENTS = "SELECT * FROM registered_courses WHERE course_id = ? AND semester_id = ?";
	public static final String VIEW_ASSOCIATED_PROFESSOR = "SELECT * FROM course_catalog WHERE instructor = ?";
	public static final String VIEW_PROFESSOR_ID = "select * from professor where user_name = ?";

	public static final String VERIFY_PAYMENT = "select isPaid from payments where studentId = ?";
}
