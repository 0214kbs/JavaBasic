package lec0127.io.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp("111","hkd",40000));
		empList.add(new Emp("222","lkd",50000));
		empList.add(new Emp("333","kkd",60000));
		empList.add(new Emp("444","skd",70000));
		
		//CSV file
		String fileDir = "C:" + File.separator+"mydir";
		String fileName = "empList.csv";
		
		File file = new File(fileDir);
		if(!file.exists()) {
			file.mkdir();
		}
		try(
			BufferedWriter writer = 
				new BufferedWriter(
						new OutputStreamWriter( // encoding 처리 꼭! 해줘야 됨 
								new FileOutputStream(fileDir+File.separator+fileName),"MS949")) 		
		){
			for(Emp emp: empList) {
				writer.write(emp.empId+"^"+emp.empNm+"^"+emp.salary);
				writer.newLine();
			}
			writer.flush();
			System.out.println("csv 파일이 생성되었습니다. ");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static class Emp{
		String empId;
		String empNm;
		int salary;
		
		public Emp() {}

		public Emp(String empId, String empNm, int salary) {
			super();
			this.empId = empId;
			this.empNm = empNm;
			this.salary = salary;
		}
		
	}
}
