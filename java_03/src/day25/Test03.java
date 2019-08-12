package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Test03 {

	public static void main(String[] args) {
		String address = "https://www.naver.com/index.html";
		String line = null;

		URL url = null;
		BufferedReader br = null;
        BufferedWriter bw = null;
		try {
            url = new URL(address);
            br =  new BufferedReader(new InputStreamReader(url.openStream()));
			bw = new BufferedWriter(new FileWriter("naver.html"));
            
            while ((line = br.readLine()) != null) {
				System.out.println(line);
				bw.write(line+"\n");
			}
            bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
             try {
				if(br != null) br.close();
				if(bw != null) bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}




