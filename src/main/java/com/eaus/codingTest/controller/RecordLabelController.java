/**
 * 
 */
package com.eaus.codingTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaus.codingTest.dto.RecordLabelDTO;
import com.eaus.codingTest.service.RecordLabelService;
import com.eaus.codingTest.utils.APIUtilConstants;

/**
 * @author Aditya
 *
 */
@RequestMapping(APIUtilConstants.URI_RECORDLABEL)
@RestController
public class RecordLabelController {

	@Autowired
	RecordLabelService recordLabelService;
	
	@RequestMapping(APIUtilConstants.URI_GET_ALL_RECORDLABELS)
	public List<RecordLabelDTO> getAllRecordLabels(){
		return recordLabelService.getAllRecordLabels();
	}
}
