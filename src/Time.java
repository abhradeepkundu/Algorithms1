import java.util.GregorianCalendar;
import java.util.Random;




public class Time {

	public Time() {
		// TODO Auto-generated constructor stub
	}
	public long getCurrentTime() {
		GregorianCalendar cal = new GregorianCalendar();
		long presentTimeMilliSeconds = cal.getTimeInMillis();
		return presentTimeMilliSeconds;
	}
	
	 public void parse() {
    	 String response = "<XML><STATUS>OK</STATUS><DETAIL></DETAIL><MSG>Sent OTP Complete</MSG></XML>";
    	 if(response.indexOf("Sent OTP Complete")!= -1)
 		{
 			System.out.println("Success");
 			//return true;
 		}else
 		{
 			System.out.println("Failed");
 			//return false;
 		}
    }
	
	private String genRefCode() {
		// TODO Auto-generated method stub
		String charset = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        //int length = config.getIntValue("REFERENCECODELENGTH");
        int length = 4;
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        System.out.println(sb.toString());
        return sb.toString();		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*GregorianCalendar cal = new GregorianCalendar();
		long presentTimeMilliSeconds = cal.getTimeInMillis();
		System.out.println(presentTimeMilliSeconds);*/
		//String cardNumber="5404300000000013 ";
		new Time().parse();
		
		//new Time().genRefCode();
	}

}
