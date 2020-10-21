
public class SuperStack<T> {
	private T[] items;
	private int top;
	
	public SuperStack(int size){
		this.items =  (T[]) new Object[size];
	}
public boolean isEmpty() {
	//TODO
	return top ==0;
}
public boolean isFull() {
	//TODO
	return top == items.length;
}
public boolean push(T item) {
	//TODO
	if (isFull()) {
		return false;
	}
items[top++] = item;
	return true;
	
}
public T pop() {
	//TODO
	if (isEmpty()) {
		return null;
	
	}else {
		top--;
		return items[top];
	}
}

}
