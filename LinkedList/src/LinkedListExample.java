public class LinkedListExample {
	
	public static void main(String[] args) {
		LinkedList<String> llv = new LinkedList();
		llv.addFirst("one");
		llv.addLast("two");
		llv.addLast("three");
		llv.addLast("four");
		llv.addLast("five");
		System.out.println(llv);

//		llv.addFirst("zero");
//		System.out.println(llv);
//
//		System.out.println(llv.getFirst());
//		System.out.println(llv.getLast());
//
		llv.addLast("four");
//		System.out.println(llv);
//		System.out.println(llv.firstIndexOf("four"));
//		System.out.println(llv.lastIndexOf("four"));
//		System.out.println(llv.getFirst());
//		System.out.println(llv.getLast());
		System.out.println(llv.getValueOf(6));
//		llv.set(4, null);
//		System.out.println(llv.removeFirst());
//		System.out.println(llv);
//		System.out.println(llv);
//		System.out.println(llv);
	}
}
