import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Graph {
	
	HashMap<String, ArrayList<Person>> adjlist = new HashMap(500, 2.0f);
	Person[] names;
	ArrayList<Person>[] lists;
	
	public void build(String file) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(file));
		ArrayList<Person> personlist = new ArrayList<Person>();
		//HashMap<String, Person> adjlist = new HashMap(500, 2.0f);
		String read = sc.nextLine();
		StringTokenizer st;
		int num = Integer.parseInt(read);
		this.names = new Person[num];
		this.lists = new ArrayList<Person>[num];
		
		// hashing time
		for(int i = 0; i < num - 1; i++){
			st = new StringTokenizer(sc.nextLine(), "|");
			names[i] = st.nextToken();
			Person temp = new Person(st.nextToken());
			
			if (st.countTokens() == 3) {
				temp.isCollege = true;
				st.nextToken();
				temp.college = st.nextToken();
			//	adjlist[i].isCollege = true;
			//	adjlist[i].college = st.nextToken();
			}
			names[i] = temp;
			//adjlist.put(temp.name, temp);
		}
		
		//edgy, brah
		while (sc.hasNext()) {
			st = new StringTokenizer(sc.nextLine(), "|");
			String sfirst = st.nextToken();
			Person pfirst;
			int i;
			for(i = 0; i < names.length; i++){
				if(names[i].name.equals(sfirst)){
					pfirst = names[i];
				}
			}
			String second = st.nextToken();
			Person psecond;
			int j
			for(j = 0; j < names.length; j++){
				if(names[j].name.equals(second)){
					psecond = names[j];
				}
			}
			lists[i].add(psecond);
			list[j].add(pfirst);
			//adjlist.put(first.name, second);
			//adjlist.put(second.name, first);
			
		}
		for(int i = 0; i<num; i++){
			adjlist.put(names[i].name, lists[i]);
		}
	}
	
	public HashMap<String, ArrayList<Person>> subgraph(String College){
		
		HashMap<String,ArrayList<Person>> sub = adjlist;
		for(int i = 0; i < names.length; i++){
			if(names[i].college.equals(College)){
				ArrayList<Person> temp = sub.get(names[i].name);
				for(Person p : temp){
					if(!p.college.equals(College)){
						temp.remove(p);
					}
				}
			}else{
				sub.remove(names[i].name);
			}
			
				
		}
		return sub;
	}
	
	public void shortestPath(){
		
	}
	
	public void connectedIsland(){
		
	}
	
	public ArrayList<Person> connectors(){
		
		ArrayList<Person> v;
		for(int i = 0; i <names.length; i++){
			ArrayList<Person> temp = adjlist.get(names[i].name);
			if(temp.length == 1){
				v.add(temp[0]);
			}
		}
	}

}