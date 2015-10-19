//Nikita Miroshnichenko 27554869
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
public class maindriver {
	/**
	 * Checks the command line arguments.
	 * Reads the entry following "-fin" as a file. Converts the entry into a file,
	 * reads the file and continues to implement desired methods for 
	 * calculating the MWST, dijkstra, graphing and displaying.
	 * @param args
	 * @throws FileNotFoundException
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws FileNotFoundException, AWTException, InterruptedException{
		
		String file1="";
		String currentLine;
		Scanner s1=new Scanner(System.in);
		BufferedReader bf=null;
		String[] textbreaker=null;
		
		
		JFrame jf = new JFrame();
		graph sm= new graph();
		graph sm1= new graph();
		JFrame jfmw = new JFrame();
		JFrame jf2 = new JFrame();
		mwst tree=new mwst();
		dij dj=new dij();
		
			for(int i=0; i<args.length;i++){
				if(args[i].equals("-fin")){
					file1=args[i+1];
				}
			}
		try{
		
		File f1=new File(file1);
		Scanner scan1=new Scanner(f1);
			/**
			 * Checking whether a the next line in the file is an intersection
			 * or a road, the method adds the entity into the desired linkedlist,
			 * arraylist, hashtable and hashset.
			 */
			while(scan1.hasNextLine()){
				String starter=scan1.next();									
				if(starter.equals("i")){
					String string1=scan1.next();
					float float1=Float.parseFloat(scan1.next());
					float float2=Float.parseFloat(scan1.next());
					int int1=(int)float1;
					int int2=(int)float2;
					point p1=new point(string1, int1, int2, Color.yellow);
					//System.out.println(p1.name+" , "+p1.x+" , "+p1.y);
					sm.addPoint(p1);
					sm1.addPoint(p1);
					point.allPoints.add(p1);
				}
				else if(starter.equals("r")){
					String string1=scan1.next();
					String string2=scan1.next();
					String string3=scan1.next();	
					point p1=sm.getPoint(string2);
					point p2=sm.getPoint(string3);
					line l1=new line(string1, p1, p2, Color.black);
					//System.out.println(l1.returnString()+" , "+l1.returnp1()+" , "+l1.returnp2()+" , "+l1.returnweight());
					sm.addLine(l1);
					sm1.addLine(l1);
					tree.lineADD(l1);
					p1.lineAdd(l1, p2);
				}
				if(scan1.hasNextLine()){
				    scan1.nextLine();}
			}
			scan1.close();
			
			/**
			 * The first map is displayed. This is the standard map.
			 */
			jfmw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jfmw.add(sm1); 
			jfmw.setSize(630,630);
			jfmw.setVisible(true);
			
			/**
			 * This should ideally take the screenshot of the original map.
			 * Since the two jframes (of the original map, and the mwst and map) 
			 * are displayed on top of eachother, the screenshot of the original map
			 * cannot be taken. I was not able to fix this issue. Even so, the jframe
			 * of the original map is displayed. There just is not .png of the orignal map. 
			 */
			/*BufferedImage i2=new Robot().createScreenCapture(new Rectangle(jfmw.getLocationOnScreen().x, jfmw.getLocationOnScreen().y, jfmw.getWidth(), jfmw.getHeight()));
			File file3 = new File("map.png");
			ImageIO.write(i2, "png", file3); */
			
			/**
			 * The MWST imposed over the original map is displayed.
			 */
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(sm);
			tree.makelinearray();
			tree.sortline();
			LinkedList<line> drawmwst=tree.countmwst();
			for(line l:drawmwst){
				l.changecolor();
				sm.addLine(l);
			}
			jf.setSize(630,630);
			jf.setVisible(true);
			
			/**
			 * Screenshot of the jframe is taken and saved into a .png file.
			 */
			BufferedImage i1=new Robot().createScreenCapture(new Rectangle(jf.getLocationOnScreen().x, jf.getLocationOnScreen().y, jf.getWidth(), jf.getHeight()));
			File file2 = new File("tree.png");
			ImageIO.write(i1, "png", file2);
			
			/**
			 * Prompt for user to enter the two points used in
			 * calculating the shortest path algorithm for the two points.
			 */
			System.out.println("Please Enter Two Points to be Tested for Shortest Path:");
			Scanner scan2=new Scanner(System.in);
			point testp1=null;
			point testp2=null;
			String a="^d";
			/**
			 * The standard input is scanned for the two points. Their values 
			 * of the two points are saved and implemented in the dij.java file.
			 */
			boolean s11=scan2.hasNext();
			if(s11){
				String string1=scan2.next();
				float float1=Float.parseFloat(scan2.next());
				float float2=Float.parseFloat(scan2.next());
				int int1=(int)float1;
				int int2=(int)float2;
				testp1=new point(string1, int1, int2, Color.yellow);	
				
				while(scan2.hasNextLine()){
					while(scan2.hasNext()){
						String string2=scan2.next();
						float float4=Float.parseFloat(scan2.next());
						float float3=Float.parseFloat(scan2.next());
						int int4=(int)float4;
						int int3=(int)float3;
						testp2=new point(string1, int4, int3, Color.yellow);
						if(scan2.next().equals(a)) break;
					}
				break;}	
			}
			scan2.close();
			
			/**
			 * If there is a possible shortest path made up of defined lines
			 * between the two points, then the points as well as the lines
			 * comprising the shortest path are printed out.
			 * Similarly, a new jframe will be displayed showing the original map
			 * and the shortest path imposed onto it in blue color.
			 */
			ArrayList<line> djlines=dj.shortestPath(testp1, testp2);
			if(djlines!=null){
				for(line l:djlines){
					l.changecolorPrime();
					sm.addLineArray(l);
				}
				jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf2.add(sm); 
				jf2.setSize(630,630);
				jf2.setVisible(true);}
			else System.out.println("Program Terminated");
				
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	
	}

}
