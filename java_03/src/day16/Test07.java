package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		System.out.println(" main start ");
		Scanner scanner =null;
		try {
			scanner = new Scanner(new File("c://lib//sample.txt"));
			while(scanner.hasNextLine()) {
				String[] data = scanner
						.nextLine().replace('_','/').split("/");
				System.out.println(Arrays.toString(data));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(scanner != null)scanner.close();
			scanner=null;
			System.out.println("자원반납수행");
		}
		System.out.println(" main end ");
	}
}
