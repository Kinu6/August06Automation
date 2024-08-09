package MethodPractice;

import java.sql.SQLException;

import GenericUtilities.DataBaseUtility;

public class DButil {

	public static void main(String[] args) throws SQLException {
		DataBaseUtility dUtil= new DataBaseUtility();
		dUtil.executeSelectQuery("select * from users;");

	}

}
