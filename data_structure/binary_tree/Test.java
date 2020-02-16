package data_structure.binary_tree;

public class Test {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();

		Node node7 = binaryTree.makeBinaryTree(null, 'G', null);
		Node node6 = binaryTree.makeBinaryTree(null, 'F', null);
		Node node5 = binaryTree.makeBinaryTree(null, 'E', null);
		Node node4 = binaryTree.makeBinaryTree(null, 'D', null);
		Node node3 = binaryTree.makeBinaryTree(node6, 'C', node7);
		Node node2 = binaryTree.makeBinaryTree(node4, 'B', node5);
		Node node1 = binaryTree.makeBinaryTree(node2, 'A', node3);

		System.out.println("Tree Traversal by Preorder");
		binaryTree.preorder(node1);

		System.out.println("\nTree Traversal by Inorder");
		binaryTree.inorder(node1);

		System.out.println("\nTree Traversal by Postorder");
		binaryTree.postorder(node1);
	}
}