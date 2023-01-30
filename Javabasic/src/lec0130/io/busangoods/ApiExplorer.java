package lec0130.io.busangoods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ApiExplorer {
	private final Path saveFile = Paths.get("./src/lec0130/io/busangoods/goods.json");
	
	private final String serviceUrl = "http://apis.data.go.kr/6260000/BusanLifeInfoService/getLifeInfo";
	private final String serviceKey = "oHL5sBEv06tGIQKFJb9MczAoDgBw8GGNABkr9/Coy3CEjhK0n6HuN99ehYvrdxVukQ07b6DbJHRZSnMaRPQOLg==";
	
	private ApiExplorer() {
		try {
			if( Files.exists(saveFile) ) {
				Files.delete(saveFile);
				System.out.println("전에 저장되어 있던 json 파일을 삭제했습니다.");
			}
			Files.createFile(saveFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ApiExplorer instance = new ApiExplorer();
	public static ApiExplorer getInstance() {
		return instance;
	}
	
	public void getApi(int pageNum, int numOfRows) {
		StringBuilder urlBuilder = new StringBuilder(serviceUrl);
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(String.valueOf(numOfRows), "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(String.valueOf(pageNum), "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			
			URL url = new URL(urlBuilder.toString());
//			System.out.println(urlBuilder);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/xml");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        String line;
	        while ((line = rd.readLine()) != null) {
	        	Files.write(saveFile, line.getBytes(), StandardOpenOption.APPEND);
	        	Files.write(saveFile, System.lineSeparator().getBytes("UTF-8"), StandardOpenOption.APPEND);
	        }
	        
	        rd.close();
	        conn.disconnect();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		
	}
}
