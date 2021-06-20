import java.util.regex.Pattern;

public class RegularExpression {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private final static Pattern _alphaNumeric = Pattern.compile("[^a-zA-Z0-9]/-");
	private final static Pattern _whiteSpace = Pattern.compile("\\s+");
	
	public static String textWithoutSpecialCharacters(final String text)
	{
		final String newText = _alphaNumeric.matcher(text).replaceAll(" ").trim().toLowerCase();
		return _whiteSpace.matcher(newText).replaceAll("-");
		//return newText;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "saaga-home-d%C3%A9cor/-2-shelf-shoe-rack---30x12x20";
		//String text = "rakhi-spl:-guess-&-more/hobo-bag_2";
		//sha512("key|command|var1|salt");
		//sha512("ibibo|verify_payment|100124|wEtyIUsE");
		//System.out.println(text + " :: " + textWithoutSpecialCharacters(text));
		
		for(int i=0;i<10;++i) {
			for(int j=0;j<10;++j) {
				if(j==0)
					break;
			}
			System.out.println(i + " : shams");			
		}
	}
	


	
	

}
