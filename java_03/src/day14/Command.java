package day14;

public interface Command {
	public void exec();

	// interface안에는 추상메소드안에 default추가 가능하다 static메소드처럼 생김
	default public void check() {
		System.out.println("Command  check() 함수");
	}
}

class DeleteCommand implements Command {
	@Override
	public void exec() {
		System.out.println("Delete(삭제) 수행");
	}

	public void check() {
		System.out.println("Command  check() 함수");
	}
}

class InsertCommand implements Command {
	@Override
	public void exec() {
		System.out.println("Insert(등록) 수행");
	}
}

class UpdateCommand implements Command {
	@Override
	public void exec() {
		System.out.println("Update(수정) 수행");
	}
}

class ListCommand implements Command {
	@Override
	public void exec() {
		System.out.println("List(목록) 수행");
	}
}
