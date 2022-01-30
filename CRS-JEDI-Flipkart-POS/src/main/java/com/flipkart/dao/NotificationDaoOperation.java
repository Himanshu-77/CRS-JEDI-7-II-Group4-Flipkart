package com.flipkart.dao;///**
// *
// */
//package com.flipkart.dao;
//
//import com.flipkart.bean.Notification;
//import com.flipkart.bean.Payment;
//import com.flipkart.constants.SQLQueries;
//import com.flipkart.utils.DBUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
///**
// * @author JEDI G6
// *
// */
//public class NotificationDaoOperation implements NotificationDaoInterface{
//	private static volatile NotificationDaoOperation instance=null;
//	//private static Logger logger=Logger.getLogger(NotificationDaoOperation.class);
//
//	@Override
//	public Notification GenerateNotification(int studentId, Payment payment, String message) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static NotificationDaoOperation getInstance(){
//		if(instance !=null)
//			return instance;
//			synchronized (NotificationDaoOperation.class){
//				instance=new NotificationDaoOperation();
//			}
//		return instance;
//	}
//
//	@Override
//	public int sendNotification(int studentId, Notification notification) {
//		int notificationId=0;
//		Connection connection= DBUtil.getConnection();
//		try{
//			PreparedStatement ps = connection.prepareStatement(SQLQueries.INSERT_NOTIFICATION,Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, studentId);
//			ps.setString(2,type.toString());
//			if(type==NotificationType.PAYMENT)
//			{
//				//insert into payment, get reference id and add here
//				UUID referenceId=addPayment(studentId, modeOfPayment,amount);
//				ps.setString(3, referenceId.toString());
//				logger.info("Payment successful, Reference ID: "+referenceId);
//			}
//			else
//				ps.setString(3,"");
//
//			ps.executeUpdate();
//			ResultSet results=ps.getGeneratedKeys();
//			if(results.next())
//				notificationId=results.getInt(1);
//
//			switch(type)
//			{
//				case REGISTRATION:
//					logger.info("Registration successfull. Administration will verify the details and approve it!");
//					break;
//				case REGISTRATION_APPROVAL:
//					logger.info("Student with id "+studentId+" has been approved!");
//					break;
//				case PAYMENT:
//					logger.info("Student with id "+studentId+" fee has been paid");
//			}
//
//		}
//		catch(SQLException ex)
//		{
//			throw ex;
//		}
//		return notificationId;
//	}
//	public UUID addPayment(int studentId, ModeOfPayment modeOfPayment,double amount) throws SQLException
//	{
//		UUID referenceId;
//		Connection connection=DBUtils.getConnection();
//		try
//		{
//			referenceId=UUID.randomUUID();
//			//INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
//			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.INSERT_PAYMENT);
//			statement.setInt(1, studentId);
//			statement.setString(2, modeOfPayment.toString());
//			statement.setString(3,referenceId.toString());
//			statement.setDouble(4, amount);
//			statement.executeUpdate();
//			//check if record is added
//		}
//		catch(SQLException ex)
//		{
//			throw ex;
//		}
//		return referenceId;
//		//
//	}
//
//
//}
//
