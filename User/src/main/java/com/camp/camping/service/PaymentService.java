package com.camp.camping.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.PaymentDTO;
import com.camp.camping.DTO.UserDTO;
import com.camp.camping.frame.MyMapper;
import com.camp.camping.mapper.PaymentMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class PaymentService implements MyMapper<String, PaymentDTO>{
    @Autowired
    SiteService siteService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    BookService bookService;
    
    @Autowired
    PaymentMapper mapper;
    
    
    
    public static final String IMPORT_TOKEN_URL = "https://api.iamport.kr/users/getToken";
	public static final String IMPORT_PAYMENTINFO_URL = "https://api.iamport.kr/payments/find/";
	public static final String IMPORT_CANCEL_URL = "https://api.iamport.kr/payments/cancel";
	public static final String IMPORT_PREPARE_URL = "https://api.iamport.kr/payments/prepare";
	
	public static final String KEY = "7647446145513332";
	public static final String SECRET = "AQtHugjbjQFwPwwxmjLoxbE78na80LRtkkwEbb0KJEzqa9S7WczSL5pk0ei9h38LtLA404z7bRewKbrU";
	
    
    
    public boolean importready(String stringDate1, String stringDate2, int site_code) {
    	try {
			return siteService.IsOkToReservation(site_code, stringDate1, stringDate2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
    }

    // 아임포트 인증(토큰)을 받아주는 함수
   	public String getImportToken() {
   		String result = "";
   		HttpClient client = HttpClientBuilder.create().build();
   		HttpPost post = new HttpPost(IMPORT_TOKEN_URL);
   		Map<String,String> m  =new HashMap<String,String>();
   		m.put("imp_key", KEY);
   		m.put("imp_secret", SECRET);
   		try {
   			post.setEntity(new UrlEncodedFormEntity(convertParameter(m)));
   			HttpResponse res = (HttpResponse) client.execute(post);
   			ObjectMapper mapper = new ObjectMapper();
   			String body = EntityUtils.toString(res.getEntity());
   			JsonNode rootNode = mapper.readTree(body);
   			JsonNode resNode = rootNode.get("response");
   			result = resNode.get("access_token").asText();
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return result;
   	}
   	
   	// Http요청 파라미터를 만들어 주는 함수
   	private List<NameValuePair> convertParameter(Map<String,String> paramMap){
   		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
   		
   		Set<Entry<String,String>> entries = paramMap.entrySet();
   		
   		for(Entry<String,String> entry : entries) {
   			paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
   		}
   		return paramList;
   	}
   	
   	// 결제취소
   	public int cancelPayment(String token, String mid) {
   		HttpClient client = HttpClientBuilder.create().build();
   		HttpPost post = new HttpPost(IMPORT_CANCEL_URL);
   		Map<String, String> map = new HashMap<String, String>();
   		post.setHeader("Authorization", token);
   		map.put("merchant_uid", mid);
   		String asd = "";
   		try {
   			post.setEntity(new UrlEncodedFormEntity(convertParameter(map)));
   			HttpResponse res = client.execute(post);
   			ObjectMapper mapper = new ObjectMapper();
   			String enty = EntityUtils.toString(res.getEntity());
   			JsonNode rootNode = mapper.readTree(enty);
   			asd = rootNode.get("response").asText();
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		if (asd.equals("null")) {
   			System.err.println("환불실패");
   			return -1;
   		} else {
   			System.err.println("환불성공");
   			return 1;
   		}
   	}
   	
   	// 아임포트 결제정보를 조회해서 결제금액을 뽑아주는 함수
   	public String getAmount(String token, String mId) {
   		String amount = "";
   		HttpClient client = HttpClientBuilder.create().build();
   		HttpGet get = new HttpGet(IMPORT_PAYMENTINFO_URL + mId + "/paid");
   		get.setHeader("Authorization", token);

   		try {
   			HttpResponse res = client.execute(get);
   			ObjectMapper mapper = new ObjectMapper();
   			String body = EntityUtils.toString(res.getEntity());
   			JsonNode rootNode = mapper.readTree(body);
   			JsonNode resNode = rootNode.get("response");
   			amount = resNode.get("amount").asText();
   		} catch (Exception e) {
   			e.printStackTrace();
   		}

   		return amount;
   	}
   	
   	// 아임포트 결제금액 변조는 방지하는 함수
   	public void setHackCheck(String amount,String mId,String token) {
   		HttpClient client = HttpClientBuilder.create().build();
   		HttpPost post = new HttpPost(IMPORT_PREPARE_URL);
   		Map<String,String> m  =new HashMap<String,String>();
   		post.setHeader("Authorization", token);
   		m.put("amount", amount);
   		m.put("merchant_uid", mId);
   		try {
   			post.setEntity(new UrlEncodedFormEntity(convertParameter(m)));
   			HttpResponse res = client.execute(post);
   			ObjectMapper mapper = new ObjectMapper();
   			String body = EntityUtils.toString(res.getEntity());
   			JsonNode rootNode = mapper.readTree(body);
   			System.out.println(rootNode);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}	
   		
   	}
   	
   	public void paybook(BookDTO book) {
   		try {
			bookService.insertBookAndReservation(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
   	}
   	
   	public UserDTO user_select(String n,String t) throws Exception {
   		return userService.selectnt(n,t);
   	}
   	

	@Override
	public void insert(PaymentDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void update(PaymentDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public PaymentDTO select(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<PaymentDTO> selectAll() throws Exception {
		return mapper.selectAll();
	}
	public int selectOk(String k) throws Exception{
		return mapper.selectOk(k);
	}
	
	

	public void payment_insert(PaymentDTO pay) {
		
		try {
			insert(pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
	}

	public void verifyImport_payment(JSONObject jsonobject) {
		String merchant_uid=(String)jsonobject.get("merchant_uid");
		Gson gson=new Gson();
    	PaymentDTO pay=gson.fromJson(jsonobject.toString(), PaymentDTO.class);
    	
		try {
			int result=selectOk(merchant_uid); 
			if(result<1) {
				payment_insert(pay);
			}else {
				update(pay);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
    
}
