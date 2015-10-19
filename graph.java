//Nikita Miroshnichenko 27554869
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class graph extends JComponent{
	final LinkedList<line> lines=new LinkedList<line>();
	final LinkedList<point> points=new LinkedList<point>();
	final ArrayList<line> lines1=new ArrayList<line>();
	/**
	 * This method draws out the linkedlists of roads and intersections, as well as
	 * the separate arraylist of lines used for the shortest path method. 
	 */
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(point l:points){
			g.setColor(l.color);
			g.drawOval(l.x, l.y, 1, 1);
		}	
		for(line l:lines){	
			g.setColor(l.color);
			g.drawLine(l.p1.x, l.p1.y, l.p2.x, l.p2.y);
		}
		//Shortest Path
		for(line l:lines1){	
			g.setColor(l.color);
			g.drawLine(l.p1.x, l.p1.y, l.p2.x, l.p2.y);
		}
		int width=getSize().width;
		int height=getSize().height;
	}
	
	/**
	 * Used to add a line to the line linkedlist.
	 * @param l
	 */
	public void addLine(line l){
    lines.add(l);        
    repaint();
	}
	/**
	 * Used to add a line to the line arraylist.
	 * @param l
	 */
	public void addLineArray(line l){
		lines1.add(l);
		repaint();
	}
	/**
	 * Used to clear all lines from the linkedlist. Primary use is for redrawing the map.
	 */
	public void clearLines(){
    lines.clear();
    repaint();
	}
	/**
	 * Adds a point from the passed in dataset to the points linkedlist.
	 * @param p1
	 */
	public void addPoint(point p1){
	points.add(p1);        
	repaint();
	}
	/**
	 * Used to clear all points from the linkedlist. Primary use is for redrawing the map.
	 */
	public void clearPoint(){
	points.clear();
	repaint();
	}
	/**
	 * By recieving the id of a point, this program returns the whole point object
	 * with all of its parameters.
	 * @param id-Name id of the point.
	 * @return-The point.
	 */
	public point getPoint(String id){
		for(point l:points){
			if(l.name.equals(id)){
				return l;}
		}
		return null;
	}
	
}
