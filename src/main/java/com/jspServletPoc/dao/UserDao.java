package com.jspServletPoc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jspServletPoc.model.User;
import com.jspServletPoc.util.HibernateUtil;


public class UserDao {

	public boolean validateEmail(String emailId) {
		return true;
	}

}
