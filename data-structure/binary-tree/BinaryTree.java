package datastructure.binarytree;

public class BinaryTree {
	private Node rootNode;

	public Node makeBinaryTree(Node leftNode, char rootData, Node rightNode) {
		Node rootNode = new Node(rootData);
		rootNode.setLeft(leftNode);
		rootNode.setRight(rightNode);
		return rootNode;
	}

	// preorder : root -> left -> right
	public void preorder(Node rootNode) {
		if (rootNode != null) {
			System.out.print(rootNode.getData() + " ");
			preorder(rootNode.getLeft());
			preorder(rootNode.getRight());
		}
	}

	// inorder : left -> root -> right
	public void inorder(Node rootNode) {
		if (rootNode != null) {
			inorder(rootNode.getLeft());
			System.out.print(rootNode.getData() + " ");
			inorder(rootNode.getRight());
		}
	}

	// postorder : left -> right -> root
	public void postorder(Node rootNode) {
		if (rootNode != null) {
			postorder(rootNode.getLeft());
			postorder(rootNode.getRight());
			System.out.print(rootNode.getData() + " ");
		}
	}
}
