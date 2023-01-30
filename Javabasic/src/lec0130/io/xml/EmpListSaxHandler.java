package lec0130.io.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//dom parser
// -> xml문서를 memroy에 올려서 처리 -> 위, 아래 / 부모, 자식 이동이 자유로움
// -> but. 무거움

// sax parser
// -> xml 문서를 시작에서 종료 순으로 1번 scan하면서 처리하고 끝!
// -> 가벼움. tag를 만나면 event를 발생시켜서 특성 메소드를 호출해줌 

// xml => ArrayList<Emp> 
public class EmpListSaxHandler extends DefaultHandler{

	List<Emp> empList = new ArrayList<>(); // 미리 만들어 놔야됨
	private Emp emp;
	private String data;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//qName이 emp이면, 
		if("emp".equals(qName)) {
			emp = new Emp();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// qName이 emp, empId, empNm, salary
		switch(qName) {
			case "empID" : emp.setEmpId(data); break;
			case "empNm": emp.setEmpNm(data); break;
			case "salary": emp.setSalary(Integer.parseInt(data)); break;
			case "emp" : 
				empList.add(emp);
//				emp = null;
				break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data =new String(ch,start,length);	
	}

	public List<Emp> getEmpList(){
		return this.empList;
	}
	
}
