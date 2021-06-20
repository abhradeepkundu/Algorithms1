import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;


public class WebServices {

	private HttpsURLConnection _request;
	private HttpURLConnection _response;
	private String _amount;
	private String _phoneNo;
	private StringBuffer buf;
	
	public Object setPayment() {
		String payuUrl = "https://test.payu.in/_payment";
		String merchantID=" fvuHiu";
		String txnid = generateTrxnID(10); // Need to change this
		BigDecimal amount = new BigDecimal(250.0);
		_amount = String.valueOf(amount.intValue());
		String productInfo = "levis";
		String fName = "shams";
		String email = "shams.tabrez11@gmail.com";
		long phone = 988655238;
		_phoneNo = String.valueOf(phone);
		String surl = "http://www.fashionandyou.com/";
		String furl = "http://www.fashionandyou.com/login";
		byte[] hashedData = generateHash(merchantID,txnid,_amount,productInfo,fName,email,_phoneNo,surl,furl);
		String hash = String.valueOf(hashedData);
		System.out.println("SHA512 hash => " + hash);
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("key", merchantID);
		param.put("txnid", txnid);
		param.put("amount", _amount);
		param.put("productinfo", productInfo);
		param.put("fname", fName);
		param.put("email", email);
		param.put("phone", _phoneNo);
		param.put("surl", surl);
		param.put("furl", furl);
		param.put("hash", hash);
		
		URL url = null;
		buf = new StringBuffer();
		buf.append(payuUrl).append("?");
		appendQueryFields(buf,param);
		//PFAYOrder order = _fspos.getOrder(_universe.getUser().getUserId().getPersistenceId(), _orderId, true);
		System.out.println("URL => " + buf.toString());
		
		try {
			//_response.sendRedirect(_response.encodeRedirectURL(buf.toString()));
			url = new URL(buf.toString());
		} catch (Exception e) {
			//LOGGER.error("Error in redirecting to PayU page : " + buf.toString() + ": ", e);
			System.out.println("Error in redirecting to PayU page : " + buf.toString() + ": "+ e);
		}
		return url;		
	}
	
    private byte[] generateHash(String key, String txnid,
			String amount, String productInfo, String fName, String email,
			String phone, String surl, String furl) {
    	String salt = "wEtyIUsE";
    	String input = key+"|"+txnid+"|"+amount+"|"+productInfo+"|"+fName+"|"+email+"|"+phone + "|"+surl+"|"+furl+"|"+salt;
    	System.out.println("input parameters for hash => "+input);
    	MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			digest.update(input.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException,"+e);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException while generating hash," + e);
		}
    	return  digest.digest();
	}

	public String generateTrxnID(final int length)
    {
        final Random random = new Random();

        // we avoid one and "I" and zero and "O" because they are easily mistaken.
        char[] goodChar = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '2', '3', '4', '5', '6', '7', '8', '9'
        };

        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(goodChar[random.nextInt(goodChar.length)]);
        }
        System.out.println("txnid => " + sb.toString());
        return sb.toString();
    }

	// Method for creating a URL query string
	private void appendQueryFields(StringBuffer buf, Map<String, String> param) {
		// TODO Auto-generated method stub
		List<String> fieldNames= new ArrayList<String>(param.keySet());
		Iterator<String> it = fieldNames.iterator();
		while(it.hasNext()) {
			String fieldName = (String)it.next();
			String fieldValue = param.get(fieldName);
			// create key value pairs in the url
			if(fieldValue != null && fieldValue.length() > 0) {
				buf.append(URLEncoder.encode(fieldName));
				buf.append("=");
				buf.append(URLEncoder.encode(fieldValue));
			}
			// check for more key,value pairs. add & after each pair  
			if(it.hasNext()) {
				buf.append("&");
			}
		}
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
