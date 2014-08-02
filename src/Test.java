import java.io.*; 
import java.nio.charset.Charset;
import java.util.*;


public class Test {

	public static void main(String[] args) throws IOException
	{
		//Read Input Character By Character & Get Frequencies into Array 
		String path = args[0]; 
		InputStream in = new FileInputStream(path);
		Charset set = Charset.defaultCharset();
		Reader reader = new InputStreamReader(in, set);
		int[] freqArray = new int[128];
		int read;
		while ((read = reader.read()) != -1)
		{
			char c = (char) read;
			int idx; 
			idx = (int) c; 
			freqArray[idx]++; 
		}

		//Test Frequencies & get Characters
	    
		System.out.println("---------Frequencies--------"); 
		for(int a=0; a<freqArray.length; a++)
		{
			if(freqArray[a]!=0)
			{
				char b = (char) a; 
				int test = (int) b; 
				if(test == 10 )
				{
					String x = "NL"; 
					System.out.print(x+" "); 
					System.out.println(freqArray[a]); 
				}
				else if(test == 32)
				{
					String t = "SP"; 
					System.out.print(t+" "); 
					System.out.println(freqArray[a]); 
				}
				else
				{
					System.out.print(b+" "); 
					System.out.println(freqArray[a]);
				}
			}
		}
		
		HuffmanTree myTree = new HuffmanTree(); 
		BinaryHeap x = new BinaryHeap(); 
		x = myTree.buildTree(freqArray);
		
		System.out.println("---------Test Total Frequencies--------"); 
		Node y = (Node) x.findMin(); 
		System.out.println(y.freq); 	
		
		
		//Node root = myTree.getRoot(); 
		//System.out.println(root.freq); 
		
		//Table for Huffman Codes
		System.out.println("---------Huffman Table--------"); 
		System.out.println("Character" +" | " + "Huffman Code" +" | " + "Frequency");
		String t = ""; 
		myTree.encode(y, t); 
		
	
		myTree.computeNodePositions(); //finds x,y positions of the tree nodes
		myTree.maxheight=myTree.treeHeight(myTree.root); //finds tree height for scaling y axis
		DisplayTree dt = new DisplayTree(myTree);//get a display panel
		dt.setVisible(true); //show the display
	

		
	}
}
