package lec0127.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharBinaryTest {
	public static void main(String[] args) throws Exception {
		// char - File 내용을 읽고 쓰기 
		/*
		{ 
			String myDir = "C:"+File.separator+"mydir"; 
			File charFile = new File(myDir, "char.txt"); 
			
			
			// file char write
			if(!charFile.exists())  {
				boolean success = charFile.createNewFile();
				if(success)  System.out.println("File created");
			}			
			try(FileWriter fw = new FileWriter(charFile)){
				fw.write("Hello, 안녕!");
				System.out.println("File에 write!");
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			
			// file char read
			try(FileReader fr = new FileReader(charFile)){
				int ch;
				StringBuilder sb = new StringBuilder();
				while((ch=fr.read()) != -1) {
					sb.append((char)ch);
				}
				System.out.println(sb.toString());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// binary - 이미지 파일 복사 
		/*
		{
			String myDir = "C:"+File.separator+"mydir"; 
			// 복사: src-> tgt
			File srcFile = new File(myDir, "dog.jpg");
			File tgtFile = new File(myDir, "dog_copy.jpg");
			
			try(
				FileInputStream fis = new FileInputStream(srcFile); //read 
				FileOutputStream fos = new FileOutputStream(tgtFile); //write 
			){
				int read = -1;
				while((read = fis.read())!= -1) {
					fos.write(read);
				}
				System.out.println("File copied!");
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		
		// buffer 
		{
			String srcFile = "src/lec0127/io/file/buffer.txt";
			try(
				FileReader fr = new FileReader(srcFile);
				BufferedReader br = new BufferedReader(fr);
			){
				String str = null;
				StringBuilder sb = new StringBuilder();
				while((str = br.readLine())!= null) {
					sb.append(str).append("\n");
				}
				System.out.println(sb);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
