package lec0127.stream;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;

public class SimpleInputTest {
	private String data1 = "hi java world";
	private String data2 = "자바는 객체 지향 언어입니다. ";
	
	private void read1() {
		try(InputStream input = new ByteArrayInputStream(data1.getBytes())){
			int read = -1;
			while((read=input.read())!=-1) {
				System.out.printf("read value : %d, %c\n",read, read);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	private void read2() {
		
		byte [] buffer = new byte[10];
		try(InputStream input = new ByteArrayInputStream(data1.getBytes())){
			int read = -1;
			while((read=input.read(buffer))>0) {
				System.out.printf("읽은 개수 : %d, %s\n",read, new String(buffer, 0, read));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	private void read3() {
		// 한글 처리는 byte는 X  char로 처리할 것 
		// why? UTF-8 한글은 한글자가 3byte이기 때문
		char [] buffer = new char[10];
		try(CharArrayReader input = new CharArrayReader(data2.toCharArray())){
			int read = -1;
			while((read=input.read(buffer))>0) {
				System.out.printf("읽은 개수 : %d, %s\n",read, new String(buffer, 0, read));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		SimpleInputTest sit = new SimpleInputTest();
		
//		sit.read1();
//		sit.read2();
		sit.read3();
	}
}
