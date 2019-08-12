package day23_ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFile {

	public synchronized static void save(String fileName,Object obj) {
		FileOutputStream fos  = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            System.out.println(obj +"객체가 " +fileName +"file에  저장되었습니다. ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public synchronized static Object load(String fileName){
		FileInputStream fis  = null;
		ObjectInputStream ois = null;
		Object data = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			data = ois.readObject();
			System.out.println(fileName+" 파일로부터 "+ data+" Load 완료 " );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}













