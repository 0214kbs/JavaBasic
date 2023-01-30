package lec0130.io.busangoods;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class JSONBuilder {
	private final File saveFile = new File("./src/lec0130/io/busangoods/goods.json");
	
	private JSONBuilder() {}
	
	private static JSONBuilder instance = new JSONBuilder();
	public static JSONBuilder getInstance() {
		return instance;
	}
	
	public List<BusanLifeInfo> getList() {
		List<BusanLifeInfo> result = null;
		
		try {
			FileReader fr = new FileReader(saveFile);
			Type resultListType = new TypeToken<ArrayList<BusanLifeInfo>>() {}.getType();
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			JsonDeserializer<List<BusanLifeInfo>> deserializer = new JsonDeserializer<List<BusanLifeInfo>>() {
				@Override
				public List<BusanLifeInfo> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
					JsonObject jsonObject = json.getAsJsonObject();
					List<BusanLifeInfo> listBusan = new ArrayList<>();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					try {
						JsonArray arr = jsonObject.getAsJsonObject("getLifeInfo").getAsJsonObject("body").getAsJsonObject("items").getAsJsonArray("item");
						for(JsonElement elem: arr) {
							JsonObject obj = elem.getAsJsonObject();
							
							listBusan.add(
									new BusanLifeInfo(
											obj.get("pumNm").getAsString(), 
											obj.get("itemName").getAsString(),
											obj.get("unitprice").getAsInt() / Double.parseDouble(obj.get("unit").getAsString()),
											obj.get("bsshNm").getAsString(),
											format.parse(obj.get("examinDe").getAsString())
									));
							
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return listBusan;
				}
			};
			gsonBuilder.registerTypeAdapter(resultListType, deserializer);
			
			Gson customGson = gsonBuilder.create();
			result = customGson.fromJson(fr, resultListType);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
