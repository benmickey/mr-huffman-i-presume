
public class Node implements Comparable //Node can serve as expression tree class
{	
	public char element; 
	public int freq;
	public Node left; 
	public Node right; 
	//public Node parent; 
	public String code; 
	int xpos;  //stores x and y position of the node in the tree
	int ypos; 
	int tCount; 

	//root node 
	Node()
	{
		this(null,null,null); 
	}

	Node(Node l, Node r, Node p)
	{
		left = l;
		right = r;
		//parent = p; 
		freq = 0; 
		xpos = 0;  //stores x and y position of the node in the tree
		ypos = 0; 
		tCount = 1; 
		code = ""; 

	}

	//Constructor
	Node(char x, int freq1)
	{
		this.left = null; 
		this.right = null; 
		this.freq = freq1;
		this.element = x; 
		this.code = ""; 
		xpos = 0;  //stores x and y position of the node in the tree
		ypos = 0; 
		tCount = 1; 
	}

	Node(char x, Node l, Node r, Node p, int b, String str1)
	{
		element = x; 
		left = l; 
		right = r; 
		//parent = p; 
		freq = b; 
		code = str1; 
		xpos = 0;  //stores x and y position of the node in the tree
		ypos = 0; 
		tCount =1; 
	}

	/*
	public int compareTo(Node another)
	{
		 int less = -1;
		 int equal = 0;
		 int greater = 1;

		 if(this.freq<another.freq)
		 {
			 return less; 
		 }
		 else if(this.freq>another.freq)
		 {
			 return greater; 
		 }
		 else
			 return equal; 
	}*/

	public int compareTo(Object otherObject) {
		Node other = (Node) otherObject; 
		if (this.freq < other.freq) return -1; 
		if (this.freq > other.freq) return 1; 
		return 0;
	}

	public static String encode(Node x, char goal)
	{
		String y = ""; 

		while(x.element != goal)
		{
			encode(x.left, goal); 
			y+="0"; 
			encode(x.right, goal); 
			y+="1"; 	
		}

		return y; 
	}

	/*
	public int compare(Node another) {
		 int less = -1;
		 int equal = 0;
		 int greater = 1;

		 if(this.freq < another.freq)
		 {
			 return less; 
		 }
		 else if(this.freq > another.freq)
		 {
			 return greater; 
		 }
		 else
			 return equal; 
	}*/

	/*
	public void print() {
        left.print();
        System.out.println(freq);
        right.print();
    }*/


	/*
	public String printMyTree(Node<AnyType> x) //Print method results reviewed and approved by Professor Blaer!  
	{
		String printString = ""; 
		        if( x != null )
		        {
		        	System.out.print("("); 
		            printMyTree( x.left);
		            System.out.print( x.element );
		            printMyTree( x.right );
		            System.out.print(")"); 
		        }
		return printString; 	
	}*/

}



//Notes
/*private <Anytype> root; 

private AnyType data;
private Node right; 
private Node left; 

 */

/*
public Node()
{
	AnyType data; 
	Node right = new Node(); 
	Node left = new Node(); 
}
 */

/*
public char getData()
{
	return data; 
}
 */
/*
public Node getLeftChild()
{
	return leftChild; 
}

public Node getRightChild()
{
	return rightChild; 
}


/*
public void setData(Node Y, AnyType x)
{
	Y.initialData = x; //set data 
}

public AnyType getData(Node z)
{
	return z.initialData; 
}
 */


/*
public void setRoot( AnyType x )
{
	root = x; 
}

public void setLeftchild( AnyType x)
{
	leftChild = x; 
}

public void setRightchild( AnyType x)
{
	rightChild = x; 
}

public Node getValue()
{
	return root; 
}
 */
