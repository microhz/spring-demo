package com.micro.demo.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static void doWithArray(int[][] array) {
		// List<Integer> levelIndexList = new ArrayList<Integer>();
		Set<Integer> rootSet = new HashSet<Integer>();
		for (int[] l1 : array) {
			if (l1.length > 0 && !rootSet.contains(l1[0])) {
				Map<Integer, Object> l1Map = new HashMap<Integer, Object>();

			}
		}
	}
	
	
	public static Map<Object,Object> constTree(int[][] arrays, Map<Object, Object> parentMap) {
		/*Set<Integer> parentSet = new HashSet<Integer>();
//		Map<Integer, Object> parentMap = new HashMap<Integer, Object>();
		Map<Object,Object> newMap = new HashMap<Object, Object>();
		for (int[] branch : arrays) {
			if (!parentSet.contains(branch[0])) {
				Map<Object, Object> map = new HashMap<Object, Object>();
				List<Integer> childrenIndexList = getChildArrayIndex(branch[0], arrays);
				List<Integer> dataList = getDataList(childrenIndexList, arrays);
				map.put(branch[0], dataList);
				parentMap.
			}
		}*/
		return null;
	}
	
	public static List<Integer> getDataList(List<Integer> indexList, int[][] arrays) {
		List<Integer> dataList = new ArrayList<Integer>();
		for (Integer index : indexList) {
			dataList.add(arrays[index][0]);
		}
		return dataList;
	}
	
	
	public static List<Integer> getChildArrayIndex(int parentIndex, int[][] arrays) {
		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0;i < arrays.length;i ++) {
			if (arrays[i][0] == parentIndex) {
				indexList.add(i);
			}
		}
		return indexList;
	}
	
	
	public static Set<Node> doNodes(int[][] arrays) {
		Set<Node> nodeSet = new HashSet<Node>();
		for (int[] branch : arrays) {
			for (int i = 0;i < branch.length;i ++) {
				Node node = new Node();
				node.setData(branch[i]);
				if (i > 0) {
					Node parentNode = new Node();
					parentNode.setData(branch[i - 1]);
					node.setParentNode(parentNode);
				}
				nodeSet.add(node);
			}
		}
		return nodeSet;
	}

	public static class Node {
		Node parentNode;
		int data;
		Node[] childrens;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node[] getChildrens() {
			return childrens;
		}

		public void setChildrens(Node[] childrens) {
			this.childrens = childrens;
		}

		public Node getParentNode() {
			return parentNode;
		}

		public void setParentNode(Node parentNode) {
			this.parentNode = parentNode;
		}

	}
}
