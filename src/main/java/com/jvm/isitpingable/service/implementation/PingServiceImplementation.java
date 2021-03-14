/** 
* PingServiceImplementation.java
* 
* 13-Sep-2020
* 4:21:38 pm
* 
*
* @author Saravanan Kalimuthu
* 
*/

package com.jvm.isitpingable.service.implementation;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.jvm.isitpingable.model.ResponseStatus;

import com.jvm.isitpingable.service.PingService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @author Saravanan Kalimuthu
 *
 */
@Service(value = "pingService")
public class PingServiceImplementation implements PingService {

	@Override
	@SneakyThrows
	public ResponseStatus checkAndPingGivenUrl(String urlString) {
		URL urlObj = new URL(urlString);
		
		if ("https".equalsIgnoreCase(urlObj.getProtocol())) {
			return pingHttps(urlObj);
		} else {
			return pingHttp(urlObj);
		}
		
	}

	/**
	 * @param urlObj
	 * @return
	 */
	@SneakyThrows
	private ResponseStatus pingHttp(URL urlObj) {
		boolean result = false;

		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("GET");
		// Set connection timeout
		con.setConnectTimeout(30000);
		con.connect();

		int code = con.getResponseCode();
		if (code == 200) {
			result = true;
		}
		return ResponseStatus.builder().message(con.getResponseMessage()).status(result).build();
	}

	/**
	 * @param urlObj
	 * @return
	 */
	@SneakyThrows
	private ResponseStatus pingHttps(URL urlObj) {
		boolean result = false;
		
		HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();
		con.setRequestMethod("GET");
		// Set connection timeout
		con.setConnectTimeout(30000);
		con.connect();

		int code = con.getResponseCode();
		if (code == 200) {
			result = true;
		}
		return ResponseStatus.builder().message(con.getResponseMessage()).status(result).build();
	}

}
