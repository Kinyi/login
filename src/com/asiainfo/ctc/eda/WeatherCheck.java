package com.asiainfo.ctc.eda;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class WeatherCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		
//		String city = request.getParameter("city");
		
//		response.getWriter().write(city);
		
		WeatherWS factory = new WeatherWS();
		WeatherWSSoap weatherWSSoap = factory.getWeatherWSSoap();
//		ArrayOfString weather = weatherWSSoap.getWeather(city, null);
		ArrayOfString weather = weatherWSSoap.getWeather("±±¾©", null);
		List<String> list = weather.getString();
		
		request.getSession().setAttribute("list", list);
		response.sendRedirect("/login/weather.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
