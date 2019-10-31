/**
 * 
 */
package com.eaus.codingTest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


import com.eaus.codingTest.dto.BandDTO;
import com.eaus.codingTest.dto.BandsBeanFlattened;
import com.eaus.codingTest.dto.RecordLabelDTO;
import com.eaus.codingTest.entity.BandBean;
import com.eaus.codingTest.entity.MusicFestivalBean;

/**
 * @author Aditya
 *
 */
@Service
public class RecordLabelServiceImpl implements RecordLabelService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${energyAus.festival.uri}")
	private String restUri;

	@Value("${energyAus.festival.get.api.endpoint}")
	private String restUriGetEndpoint;

	@Autowired
	public List<RecordLabelDTO> getAllRecordLabels() {
		List<RecordLabelDTO> recordLabelDTOList = new ArrayList<RecordLabelDTO>();
		List<MusicFestivalBean> festivalBeanList = new ArrayList<MusicFestivalBean>();

		try {
			// consume web service exposed by energy australia team here
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ResponseEntity<MusicFestivalBean[]> respEntity = restTemplate.exchange(restUri+restUriGetEndpoint,
					HttpMethod.GET, entity, MusicFestivalBean[].class);

			festivalBeanList = (respEntity != null)
					? ((respEntity.getBody() != null) ? Arrays.asList(respEntity.getBody()) : Collections.emptyList())
					: Collections.emptyList();
			respEntity=null;
		} catch (HttpClientErrorException hce) {
			hce.printStackTrace();
		} catch (HttpServerErrorException hse) {
			hse.printStackTrace();
		}
		// manipulate data received from webservices to DTO objects
		if (festivalBeanList.size() > 0)
			recordLabelDTOList = convertURIResponseToDTOObjects(festivalBeanList);

		// return the data in dto structure
		return recordLabelDTOList;
	}
	
	public List<RecordLabelDTO> convertURIResponseToDTOObjects(List<MusicFestivalBean> festivalBeanList) {
		List<RecordLabelDTO> recordLabelDTOList = new ArrayList<RecordLabelDTO>();
		List<BandsBeanFlattened> bandsBeanList = new ArrayList<BandsBeanFlattened>();

		//festivalBeanList = mockData();

		// push festivlanme to bands list
		for (MusicFestivalBean mfb : festivalBeanList) {
			for (BandBean bb : mfb.getBands()) {
				BandsBeanFlattened bbf = new BandsBeanFlattened();
				bbf.setName((bb.getName() != null) ? bb.getName() : "");
				bbf.setRecordLabel((bb.getRecordLabel() != null) ? bb.getRecordLabel() : "");
				bbf.setFestivalNameLabel((mfb.getName() != null) ? mfb.getName() : "");

				bandsBeanList.add(bbf);
			}
		}
		// find all record labels in a list
		List<String> recordLabelsList = bandsBeanList.stream().map(BandsBeanFlattened::getRecordLabel).distinct()
				.collect(Collectors.toList());

		// group bands based on record label
		for (String recordLabelName : recordLabelsList) {
			RecordLabelDTO rlDto = new RecordLabelDTO();
			List<BandsBeanFlattened> recordLabelListGrouped = bandsBeanList.stream()
					.filter(band -> recordLabelName.equalsIgnoreCase(band.getRecordLabel()))
					.collect(Collectors.toList());
			List<String> bandNameList = recordLabelListGrouped.stream().map(BandsBeanFlattened::getName).distinct()
					.collect(Collectors.toList());
			List<BandDTO> bandsDTOList = new ArrayList<BandDTO>();
			for (String bandName : bandNameList) {
				List<String> festNameListGrouped = recordLabelListGrouped.stream()
						.filter(band -> bandName.equalsIgnoreCase(band.getName()))
						.map(BandsBeanFlattened::getFestivalNameLabel).distinct().collect(Collectors.toList());
				BandDTO bandDto = new BandDTO();
				bandDto.setFestivals(festNameListGrouped);
				bandDto.setName(bandName);
				bandsDTOList.add(bandDto);
			}
			rlDto.setBands(bandsDTOList);
			rlDto.setName(recordLabelName);
			recordLabelDTOList.add(rlDto);
		}

		return recordLabelDTOList;
	}
}
