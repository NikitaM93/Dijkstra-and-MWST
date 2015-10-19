//Nikita Miroshnichenko 27554869
import java.util.LinkedList;
public class mwst{
	final LinkedList<line> lineslist=new LinkedList<line>();
	final LinkedList<point> pointslist=new LinkedList<point>();
	point[] points;
	line[] lines;
	/**
	 * The method used to calculate the MWST.
	 * The MWST is returned as an array of lines, used to be drawn in red color.
	 */
	public mwst(){}
	public void sortline(){
		for(int i=0;i<lines.length;i++){
			double minimumLine= lines[i].returnweight();
			int index=i;
			for(int j=i+1;j<lines.length;j++){
				if(lines[j].returnweight()<minimumLine){
					minimumLine=lines[j].returnweight();
					index=j;
				}
			}
			if(index!=i){
				line x=lines[index];
				lines[index]=lines[i];
				lines[i]=x;
			}
		}
	}
	/**
	 * The returned array of lines of the MWST is converted into a linkedlist 
	 * to return to maindriver to be used in the graph class to draw the MWST.
	 * @return
	 */
	public LinkedList countmwst(){
		LinkedList<line> returnlist=new LinkedList<line>();
		for(int i=0;i<lines.length;i++){
			if(!lines[i].ispointvisit()){
				returnlist.add(lines[i]);
				lines[i].setpointvisit();
			}
		}
		return returnlist;
	}
	/**
	 * Adds a point to the point linkedlist.
	 * @param p1
	 */
	public void pointADD(point p1){
		pointslist.add(p1);        
	}
	/**
	 * Adds a line to the line linkedlist.
	 * @param l
	 */
	public void lineADD(line l){
		lineslist.add(l);
	}
	public void makepointarray(){
		points=(point[]) pointslist.toArray();
	}
	/**
	 * Converts the specified linkedlist into an array, 
	 * to be used in the sortline method of the MWST.
	 */
	public void makelinearray(){
		lines=new line[lineslist.size()];
		for(int i=0;i<lineslist.size();i++){
		lines[i]=lineslist.get(i); 
		}
	}
}
