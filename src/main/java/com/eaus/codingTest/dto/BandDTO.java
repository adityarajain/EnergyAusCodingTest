/**
 * 
 */
package com.eaus.codingTest.dto;

import java.util.List;

/**
 * @author Aditya
 *
 */
public class BandDTO {

	private String name;
	private List<String> festivals;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFestivals() {
		return festivals;
	}
	public void setFestivals(List<String> festivals) {
		this.festivals = festivals;
	}
}
