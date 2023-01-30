package lec0130.io.busangoods;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApiExplorer api = ApiExplorer.getInstance();
		api.getApi(1, 100);
		
		JSONBuilder jsonBuilder = JSONBuilder.getInstance();
		
		List<BusanLifeInfo> result = jsonBuilder.getList();
		for(BusanLifeInfo good: result) {
			System.out.println(good);
		}
	}

}
