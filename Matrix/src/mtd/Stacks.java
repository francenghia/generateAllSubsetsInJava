package mtd;

public class Stacks {
	int[] topOfStack;
	int[] stackData;
	int[] nextIndex;

	int nextAvailable = 0;

	public Stacks(int numStacks, int capacity) {
		
		topOfStack = new int[numStacks];
		
		for (int i = 0; i < topOfStack.length; i++) {
			topOfStack[i] = -1;
		}
		
		stackData = new int[capacity];
		nextIndex = new int[capacity];

		for (int i = 0; i < nextIndex.length - 1; i++) {
			nextIndex[i] = i + 1;
		}
		
		nextIndex[nextIndex.length-1] = -1;
	}
	
	public void push(int stack , int value) {
		if(stack < 0 || stack >= topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}
		
		if(nextAvailable < 0) return;
		
		int currentIndex =  nextAvailable;
		nextAvailable =nextIndex[currentIndex];
		stackData[currentIndex] =value;
		nextIndex[currentIndex] =topOfStack[stack];
		topOfStack[stack] = currentIndex;
		
	}
	
	public int pop(int stack) {
		if(stack <0 ||stack >= topOfStack.length || topOfStack[stack] < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		int currentIndex =  topOfStack[stack];
		int value = stackData[currentIndex];
		topOfStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] =nextAvailable;
		nextAvailable = currentIndex;
		return value;
		}
}
