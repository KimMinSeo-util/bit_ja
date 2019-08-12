package day25_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Test02 {

	public static void main(String[] args) {
		String address = "https://www.naver.com/index.html";
		String line = null;

		URL url = null;
		BufferedReader br = null;

		try {
            url = new URL(address);
            br =  new BufferedReader(new InputStreamReader(url.openStream()));
			
            while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
             try {
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}




