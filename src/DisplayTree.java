
// in this case we are displaying a Binary Search tree  
// reference problem 4.38 of Weiss to compute tree node x,y positions

// input is a text file name that will form the Binary Search Tree

//     java DisplaySimpleTree textfile


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class DisplayTree extends JFrame {
	JScrollPane scrollpane;
	DisplayPanel panel;

	public DisplayTree(HuffmanTree t) {
		panel = new DisplayPanel(t);
		panel.setPreferredSize(new Dimension(300, 300));
		scrollpane = new JScrollPane(panel);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();  // cleans up the window panel
	}
}

class DisplayPanel extends JPanel {
	HuffmanTree t;
	int xs;
	int ys;

	public DisplayPanel(HuffmanTree t) {
		this.t = t; // allows dispay routines to access the tree
		setBackground(Color.white);
		setForeground(Color.black);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground()); //colors the window
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getForeground()); //set color and fonts
		Font MyFont = new Font("SansSerif",Font.PLAIN,10);
		g.setFont(MyFont);
		xs=20;   //where to start printing on the panel
		ys=20;
		g.drawString("Representation of Huffman Code in Tree\n",xs,ys);
		ys=ys+10;;
		int start=0;
		
		MyFont = new Font("SansSerif",Font.BOLD,20); //bigger font for tree
		g.setFont(MyFont);
		this.drawTree(g, t.root); // draw the tree
		revalidate(); //update the component panel
	}

	public void drawTree(Graphics g, Node root) {//actually draws the tree
		int dx, dy, dx2, dy2;
		int SCREEN_WIDTH=300; //screen size for panel
		int SCREEN_HEIGHT=500;
		int XSCALE, YSCALE;  
		XSCALE=SCREEN_WIDTH/t.totalnodes; //scale x by total nodes in tree
		YSCALE=(SCREEN_HEIGHT-ys)/(t.maxheight+1); //scale y by tree height

		if (root != null) { // inorder traversal to draw each node
			drawTree(g, root.left); // do left side of inorder traversal 
			dx = root.xpos * XSCALE; // get x,y coords., and scale them 
			dy = root.ypos * YSCALE +ys;
			Character x = null; 
			String s =""; 
			if(root.element == 10)
			{
				s = "NL"; 
			}
			else if(root.element == 32)
			{
				s = "SP"; 
			}
			else if (root.left !=null && root.right !=null)
			{
				s="T"; 
				String str = Integer.toString(root.tCount); 
				s+=str; 
			}
			else
			{ 
				x = (Character) root.element; 
				s = x.toString();
			}
			g.drawString(s, dx, dy); // draws the word
			// this draws the lines from a node to its children, if any
			if(root.left!=null){ //draws the line to left child if it exists
				dx2 = root.left.xpos * XSCALE; 
				dy2 = root.left.ypos * YSCALE +ys;
				g.drawLine(dx,dy,dx2,dy2);
			}
			if(root.right!=null){ //draws the line to right child if it exists
				dx2 = root.right.xpos * XSCALE;//get right child x,y scaled position
				dy2 = root.right.ypos * YSCALE + ys;
				g.drawLine(dx,dy,dx2,dy2);
			}
			drawTree(g, root.right); //now do right side of inorder traversal 
		}
	}
}



