package com.camp.camping.Controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camp.camping.DTO.WeatherDTO;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@GetMapping("/getweather")
	public String getWeather() throws Exception{
		
		WeatherDTO weather=new WeatherDTO();
		WeatherDTO weather2=new WeatherDTO();
		//url
		//getMidLandFcst : 중기육상예보조회
		//getMidTa : 중기기온조회
		weather.setWeather_url("getMidLandFcst");//url설정
		weather.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");//serviceKey
		weather.setWeahter_pageNo(1);
		weather.setWeather_numOfRows(10);
		weather.setWeather_dataType("JSON");
		weather.setWeather_redId("11B00000");
		weather.setWeather_tmFc("202301190600");
		
		weather2.setWeather_url("getMidTa");//url설정
		weather2.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");//serviceKey
		weather2.setWeahter_pageNo(1);
		weather2.setWeather_numOfRows(10);
		weather2.setWeather_dataType("JSON");
		weather2.setWeather_redId("11B10101");
		weather2.setWeather_tmFc("202301190600");
		
		
        URL url = new URL(getDataUrl(weather2));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        
        
        conn.disconnect();
        
        
        
        
        rd.close();
        System.out.println(sb.toString());
        return sb.toString();
    }
	
	public String getDataUrl(WeatherDTO weather) throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder(); 
		urlBuilder.append("http://apis.data.go.kr/1360000/MidFcstInfoService/"+weather.getWeather_url()); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") +"="+weather.getWeather_serviceKey() ); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(weather.getWeahter_pageNo()+"", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_numOfRows()+"", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_dataType()+"", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_redId()+"", "UTF-8")); /*108 전국, 109 서울, 인천, 경기도 등 (활용가이드 하단 참고자료 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_tmFc()+"", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공*/
        
		System.out.println(urlBuilder.toString());
		return urlBuilder.toString();
	}
	
	
	
	
	
	
	
}


	
	
	
	
	

