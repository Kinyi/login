package cn.com.webxml;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>
 * 2400多个城市天气预报Web服务</strong>，包含2300个以上中国城市和100个以上国外城市天气预报数据。数据每2.5小时左右自动更新一次
 * ，准确可靠。<br />
 * 使用本站 WEB 服务请注明或链接本站：<a href="http://www.webxml.com.cn/"
 * target="_blank">http://www.webxml.com.cn/</a> 感谢大家的支持！<br />
 * <br />
 * <img alt="PDF" title="PDF file"
 * src="http://www.webxml.com.cn/images/icon/pdf.gif"
 * style="vertical-align: middle;" /> <a
 * href="http://www.webxml.com.cn/files/WeatherWsHelp.pdf"
 * target="_blank">接口帮助文档</a> &nbsp;&nbsp;&nbsp; <img alt="ZIP" title="ZIP file"
 * src="http://www.webxml.com.cn/images/icon/zip.gif"
 * style="vertical-align: middle;" /> <a
 * href="http://www.webxml.com.cn/files/about_city.zip">部分城市介绍和气候背景</a>
 * &nbsp;&nbsp;&nbsp; <img alt="ZIP" title="ZIP file"
 * src="http://www.webxml.com.cn/images/icon/zip.gif"
 * style="vertical-align: middle;" /> <a
 * href="http://www.webxml.com.cn/files/city_photo.zip">部分城市图片</a>
 * &nbsp;&nbsp;&nbsp; <img alt="HTML" title="HTML file"
 * src="http://www.webxml.com.cn/images/icon/html.gif"
 * style="vertical-align: middle;" /> <a
 * href="http://www.webxml.com.cn/zh_cn/weather_icon.aspx"
 * target="_blank">天气现象和图例</a><br />
 * &nbsp;
 * 
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * WeatherWS service = new WeatherWS();
 * WeatherWSSoap portType = service.getWeatherWSSoap();
 * portType.getRegionDataset(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "WeatherWS", targetNamespace = "http://WebXml.com.cn/", wsdlLocation = "file:/E:/kinyi/MyEclipse%208.5/Workspaces/login/weather.wsdl")
public class WeatherWS extends Service {

	private final static URL WEATHERWS_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(cn.com.webxml.WeatherWS.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = cn.com.webxml.WeatherWS.class.getResource(".");
			url = new URL(baseUrl,
					"file:/E:/kinyi/MyEclipse%208.5/Workspaces/login/weather.wsdl");
		} catch (MalformedURLException e) {
			logger
					.warning("Failed to create URL for the wsdl Location: 'file:/E:/kinyi/MyEclipse%208.5/Workspaces/login/weather.wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		WEATHERWS_WSDL_LOCATION = url;
	}

	public WeatherWS(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public WeatherWS() {
		super(WEATHERWS_WSDL_LOCATION, new QName("http://WebXml.com.cn/",
				"WeatherWS"));
	}

	/**
	 * 
	 * @return returns WeatherWSSoap
	 */
	@WebEndpoint(name = "WeatherWSSoap")
	public WeatherWSSoap getWeatherWSSoap() {
		return super.getPort(
				new QName("http://WebXml.com.cn/", "WeatherWSSoap"),
				WeatherWSSoap.class);
	}

	/**
	 * 
	 * @return returns WeatherWSSoap
	 */
	@WebEndpoint(name = "WeatherWSSoap12")
	public WeatherWSSoap getWeatherWSSoap12() {
		return super.getPort(new QName("http://WebXml.com.cn/",
				"WeatherWSSoap12"), WeatherWSSoap.class);
	}

	/**
	 * 
	 * @return returns WeatherWSHttpGet
	 */
	@WebEndpoint(name = "WeatherWSHttpGet")
	public WeatherWSHttpGet getWeatherWSHttpGet() {
		return super.getPort(new QName("http://WebXml.com.cn/",
				"WeatherWSHttpGet"), WeatherWSHttpGet.class);
	}

	/**
	 * 
	 * @return returns WeatherWSHttpPost
	 */
	@WebEndpoint(name = "WeatherWSHttpPost")
	public WeatherWSHttpPost getWeatherWSHttpPost() {
		return super.getPort(new QName("http://WebXml.com.cn/",
				"WeatherWSHttpPost"), WeatherWSHttpPost.class);
	}

}
