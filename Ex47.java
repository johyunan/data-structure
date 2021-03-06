import java.awt.*;
import javax.swing.*;

class TimerThread implements Runnable /*extends Thread*/{
	int value = 10000;//동시에 수행이 될 경우 공유 변수(공유자원)
	//--> 공유자원의 동시 접근을 막기 위하여 
	//synchronized를 사용하거나 wait(), notify() 사용
	
	public void run() {
		int n = 0;
		while(true) {
			System.out.println(n + "value " + value);
			++n;
			synchronized(this) {//공유자원을 한번에 하나씩 접근하여 사용할 수 있다.
			value += n; // 인스턴스 변수에 접근
			} //이걸 적어줘야 반드시 하나만 접근할 수 있따.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//imterface Runnable 사용하는 경우 필요(외부에서 스레드를 실행시킬때)
	void start() {
		Thread thread = new Thread(this); //runnable 구현 클래스 생성자인자로 넣어줌
		thread.start();
	}	
}

public class Ex47 {

	public static void main(String[] args) {
		/*Thread를 상속받아서 사용하는 경우
		TimerThread t = new TimerThread();
		//TimerThread t2 = new TimerThread(); 
		  //인스턴스가 별도로 만들어 지므로 다른 스레드로 동작한다.
		t.start();
		//t2.start();
		 * */ //얘는 인스턴스가 만들어져서 수행되는것
		//interface Runnable 이용하여 구현하는 경우
		TimerThread t = new TimerThread();
		t.start(); //thread가 생성되고 동작
		t.start(); //새로운 thread가 생성되고 동작
		//얘는 스레드가 새로 만들어져서 수행되는 것
	}

}
