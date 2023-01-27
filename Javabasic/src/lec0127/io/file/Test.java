package lec0127.io.file;

import java.io.File;

public class Test {
	public static void main(String[] args) throws Exception{
		// #1 폴더 생성 및 존재 여부 확인
		String dirName = "C:"+File.separator+"mydir"; 
		// File.separator : File 구분자 (OS마다 구분자가 다르기 때문에, seperator를 통해 프로그램이 실행중인 OS에 해당하는 구분자를 리턴)
		File file1 = new File(dirName); // file, folder 2가지 모두 커버
		
		// 폴더가 존재하면 존재한다는 메시지 출력. 존재하지 않으면 폴더를 생성
		if(file1.exists()) System.out.println("Folder exists");
		else {
			boolean success = file1.mkdir();
			if(success) System.out.println("Folder created");
		}
		
		// #2 파일 생성 및 존재 여부 확인
		File file2 = new File(dirName, "char.txt"); // File(directory 이름, "파일이름");
		if(file2.exists()) System.out.println("File exists");
		else {
			boolean success = file2.createNewFile(); //e.m. Unhandled exception type IOException
			if(success)  System.out.println("File created");
		}
		
		// #3 파일 삭제
		File file3 = new File(dirName, "char.txt");
		if(!file3.exists()) System.out.println("File Not exists!");
		else {
			boolean success = file3.delete();
			if(success) System.out.println("File deleted");
		}
	}
}
