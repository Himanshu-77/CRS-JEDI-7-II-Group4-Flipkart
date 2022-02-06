/**
 * 
 */
package com.flipkart.constants;

/**
 * @author Aeron
 *
 */
public class SQLQueries {
	// Add a new student details into system.
	public static final String ADD_STUDENT = "insert into student(user_name, name, role, student_id, department, joining_year, password, contact_number) values (?, ?, ?, ?, ?, ?, ?, ?)";

	// Get all student details.
	public static final String GET_STUDENTS = "select * from student";

	// Get details of given student.
	public static final String GET_STUDENT_BY_ID = "select * from student where user_name = ?";

	// Login account approval status for a student account.
	public static final String GET_ACCOUNT_STATUS_BY_ID = "SELECT account_approved FROM student WHERE user_name = ?";

	// Get maximum student-ID.
	public static final String GET_MAX_STUDENT_ID = "SELECT MAX(student_id) FROM student";

	// List of students for which account approval is pending.
	public static final String GET_PENDING_STUDENT = "select * from student where account_approved = 0 ";

	// Add a new professor by admin.
    public static final String ADMIN_ADD_PROFESSOR = "INSERT INTO professor(user_name, name, joining_year, contact_number, password, instructor_ID, designation, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	// Remove an existing professor by admin.
	public static final String ADMIN_REMOVE_PROFESSOR = "DELETE FROM professor WHERE instructor_ID=?";

	// Remove an existing course from catalog.
	public static final String ADMIN_REMOVE_COURSE = "DELETE FROM course_catalog WHERE courseID=?";

	// Add a new course into catalog.
	public static final String ADMIN_ADD_COURSE = "INSERT INTO course_catalog(courseID, course_name,  offered_semester, available_seats) VALUES (?, ?, ?, ?)";

	// Get admin login password.
	public static final String GET_PASSWORD_ADMIN = "SELECT password FROM admin WHERE user_name=? ";

	// Get student login password.
	public static final String GET_PASSWORD_STUDENT = "SELECT password FROM student WHERE user_name=? ";

	// Get professor login password.
	public static final String GET_PASSWORD_PROF = "SELECT password FROM professor WHERE user_name=? ";

	// Update contact number by username.
	public static final String UPDATE_CONTACT = "UPDATE ? SET contact_number = ? WHERE user_name = ?";

	// Check if a user with provided id exists in a given role.
	public static final String USER_WITH_ROLE_EXIST = "SELECT COUNT(1) FROM ? WHERE user_name = ?";

	// Update admin login password.
	public static final String UPDATE_ADMIN_PASSWORD = "UPDATE admin SET password = ? WHERE user_name = ?";

	// Update professor login password.
	public static final String UPDATE_PROF_PASSWORD = "UPDATE professor SET password = ? WHERE user_name = ?";

	// Update student login password.
	public static final String UPDATE_STUDENT_PASSWORD = "UPDATE student SET password = ? WHERE user_name = ?";

	// Register a student in a course.
    public static final String REGISTRATION_ADD_COURSE = "INSERT INTO registered_courses VALUES (?,?,?,?,?,?,?)";

	// View course details.
	public static final String REGISTRATION_GET_COURSES = "SELECT * FROM course_catalog WHERE courseID = ? AND offered_semester = ?";

	// Check if a given student has registered for a given course.
	public static final String REGISTRATION_COURSE_EXISTS = "SELECT COUNT(1) FROM registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";

	// Update available seats for a course.
	public static final String REGISTRATION_UPDATE_SEATS = "UPDATE course_catalog SET available_seats = ? WHERE  courseID = ? AND offered_semester = ?";

	// Drop / Un-register a course by a student.
	public static final String REGISTRATION_DROP_COURSE = "DELETE FROM registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";

	// Get all courses in which a student has registered.
	public static final String REGISTRATION_FINISH_REG = "SELECT * FROM registered_courses WHERE student_id = ? AND semester_id = ?";

	// Get all course details.
	public static final String REGISTRATION_GET_ALL_COURSES = "SELECT * FROM course_catalog";

	// Get all primary registered courses for a student.
	public static final String GET_REPORT = "select * from registered_courses where student_id = ? and semester_id = ? and is_primary=1";

	// Check if a course is primary for a student.
	public static final String GET_COURSES = "select course_id, is_primary from registered_courses where student_id = ? and semester_id = ?";

	// Get course details by course-id.
	public static String GET_COURSE_BY_ID = "select * from course_catalog where courseID = ? and offered_semester = ?";

	// Delete a course from legacy by course-id.
	public static String REMOVE_COURSE_BY_ID = "DELETE FROM course_catalog_legacy WHERE courseID= ?";

	// Add a new course into legacy by course-id.
	public static String ADD_COURSE_BY_ID = "INSERT INTO course_catalog_legacy(courseID, course_name) VALUES (?, ?)";

	// Get course for which instructor is not assigned.
	public static String GET_COURSE_WITHOUT_INSTRUCTOR = "SELECT * FROM course_catalog WHERE courseID = ? AND offered_semester = ? AND instructor is NULL";

	// Assign instructor for a course.
	public static String ASSIGN_COURSE_INSTRUCTOR = "UPDATE course_catalog set instructor = ? WHERE courseID = ? AND offered_semester = ?";
	public static String GET_COURSES_BY_STUDENT_ID = "select * from registered_courses where student_id = ? and semester_id = ?";
	public static String APPROVE_STUDENT = "UPDATE registered_courses set is_approved=1 where student_id = ? and semester_id = ?";
	public static String GET_ALL_COURSES = "select distinct course_id from registered_courses where semester_id = ?";
	public static String GET_COURSE_STUDENTS = "select student_id from registered_courses where course_id = ? and semester_id = ?";

	// Check if a student's account is approved.
	public static String GET_STUDENT = "select account_approved from student where student_id = ?";

	// Generate report card for a student.
	public static String GENERATE_REPORT_CARD = "update student set spi = ? where student_id = ?";

	// Approve a student account.
	public static String APPROVE_STUDENT_ACCOUNT = "update student set account_approved = 1 where student_id = ?";

	// Check for semester registration for a student.
	public static final String CHECK_COURSE_VALIDITY = "SELECT is_approved from registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";
	public static final String ADD_GRADE = "UPDATE registered_courses SET grade = ? WHERE student_id = ? AND course_id = ? AND semester_id = ?";

	// View all students registered for a course.
	public static final String VIEW_REGISTERED_STUDENTS = "SELECT * FROM registered_courses WHERE course_id = ? AND semester_id = ?";
	public static final String VIEW_ASSOCIATED_PROFESSOR = "SELECT * FROM course_catalog WHERE instructor = ?";

	// Get professor details by username.
	public static final String VIEW_PROFESSOR_ID = "select * from professor where user_name = ?";
	public static final String GET_MAX_PROFESSOR_ID = "SELECT MAX(instructor_ID) FROM professor";

	// Get registered semester for a student.
	public static String GET_SEM_BY_STUDENT = "SELECT semester_id FROM registered_courses WHERE student_id = ?";

	// Verify payment status.
	public static final String VERIFY_PAYMENT = "SELECT studentId from payments where studentId = ?";

	// Check if payment window is open for a semester.
	public static final String SEM_PAYMENT_WINDOW = "SELECT is_open FROM paymentwindow WHERE semester_id = ?";

	// Update payment window status.
	public static final String CHANGE_PAYMENT_WINDOW_STATUS = "UPDATE paymentwindow SET is_open = ? WHERE semester_id = ?";

	// Get maximum transaction id exist.
	public static final String GET_MAX_TRANSACTION_ID = "SELECT MAX(transactionId) FROM payments";

	// Make a new payment.
	public static final String MAKE_PAYMENT = "INSERT INTO payments(studentId, amount, transactionId, paymentType, isPaid) VALUES (?, ?, ?, ?, ?)";

	// Update payment status for a student.
	public static final String UPDATE_STUDENT_PAYMENT_STATUS = "UPDATE registered_courses set is_paid = 1 where student_id = ?";
	public static final String PAYMENT_STATUS_STUDENT = "SELECT studentId from payments where studentId = ?";

	// Add a new notification details.
	public static final String ADD_NOTIFICATION = "INSERT INTO notification(notification_id,transactionId, studentId) VALUES (?, ?, ?)";
	public static final String GET_MAX_NOTIFICATION_ID = "SELECT MAX(notification_id) FROM notification";
}
