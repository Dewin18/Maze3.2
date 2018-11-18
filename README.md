# Maze 4.2

## 4.2.1 & 4.2.2
See the comments in our code.
We implemented the generic search algorithm by an Abstract class: BasicSearch.
BFS and DFS only have to specify how the frontier is implemented.

## 4.2.3
The Maze:

    xxxxxxxxxxxx
    xg        sx
    x xxxxxxxx x
    x          x
    xxxxxxxxxxxx

### <---- output: ------>
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
### <----- :output end ------>

We can see a few differences between the DFS and the BFS, the BFS finds the shortest path while the DFS just finds a path. The Maze is designed so that it finds the only other path there is.
In our output for DFS the 14 paths added correspond to the steps of the path, whereas in the BFS we have actually 18 which is way more then the 10 steps we took. If there where more paths we would moreover see that DFS has linear and BFS has exponential cost.
In our portal example in 4.2.5 we see that the path found by DFS may be much longer than the shortest one and the number of paths added to the frontier may be larger than with BFS, even though the number of paths checked is smaller.
A lot depends on cycle detection and multiple path pruning settings. (see our Implementation of BasicSearch for details. 

## 4.2.4
a maze with no solution:

    xxxxx
    xsxgx
    xxxxx

### <----- output: ------>
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
### <----- :output end ----->
We use cycle detection (which can be turned off in our implementation) and have finite graphs 
which means that the only way we wont find a solution is that there is no solution. Of course, 
even though we optionally use multiple path pruning some labyrinths may be too large to find a 
solution in suitable time.

## 4.2.5

We implemented Portals with a Map: Point -> Point. We add both tuples to ensure, that the portal
works in both directions. Before we generate a successor state we check whether it's a state in 
which the robot is on a portal. If so, we generate the corresponding state in which the robot is 
on the other end of the portal instead, ie. the robot is teleported immediately. For implementation details see our code.

portal maze:

    xxxxxxxxxxxxxxxxxxxx
    x                  x
    x       xxx        x
    x       x xxxxx    x
    x 1 s     x        x
    x       x x  xxxxxxx
    x  xx xxxxx        x
    x      x      g    x
    x  1 2 x   2       x
    xxxxxxxxxxxxxxxxxxxx


### <----- output: ----->
Enter 'q' to quit
Press Enter to start BreadthFirstSearch.
§>
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:8, currentPath-cost:2
Frontier-size:7, currentPath-cost:2
Frontier-size:7, currentPath-cost:2
Frontier-size:9, currentPath-cost:3
Frontier-size:9, currentPath-cost:3
Frontier-size:9, currentPath-cost:3
Frontier-size:11, currentPath-cost:3
Frontier-size:11, currentPath-cost:3
Frontier-size:12, currentPath-cost:3
Frontier-size:12, currentPath-cost:3
Frontier-size:14, currentPath-cost:4
Frontier-size:13, currentPath-cost:4
Frontier-size:13, currentPath-cost:4
Frontier-size:13, currentPath-cost:4
Frontier-size:13, currentPath-cost:4
Frontier-size:15, currentPath-cost:4
Frontier-size:16, currentPath-cost:4
Frontier-size:15, currentPath-cost:4
Frontier-size:16, currentPath-cost:4
Frontier-size:17, currentPath-cost:4
Frontier-size:17, currentPath-cost:4
Frontier-size:16, currentPath-cost:4
Frontier-size:16, currentPath-cost:5
Frontier-size:15, currentPath-cost:5
Frontier-size:15, currentPath-cost:5
Frontier-size:15, currentPath-cost:5
Frontier-size:15, currentPath-cost:5
Frontier-size:14, currentPath-cost:5
Frontier-size:16, currentPath-cost:5
Frontier-size:16, currentPath-cost:5
Frontier-size:15, currentPath-cost:5
Frontier-size:15, currentPath-cost:5
Frontier-size:14, currentPath-cost:5
Frontier-size:14, currentPath-cost:5
Frontier-size:13, currentPath-cost:5
Frontier-size:13, currentPath-cost:5
Frontier-size:13, currentPath-cost:5
Frontier-size:12, currentPath-cost:5
Frontier-size:13, currentPath-cost:6
Frontier-size:13, currentPath-cost:6
Frontier-size:12, currentPath-cost:6
Frontier-size:12, currentPath-cost:6
Frontier-size:14, currentPath-cost:6
Frontier-size:15, currentPath-cost:6
Frontier-size:15, currentPath-cost:6
Frontier-size:14, currentPath-cost:6
Frontier-size:13, currentPath-cost:6
Frontier-size:12, currentPath-cost:6
Frontier-size:12, currentPath-cost:6
Frontier-size:11, currentPath-cost:6
Frontier-size:10, currentPath-cost:7
Frontier-size:9, currentPath-cost:7
Frontier-size:9, currentPath-cost:7
Frontier-size:8, currentPath-cost:7
Frontier-size:9, currentPath-cost:7
Frontier-size:8, currentPath-cost:7
Frontier-size:8, currentPath-cost:7
Frontier-size:9, currentPath-cost:7
Frontier-size:8, currentPath-cost:7
Frontier-size:8, currentPath-cost:7
Frontier-size:7, currentPath-cost:7
Frontier-size:7, currentPath-cost:8
Frontier-size:8, currentPath-cost:8
Frontier-size:8, currentPath-cost:8
Frontier-size:8, currentPath-cost:8
Frontier-size:8, currentPath-cost:8
Frontier-size:7, currentPath-cost:8
Frontier-size:7, currentPath-cost:8
Frontier-size:7, currentPath-cost:9
Frontier-size:8, currentPath-cost:9
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x 1|$     x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x      §    x
x  O|2 x   O|||    x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:7, currentPath-cost:9
1 solutions found, 79 paths added.
Enter 'q' to terminate BreadthFirstSearch and start DepthFirstSearch
Press Enter to continue BFS.
§>q
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:8, currentPath-cost:3
Frontier-size:9, currentPath-cost:4
Frontier-size:9, currentPath-cost:5
Frontier-size:10, currentPath-cost:6
Frontier-size:11, currentPath-cost:7
Frontier-size:12, currentPath-cost:8
Frontier-size:14, currentPath-cost:9
Frontier-size:16, currentPath-cost:10
Frontier-size:17, currentPath-cost:11
Frontier-size:19, currentPath-cost:12
Frontier-size:19, currentPath-cost:13
Frontier-size:19, currentPath-cost:14
Frontier-size:19, currentPath-cost:15
Frontier-size:18, currentPath-cost:16
Frontier-size:17, currentPath-cost:13
Frontier-size:16, currentPath-cost:13
Frontier-size:15, currentPath-cost:12
Frontier-size:14, currentPath-cost:11
Frontier-size:14, currentPath-cost:11
Frontier-size:16, currentPath-cost:12
Frontier-size:16, currentPath-cost:13
Frontier-size:16, currentPath-cost:14
Frontier-size:17, currentPath-cost:15
Frontier-size:18, currentPath-cost:16
Frontier-size:19, currentPath-cost:17
Frontier-size:20, currentPath-cost:18
Frontier-size:20, currentPath-cost:19
Frontier-size:20, currentPath-cost:20
Frontier-size:20, currentPath-cost:21
Frontier-size:20, currentPath-cost:22
Frontier-size:20, currentPath-cost:23
Frontier-size:21, currentPath-cost:24
Frontier-size:21, currentPath-cost:25
Frontier-size:21, currentPath-cost:26
Frontier-size:22, currentPath-cost:27
Frontier-size:22, currentPath-cost:28
Frontier-size:22, currentPath-cost:29
Frontier-size:23, currentPath-cost:30
Frontier-size:24, currentPath-cost:31
Frontier-size:25, currentPath-cost:32
Frontier-size:26, currentPath-cost:33
Frontier-size:26, currentPath-cost:34
Frontier-size:26, currentPath-cost:35
Frontier-size:27, currentPath-cost:36
Frontier-size:28, currentPath-cost:37
Frontier-size:30, currentPath-cost:38
Frontier-size:32, currentPath-cost:39
Frontier-size:33, currentPath-cost:40
Frontier-size:33, currentPath-cost:41
Frontier-size:32, currentPath-cost:42
Frontier-size:32, currentPath-cost:41
Frontier-size:33, currentPath-cost:42
xxxxxxxxxxxxxxxxxxxx
x ||| |||||| |||   x
x | | | xxx||| |   x
x | | | x xxxxx|   x
x 1 $ |   x ||||   x
x    || x x |xxxxxxx
x  xx|xxxxx |      x
x  ||| x    | §    x
x  O 2 x   2|||    x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:32, currentPath-cost:43
1 solutions found, 86 paths added.
Enter 'q' to terminate SearchDemo
§>
### <----- :output end ----->




## 5.2
#1
We Decided to use the manhatten distance for the heuristic as it is underestimating the Distance but realtivly close as well.
#2
If the Heuristic is supposed to work with Portals we also have the possibilty that there is a shorter way then the manhatten distance (through a portal) therefore we need to adjust our heuristic. We did this by heavily underestimating the distance wich remains after going through a portal. There is a possibilty that right after we used the portal we are next to the goal.
#3
our Search goes through all possibiltes, doesnt find a soloution and then terminates.
output:
Enter 'q' to quit
Press Enter to start BreadthFirstSearch.
§>
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:8, currentPath-cost:2
Frontier-size:7, currentPath-cost:2
Frontier-size:7, currentPath-cost:2
Frontier-size:9, currentPath-cost:3
Frontier-size:9, currentPath-cost:3
Frontier-size:9, currentPath-cost:3
Frontier-size:11, currentPath-cost:3
Frontier-size:10, currentPath-cost:3
Frontier-size:10, currentPath-cost:3
Frontier-size:10, currentPath-cost:3
Frontier-size:12, currentPath-cost:4
Frontier-size:11, currentPath-cost:4
Frontier-size:11, currentPath-cost:4
Frontier-size:11, currentPath-cost:4
Frontier-size:11, currentPath-cost:4
Frontier-size:12, currentPath-cost:4
Frontier-size:12, currentPath-cost:4
Frontier-size:12, currentPath-cost:4
Frontier-size:12, currentPath-cost:4
Frontier-size:11, currentPath-cost:4
Frontier-size:11, currentPath-cost:5
Frontier-size:10, currentPath-cost:5
Frontier-size:10, currentPath-cost:5
Frontier-size:10, currentPath-cost:5
Frontier-size:12, currentPath-cost:5
Frontier-size:11, currentPath-cost:5
Frontier-size:11, currentPath-cost:5
Frontier-size:11, currentPath-cost:5
Frontier-size:11, currentPath-cost:5
Frontier-size:11, currentPath-cost:5
Frontier-size:10, currentPath-cost:5
Frontier-size:11, currentPath-cost:6
Frontier-size:11, currentPath-cost:6
Frontier-size:10, currentPath-cost:6
Frontier-size:10, currentPath-cost:6
Frontier-size:11, currentPath-cost:6
Frontier-size:10, currentPath-cost:6
Frontier-size:10, currentPath-cost:6
Frontier-size:10, currentPath-cost:6
Frontier-size:10, currentPath-cost:6
Frontier-size:9, currentPath-cost:6
Frontier-size:8, currentPath-cost:7
Frontier-size:7, currentPath-cost:7
Frontier-size:7, currentPath-cost:7
Frontier-size:6, currentPath-cost:7
Frontier-size:6, currentPath-cost:7
Frontier-size:5, currentPath-cost:7
Frontier-size:5, currentPath-cost:7
Frontier-size:4, currentPath-cost:7
Frontier-size:3, currentPath-cost:7
Frontier-size:3, currentPath-cost:8
Frontier-size:2, currentPath-cost:8
Frontier-size:1, currentPath-cost:8
Frontier-size:1, currentPath-cost:9
Frontier-size:1, currentPath-cost:10
Frontier-size:2, currentPath-cost:11
Frontier-size:3, currentPath-cost:12
Frontier-size:2, currentPath-cost:12
Frontier-size:3, currentPath-cost:13
Frontier-size:2, currentPath-cost:13
Frontier-size:3, currentPath-cost:14
Frontier-size:2, currentPath-cost:14
Frontier-size:3, currentPath-cost:15
Frontier-size:2, currentPath-cost:15
Frontier-size:3, currentPath-cost:16
Frontier-size:3, currentPath-cost:16
Frontier-size:4, currentPath-cost:17
Frontier-size:4, currentPath-cost:17
Frontier-size:4, currentPath-cost:17
Frontier-size:4, currentPath-cost:18
Frontier-size:4, currentPath-cost:18
Frontier-size:4, currentPath-cost:18
Frontier-size:4, currentPath-cost:18
Frontier-size:4, currentPath-cost:19
Frontier-size:4, currentPath-cost:19
Frontier-size:3, currentPath-cost:19
Frontier-size:3, currentPath-cost:19
Frontier-size:3, currentPath-cost:20
Frontier-size:2, currentPath-cost:20
Frontier-size:2, currentPath-cost:20
Frontier-size:1, currentPath-cost:21
Frontier-size:2, currentPath-cost:21
Frontier-size:2, currentPath-cost:22
Frontier-size:2, currentPath-cost:22
Frontier-size:2, currentPath-cost:23
Frontier-size:2, currentPath-cost:23
Frontier-size:2, currentPath-cost:24
Frontier-size:2, currentPath-cost:24
Frontier-size:3, currentPath-cost:25
Frontier-size:2, currentPath-cost:25
Frontier-size:3, currentPath-cost:26
Frontier-size:2, currentPath-cost:26
Frontier-size:3, currentPath-cost:27
Frontier-size:2, currentPath-cost:27
Frontier-size:2, currentPath-cost:28
Frontier-size:1, currentPath-cost:28
0 solutions found, 98 paths added.
Enter 'q' to terminate BreadthFirstSearch and start DepthFirstSearch
Press Enter to continue BFS.
§>
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:8, currentPath-cost:3
Frontier-size:9, currentPath-cost:4
Frontier-size:9, currentPath-cost:5
Frontier-size:10, currentPath-cost:6
Frontier-size:11, currentPath-cost:7
Frontier-size:12, currentPath-cost:8
Frontier-size:13, currentPath-cost:9
Frontier-size:15, currentPath-cost:10
Frontier-size:16, currentPath-cost:11
Frontier-size:18, currentPath-cost:12
Frontier-size:19, currentPath-cost:13
Frontier-size:18, currentPath-cost:14
Frontier-size:18, currentPath-cost:14
Frontier-size:19, currentPath-cost:15
Frontier-size:19, currentPath-cost:16
Frontier-size:20, currentPath-cost:17
Frontier-size:20, currentPath-cost:18
Frontier-size:20, currentPath-cost:19
Frontier-size:21, currentPath-cost:20
Frontier-size:22, currentPath-cost:21
Frontier-size:23, currentPath-cost:22
Frontier-size:24, currentPath-cost:23
Frontier-size:24, currentPath-cost:24
Frontier-size:24, currentPath-cost:25
Frontier-size:24, currentPath-cost:26
Frontier-size:24, currentPath-cost:27
Frontier-size:24, currentPath-cost:28
Frontier-size:25, currentPath-cost:29
Frontier-size:25, currentPath-cost:30
Frontier-size:25, currentPath-cost:31
Frontier-size:26, currentPath-cost:32
Frontier-size:26, currentPath-cost:33
Frontier-size:26, currentPath-cost:34
Frontier-size:27, currentPath-cost:35
Frontier-size:28, currentPath-cost:36
Frontier-size:29, currentPath-cost:37
Frontier-size:30, currentPath-cost:38
Frontier-size:30, currentPath-cost:39
Frontier-size:30, currentPath-cost:40
Frontier-size:31, currentPath-cost:41
Frontier-size:32, currentPath-cost:42
Frontier-size:33, currentPath-cost:43
Frontier-size:34, currentPath-cost:44
Frontier-size:34, currentPath-cost:45
Frontier-size:34, currentPath-cost:46
Frontier-size:35, currentPath-cost:47
Frontier-size:35, currentPath-cost:48
Frontier-size:35, currentPath-cost:49
Frontier-size:35, currentPath-cost:50
Frontier-size:34, currentPath-cost:51
Frontier-size:33, currentPath-cost:48
Frontier-size:32, currentPath-cost:45
Frontier-size:31, currentPath-cost:44
Frontier-size:30, currentPath-cost:43
Frontier-size:29, currentPath-cost:42
Frontier-size:29, currentPath-cost:39
Frontier-size:30, currentPath-cost:40
Frontier-size:31, currentPath-cost:41
Frontier-size:32, currentPath-cost:42
Frontier-size:32, currentPath-cost:43
Frontier-size:31, currentPath-cost:44
Frontier-size:30, currentPath-cost:43
Frontier-size:29, currentPath-cost:42
Frontier-size:28, currentPath-cost:41
Frontier-size:27, currentPath-cost:38
Frontier-size:26, currentPath-cost:37
Frontier-size:25, currentPath-cost:36
Frontier-size:24, currentPath-cost:33
Frontier-size:23, currentPath-cost:30
Frontier-size:22, currentPath-cost:24
Frontier-size:21, currentPath-cost:23
Frontier-size:21, currentPath-cost:22
Frontier-size:21, currentPath-cost:23
Frontier-size:22, currentPath-cost:24
Frontier-size:21, currentPath-cost:25
Frontier-size:20, currentPath-cost:25
Frontier-size:19, currentPath-cost:21
Frontier-size:19, currentPath-cost:18
Frontier-size:18, currentPath-cost:19
Frontier-size:17, currentPath-cost:16
Frontier-size:16, currentPath-cost:13
Frontier-size:15, currentPath-cost:13
Frontier-size:14, currentPath-cost:12
Frontier-size:13, currentPath-cost:11
Frontier-size:12, currentPath-cost:11
Frontier-size:11, currentPath-cost:10
Frontier-size:10, currentPath-cost:9
Frontier-size:9, currentPath-cost:8
Frontier-size:8, currentPath-cost:7
Frontier-size:7, currentPath-cost:5
Frontier-size:6, currentPath-cost:4
Frontier-size:5, currentPath-cost:4
Frontier-size:4, currentPath-cost:3
Frontier-size:3, currentPath-cost:3
Frontier-size:2, currentPath-cost:2
Frontier-size:1, currentPath-cost:2
0 solutions found, 98 paths added.
Enter 'q' to terminate SearchDemo
§>
