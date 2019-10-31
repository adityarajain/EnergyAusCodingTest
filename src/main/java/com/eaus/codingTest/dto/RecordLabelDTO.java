/**
 * 
 */
package com.eaus.codingTest.dto;

import java.util.List;

/**
 * @author Aditya
 *
 */
public class RecordLabelDTO {

	private String name;
	private List<BandDTO> bands;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BandDTO> getBands() {
		return bands;
	}
	public void setBands(List<BandDTO> bands) {
		this.bands = bands;
	}
}
