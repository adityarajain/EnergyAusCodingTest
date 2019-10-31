/**
 * 
 */
package com.eaus.codingTest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Aditya
 *
 */
public class BandsBeanFlattened {

	private String name;
	private String recordLabel;
	private String festivalNameLabel;
	
	/**
	 * @return the festivalNameLabel
	 */
	public String getFestivalNameLabel() {
		return festivalNameLabel;
	}
	/**
	 * @param festivalNameLabel the festivalNameLabel to set
	 */
	public void setFestivalNameLabel(String festivalNameLabel) {
		this.festivalNameLabel = festivalNameLabel;
	}
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
