package day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test06_Command_Map {
	public static void main(String[] args) {
		// Map 구조로 설계 

		Map<String, Command> map = new HashMap<String, Command>();
		map.put("delete", new DeleteCommand());
		map.put("update", new UpdateCommand());
		map.put("select", new SelectCommand());
		map.put("insert", new InsertCommand());
		map.put("new"   , new Command() {
								@Override
								public void exec() {
									System.out.println(" 기능 추가 ");
								}
						  } );
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("delete update select insert new 중 하나 입력 하세요 ");
		String cmd = scanner.nextLine(); // delete update select insert

		Command command = map.get(cmd);
		if(command != null)	command.exec();
		
		
	}
}




