import java.util.Random;
 
public class RandomPassword {
 
    private static final String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
 
    public static String getRandomString(int length) {
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }
 
   // String responseData = "<XML><STATUS>OK</STATUS><DETAIL></DETAIL><MSG>Sent OTP Complete</MSG></XML>";
    
    
    public void parse() {
    	 String responseData = "<XML><STATUS>OK</STATUS><DETAIL></DETAIL><MSG>Sent OTP Complete</MSG></XML>";
		if(responseData.indexOf("MSG")!= -1)
		{
			System.out.println("Success");
			
		}else
		{
			System.out.println("Failed");		
		}
    }
    
    
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
 
            System.out.println(getRandomString(4));
 
            try {
                // if you generate more than 1 time, you must
                // put the process to sleep for awhile
                // otherwise it will return the same random string
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
}
