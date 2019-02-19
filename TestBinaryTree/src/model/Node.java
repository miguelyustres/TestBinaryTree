package model;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void add (int value) {
		if (value > this.value) {
			//Right
			if (right == null) {
				right = new Node(value);
			} else {
				right.add(value);
			}
		} else if (value < this.value) {
			//left
			if (left == null) {
				left = new Node(value);
			} else {
				left.add(value);
			}
		} else {
			// Equal we dont add it
		}
		
	}
	
	public Node find (int value) {
		if (value == this.value) {
			return this;
		} else if (value > this.value) {
			//Right
			if (right != null) {
				return right.find(value);
			} else {
				return null;
			}
		} else {
			//Left
			if (left != null) {
				return left.find(value);
			} else {
				return null;
			}
		}
	}
	
	public Node findPredecessor() {
		if (this.getRight() != null) {
			return this.getRight().findPredecessor();
		} else {
			return this;
		}
	}
	
	public Node delete(int value) {
		Node response = this;
		if (value > this.value) {
			if (right != null) {
				this.right = this.right.delete(value);
			}
		} else if (value < this.value) {
			if (left != null) {
				this.left = this.left.delete(value);
			}
		} else {
			if (right != null && left != null) {
				Node pred = this.left.findPredecessor();
				this.value = pred.value;
				this.left = this.left.delete(pred.value);
			} else if (right != null) {
				response = right;
			} else if (left != null) {
				response = left;
			} else {
				response = null;
			}
		}
		return response;
	}
	
	public void printInOrder() {
		if (left != null) left.printInOrder();
		System.out.println(this.value);
		if (right != null) right.printInOrder();
	}

}
