package com.camp.camping.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {
	
	private String weather_url;
	private String weather_serviceKey;
	private int weahter_pageNo;
	private int weather_numOfRows;
	private String weather_dataType;
	private String weather_redId;
	private String weather_tmFc;
	

}
