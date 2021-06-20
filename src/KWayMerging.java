
public class KWayMerging {

	public KWayMerging() {
		// TODO Auto-generated constructor stub	
		this.run();
	}

	private void run() {
		int[][] input = new int[4][];
		input[0] = new int[] { 1, 2, 5, 74, 344 };
		input[1] = new int[] { 1, 8, 12, 33, 90, 95 };
		input[2] = new int[] { 9, 12, 17, 20, 91 };
		input[3] = new int[] { 1, 3 };
		
		int[] output = kwayMerge(input);
		printArray(output);
	}

	private void printArray(int[] output) {
		for(int i=0; i<output.length;++i)
			System.out.print(output[i] + " ");
	}

	private int[] kwayMerge(int[][] input) {
		int[] output;
		int arrLength = 0;
		int index;
		for(int i = 0; i<input.length;++i)
			arrLength += input[i].length;
		output = new int[arrLength];
		int[] counterIndex = new int[input.length];
		int j = 0;
		while(true) {
			index = compare(input,counterIndex);			
			 // Add the elements to output array						
			if(index == -1)
				break;
			else {
				output[j++] = input[index][counterIndex[index]];
				counterIndex[index]++;
			}
		}
		return output;
	}

	private int compare(int[][] input,int[] counterIndex) {
		int index = -1;
		int min = Integer.MAX_VALUE;
			for(int i=0;i<input.length;++i) {
				if(counterIndex[i] < input[i].length && input[i][counterIndex[i]] < min) {
					min = input[i][counterIndex[i]];					
					index = i;
				}
			}
		return index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new KWayMerging();
	}

}
