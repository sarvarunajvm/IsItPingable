/** 
* ResponseStatus.java
* 
* 13-Sep-2020
* 4:17:20 pm
* 
*
* @author Saravanan Kalimuthu
* 
*/

package com.jvm.isitpingable.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Saravanan Kalimuthu
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {

	private boolean status;

	private Object result;

	private String message;

}
