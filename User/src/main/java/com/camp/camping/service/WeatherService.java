package com.camp.camping.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.DTO.WeatherDTO;
import com.camp.camping.utility.GpsTransfer;

@Service
public class WeatherService {

	@Autowired
	HomeService serviceH;

	public JSONObject getWeather(int home_code) throws Exception {

		WeatherDTO weather = new WeatherDTO();
		WeatherDTO weather2 = new WeatherDTO();
		WeatherDTO weather3 = new WeatherDTO();

		Date checktime=checktime();
		HomeDTO home = serviceH.select(home_code);
		GpsTransfer xy = new GpsTransfer(home.getHome_longitude(), home.getHome_latitude());
		GpsTransfer.transfer(xy);
		
		SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMdd");
		String date = fourteen_format.format(checktime) + "1800";

		weather.setWeather_url("MidFcstInfoService/getMidLandFcst");
		weather.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");
		weather.setWeahter_pageNo(1);
		weather.setWeather_numOfRows(10);
		weather.setWeather_dataType("JSON");
		weather.setWeather_redId("11B00000");
		weather.setWeather_tmFc(date);

		weather2.setWeather_url("MidFcstInfoService/getMidTa");
		weather2.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");// serviceKey
		weather2.setWeahter_pageNo(1);
		weather2.setWeather_numOfRows(10);
		weather2.setWeather_dataType("JSON");
		weather2.setWeather_redId("11B10101");
		weather2.setWeather_tmFc(date);

		weather3.setWeather_url("VilageFcstInfoService_2.0/getVilageFcst");
		weather3.setWeather_serviceKey("Q3Jb4VLoiLZHahN%2BoYfI%2BerBplbbZ4%2BNN2XrxdjqZ3hNy%2BuAujVtG3s%2F%2BPWq9BiLB5Anfysmb4Kltjhe0bFUCQ%3D%3D");
		weather3.setWeahter_pageNo(1);
		weather3.setWeather_numOfRows(970);
		weather3.setWeather_dataType("JSON");
		date = fourteen_format.format(checktime);
		weather3.setWeather_base_date(date);
		weather3.setWeather_base_time("0200");
		weather3.setWeather_nx((int)xy.getxLat()+"");
		weather3.setWeather_ny((int)xy.getyLon()+"");
		
		JSONArray json1 = getjsondata(weather);
		JSONArray json2 = getjsondata(weather2);
		json2.add(json1.get(0));

		JSONArray json3 = getjsondata(weather3);
		JSONArray list = new JSONArray();

		for (int i = 41; i < json3.size(); i += 290) {
			list.add(json3.get(i));
			list.add(json3.get(i + 7));
			list.add(json3.get(i + 116));
		}

		JSONObject combined = new JSONObject();
		combined.put("json1", json2);
		combined.put("json2", list);

		return combined;
	}

	public JSONArray getjsondata(WeatherDTO weather) throws Exception {

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("http://apis.data.go.kr/1360000/" + weather.getWeather_url());  
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + weather.getWeather_serviceKey());  
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode(weather.getWeahter_pageNo() + "", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode(weather.getWeather_numOfRows() + "", "UTF-8"));  
		urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
				+ URLEncoder.encode(weather.getWeather_dataType() + "", "UTF-8")); 

		if (weather.getWeather_url().equals("VilageFcstInfoService_2.0/getVilageFcst")) {
			urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "="
					+ URLEncoder.encode(weather.getWeather_base_date() + "", "UTF-8"));  
			urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "="
					+ URLEncoder.encode(weather.getWeather_base_time() + "", "UTF-8"));  
			urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "="
					+ URLEncoder.encode(weather.getWeather_nx() + "", "UTF-8"));  
			urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "="
					+ URLEncoder.encode(weather.getWeather_ny() + "", "UTF-8"));  

		} else {
			urlBuilder.append("&" + URLEncoder.encode("regId", "UTF-8") + "=" + URLEncoder.encode(weather.getWeather_redId() + "", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("tmFc", "UTF-8") + "=" + URLEncoder.encode(weather.getWeather_tmFc() + "","UTF-8")); 

		}

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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

		JSONParser parser = new JSONParser();
		JSONObject jo = null;

		jo = (JSONObject) parser.parse(sb.toString());


		JSONObject obj = (JSONObject) jo.get("response");
		JSONObject obj1 = (JSONObject) obj.get("body");
		JSONObject obj2 = (JSONObject) obj1.get("items");
		JSONArray ary = (JSONArray) obj2.get("item");

		return ary;
	}
	
	public Date checktime() throws Exception{
		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time_format = new SimpleDateFormat("yyyyMMddHHmm");
		String date = fourteen_format.format(date_now) + "0600";
		String date2 = time_format.format(date_now);
		Date basic_date06 = time_format.parse(date);
	    Date date2_1 = time_format.parse(date2);
		
		if(basic_date06.after(date2_1)) {
			date_now = new Date(System.currentTimeMillis()-(1000 * 24 * 60 * 60));
			
		}
		
		return date_now;
	}
	
	
	
	
	
	
	
	

}
