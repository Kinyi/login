package com.asiainfo.ctc.eda;

import java.util.List;

import javax.xml.ws.BindingType;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;
@BindingType("http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class Test {

	public static void main(String[] args) {
		WeatherWS factory = new WeatherWS();
		WeatherWSSoap weatherWSSoap = factory.getWeatherWSSoap();
		ArrayOfString weather = weatherWSSoap.getWeather("±±¾©", null);
		List<String> list = weather.getString();
		for (String string : list) {
			System.out.println(string);
			System.out.println("------------");
		}
	}
}
