/**
 * 
 */
package com.eaus.codingTest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aditya
 *
 */
@JsonIgnoreProperties
public class BandBean {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("recordLabel")
	private String recordLabel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecordLabel() {
		return recordLabel;
	}
	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
}
