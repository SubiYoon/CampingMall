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
	
	
	private String weather_base_date;
	private String weather_base_time;
	private String weather_nx;
	private String weather_ny;
	
	
	public WeatherDTO(String weather_url, String weather_serviceKey, int weahter_pageNo, int weather_numOfRows,
			String weather_dataType, String weather_base_date, String weather_base_time, String weather_nx,
			String weather_ny) {
		super();
		this.weather_url = weather_url;
		this.weather_serviceKey = weather_serviceKey;
		this.weahter_pageNo = weahter_pageNo;
		this.weather_numOfRows = weather_numOfRows;
		this.weather_dataType = weather_dataType;
		this.weather_base_date = weather_base_date;
		this.weather_base_time = weather_base_time;
		this.weather_nx = weather_nx;
		this.weather_ny = weather_ny;
	}
	
	public WeatherDTO(String weather_url, String weather_serviceKey, int weahter_pageNo, int weather_numOfRows,
			String weather_dataType, String weather_redId, String weather_tmFc) {
		super();
		this.weather_url = weather_url;
		this.weather_serviceKey = weather_serviceKey;
		this.weahter_pageNo = weahter_pageNo;
		this.weather_numOfRows = weather_numOfRows;
		this.weather_dataType = weather_dataType;
		this.weather_redId = weather_redId;
		this.weather_tmFc = weather_tmFc;
	}
	
	
	

}
