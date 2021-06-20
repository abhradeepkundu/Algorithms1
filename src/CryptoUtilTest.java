import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import com.arcot.crypto.CryptoUtil;


public class CryptoUtilTest {
                
                private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public static String asHex(byte[] buf)
    {
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i)
        {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
                
                public static void main(String[] args) throws IOException{
                                
                                System.load("C:\\Program Files\\Arcot Systems\\VPAS Server\\bin\\ArcotJNI.dll");
                /*           InputStream inputStream = new FileInputStream(args[0]);
                                byte[] byteArray= new byte[1000];
                                StringBuffer fileContents = new StringBuffer();
                                while(inputStream.read(byteArray, 0, byteArray.length) > -1)
                                {
                                                System.out.println(new String(byteArray));        
                                                fileContents.append(new String(byteArray).trim());                                       
                                }
                                
                                //String stringToBeEncrypted = "LogicHandler=com.arcot.apps.ccard.CcardBusinessLogicHandler;LogFilePath=D:/logs/odslog/ccardxmlm;EXPIRYDATEFORMAT=MMyy;ES_QUESTION_MAP=SSN:1~EXPIRYDATE:2~FISCALCODE:3;NUMBEROFPACKETS=3;HOSTNAME=194.150.182.117;PORT=1414;CHANNEL=JAVA.TO.UKEBS01P;QMANAGER=UKEBS01P;PUTQUEUE=RQ.C7763.NGINQ;GETQUEUE=LQ.C7763.NGINQ.REPLY;EXPIRY=200;WAITINTERVAL=15000;INQURLPART1=http:/queue?host~194.150.182.117&port~1414&clientChannel~JAVA.TO.UKEBS01P&connectQManager~UKEBS01P&serviceQManager~UKEBS01P&requestQName~RQ.C7703.NGINQ&responseQName~LQ.C7703.NGINQ.REPLY;INQURLPART2=&timeout~20000&expiry~200&waitInterval~15000;MNTURLPART1=1;MNTURLPART2=&timeout~20000&expiry~200&waitInterval~15000;CONSUMERUSERID=1002;CONSUMERVENDORID=00001002;CONSUMERCLIENTID=7703;QManagerName=UKEBS01P;ClientChannel=JAVA.TO.UKEBS01P;TimeOut=16000;Expiry=200;WaitInterval=15000;PutQNameINQ=RQ.C7763.NGINQ;GetQNameINQ=LQ.C7763.NGINQ.REPLY;CLIENTID=7763;VENDORID=00001002;COMMERCIALBINS=5475920000000000,5329690000000000;ENDPOINTURL=https://tsysapi1p.tsyseurope.com/7703/00001002/Inquire;VendorId=00001002;UserId=1002;TRUSTSTOREPATH=C:/Program Files/Common Files/Arcot Shared/ssl/captrust.jks;TRUSTSTORTYPE=JKS;TRUSTSTOREPASSWORD=caponeroot;DOBLowerThreshold=01011910;NUMBEROFPACKETSFISCALCODE=1;ClientId1=7703;";
                /*           System.out.println(fileContents.toString());
                                String encrptedValue = CryptoUtil.encrypt3DES64("MasterKey", fileContents.toString(), true);
                                OutputStream outputStream = new FileOutputStream(args[1]);
                                outputStream.write(encrptedValue.getBytes());
                                System.out.println(encrptedValue);
                                outputStream.close();
                                inputStream.close();
                                
                */
                               // System.out.println(CryptoUtil.hashDataB64("Dost1234"));
                                /*int randomInteger = CryptoUtil.genRandomInteger();
                                System.out.println("Random Integer :" + randomInteger);
                                
                                */
                                /*String encryptedRandomNumber = CryptoUtil.encrypt3DES64("6EFE45ABEDDF4499", "123450", true);
                                System.out.println(encryptedRandomNumber);
                                long sum = 0;
                                for(int i=0; i < encryptedRandomNumber.length(); i++){               
                                                sum *= i;
                                                sum += ((int)encryptedRandomNumber.charAt(i));
                                                sum %= 1000000;
                                }
                                */
                                /*BASE64Decoder decoder = new BASE64Decoder();
                                String base64EncodedString = CryptoUtil.hashDataB64("Sham1234");
                                System.out.println(base64EncodedString);
                                */
                                //System.out.println(CryptoUtil.encrypt3DES64("Arpita1234", null, true));
                /*           byte[] byteArray = null;
                                try {
                                                byteArray = decoder.decodeBuffer(base64EncodedString);
                                } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                String hexArray = asHex(byteArray);       
                                System.out.println(hexArray);
                                byte[] hexByteArray = hexStringToByteArray(hexArray);
                                BASE64Encoder encoder = new BASE64Encoder();
                                System.out.println(encoder.encode(hexByteArray));
                                
                                */
                }

}

