
public class Person {
	String name;
	String college;
	Person parent;
	int depth;
	boolean isCollege;
	boolean visited;
	
	public Person(){
		name = null;
		isCollege = false;
		college = null;
		visited = false;
		parent = null;
		depth = 0;
	}
	
	public Person(String name){
		this.name = name;
		college = null;
		isCollege = false;
		visited = false;
		parent = null;
		depth = 0;
	}
	
	public Person(String name, String college){
		
		this.name = name;
		this.college = college;
		visited = false;
		parent = null;
		depth = 0;
		isCollege = true;
	}
	
	
}
