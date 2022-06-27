package Sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class weirdSorterv2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Integer> array = new ArrayList<Integer>();
		array.add(6);
		array.add(5);
		array.add(2);
		array.add(2);
		array.add(7);
		array.add(4);
		array.add(5);
		array.add(5);
		array.add(8);
		array.add(4);
		array.add(6);
		array.add(3);
		array.add(1);
		array.add(8);
		array.add(5);
		array.add(8);
		
		System.out.println("Original array:\t" + array.toString());
		long startTime = System.currentTimeMillis();
		System.out.println("Sorted array:\t" + weirdSort(array).toString());
		long totalTime = System.currentTimeMillis() - startTime;
		double total = ((double)((float)totalTime / 1000));
		System.out.println("Total Time:\t" + total);
	}
	
	private static List<Integer> weirdSort(List<Integer> a) throws FileNotFoundException {
		try {
			Scanner in = new Scanner(new FileReader("C:\\Users\\Jack\\eclipse-workspace\\WeirdSorting\\src\\Sort\\filename"));
			
			List<Integer> b = new ArrayList<Integer>();			//listarray to return
			HashMap<Integer, Integer> dups = new HashMap<>();	//key-value pairs = dups-freq
			
			//check for duplicates
			for(int j = 0; j < a.size(); j++) {
				int val = a.get(j);
				int freq = Collections.frequency(a, val);
				//if element appears more than once and it's not already recorded in dups
				if(freq > 1 && !dups.containsKey(val)) dups.put(val, freq);
			}
			
			while(in.hasNext()) {
				
				int nextInt = in.nextInt(); //read next int in file
				if(nextInt > Collections.max(a)) break; //break out of while loop if nextInt exceeds the max of a
				
				for(int i = 0; i < a.size(); i++) {
					int currVal = a.get(i); //current value in a
					if(currVal == nextInt) {
						if(!dups.isEmpty()) { //if there are duplicates, do more stuff
							if(dups.containsKey(currVal)) {//if the current value is a recorded duplicate
								
								//add duplicated element however many times it appears in the original array
								for(int k = 0; k < dups.get(currVal); k++) b.add(currVal);
								System.out.println("B array:\t" + b.toString());
								break;
								
							} else b.add(currVal); //otherwise, just add as normal
						} else b.add(currVal); //otherwise, just add as normal
						System.out.println("B array:\t" + b.toString());
					}
				}
			}
			in.close();
			return b;
			
		} catch(FileNotFoundException e) {
			List<Integer> c = new ArrayList<Integer>();
			c.add(0);
			return c;
		}
	}
}
