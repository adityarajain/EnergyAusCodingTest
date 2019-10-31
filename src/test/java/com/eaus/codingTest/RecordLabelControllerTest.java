package com.eaus.codingTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaus.codingTest.dto.RecordLabelDTO;
import com.eaus.codingTest.service.RecordLabelService;
import com.eaus.codingTest.utils.APIUtilConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class RecordLabelControllerTest extends EnergyAusCodingTestApplicationTest {

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	@Test
	public void getRecordsList() throws Exception {
	   String uri = "/recordlabel/getAllRecordLabels";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	}
	
}
