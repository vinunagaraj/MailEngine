package com.geekyants.mailengine.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileToDataBase {
		public static void main(String[] args) throws Exception {
			String fileName = "C:/template.html";
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emailenginedb", "root", "root");
			PreparedStatement pstmt = conn
					.prepareStatement("insert into filePath( file, file_data) values ( ?, ?)");
			pstmt.setString(1, file.getName());
			pstmt.setBinaryStream(2, fis, (int) file.length());
			pstmt.executeUpdate();
		}
	}


