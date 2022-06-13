package Sort;

public class duplicateElement {
	int element; //duplicate element
	int freq; //frequency that said duplicate element appears
	
	public duplicateElement(int element, int freq) {
		this.element = element;
		this.freq = freq;
	}
	
	//return duplicate element
	public int getElement() {
		return this.element;
	}
	//return frequency of duplicate element
	public int getFreq() {
		return this.freq;
	}
	
}
