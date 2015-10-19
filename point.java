//Nikita Miroshnichenko 27554869
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Set;
public class point implements Comparable{
	protected String name;
	protected int y;
	protected int x;
	public static int counter=0;
	public Color color;
	private boolean visit;
	public int hashId;
	public Hashtable<line,point> connected=new Hashtable<line,point>();
	public LinkedList<line> connectedlines=new LinkedList<line>(); 
	public static HashSet<point> allPoints=new HashSet<point>();
	public double minDistance=Double.POSITIVE_INFINITY;
	public point prev;
	
	/**
	 * Constructor of a point.
	 * @param a-Name id.
	 * @param b-x coordinate.
	 * @param c-y coordinate.
	 * @param d-Color of the point.
	 */
	public point(String a, int b, int c, Color d){
		name=a;
		x=b;
		y=c;
		color=d;
		visit=false;
		hashId=counter+1;
	}
	/**
	 * Returns the name id of the point.
	 * @return-Name (id).
	 */
	public String returnString(){
		return name;
	}
	/**
	 * Returns a boolean stating if a point has been visited.
	 * Used for the MWST calculation.
	 * @return-Visit (if visited).
	 */
	public boolean isvisit(){
		return visit;
	}
	/**
	 * Sets wether a point has been visited.
	 * Used for the MWST calculation.
	 * @param v
	 */
	public void setvisit(boolean v){
		visit=v;
	}
	public int comparePoints(point b){
		return Double.compare(minDistance,  b.minDistance);
	}
	/**
	 * Used to compare points.
	 * The cost (minDistance) of each point is used in the comparement.
	 */
	public int compareTo(Object o){
		point p=(point)o;
		return Double.compare(minDistance,p.minDistance);
	}
	/**
	 * Adds a line to the linkelist of lines connected to the point.
	 * @param l-Line (line connected to the point).
	 */
	public void lineListADD(line l){
		connectedlines.add(l);
	}
	/**
	 * Returns the connected from the hashtable of connected lines and their end points.
	 * @param p-Line (line connected to the point).
	 * @return
	 */
	public point pointReturn(line p){
		return connected.get(p);
	}
	/**
	 * Adds a line and end point of the line to the hashtable of connected elements.
	 * Used to calculate dijkstra's algorithm.
	 * @param l-Connected line.
	 * @param p-Endpoint of the connected line.
	 */
	public void lineAdd(line l, point p){
		connected.put(l,p);
	}
	/**
	 * Returns all connected lines.
	 * @return
	 */
	public Set<line> returnLines(){
		return connected.keySet();
	}
	/**
	 * Returns all points entered in the file dataset.
	 * @return
	 */
	public static Set<point> returnAll(){
		return allPoints;
	}
}

