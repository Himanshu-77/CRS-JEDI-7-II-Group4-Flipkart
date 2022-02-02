package com.flipkart.dao;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.constants.SQLQueries;
import com.flipkart.utils.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dell
 *
 */
public class NotificationDaoOperation implements NotificationDaoInterface{
	private static volatile NotificationDaoOperation instance=null;
	private static Logger logger=LogManager.getLogger(NotificationDaoOperation.class);
    private final Connection connection=DBUtil.getConnection();

	public static NotificationDaoOperation getInstance(){
		if(instance !=null)
			return instance;
			synchronized (NotificationDaoOperation.class){
				instance=new NotificationDaoOperation();
			}
		return instance;
	}

    public static void main(String[] args) {

        NotificationDaoOperation test = new NotificationDaoOperation();
        test.sendPaymentCompleteNotification(4,2);
    }
	@Override
	public Boolean sendPaymentCompleteNotification(int transactionID, int studentid) {
        try{

            PreparedStatement statement;
            int newID = getNewTransactionID();

            statement = connection.prepareStatement(SQLQueries.ADD_NOTIFICATION);

            statement.setInt(1, newID);
            statement.setInt(2, transactionID);
            statement.setInt(3, studentid);

            statement.executeUpdate();
            return true;


        }
        catch (SQLException ex){
            logger.error(ex.getMessage());
            return false;
        }

    }

    private int getNewTransactionID() {

        int newNotificationID = -1;

        try
        {
            PreparedStatement stmt = connection.prepareStatement(SQLQueries.GET_MAX_NOTIFICATION_ID, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                newNotificationID = rs.getInt("MAX(notification_id)") + 1;
            }

        }
        catch(Exception ex) {
            logger.error(ex.getMessage());
        }

        return newNotificationID;
    }

}

