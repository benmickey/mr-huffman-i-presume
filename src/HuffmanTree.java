public class HuffmanTree {

	public static Node root = new Node();
	//public BinaryHeap myHeap = new BinaryHeap(); 
	int totalnodes = 0; //Horizontal
	int maxheight=0; //Vertical 

	public HuffmanTree() {

		root.left = null; 
		root.right = null; 
		//root.parent = null; 
		
	}

	public static BinaryHeap buildTree(int [] x)
	{
		int count = 0; 
		BinaryHeap myHeap = new BinaryHeap(); 
		for(int i=0; i<x.length; i++)
		{
			if(x[i] != 0)
			{
				char s = (char) i; 
				Node y = new Node(s, x[i]); 
				myHeap.insert(y); 
				count++; 
			}

		}

		/*
		Node t = new Node(); 
		t = (Node) myHeap.findMin(); 
		int f = t.freq; 
		System.out.println(f); */

		int tab = 1; 
		for(int j=0; j<count; j++)
		{
			//DeleteMin twice, merge, insert back into Heap...
			int freq1; 
			Node y = new Node(); 
			y.tCount = tab; 
			y.left = (Node) myHeap.deleteMin();
			System.out.println(y.left.element); 
			y.right = (Node) myHeap.deleteMin(); 
			System.out.println(y.right.element); 
			freq1 = y.left.freq + y.right.freq; 
			y.freq = freq1; 
			myHeap.insert(y); 
			tab++; 
		}

		Node ex = new Node(); 
		ex = (Node) myHeap.findMin(); 
		root = ex; 
		root.left = ex.left; 
		root.right = ex.right; 

		return myHeap; 
	}

	public static Node getRoot()
	{
		return root; 
	}

	public static void encode(Node x, String code)
	{
		if(x.left == null && x.right == null) // it is a leaf
		{
			x.code += code; 
			if(x.element == 10 )
			{
				String p = "NL"; 
				System.out.print(p+" "); 
				System.out.println(x.code+ " " + x.freq); 
			}
			else if(x.element == 32)
			{
				String t = "SP"; 
				System.out.print(t+" "); 
				System.out.println(x.code+ " " + x.freq); 
			}
			else
				System.out.println(x.element +" " + x.code +" " + x.freq); 
		}
		else //it's not a leaf... 
		{ 
			String templ = code+"0"; 
			String tempr = code+"1";
			encode(x.left,templ); 
			encode(x.right,tempr);
		}
	}

	public int treeHeight(Node t){
		if(t==null) return -1;
		else return 1 + max(treeHeight(t.left),treeHeight(t.right));
	}
	public int max(int a, int b){
		if(a>b) return a; else return b;
	}

	public void computeNodePositions() {
		int depth = 1;
		inorder_traversal(root, depth);
	}

	//traverses tree and computes x,y position of each node, stores it in the node

	public void inorder_traversal(Node t, int depth) { 
		if (t != null) {
			inorder_traversal(t.left, depth + 1); //add 1 to depth (y coordinate) 
			t.xpos = totalnodes++; //x coord is node number in inorder traversal
			t.ypos = depth; // mark y coord as depth
			inorder_traversal(t.right, depth + 1);
		}
	}


}
