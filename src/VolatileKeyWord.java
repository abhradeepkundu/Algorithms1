
public class VolatileKeyWord extends Thread{

	private volatile int testValue;
	public VolatileKeyWord(String str){
		super(str);
	}
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				System.out.println(getName() + " : "+i);
				if (getName().equals("Thread 1 "))
				{
					testValue = 15;
					System.out.println( "Test Value in Thread 1: " + testValue);
					testValue += 1;;
				}
				if (getName().equals("Thread 2 "))
				{
					System.out.println( "Test Value in Thread 2: " + testValue);
				}				
				Thread.sleep(2000);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VolatileKeyWord("Thread 1 ").start();
		new VolatileKeyWord("Thread 2 ").start();
	}

}
