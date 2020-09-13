/** 
* PingController.java
* 
* 13-Sep-2020
* 3:41:32 pm
* 
* @author Saravanan Kalimuthu
* 
*/

package com.jvm.isitpingable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jvm.isitpingable.model.ResponseStatus;
import com.jvm.isitpingable.service.PingService;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

/**
 * @author Saravanan Kalimuthu
 *
 */
@RestController
@RequestMapping(value = "/ping")
@Log4j2
public class PingController {

	@Autowired
	private PingService pingService;

	@PostMapping("/url")
	public ResponseEntity<ResponseStatus> pingGivenUrl(
			@NonNull @RequestParam(required = true, value = "url") String url) {
		log.debug("Ping Url: {}", url);
		return ResponseEntity.ok().body(pingService.checkAndPingGivenUrl(url));
	}

}
