package com.nt.service;

import jakarta.mail.MessagingException;

public interface IpurchaseOrder {
	public String purchase(String[] items,String[] emailas) throws MessagingException;
	

}
