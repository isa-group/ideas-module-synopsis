package es.us.isa.ideas.synopsis.common;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.util.Node;

/**
 * Represents a Tree of Objects of generic type T. The Tree is represented as a
 * single rootElement which points to a List<Node<T>> of children. There is no
 * restriction on the number of children that a particular node may have. This
 * Tree provides a method to serialize the Tree into a List by doing a pre-order
 * traversal. It has several methods to allow easy updation of Nodes in the
 * Tree.
 */
public class Tree<T> {

	private Node<T> rootElement;

	/**
	 * Default ctor.
	 */
	public Tree() {
		super();
	}

	/**
	 * Return the root Node of the tree.
	 * 
	 * @return the root element.
	 */
	public Node<T> getRootElement() {
		return this.rootElement;
	}

	/**
	 * Set the root Element for the tree.
	 * 
	 * @param rootElement
	 *            the root element to set.
	 */
	public void setRootElement(Node<T> rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * Returns the Tree<T> as a List of Node<T> objects. The elements of the
	 * List are generated from a pre-order traversal of the tree.
	 * 
	 * @return a List<Node<T>>.
	 */
	public List<Node<T>> toList() {
		List<Node<T>> list = new ArrayList<Node<T>>();
		walk(rootElement, list);
		return list;
	}

	/**
	 * Returns a String representation of the Tree. The elements are generated
	 * from a pre-order traversal of the Tree.
	 * 
	 * @return the String representation of the Tree.
	 */
	public String toString() {
		return toList().toString();
	}
	
	public String printTree(){
		StringBuilder sb = new StringBuilder();
		sb.append(rootElement.getData().toString()).append("\n");
		int index = 1;
		for (Node<T> child : rootElement.getChildren()) {
			if(!child.getData().toString().equals(rootElement.getData().toString().trim())){
				String tab = new String(new char[index]).replace("\0", "   ");
				sb.append(tab + child.getData().toString()).append("\n");
				sb.append(printTree(child, index + 1));
			}
		}
		return sb.toString();
	}
	
	public String printTree(Node<T> element, Integer index){
		StringBuilder sb = new StringBuilder();
		for (Node<T> child : element.getChildren()) {
			if(!child.getData().toString().equals(element.getData().toString().trim())){
				String tab = new String(new char[index]).replace("\0", "   ");
				sb.append(tab + child.getData().toString()).append("\n");
				sb.append(printTree(child, index + 1));
			}
		}
		return sb.toString();
	}

	/**
	 * Walks the Tree in pre-order style. This is a recursive method, and is
	 * called from the toList() method with the root element as the first
	 * argument. It appends to the second argument, which is passed by reference
	 * * as it recurses down the tree.
	 * 
	 * @param element
	 *            the starting element.
	 * @param list
	 *            the output of the walk.
	 */
	private void walk(Node<T> element, List<Node<T>> list) {
		list.add(element);
		for (Node<T> data : element.getChildren()) {
			walk(data, list);
		}
	}
}