package generic;
// generic => Collections <- 어떤 객체를 담는 자료 구조 
// A 객체를 담거나, B 객체를 담거나 ... 모든 타입의 객체를 담으려면???
// 많고 다양한 객체를 담고싶을 때!
public class ObjectContainer {
	private Object element;

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	
}
