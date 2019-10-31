/**
 * 
 */
package com.eaus.codingTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaus.codingTest.dto.RecordLabelDTO;
import com.eaus.codingTest.service.RecordLabelService;
import com.eaus.codingTest.utils.APIUtilConstants;

/**
 * @author Aditya
 *
 */

@Controller
public class HomeController {

	@RequestMapping(APIUtilConstants.URI_HOME)
	public String home() {
		return "index";
	}
}



