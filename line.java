//Nikita Miroshnichenko 27554869
import javax.swing.*;
import java.awt.*;
public class line{
	public String name;
	public point p1;
	public point p2;
	public Color color;
	public double weight;
	
	public point end;
	
	/**
	 * The constructor for a line.
	 * @param a-Name id of the line.
	 * @param b-Starting point of the line.
	 * @param c-Ending point of the line.
	 * @param d-Color of the line to be painted.
	 */
	public line(String a, point b, point c, Color d){
		name=a;
		p1=b;
		p2=c;
		color=d;
		weight=seglength(b,c);
		end=c;
	}
	/**
	 * Changes color to red. Used when drawing the MWST.
	 */
	public void changecolor(){
		color=Color.red;
	}
	/**
	 * Changes color to blue. Used when drawing the shortest path.
	 */
	public void changecolorPrime(){
		color=Color.blue;
	}
	/**
	 * Returns name of line, needed for the print out in part 3.
	 * @return
	 */
	public String returnString(){
		return name;
	}
	/**
	 * Returns starting point's name. Needing for weight calculation.
	 * @return
	 */
	public String returnp1(){
		return p1.name;
	}
	/**
	 * Returns ending point's name. Needing for weight calculation.
	 * @return
	 */
	public String returnp2(){
		return p2.name;
	}
	/**
	 * Returns wright. Used for MWST and dijkstra.
	 * @return
	 */
	public double returnweight(){
		return weight;
	}
	/**
	 * Sets both points of the line as visited. Used for MWST.
	 */
	public void setpointvisit(){
		p1.setvisit(true);
		p2.setvisit(true);
	}
	/**
	 * Checks if both points were visited.
	 * @return-Returns if they have been visited.
	 */
	public boolean ispointvisit(){
		return (p1.isvisit()&&p2.isvisit());
	}
	/**
	 * Calculates the length of the line. 
	 * The length is the weight of the line.
	 * @param a-Starting point.
	 * @param b-Ending point.
	 * @return-Returns the length (weight).
	 */
	public double seglength(point a, point b){
		double seglen;
		//seglen=(a.x-b.x*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		//seglen=Math.sqrt((Math.pow((b.x-a.x),2)+Math.pow((b.y-a.y),2)));
		//return((double) Math.sqrt(seglen));}
		seglen=(Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)));
		return seglen;}
}
