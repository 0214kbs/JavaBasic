package lec0130.io.json;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lec0130.io.xml.Emp;

// json 사용하는 입장임 
public class Test {

	public static void main(String[] args) {
		try {
			File file = new File("./src/lec0130/io/json/emp-list.json");
			FileReader fr = new FileReader(file);	
			
			Type empListType = new TypeToken<ArrayList<Emp>>() {}.getType();
			Gson gson = new Gson();
			List<Emp> empList = gson.fromJson(fr,empListType);
			//Emp.class 대신 empListType
			// List<T> generic 때문에 gson으로 쓸 수 없어서 Type객체를 하나 만들어서 사용해야함 
			
			for (Emp emp : empList) {
				System.out.println(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
