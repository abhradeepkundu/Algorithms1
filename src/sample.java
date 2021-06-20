import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class sample {
	
	
public void getNextNumber() {
	int[] a = {9,9,9,9};
	int i = 0;
	printArray(a);

	System.out.println();
	reverseArray(a);
	printArray(a);
	int carry =1;
	while(i < a.length) {
		if(( a[i]+ carry)>=10 ) {
			carry = (a[i]+carry)/10;
			int remainder = (a[i]+carry)%10;
			a[i] = remainder;
			System.out.println("remainder : " + remainder);
			if(i+1 < a.length) {
				a[i+1] += carry;
				System.out.println();
				System.out.println("i : " + i);
			}else {
				//copy everything to new array and place 1 at the last position
				int[] b = new int[a.length+1];
				b = a.clone();
				System.out.println("i's val here is " + i + " b's length : " + b.length);
				//b[i+1] = carry;
				
				System.out.println("Need to put logic here " + carry);
				printArray(b);
			}

		}else {
			if(i < a.length) {
				a[i] = a[i] + 1;
				System.out.println("a[i] : " + a[i] + " i " + i);
				break;
			}
			else {
				//copy everything to new array and place 1 at the last position
			/*	int[] b = new int[a.length+1];
				b = a.clone();
				
				System.out.println("Need to put logic here");
				printArray(b);*/
			}
		}
		++i;
	}
	reverseArray(a);
	System.out.println("Result");
	printArray(a);
}
	
private void printArray(int[] a) {
	// TODO Auto-generated method stub
	
	for(int i = 0;i < a.length;++i)
		System.out.print(a[i] + " ");	
}

private void reverseArray(int[] a) {
	// TODO Auto-generated method stub
	int i = 0; int j = a.length-1;
	while(i < j) {
		swap(a,i,j);
		++i; --j;
	}
}

private void swap(int[] a, int i, int j) {
	// TODO Auto-generated method stub
	 int temp = a[i];
	 a[i] = a[j];
	 a[j] = temp;
}

public static void main(String[] args) {
/*	String strremove1= "  mrs. mrsGB 435345VISA";
	String strremove = strremove1.trim();
	String regex1 = "^(mrs|mr|ms|dr|)[.]";
	String regex2 = "([0-9]+)";
	Pattern pattern = Pattern.compile(regex1,Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(strremove.trim());
    if(matcher.find())
    {
    	
    	//remove all nonalphanumeric chars
        strremove = matcher.replaceAll("");
        System.out.println("Found Special Char 1 and "+strremove);
        pattern = Pattern.compile(regex2,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(strremove);
        if(matcher.find())
        {
        	strremove = matcher.replaceAll("");
        	System.out.println("Found Special Char 2 and "+strremove);
        }
        
        *//***REMOVE BEFOR PROD PUSH****//*
    } else {
    	System.out.println("Not found "+strremove);
    }*/

	new sample().getNextNumber();
 }
}
