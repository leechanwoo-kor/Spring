package spring.chap06.common;

public class CommonLoggerImpl implements CommonLogger {

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		System.out.println("CommonLogger - " + message);
	}
}
