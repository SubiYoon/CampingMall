package com.camp.camping.Controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
		WeatherDTO weather3=new WeatherDTO();
		
		Date date_now=new Date(System.currentTimeMillis());// 현재시간을 Date형으로 저장
		SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMdd"); 
		String date=fourteen_format.format(date_now)+"0600";
		
		//url
		//getMidLandFcst : 중기육상예보조회
		//getMidTa : 중기기온조회
		weather.setWeather_url("MidFcstInfoService/getMidLandFcst");//url설정
		weather.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");//serviceKey
		weather.setWeahter_pageNo(1);
		weather.setWeather_numOfRows(10);
		weather.setWeather_dataType("JSON");
		weather.setWeather_redId("11B00000");
		weather.setWeather_tmFc(date);
		
		weather2.setWeather_url("MidFcstInfoService/getMidTa");//url설정
		weather2.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");//serviceKey
		weather2.setWeahter_pageNo(1);
		weather2.setWeather_numOfRows(10);
		weather2.setWeather_dataType("JSON");
		weather2.setWeather_redId("11B10101");
		weather2.setWeather_tmFc(date);
		
		weather3.setWeather_url("VilageFcstInfoService_2.0/getVilageFcst");//url설정
		weather3.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");//serviceKey
		weather3.setWeahter_pageNo(1);
		weather3.setWeather_numOfRows(970);
		weather3.setWeather_dataType("JSON");
		date =  fourteen_format.format(date_now);
		weather3.setWeather_base_date(date);
		weather3.setWeather_base_time("0200");
		weather3.setWeather_nx("61");
		weather3.setWeather_ny("129");
		
		
		//날씨예보 ex)맑음,흐림
		JSONObject json1=getjsondata(weather);
		//예상 최고,최저 기온
		JSONObject json2=getjsondata(weather2);
		//오늘,내일,모레 최고,최저 기온
		JSONObject json3=getjsondata(weather3);
		JSONArray list = new JSONArray();
		list.add(json3.get(list));
		System.out.println("list:" + list);
		
		
		
		
		
		
		JSONObject combined = new JSONObject();
		combined.put("json1", json1);
		combined.put("json2", json2);
		combined.put("json3", json3);
		
		
        return combined.toString();
    }
	
	public JSONObject getjsondata(WeatherDTO weather) throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder(); 
		urlBuilder.append("http://apis.data.go.kr/1360000/"+weather.getWeather_url()); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") +"="+weather.getWeather_serviceKey() ); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(weather.getWeahter_pageNo()+"", "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_numOfRows()+"", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_dataType()+"", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
		
		if(weather.getWeather_url().equals("VilageFcstInfoService_2.0/getVilageFcst")) {
			urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_base_date()+"", "UTF-8")); /*‘21년 6월 28일발표*/
	        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_base_time()+"", "UTF-8")); /*05시 발표*/
	        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_nx()+"", "UTF-8")); /*예보지점의 X 좌표값*/
	        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_ny()+"", "UTF-8")); /*예보지점의 Y 좌표값*/
			
		}else {
			urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_redId()+"", "UTF-8")); /*108 전국, 109 서울, 인천, 경기도 등 (활용가이드 하단 참고자료 참조)*/
			urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(weather.getWeather_tmFc()+"", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공*/
			
		}
		
		
		URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("responescode: "+conn.getResponseCode());
        
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
        rd.close();
        conn.disconnect();
		
        JSONParser parser=new JSONParser();
        JSONObject jo=null;
        
        jo=(JSONObject)parser.parse(sb.toString());
		
		
		return jo;
	}
	
	 
	
	
}


	
	
	
	
	

