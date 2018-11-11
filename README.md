# Maze3.2

Human Readable Output:

The start state of the maze:
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x   $     x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x       g   x
x      x           x
xxxxxxxxxxxxxxxxxxxx
All successors of the start state:
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x   s|    x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x       g   x
x      x           x
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x  |s     x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x       g   x
x      x           x
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x   s     x        x
x   |   x x  xxxxxxx
x  xx xxxxx        x
x      x       g   x
x      x           x
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x   |   x xxxxx    x
x   s     x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x       g   x
x      x           x
xxxxxxxxxxxxxxxxxxxx


4.2.3
output:
Enter 'q' to quit
Press Enter to start BreadthFirstSearch.
§>
Frontier-size:1, currentPath-cost:0
Frontier-size:2, currentPath-cost:1
Frontier-size:2, currentPath-cost:2
Frontier-size:2, currentPath-cost:2
Frontier-size:2, currentPath-cost:3
Frontier-size:2, currentPath-cost:3
Frontier-size:2, currentPath-cost:4
Frontier-size:2, currentPath-cost:4
Frontier-size:2, currentPath-cost:5
Frontier-size:2, currentPath-cost:5
Frontier-size:2, currentPath-cost:6
Frontier-size:2, currentPath-cost:6
Frontier-size:2, currentPath-cost:7
Frontier-size:2, currentPath-cost:7
Frontier-size:2, currentPath-cost:8
Frontier-size:2, currentPath-cost:8
Frontier-size:2, currentPath-cost:9
Frontier-size:2, currentPath-cost:9
xxxxxxxxxxxx
x§||||||||$x
x xxxxxxxx x
x          x
xxxxxxxxxxxx
Frontier-size:1, currentPath-cost:10
1 solutions found, 18 paths added.
Enter 'q' to terminate BreadthFirstSearch and start DepthFirstSearch
Press Enter to continue BFS.
§>q
Frontier-size:1, currentPath-cost:0
Frontier-size:2, currentPath-cost:1
Frontier-size:2, currentPath-cost:2
Frontier-size:2, currentPath-cost:3
Frontier-size:2, currentPath-cost:4
Frontier-size:2, currentPath-cost:5
Frontier-size:2, currentPath-cost:6
Frontier-size:2, currentPath-cost:7
Frontier-size:2, currentPath-cost:8
Frontier-size:2, currentPath-cost:9
Frontier-size:2, currentPath-cost:10
Frontier-size:2, currentPath-cost:11
Frontier-size:2, currentPath-cost:12
Frontier-size:2, currentPath-cost:13
xxxxxxxxxxxx
x§        $x
x|xxxxxxxx|x
x||||||||||x
xxxxxxxxxxxx
Frontier-size:1, currentPath-cost:14
1 solutions found, 14 paths added.
Enter 'q' to terminate SearchDemo
§>

We can see a few differences between the DFS and the BFS, the BFS finds the shortest path while the DFS just finds a path.
In our output for DFS the 14 paths added are the steps of the path wwhile in the BFS we have actually 18 wich is way more then the
10 steps we took. this shows how the DFS has linear cost and the BFs has exponential cost.

4.2.4
output:
Enter 'q' to quit
Press Enter to start BreadthFirstSearch.
§>
Frontier-size:1, currentPath-cost:0
0 solutions found, 0 paths added.
Enter 'q' to terminate BreadthFirstSearch and start DepthFirstSearch
Press Enter to continue BFS.
§>q
Frontier-size:1, currentPath-cost:0
0 solutions found, 0 paths added.
Enter 'q' to terminate SearchDemo
§>
We use cycle detection and have finite graphs wich means the only way that we dont find a solution is that there is no solution.