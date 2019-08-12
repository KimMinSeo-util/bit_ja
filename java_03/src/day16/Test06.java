package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test06 {
	public static void main(String[] args) {
		System.out.println(" main start ");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c://lib//samplesssss.txt");
			System.out.println("파일 준비 완료 ~~~");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("sample.txt 파일을 확인해 주세요 ");
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
					fis = null;
				}				
				System.out.println("자원반납 ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" main end ");
	}
}
