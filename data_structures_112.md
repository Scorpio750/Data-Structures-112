# Data Structures 112
## Sesh Venugopal
## Fall 2013

---
---
## Table of Contents


1. [Linked Lists](#anchor1)
2. [Graphs](#anchor2)
3. [Final Review](#anchor3)

---

## [Linked Lists](id:anchor1)

- Generic Linked Lists
	- [Wrapper classes: Takes primitive types and turns them into Objects] 
		- Integer, Float, Double, Character, Short, Long, Byte
	- Replace primitive type with generic type (can be any name, we use 'T' as example):
		
			public T data;
			public Node<T> next; //constructor argument does not take T
		
		- When using new types the compiler will *auto-box* them for you (convert primitive types to wrapper classes, e.g. 10 auto-boxes into Integer(10)):
			
				LinkedList<Integer> intll = new LinkedList<Integer>;
				intll.addFron(10);
				intll.addFront(15);
				intll.deleteFront();

### ArrayLists

- 'Smart' array: grows automatically on demand

		ArrayList<Integer> al = new ArrayList<Integer>(); //initial capacity 10

### Sorted Array

- Core set of operations:
	- Worst-case Big O: 
		- Search, insert delete, all $$$O(\log n)$$$
	- *Inefficient data structure*

## Binary Search Trees

- Recursive function using nodes
- Root pointer pointing to top node

---

## [Graphs](id:anchor2) 

 
#### Structure

- Have edges and vertices
	- Trees are a type of graph
- Two types of graph: directional and undirectional
	- Directional graphs point from one vertex to another $$$E = (u,v)$$$ 
	where direction is from $$$u$$$ to $$$v$$$.
			
	- Undirectional graphs don't have directionality

	- You can have circular edges:
		$$$E = (v,v)$$$
		where $$$E$$$ loops back to its origin
	
	- Paths are series of same-pointing edges along a set of vertices

#### Implementation
- Graphs can be modeled in two ways: Adjacency matrices and adjacency lists
- Adjacency matrix
	- Size $$$v^2$$$
	- An undirectional graph will have a symmetrical matrix
- Adjacency list
	- Array of vertices with linked lists determining connections
	- Size $$$|V|+|4E\,|$$$	
	- For undirectional graphs each edge must be counted twice
- A graph is called *sparse* when it has far fewer edges than the maximum possible
	- Sparse graphs have a lot of '0's or 'F's in an adjacency matrix
	- Best modeled with an adjacency list
- Maximum # of edges:
	- Undirected graph: $$${n(n-1)}\over 2$$$
	- Digraph: $$$n(n-1)$$$
	
	

#### Traversals

- Two types of *traversals*, **depth-first search** and **breadth-first search** (DFS and BFS)
- A path is 
	- DFS: traverse as deep as you can via one path (pre-order traversal)
	- BFS: traverse first one vertex, then all vertices one node away, then all vertices two nodes away, etc. (level-order traversal)
- When traversing a graph, each vertex needs a boolean field to check whether it has been visited already.
- **DFS**
	- can be done recursively
	
			public void dfs(Vertex u) {
				u.visit();
				u.visited = true;
				for (each vertex v such that (u,v) is an edge in E) {
					if (!v.visited) {
						dfs(v);;
						}
					}
				}
			}
			
- **BFS**
	- can be done with a queue
	
			public void bfs(Vertex u) {
				u.visit(null);
				u.visited = true;
				q = new Queue();
				q.enqueue(u);
				while (!q.isEmpty()) {
					v = q.dequeue;
					for (each vertex w such that (v,w) is an edge in E) {
						if (!w.visited) {
							w.visit(v);
							q.enqueue(w);
							}
						}
					}
			
			public class Vertex {
				protected Vertex parent;
				protected int depth;
						
				public void visit(Vertex origin) {
					this.parent = origin;
					if (origin == null) {
						this.depth = 0;
						} else {
						this.depth = origin.depth + 1;
						}
						w.visited = true;
					}
				}
				
	- When edge $$$(v,w)$$$ is traversed to visit $$$w$$$, depth of $$$w$$$ = depth of $$$v + 1$$$, and $$$v$$$ becomes the *parent* of $$$w$$$. 

	- ***BFS** can be used to find SHORTEST PATHS for UNWEIGHTED graphs from your starting vertex to any vertex in the graph*
		- When looking for the shortest path from your starting vertex $$$A$$$ to any vertex $$$A^*$$$, trace the parent pointers back from $$$A^\*$$$ back to $$$A$$$. The distance will be the depth.
- Both **DFS** and **BFS** run in $$$O(|V|+|E|)$$$ time if you use an adjacency list, $$$O(|V|^2)$$$ for an adjacency matrix

#### Weighted Graphs

- **Weighted graphs** are those whose edges are weighted with information
- Weight edges with a numerical value
- - Adjacency matrix: 2D array of ints/doubles/whatever
- Adjacency list: Each instance includes a weight
- Shortest path problems
	- "Minimum Spanning Tree"
		- Each node is an outlet, or source of electricity
		- Each edge is a length of wire
		- How can you connect them all with the shortest length of wire?
	- Kruskal's Algorithm
		- You have a graph $$$G=(V,E)$$$
		- "Spanning tree" $$$T=(V,F)$$$ of $$$G$$$ is a graph w/ same vertices as $$$G$$$, and $$$|V|-1|$$$ edges that form a tree.
		- If G is not connected, T is a *forest*, a collection of trees
		- If G is weighted, a "minimum spanning tree" is a spanning tree of G whose total weight summed over all edges of T is minimal.
- Create new graph T with same vertices as G, but no edges

#### Applications

- Graphs can be used to model shortest-route directions across multiple waypoints
- Can also be used to model friendships and other directional relationships

---

### 12/13/13
### [Final Review](id:anchor3)

- Default for heaps is always Max_Heap unless specified as Min_Heap

**Hash Tables: Smallest dataset**

- Init cap = 5
- Force one rehash
- $$$\lambda$$$Threshold = 2
- Need at end
	- (Avg #comparisons for search) < 3
	- Worst case = 6
- Min. # entries to cause rehash = 11 (load threshold * init. cap + 1)

### Heaps

- Can be implemented as either an array or a **complete** binary tree (no gaps in your tree, must be filled from left to right)
- Min heap - smallest value on top
	- Every node is itself a heap
- When implemented as an array,
	- LC = 2k+1
	- RC = 2k+2
	- P = $$$\lfloor \left( {k-1 \over 2} \right) \rfloor$$$
	
	| 0 | 1 | 2 | 3 | 4 | 5 |
	| - | - | - | - | - | - |
	| 10 | 20 | 30 | 50 | 40 | 60 |

- Updatable heaps - a heap with an auxiliary data structure that minimizes the search time (otherwise it's linear), usually a hash table
- Efficiency analysis
	- Big O of analysis of sift ups and sift downs:
	$$n = 2^0 + 2^1 + 2^2 +... = 2^{h+1} - 1$$
	- for $$$S$$$ = worst case number of comparisons,
		- $$$S = O(n)$$$ for heap build
		- $$$S = O(n\log n)$$$ for add/remove

#### Heapsort

- Heapification - ordering an array to be a heap in order to reduce the amount of sifts needed
	- Each leaf node is already its own heap
		- \# of leaf nodes in a complete binary tree is always at least **half** the total # of nodes
		- Less than $$$2n \log n$$$ but still $$$n\log n$$$
		<br>
		<br>
- Big O of **HeapSort**: 
	
	\\[\begin{aligned}
	\mbox {Build phase:} \quad &\sum_{i=1}^{n} \log(e_i) = \log\Big(\prod\_{i=1}^{n}e_i\Big) = \log n!\,, \; \text{for element } e \\\
	&\log n! \approx n \log n\; \text{by Stirling's Formula} \\\
	\\
	\mbox {Sort phase:} \quad &O(n\log n) \\\
	\mbox {Big O:} \quad &O(n\log n) + O(n\log n) = O(n\log n)
	\end{aligned} \\]
	

### Quicksort

1. Take first element to be your pivot
2. Take lo and hi pointers, lo = pivot index + 1, hi = length - 1;
3. Move lo up until it's higher than pivot
4. Move hi down until lower than pivot
5. Swap lo and hi values if lo is less than hi
6. Repeat until lo and hi cross
5. Once the lo and hi cross, swap pivot with hi
6. Repeat 1-5 recursively on sublist new pivot [0, index - 1] and [index + 1, length - 1]
7. Rinse and repeat.

- Big O:
	- Worst-case:  $$$O(n\log n)$$$

##### [Optimization]

1. Pick three values and use median as pivot
2. Call QuickSort on the lower sublist first all the way before calling on the higher sublist
3. Recursive calls are expensive
	- Insertion sorts are recommended for items fewer than 20

### Insertion Sort

1. Check first number in unsorted part against all numbers in sorted sublist
2. Best case $$$O(n)$$$

### Djikstra's Algorithm

- Used to find shortest distances on weighted graphs $$$\; A \to B$$$ 
	- Keeps track of previous (parent) vertices
- 'Greedy' Algorithm
	- Goes for a path first, then corrects itself if it finds a shorter one
1. Start from the source vertex and find all vertices one edge away from it.
	- These are called the *fringe*.
	- All vertices beyond the *fringe* are treated with a distance of $$$\infty$$$
2. Take the vertex with the smallest minimum distance and remove it from the *fringe*
	- Guaranteed to be shortest path
3. Add your current vertex's neighbors to the *fringe* if they aren't there already
4. Adjust minimum distances to vertices in the fringe given your new current vertex as necessary 
5. When you have more than one vertex with the same minimum vertex, you may take any of them.
6. Repeat 2-6 until you empty out your fringe.
7. This gives you the shortest distance to any vertex traversable from the source.
- Use priority queue for fringe


### Topological Sort

- Used to sort dependencies, where a dependency is a directed edge from X to Y. Here Y has a dependency on X
- use **DFS**
- Start with an int = # vertices
- Trace directed edges until it is a terminal vertex, i.e. no outgoing edges
	- Assign that vertex a value 
	
### Practice Final Exam

#### Question 5: Heap Merge

- $$$k$$$ heaps, each has $$$n$$$ elements.
- 4 different methods of merging them:
- (a) 
	- Deleting all elements in each heap = $$$n \log n$$$
times k heaps = $$$kn \log n$$$
	- Adding to heap H: $$$kn$$$ elements
	
		$$\log (1) + \log(2) +...+\log (kn) = \sum_{i=1}^{kn}\log(i)$$
		
	- Operations: $$$kn\log kn + kn\log n$$$
	- Final Big O: $$$O(kn \log kn)$$$
- (b) 
	- Start with empty LL (L)
	- Delete all elements from k heaps: $$$kn \log n$$$
	- Fill L, **add to front**:		$$$kn$$$
	- Transfer from L to array:		$$$kn$$$ 
	- Convert array into heap order (Order of how many elements you have):	$$$kn \log n$$$ - (An array would work just as well)
	- Operations: $$$kn\log n + kn + kn$$$
	- Final Big O: $$$O(kn \log n)$$$
- (c) 
	- start with empty LL
	- fill L by iterating over array for each heap: $$$kn$$$
	- Xfer to array:	$$$kn$$$
	- heapify $$$kn$$$
	- Operations: $$$3kn$$$
	- Final Big O: $$$O(kn)$$$
- (d) 
	- Group k heaps into k/2 pairs
	- apply (c) to each pair, leaving k/2 heaps. Repeat until single heap.
	- Height = log(k)
	- Operations: $$$(kn\log k)$$$
	- Final Big O: $$$O(kn\log k)$$$