# Maze 5.2

## 5.2
##5.2.1
We Decided to use the Manhatten distance for the heuristic as it is underestimating the actual distance by giving the minimal possible distance (ie if each position were accessible). It is useful if we assume that going into the general direction of the nearest goal is a good idea.
We calculate the minimal distance to a goal (by checking for each goal and determining the minimum), in order to cope with multiple goals.

We implemented A* by a BasicHeuristicSearch-class which manages the frontier by a priority queue. It expects 
a Comparator<SearchPath> as a necessary constructor argument and initialises the queue with this comparator. We provide an AStartComparator which compares two paths on the basis of the sum of the path cost and the heuristic value of the last searchState in this path. 

For output look at 5.2.4

##5.2.2
If the Heuristic is supposed to work with Portals we also have the possibility that there is a shorter way then the manhatten distance, if we go through a portal. Therefore we need to adjust our heuristic. We did this by choosing either the minimum of the previous heuristic value (Manhattan-distance to nearest goal) or (if smaller) the minimal value of the sum of (distance to the current point + heuristic of portal target) amongst all portals.
This solution does not go well with the "chaining" of portals: If a nearby portal gets us far away from a goal but very near to another portal, which in turn gets us right next to the goal, this might be a shortest path.
We could further adjust our solution by using Dijkstra to find the shortest paths from a goal to a portal. We would have to put an edge between each goal and each portal-end-point and between all portals with weights equal to the Manhattan distance.  
### <----- output: ----->
A* with portals
Solution found!
xxxxxxxxxxxxxxxxxxxx
x2                 x
x|      xxx        x
x|| 1   x xxxxx    x
x ||$              x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x      §    x
x   1  x  O||||    x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:15, currentPath-cost:11
1 solutions found, 36 paths added.
Time: 0.015340632s
Paths extended:21
Max Frontier Size:16
### <----- :output end ----->
##5.2.3
Our Search goes through all possibilities, doesn't find a solution and then terminates. We can ensure termination because each maze is contained and we use cycle detection, so that there are only finitely many paths over all.

##5.2.4
### <----- output: ----->
BFS:
Solution found!
xxxxxxxxxxxxxxxxxxxx
x      |||||||||   x
x      |xxx    |   x
x      |x xxxxx|   x
x   $|||  x ||||   x
x       x x |xxxxxxx
x  xx xxxxx |||    x
x      x      §    x
x      x           x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:25
1 solutions found, 103 paths added.
Time: 0.012078161s
Paths extended:98
Max Frontier Size:12

DFS
Solution found!
xxxxxxxxxxxxxxxxxxxx
x ||| |||||| |||   x
x | | | xxx||| |   x
x | | | x xxxxx|   x
x | $ |   x ||||   x
x |  || x x |xxxxxxx
x |xx|xxxxx |      x
x | || x    | §    x
x |||  x    |||    x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:36, currentPath-cost:47
1 solutions found, 91 paths added.
Time: 0.006872248s
Paths extended:55
Max Frontier Size:38

A*
Solution found!
xxxxxxxxxxxxxxxxxxxx
x      |||||       x
x      |xxx|||||   x
x      |x xxxxx|   x
x   $|||  x ||||   x
x       x x |xxxxxxx
x  xx xxxxx |||    x
x      x      §    x
x      x           x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:11, currentPath-cost:25
1 solutions found, 97 paths added.
Time: 0.007465462s
Paths extended:86
Max Frontier Size:12
### <----- :output end ----->

##5.2.5
If we use multiple path pruning we don't have as many solutions as one might have imagined, especially if there is a bottleneck somewhere. With multiple path pruning disabled, however, we are still able to find a lot of different solutions. We use A* for demo purposes. 

### <----- :output ----->
Solution found!
xxxxxxxxxxxxxxxxxxxx
x      |||||||||   x
x      |xxx    |   x
x     ||x xxxxx|   x
x   $||   x ||||   x
x       x x |xxxxxxx
x  xx xxxxx |||    x
x      x      §    x
x      x           x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:33351, currentPath-cost:25
1 solutions found, 85557 paths added.
Time: 0.308077889s
Paths extended:52206
Enter 'q' to terminate search
Press Enter to continue searching
§>
Solution found!
xxxxxxxxxxxxxxxxxxxx
x      |||||||||   x
x      |xxx    |   x
x     ||x xxxxx|   x
x   $||   x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x      x           x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:33350, currentPath-cost:25
2 solutions found, 85557 paths added.
Time: 0.003239891s
Paths extended:52206
Enter 'q' to terminate search
Press Enter to continue searching
§>
Solution found!
xxxxxxxxxxxxxxxxxxxx
x      |||||||||   x
x      |xxx    |   x
x     ||x xxxxx|   x
x   $||   x ||||   x
x       x x |xxxxxxx
x  xx xxxxx |      x
x      x    ||§    x
x      x           x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:33349, currentPath-cost:25
3 solutions found, 85557 paths added.
Time: 0.003395482s
Paths extended:52206
Enter 'q' to terminate search
Press Enter to continue searching
§>
Solution found!
xxxxxxxxxxxxxxxxxxxx
x      |||||||||   x
x    |||xxx    |   x
x   ||  x xxxxx|   x
x   $     x ||||   x
x       x x |xxxxxxx
x  xx xxxxx |||    x
x      x      §    x
x      x           x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:37277, currentPath-cost:25
4 solutions found, 95761 paths added.
Time: 0.040987174s
Paths extended:58481
Enter 'q' to terminate search
Press Enter to continue searching
§>
### ...
### <----- :output end ----->

If we disable stopAfterFirstSolution we could find the total number of solutions,
if the maze were small enough.


##5.2.6
We use the following maze for demonstration:

    xxxxxxxxxxxxxxxxxxxx
    x                  x
    x       xxx        x
    x 1     x xxxxx    x
    x   s     x        x
    x       x x  xxxxxxx
    x  xx xxxxx     2  x
    x     1x      g    x
    x     2x g         x
    xxxxxxxxxxxxxxxxxxxx


We allow for multiple goals by always using 
the minimal manhattan distance. (see 5.2.1)

Multiple goals demo:

A* using the normal manhattan distance:

### <----- output: ----->
A*, mutiple goals, portals
Solution found!
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x 1     x xxxxx    x
x   $|    x        x
x    |  x x  xxxxxxx
x  xx|xxxxx   ||O  x
x    |1x      §    x
x    |2x g         x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:16, currentPath-cost:9
1 solutions found, 35 paths added.
Time: 0.010512816s
Paths extended:19
Max Frontier Size:17
### <----- :output end ----->

A* using the portal distance:
### <----- output: ----->
A*, mutiple goals, portals
Solution found!
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x 1     x xxxxx    x
x ||$     x        x
x       x x  xxxxxxx
x  xx xxxxx   ||O  x
x     Ox      §    x
x     2x g         x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:15, currentPath-cost:7
1 solutions found, 26 paths added.
Time: 0.011115472s
Paths extended:11
Max Frontier Size:16
### <----- :output end ----->