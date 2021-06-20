import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringExamples {

	public StringExamples() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	

	private void run() {
		// TODO Auto-generated method stub
	/*	String str = " hello Shams tabrez         arcot";
		System.out.println("Before trim => " + str);
		String regex="\\s+";
		String result = checkMmnFormat(str,regex);
		System.out.println(result);*/
	/*	for(int i=0;i<10;++i) {			
			getRandomString(4);
			try{
				  //do what you want to do before sleeping
				  Thread.currentThread().sleep(1000);//sleep for 1000 ms
				  //do what you want to do after sleeptig
				}
				catch(InterruptedException ie){
				//If this thread was intrrupted by nother thread 
				}
		}*/
		int result = strstr("hello world","row");
		System.out.println("result " + result);
		
	}
	
	/**
	 * strstr()
	 * */
	public int strstr(String hay, String needle) {
		int count = 0; int returnIndex = -1;
		if(hay == null || needle == null)
			return returnIndex;
		for(int i=0;i<hay.length();++i) {
			if(count < needle.length() && hay.charAt(i) != needle.charAt(count)) {				
				count = 0;
				continue;
			}else {
				if(count == 0) {
					returnIndex = i;					
				}
				count++;
			}
		}		
		if(count == needle.length())
			return returnIndex;
		
		return returnIndex;
	}

	private  String checkMmnFormat(String sPassed, String regex) {
		String str;
		Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(sPassed);
		  boolean check = matcher.find();
		  if(check) {
			  str = matcher.replaceAll("");			  
			  return str;
		  }
		  return null;
  }
	public static String getRandomString(int length) {
		String charset = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
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
		new StringExamples();
	}

}
