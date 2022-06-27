package Sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class weirdSorterTM {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Integer> array = new ArrayList<Integer>();
		array.add(6);
		array.add(5);
		array.add(2);
		array.add(2);
		array.add(7);
		array.add(4);
		array.add(1);
		array.add(4);
		array.add(6);
		array.add(6);
		
		System.out.print("Original array:\t" + array.toString());
		
		List<Integer> sortedArray = weirdSort(array);
		System.out.print("\nSorted array:\t" + sortedArray.toString());
	}
	
	
	
	
	
	
	
	private static List<Integer> weirdSort(List<Integer> a) throws FileNotFoundException {
		try {
			Scanner in = new Scanner(new FileReader("C:\\Users\\Jack\\eclipse-workspace\\WeirdSorting\\src\\Sort\\filename"));
			
			List<Integer> b = new ArrayList<Integer>(); 			//array to return
			List<Integer> dupsList = new ArrayList<Integer>();		//array to hold a copy of the duplicates (if any)
			List<duplicateElement> duplicateList = new ArrayList<duplicateElement>();	//arrayList to store duplicates (if any) with frequency
			
			//check for duplicates
			for(int j = 0; j < a.size(); j++) {
				int val = a.get(j);
				int freq = Collections.frequency(a, val);
				if(freq > 1 && !dupsList.contains(val)) { //if element appears more than once and it's not already recorded in dupsList
					duplicateElement dup = new duplicateElement(val, freq);
					duplicateList.add(dup); //add duplicate element w/ freq to duplicateList
					dupsList.add(val); //add duplicate value to dupsList
				}
			}
			
			while(in.hasNext()) {
				
				int nextInt = in.nextInt(); //read next int in file
				
				for(int i = 0; i < a.size(); i++) {
					if(a.get(i) == nextInt) {
						
						if(!duplicateList.isEmpty()) { //if there are duplicates, do more stuff
							//temp duplicate element object 
							duplicateElement temp = new duplicateElement(a.get(i), Collections.frequency(a, a.get(i)));
							if(dupsList.contains(temp.getElement())) {
								
								//index of duplicated element; elements are in the same order in both lists
								int dupIndex = dupsList.indexOf(temp.getElement());
								//add duplicated element however many times it appears in the original array
								for(int k = 0; k < duplicateList.get(dupIndex).getFreq(); k++) b.add(a.get(i));
								System.out.print("\nB array:\t" + b.toString());
								break;
								
							} else b.add(a.get(i)); //otherwise, just add as normal
								
						} else b.add(a.get(i)); //otherwise, just add as normal
						System.out.print("\nB array:\t" + b.toString());
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
