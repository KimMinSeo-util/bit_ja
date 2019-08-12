package day23;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test05 {
	public static void main(String[] args) {
		String fileName = "account.obj";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			Set<Account> set = new HashSet<Account>();
			
			Account a = new Account("2019-001", "홍길동", 100, "1234");
			Account b = new Account("2019-002", "박길동", 1000, "1111");
			set.add(a);
			set.add(b);
			set.add(a);
			set.add(new Account("2019-004", "최길동", 2000, "9999"));
			
			oos.writeObject(set);
			oos.flush();
			System.out.println(" 파일에 저장되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (Exception e2) {
               e2.printStackTrace();
			}
		}
		
        System.out.println("  main end ");
	}
	
}

class Account extends Object implements Serializable{
	String number;
	String name;
	int money;
	transient String pw;
	
	public Account() {}
	public Account(String number, String name, int money, String pw) {
		this.number = number;
		this.name = name;
		this.money = money;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", money=" + money + ", pw=" + pw + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	
	
}













//public static void main(String[] args) {
//	String fileName = "data.obj";
//	FileOutputStream fis = null;
//	ObjectOutputStream oos = null;
//	
//	try {
//		
//	} catch (Exception e) {
//		System.out.println(e.getMessage());
//	} finally {
//		try {
//			if(oos != null) oos.close();
//			if(fis != null) fis.close();
//		} catch (Exception e2) {
//           e2.printStackTrace();
//		}
//	}
//	
//
//}