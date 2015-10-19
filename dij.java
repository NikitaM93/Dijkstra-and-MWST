//Nikita Miroshnichenko 27554869
import java.util.TreeSet;
import java.util.ArrayList;
public class dij{
	/**
	 * By using dijkstra's algorithm developed in class and in labs, this method
	 * calculates the shortest path between two queried points by looking at the
	 * hashset of entered points and hashtable of connected lines and points.
	 * @param p1-First point queried.
	 * @param p2-Second point queried.
	 * @return -The result of this method returns an arraylist of lines connecting
	 * the shortest path between the two points.
	 */
	public ArrayList<line> shortestPath(point p1, point p2){
		line lines[]=new line[point.counter];
		point prior[]=new point[point.counter];
		TreeSet<point> tree=new TreeSet<point>();
		p1.minDistance=0;
		tree.addAll(point.returnAll());
		point p3=null;
		
		while(!tree.isEmpty()){
			p3=tree.pollFirst();
			if(p3==p2||p3.minDistance==Double.POSITIVE_INFINITY){
				break;
			}
			for(line l:p3.returnLines()){
				point p4=p3.pointReturn(l);
				double finalDistance=p3.minDistance+l.weight;
				if(finalDistance<p4.minDistance){
					tree.remove(p4);
					p4.minDistance=finalDistance;
					tree.add(p4);
					lines[p4.hashId]=l;
					prior[p4.hashId]=p3;
				}
			}
		}
		if(p3==p2){
			ArrayList<point> points1=new ArrayList<point>();
			ArrayList<line> lines1=new ArrayList<line>();
			for(point p=p3;p!=p1;p=prior[p.hashId]){
				points1.add(p);
				lines1.add(lines[p.hashId]);
			}
			points1.add(p1);
			int end=points1.size()-1;
			for(int i=end;i>=0;end--){
				if(i!=end){
					System.out.print(", ");
				}
				System.out.print(points1.get(i).name);
			}
			System.out.println();
			end=lines1.size()-1;
			for(int i=end;i>=0;i--){
				if(i!=end){
					System.out.print(", ");
				}
				System.out.print(lines1.get(i).name);
			}
			System.err.println();
			return lines1;
		}
		else{ 
		System.out.println("Path Not Found");
		return null;
		}
	}
}
