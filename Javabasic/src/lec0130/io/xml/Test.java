package lec0130.io.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test {
	public static void main(String[] args) {
		File file = new File("./src/lec0130/io/xml/emp-list.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			// 파서 문서를 뒤지고 처리하는 기본 클래스 
			// 이 파서가 처리하면서 태그를 만나면 호출하는 메소드를 가지고 있는 클래스 : EmpListSaxHandler
			// 파서는 태그를 만나서 핸들러에 있는 메소드를 호출한다. 
			SAXParser saxParser = saxParserFactory.newSAXParser();
			
			// 핸들러 만듦
			EmpListSaxHandler handler = new EmpListSaxHandler();
			
			// 파서의 입력 2개 : xml, handler
			saxParser.parse(file, handler);
		
			// 파서의 작업이 완료되면 우리가 필요한 List<Emp>를 얻으면 끝
			List<Emp> empList = handler.getEmpList();
			
			for (Emp emp : empList) {
				System.out.println(emp);
			}
		}catch(IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
