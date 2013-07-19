package com.naironics.trinary;

public class TrinaryTree {

	Node root;

	// Inserting a node into the Trinary Tree
	public void insertNode(int key, String name) {

		Node newNode = new Node(key, name);

		if (root == null) {

			root = newNode;

		} else {

			Node nodeOnFocus = root;

			Node parent;

			while (true) {

				parent = nodeOnFocus;

				if (key < nodeOnFocus.key) {

					nodeOnFocus = nodeOnFocus.leftChild;

					if (nodeOnFocus == null) {

						parent.leftChild = newNode;
						return;

					}

				} else if (key == nodeOnFocus.key) {

					nodeOnFocus = nodeOnFocus.middleChild;

					if (nodeOnFocus == null) {

						parent.middleChild = newNode;
						return;

					}

				}

				else {

					nodeOnFocus = nodeOnFocus.rightChild;

					if (nodeOnFocus == null) {

						parent.rightChild = newNode;
						return;

					}

				}

			}
		}

	}

	// deletes a node from Trinary tree

	public void deleteNode(int key) {
		this.rearrangeNodes(this.root, key);
	}

	// helper method to rearrange nodes in case of a node deletion
	
	private Node rearrangeNodes(Node node, int key) {
		if (key < node.key) {
			node.leftChild = rearrangeNodes(node.leftChild, key);
		} else if (key > node.key) {
			node.rightChild = rearrangeNodes(node.rightChild, key);
		} else {
			if (node.middleChild != null) {
				node.middleChild = rearrangeNodes(node.middleChild, key);
			} else if (node.rightChild != null) {
				int min = min(node.rightChild).key;
				node.key = min;
				node.rightChild = rearrangeNodes(node.rightChild, min);
			} else {
				node = node.leftChild;
			}
		}

		return node;
	}

	// find minimum of a node (helper method for deletion)

	private Node min(Node node) {
		if (node != null) {
			while (node.leftChild != null) {
				return min(node.leftChild);
			}
		}

		return node;
	}

	// Prints the tree in (Root-LeftChild-MiddleChild-RightChild) fashion recursively

	public void printTree(Node node) {
		if (node == null) {
			return;
		}

		System.out.println(node.name + "\t\t" + node.key);
		this.printTree(node.leftChild);
		this.printTree(node.middleChild);
		this.printTree(node.rightChild);
	}

	public static void main(String[] args) {

		TrinaryTree tTree = new TrinaryTree();
		tTree.insertNode(5, "First Five");
		tTree.insertNode(4, "Four");
		tTree.insertNode(9, "Nine");
		tTree.insertNode(5, "Second Five");
		tTree.insertNode(7, "Seven");
		tTree.insertNode(2, "First Two");
		tTree.insertNode(2, "Second Two");

		System.out.println("------------------------------");		
		tTree.deleteNode(4);		
		tTree.printTree(tTree.root);
		
		System.out.println("------------------------------");		
		tTree.deleteNode(2);
		tTree.insertNode(1, "One");
		tTree.insertNode(19, "Nineteen");	
		tTree.insertNode(17, "Seventeen");
		tTree.insertNode(23, "TwentyThree");
		tTree.insertNode(15, "Fifteen");
		tTree.insertNode(12, "Twelve");
		tTree.insertNode(14, "Fourteen");
		tTree.printTree(tTree.root);
		
		
	
	}
}

class Node {

	int key;
	String name;

	Node leftChild;
	Node rightChild;
	Node middleChild;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

}
