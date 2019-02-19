package main;
import model.Node;

public class Main {

	public static void main(String args[]) {
		Node raiz = new Node(10);
		raiz.add(3);
		raiz.add(16);
		raiz.add(1);
		raiz.add(4);
		raiz.add(6);
		raiz.add(5);
		Node node;
		for (int i = 1; i < 7;i++) {
			node = raiz.find(i);
			if (node != null) {
				System.out.println("ENCONTRADO" + node.getValue());
			} else {
				System.out.println("NO ENCONTRADO");
			}
		}
		
		raiz.printInOrder();
	}
}
