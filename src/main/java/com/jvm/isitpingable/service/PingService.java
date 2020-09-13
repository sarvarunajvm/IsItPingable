/** 
* PingService.java
* 
* 13-Sep-2020
* 4:12:00 pm
* 
*
* @author Saravanan Kalimuthu
* 
*/

package com.jvm.isitpingable.service;

import org.springframework.stereotype.Service;

import com.jvm.isitpingable.model.ResponseStatus;

/**
 * @author Saravanan Kalimuthu
 *
 */
@Service
public interface PingService {
	
	ResponseStatus checkAndPingGivenUrl(String urlString);

}
