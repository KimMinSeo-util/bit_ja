package day15;

import javax.swing.JOptionPane;

public class Test06 {
	public static void main(String[] args) {
		String msg = JOptionPane.showInputDialog("1.list 2.update 3.delete 4.insert q.quit");
		
		//<람다식>command(interface)안에 추상 클래스가 딱 1개 있을 때에만 람다표현가능
		//변수에 함수를 바인딩시키는 것
		Command list = () -> System.out.println(" *** list *** ");
		Command update = () -> System.out.println(" *** update *** ");
			
		//<원래는 아래처럼 긴 구조에서 위에 짧은 람다식으로 변경>
		Command insert = new Command() {
			@Override
			public void exec() {
				System.out.println(" *** insert *** ");
			}
		};
		Command delete = new Command() {
			@Override
			public void exec() {
				System.out.println(" *** delete *** ");
			}
		};
		switch (msg) {
		case "1":
			list.exec();
			break;
		case "2":
			update.exec();
			break;
		case "3":
			delete.exec();
			break;
		case "4":
			insert.exec();
			break;
		default:
			break;
		}
	}

}
