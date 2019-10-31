/**
 * 
 */
package com.eaus.codingTest.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aditya
 *
 */
@JsonIgnoreProperties
@XmlRootElement
public class MusicFestivalBean {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("bands")
	private List<BandBean> bands;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bands
	 */
	public List<BandBean> getBands() {
		return bands;
	}
	/**
	 * @param bands the bands to set
	 */
	public void setBands(List<BandBean> bands) {
		this.bands = bands;
	}
}
