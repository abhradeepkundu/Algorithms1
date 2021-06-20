
public class Strings {

	public Strings() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	 
	private void run() {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("abcd");
		//permut(str,0,str.length()-1);
		int[]a = {1, 4, 8, 2, 5, 7, 3, 4, 6};
		//System.out.println(strstr("hellopipipipi pipe","opi"));
		//getlongestIncreasingSubsequence(a);
		//printStack(s);
		printAllPermutationsOfString(str,0,str.length()-1);
	}
	private void printStack(int[] s) {
		// TODO Auto-generated method stub
		int i =0;
		while(i <= top) {
			System.out.print(s[i++] + " " );			
		}
	}

	private void getlongestIncreasingSubsequence(int[] a) {
		// TODO Auto-generated method stub
		int len = a.length;
		if(len < 1) {
			System.out.println("Invalid input");
			return;
		}
		
		push(s,a[0]);
		//printStack(s);
		
		
		int i = 1;
		int x;
		while(i < len) {
			x = pop(s);
			if(a[i] > x) {
				push(s,x);
				push(s,a[i]);
			}else {
				while(!isStackEmpty(s)) {
					x = pop(s);
					if(a[i] > x) {
						push(s,x);
						push(s,a[i]);
						break;
					}
				}
			}
			++i;
		}
	}
	public static int top = -1;
	int[] s = new int[100];
	public void push(int[] s,int val) {
		if(isStackFull(s)) {
			System.out.println("stack is full");
			return;
		}
		s[++top] = val;
	}
	public int pop(int[] s) {
		if(isStackEmpty(s)) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int temp;
		temp = s[top--];
		return temp;
	}

	private boolean isStackEmpty(int[] s) {
		// TODO Auto-generated method stub
		if(top < 0)
			return true;
		return false;
	}

	private boolean isStackFull(int[] s) {
		// TODO Auto-generated method stub
		if(top >= s.length)
			return true;
		return false;
	}

	private void printAllPermutationsOfString(StringBuffer str,int i,int j) {
		int k = 0;
		int count = 0;
		int charCount = 0;
		while(count < 6) {
			swap(str,i,k);
			System.out.println(str);
			if(k ==0)
				k++;
			while(k < j) {
				swap(str, k, j);
				System.out.println(str);
				charCount++;
				k++;
			}
			count++;
			count = count + charCount;
			k = 1;
		}
	}
	private void permut(StringBuffer str,int i, int len) {
		// TODO Auto-generated method stub
		if(i == len)
			System.out.println(str); 
		else {
			for(int j = i; j<= len; ++j) {
				swap(str,i,j);
				permut(str,i+1,len);
				swap(str,i,j);
			}
		}
	}
	public void sort(int[] a) {
		int zero = 0; int two = a.length-1; int i = 0;
		int ele;int temp;
		while( i < a.length && two >= i) {
			ele = a[i];
			if(ele == 0) {a[zero++] = 0; if(i != 0 ) a[i] = 1; i++;}
			if(ele == 2) {temp = a[two]; a[two--] = 2; a[i] = temp;}
			if(ele == 1) ++i;
		}
	}
	private void swap(StringBuffer str,int i,int j) {
		// TODO Auto-generated method stub
		//System.out.println("i => " + i + " j => " + j);
		char temp;
		temp = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, temp);
		//System.out.println("After swapping => " + str + " i => " + i + " j => " + j);
	}
	// strstr() // test case : "hellopipipepi pipe","pipe"
	public int strstr(String hayStack, String needle) {
		for(int i = 0; i < hayStack.length();++i) {
			for(int j = 0;j < needle.length() && (i+j) < hayStack.length();++j) {
				if(hayStack.charAt(i+j) != needle.charAt(j))
					break;
				else if(j == needle.length()-1)
					return i;
			}
		}
		
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Strings();
		/*String mydate = "02/16/1926" ;
		System.out.println(mydate.replace("/", ""));*/
		
	}

}
