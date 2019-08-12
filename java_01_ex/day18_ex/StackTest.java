package day18_ex;

public class StackTest {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>(10);
		if(stack.isEmpty()){
			System.out.println("스택이 비어있습니다.");
		}
		
		for (int i = 1; i <= 33; i++) {
			stack.push(i);
		}
		
		if(stack.isFull()){
			System.out.println("스택이 가득 찼습니다.");
		}
		
		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
		for (int i = 1; i <= 10; i++) {
			int num = stack.pop();
			if(num != -1)
				System.out.println(num);
		}
	}
}

class MyStack2{
	int[] stack;
    int top = 0;
    
	MyStack2(){
		stack = new int[10];
	}
	MyStack2(int size){
		if(size < 0)
		    stack = new int[10];
		else 
			stack = new int[size];
	}	
	
	boolean isEmpty() {
		return top == 0 ? true:false;
	}
			
	boolean isFull(){
		return top == stack.length ? true : false;
	}
	
	void push(int data){
		if(isFull()) {
			//System.out.println("stack is full ...");
			return;
		}
		stack[top] = data;
		top++;
	}

	int top(){
		if(isEmpty()) return -1;
		return stack[top-1];
	}

	int pop(){
		if(isEmpty()) return -1;
		return stack[--top];
	}
}













