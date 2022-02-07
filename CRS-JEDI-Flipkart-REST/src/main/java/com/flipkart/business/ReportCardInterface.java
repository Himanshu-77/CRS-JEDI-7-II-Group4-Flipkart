/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.ReportCard;

/**
 * @author Aeron
 *
 */
public interface ReportCardInterface {
	
	/**
	 * Method to get student's SPI
	 * @param RC
	 * @return spi for that semester and student
	 */
	public Float getSPI(ReportCard RC) ;

	
	
}
