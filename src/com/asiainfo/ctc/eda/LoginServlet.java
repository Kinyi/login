package com.asiainfo.ctc.eda;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (checkData(username, password) == 1) {
			request.getSession().setAttribute("user", username);
			response.sendRedirect("/login/index.jsp");
			return;
		}
		
		out.write("用户名或密码不对!");
		response.sendRedirect("/login/login.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public static int checkData(String username, String password) {
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ,加载驱动失败！");
			e.printStackTrace();
		}

		// 连接MySql数据库
		String url = "jdbc:mysql://127.0.0.1:3306/kinyi";
		String db_username = "root";
		String db_password = "admin";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, db_username, db_password);
		} catch (SQLException se) {
			System.out.println("数据库连接失败!");
			se.printStackTrace();
		}

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery("select username,password from namelist where username='" + username + "';");
			while (rs.next()) {
				String name = rs.getString(1);
				String pass = rs.getString(2);
				if (name.equals(username) && pass.equals(password)) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) { // 关闭记录集
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) { // 关闭声明
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) { // 关闭连接对象
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

class DB{
	public static List<User> list = new ArrayList<User>();
	
	static{
		list.add(new User("aaa", "123"));
		list.add(new User("bbb", "123"));
		list.add(new User("ccc", "123"));
	}
	
	public static List<User> getAll(){
		return list;
	}
}