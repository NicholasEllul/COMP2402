package comp2402a4;

import java.util.Random;
import java.util.*;

public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}

	/**
	 * Set the x and y-coordinates of each node such that it is between the
	 * x-coordinate of its two children, no two nodes have the same
	 * x-coordinate, and each level of the tree is drawn on separate y-coordinates.
	 */
	public void inorderDraw() {
		assignLevels();
		GeometricTreeNode u = firstNode();
		int x = 0;

		while(u != nil){
			u.position.x = x++;
			u = nextNode(u);
		}
		//Random rand = new Random();
		//randomX(r, rand);
	}


	/**
	 * Set the x- and y-coordinates of each node such that each node
	 * has an x-coordinate as small as possible without overlapping
	 * any other node at the same level and each level of the tree is
	 * drawn on separate y-coordinates
	 */
	public void leftistDraw() {
		assignLevels();
		//  T ODO: use your code here instead
		Queue<GeometricTreeNode> q = new LinkedList<GeometricTreeNode>();
		int[] levelOfXVal = new int[height()+1];

		q.add(r);
		while (!q.isEmpty()) {
			GeometricTreeNode u = q.remove();
			u.position.x = levelOfXVal[u.position.y]++;
			if (u.left != nil) q.add(u.left);
			if (u.right != nil) q.add(u.right);
		}
		//Random rand = new Random();
		//randomX(r, rand);
	}

	/**
	 * Set the x- and y-coordinate of each node such that the smaller
	 * of a node's two subtrees is drawn directly below the node, and the
	 * larger is drawn directly to the right, but far enough away that
	 * it does not intersect with the smaller subtree.
	 */

	public void balancedDraw() {
		assignLevels();
		HashSet<GeometricTreeNode> set = new HashSet<>();

		GeometricTreeNode u = r, prev = nil, next;

		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != null) next = u.left;
				else if (u.right != null) next = u.right;
				else{
						set.add(u);
					next = u.parent;
				}
			}
			else if (prev == u.left) {
				if (u.right != nil) next = u.right;
				else{
				set.add(u);
					next = u.parent;
				}
			}
			else {
				set.add(u);
				next = u.parent;
			}
			prev = u;
			u = next;
		}

/// Assigning X and Y Values
		u = r;
	  next = nil;
		int x = 0;
		int y = 0;

	u.position.x = 0;
	u.position.y = 0;

	while(u != null){
		if(set.contains(u.left) == false && set.contains(u.right) == false){
			if(u.parent == null) break;
			next = u.parent;
			set.remove(next);
			if(u.parent.position.x == u.position.x) y--;
		} else if(set.contains(u.left) && set.contains(u.right) == false){
			next = u.left;
			next.position.x = ++x;
			next.position.y = y;
			set.remove(u.left);
		}
		else if(set.contains(u.right) && set.contains(u.left) == false){
			next = u.right;
			next.position.x = ++x;
			next.position.y = y;
			set.remove(u.right);
		}
		else {
			if(size(u.left) > size(u.right)){
				next = u.right;
				next.position.y = ++y;
				next.position.x = x;
				set.remove(u.right);
			}else{
				next = u.left;
				next.position.y = ++y;
				next.position.x = x;
				set.remove(u.left);
			}

		}
		u = next;
}


/*while(u != null){

	if(map.get(u.left) == null && map.get(u.right) == null){
		if(u.parent == null) break;
		//System.out.println(" 						 "+u.parent.toString());
		//System.out.println("Y--");
		next = u.parent;
		map.remove(next);
		if(u.parent.position.x == u.position.x)
				y= y-1;

	} else if(map.get(u.left) != null && map.get(u.right) == null){
		//System.out.println("case1");
		next = u.left;
				x++;
		next.position.x = x;
		next.position.y = y;
			//			System.out.println("  "+next.toString());
							map.remove(u.left);
	}
	else if(map.get(u.right) != null && map.get(u.left) == null){
	//	System.out.println("case2");
		next = u.right;
				x++;
		next.position.x = x;
		next.position.y = y;
	//	System.out.println("  "+next.toString());
				map.remove(u.right);
	}
	else if(map.get(u.left) >= map.get(u.right)){
	//	System.out.println("-----r"+map.get(u.right));
				y++;
		next = u.right;
		next.position.y = y;
		next.position.x = x;
	//	System.out.println("  "+next.toString());


	//	System.out.println("y++");
		map.remove(u.right);
	}
	else if(map.get(u.right) > map.get(u.left)){
	//	System.out.println("-----l"+map.get(u.left));
					y++;
		next = u.left;
		next.position.y = y;
		next.position.x = x;

		map.remove(u.left);
	}else{
		break;
	}

	u = next;


}*/
		/*
			Pick the smallest tree, and place its node directly under(y++)
			make its x value the same as the one before it.
			Update head node to be this node.
			Pick smallest tree...
		*/

		/*
		Pick Smallest Tree: if both are null. Next node is parent{y++}
		if left > right, smallest tree return right
		if right > left return left
		-- IGNORE CASE if left is null but right isnt smallest node is
		*/

/*

			if (u.left != nil && map.get(left) > map.get(right)) q.add(u.left);
			if (u.right != nil) && map.get(left) < map.get(right) q.add(u.right);
			prev = u;
		}



		while (u != nil) {
			if (prev == u.parent) {
				if (map.get(u.left) != nil && map.get(u.right) != nil){
					if(map.get(u.left) > map.get(u.right)){
						u.right = x;
					}
					else{
						u.left = x;
					}
				}
				if (u.right == nil && u.left == nil){

				}
				else if (u.right != nil){
					u.right
				}
			}
			else if (prev == u.left) {
				if (u.right != nil) next = u.right;
				else next = u.parent;
			}
			else {
				next = u.parent;

			}
			prev = u;
			u = next;
		}

		System.out.println(map.get("DDEED"));
		*/
	}


	/**This function randomly assign's x values to each node in the tree.
	It is for demonstration purposes only*/
	protected void randomX(GeometricTreeNode u, Random r) {
		if (u == null) return;
		u.position.x = r.nextInt(60);
		randomX(u.left, r);
		randomX(u.right, r);
	}


	/**This function sets the y values for all nodes in the tree according to their depth*/
	protected void assignLevels() {
		assignLevels(r, 0);
	}

	protected void assignLevels(GeometricTreeNode u, int i) {
		if (u == null) return;
		u.position.y = i;
		assignLevels(u.left, i+1);
		assignLevels(u.right, i+1);
	}

	public static void main(String[] args) {
		GeometricTree t = new GeometricTree();
		galtonWatsonTree(t, 100);
		System.out.println(t);
		t.inorderDraw();
		System.out.println(t);
	}

}
