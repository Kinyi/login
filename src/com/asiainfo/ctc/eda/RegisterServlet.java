package com.asiainfo.ctc.eda;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int flag = insertData(username, password);
		if (flag == 1) {
			out.write("ע��ɹ�!�뷵�ص�¼");
		}else {
			out.write("ע��ʧ��!�û����Ѵ���");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public static int insertData(String username, String password) {
		try {
			// ����MySql��������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("�Ҳ������������� ,��������ʧ�ܣ�");
			e.printStackTrace();
		}

		// ����MySql���ݿ�
		String url = "jdbc:mysql://127.0.0.1:3306/kinyi";
		String db_username = "root";
		String db_password = "admin";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, db_username, db_password);
		} catch (SQLException se) {
			System.out.println("���ݿ�����ʧ��!");
			se.printStackTrace();
		}

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery("select count(1) from namelist where username='"	+ username + "';");
			while (rs.next()) {
				String pass = rs.getString(1);
				if (Integer.parseInt(pass) != 0) {
					return 0;
				} else {
					stmt.execute("insert into namelist(username,password) values('" + username + "','" + password + "');");
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) { // �رռ�¼��
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) { // �ر�����
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) { // �ر����Ӷ���
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 2;
	}
}