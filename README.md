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
##5.2.1
We Decided to use the manhatten distance for the heuristic as it is underestimating the Distance but realtivly close as well.
##5.2.2
If the Heuristic is supposed to work with Portals we also have the possibilty that there is a shorter way then the manhatten distance (through a portal) therefore we need to adjust our heuristic. We did this by heavily underestimating the distance wich remains after going through a portal. There is a possibilty that right after we used the portal we are next to the goal.

### <----- output: ----->
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:7, currentPath-cost:2
Frontier-size:9, currentPath-cost:3
Frontier-size:11, currentPath-cost:3
Frontier-size:12, currentPath-cost:4
Frontier-size:12, currentPath-cost:4
Frontier-size:12, currentPath-cost:4
Frontier-size:13, currentPath-cost:5
Frontier-size:14, currentPath-cost:5
Frontier-size:13, currentPath-cost:3
Frontier-size:14, currentPath-cost:6
Frontier-size:15, currentPath-cost:6
Frontier-size:15, currentPath-cost:7
Frontier-size:14, currentPath-cost:5
Frontier-size:14, currentPath-cost:8
Frontier-size:16, currentPath-cost:7
Frontier-size:16, currentPath-cost:9
Frontier-size:16, currentPath-cost:8
Frontier-size:17, currentPath-cost:10
Frontier-size:17, currentPath-cost:9
Frontier-size:17, currentPath-cost:6
Frontier-size:16, currentPath-cost:7
Frontier-size:16, currentPath-cost:4
Frontier-size:17, currentPath-cost:8
Frontier-size:18, currentPath-cost:5
Frontier-size:19, currentPath-cost:9
Frontier-size:19, currentPath-cost:5
Frontier-size:20, currentPath-cost:2
Frontier-size:20, currentPath-cost:4
Frontier-size:20, currentPath-cost:9
Frontier-size:21, currentPath-cost:6
Frontier-size:21, currentPath-cost:2
Frontier-size:21, currentPath-cost:3
Frontier-size:21, currentPath-cost:4
Frontier-size:21, currentPath-cost:7
Frontier-size:21, currentPath-cost:3
Frontier-size:22, currentPath-cost:11
Frontier-size:22, currentPath-cost:11
Frontier-size:22, currentPath-cost:12
Frontier-size:22, currentPath-cost:6
Frontier-size:21, currentPath-cost:7
Frontier-size:21, currentPath-cost:7
Frontier-size:21, currentPath-cost:10
Frontier-size:20, currentPath-cost:8
Frontier-size:21, currentPath-cost:11
Frontier-size:22, currentPath-cost:10
Frontier-size:22, currentPath-cost:12
Frontier-size:22, currentPath-cost:12
Frontier-size:22, currentPath-cost:5
Frontier-size:22, currentPath-cost:6
Frontier-size:22, currentPath-cost:6
Frontier-size:23, currentPath-cost:10
Frontier-size:24, currentPath-cost:3
Frontier-size:23, currentPath-cost:10
Frontier-size:23, currentPath-cost:3
Frontier-size:23, currentPath-cost:5
Frontier-size:23, currentPath-cost:4
Frontier-size:23, currentPath-cost:3
Frontier-size:24, currentPath-cost:8
Frontier-size:24, currentPath-cost:12
Frontier-size:24, currentPath-cost:9
Frontier-size:24, currentPath-cost:8
Frontier-size:24, currentPath-cost:4
Frontier-size:24, currentPath-cost:10
Frontier-size:24, currentPath-cost:7
Frontier-size:23, currentPath-cost:13
Frontier-size:23, currentPath-cost:11
Frontier-size:23, currentPath-cost:7
Frontier-size:23, currentPath-cost:12
Frontier-size:23, currentPath-cost:8
Frontier-size:23, currentPath-cost:13
Frontier-size:23, currentPath-cost:4
Frontier-size:24, currentPath-cost:11
Frontier-size:24, currentPath-cost:13
Frontier-size:25, currentPath-cost:11
Frontier-size:26, currentPath-cost:13
Frontier-size:25, currentPath-cost:7
Frontier-size:25, currentPath-cost:6
Frontier-size:24, currentPath-cost:7
Frontier-size:24, currentPath-cost:9
Frontier-size:25, currentPath-cost:4
Frontier-size:25, currentPath-cost:12
Frontier-size:25, currentPath-cost:11
Frontier-size:24, currentPath-cost:6
Frontier-size:23, currentPath-cost:11
Frontier-size:22, currentPath-cost:4
Frontier-size:22, currentPath-cost:13
Frontier-size:21, currentPath-cost:5
Frontier-size:20, currentPath-cost:4
Frontier-size:19, currentPath-cost:8
Frontier-size:19, currentPath-cost:9
Frontier-size:19, currentPath-cost:5
Frontier-size:20, currentPath-cost:10
Frontier-size:20, currentPath-cost:6
Frontier-size:20, currentPath-cost:12
Frontier-size:21, currentPath-cost:14
Frontier-size:22, currentPath-cost:5
Frontier-size:22, currentPath-cost:9
Frontier-size:21, currentPath-cost:14
Frontier-size:22, currentPath-cost:12
Frontier-size:21, currentPath-cost:12
Frontier-size:21, currentPath-cost:11
Frontier-size:20, currentPath-cost:13
Frontier-size:19, currentPath-cost:12
Frontier-size:19, currentPath-cost:5
Frontier-size:19, currentPath-cost:14
Frontier-size:19, currentPath-cost:10
Frontier-size:18, currentPath-cost:5
Frontier-size:17, currentPath-cost:12
Frontier-size:16, currentPath-cost:14
Frontier-size:16, currentPath-cost:14
Frontier-size:16, currentPath-cost:7
Frontier-size:17, currentPath-cost:15
Frontier-size:18, currentPath-cost:16
Frontier-size:18, currentPath-cost:17
Frontier-size:20, currentPath-cost:18
Frontier-size:20, currentPath-cost:13
Frontier-size:21, currentPath-cost:19
Frontier-size:21, currentPath-cost:10
Frontier-size:21, currentPath-cost:20
Frontier-size:21, currentPath-cost:6
Frontier-size:21, currentPath-cost:15
Frontier-size:20, currentPath-cost:16
Frontier-size:19, currentPath-cost:17
Frontier-size:18, currentPath-cost:8
Frontier-size:18, currentPath-cost:19
Frontier-size:18, currentPath-cost:19
Frontier-size:18, currentPath-cost:12
Frontier-size:17, currentPath-cost:13
Frontier-size:16, currentPath-cost:13
Frontier-size:15, currentPath-cost:11
Frontier-size:14, currentPath-cost:15
Frontier-size:14, currentPath-cost:15
Frontier-size:14, currentPath-cost:11
Frontier-size:14, currentPath-cost:6
Frontier-size:13, currentPath-cost:6
Frontier-size:13, currentPath-cost:7
Frontier-size:12, currentPath-cost:14
Frontier-size:12, currentPath-cost:8
Frontier-size:11, currentPath-cost:11
Frontier-size:11, currentPath-cost:13
Frontier-size:11, currentPath-cost:20
Frontier-size:11, currentPath-cost:16
Frontier-size:11, currentPath-cost:21
Frontier-size:11, currentPath-cost:20
Frontier-size:10, currentPath-cost:20
Frontier-size:10, currentPath-cost:7
Frontier-size:9, currentPath-cost:7
Frontier-size:9, currentPath-cost:16
Frontier-size:8, currentPath-cost:12
Frontier-size:9, currentPath-cost:17
Frontier-size:9, currentPath-cost:9
Frontier-size:9, currentPath-cost:18
Frontier-size:9, currentPath-cost:21
Frontier-size:8, currentPath-cost:21
Frontier-size:8, currentPath-cost:19
Frontier-size:8, currentPath-cost:22
Frontier-size:9, currentPath-cost:20
Frontier-size:9, currentPath-cost:14
Frontier-size:8, currentPath-cost:17
Frontier-size:9, currentPath-cost:8
Frontier-size:9, currentPath-cost:21
Frontier-size:10, currentPath-cost:9
Frontier-size:10, currentPath-cost:10
Frontier-size:9, currentPath-cost:18
Frontier-size:9, currentPath-cost:9
Frontier-size:9, currentPath-cost:22
Frontier-size:10, currentPath-cost:15
Frontier-size:10, currentPath-cost:23
Frontier-size:11, currentPath-cost:16
Frontier-size:11, currentPath-cost:21
Frontier-size:11, currentPath-cost:17
Frontier-size:12, currentPath-cost:22
Frontier-size:12, currentPath-cost:18
Frontier-size:12, currentPath-cost:10
Frontier-size:11, currentPath-cost:10
Frontier-size:10, currentPath-cost:22
Frontier-size:9, currentPath-cost:16
Frontier-size:9, currentPath-cost:11
Frontier-size:8, currentPath-cost:17
Frontier-size:8, currentPath-cost:24
Frontier-size:8, currentPath-cost:10
Frontier-size:9, currentPath-cost:23
Frontier-size:10, currentPath-cost:24
Frontier-size:9, currentPath-cost:11
Frontier-size:10, currentPath-cost:25
Frontier-size:9, currentPath-cost:25
Frontier-size:9, currentPath-cost:11
Frontier-size:9, currentPath-cost:19
Frontier-size:9, currentPath-cost:24
Frontier-size:9, currentPath-cost:23
Frontier-size:10, currentPath-cost:25
Frontier-size:10, currentPath-cost:12
Frontier-size:9, currentPath-cost:23
Frontier-size:9, currentPath-cost:13
Frontier-size:9, currentPath-cost:26
Frontier-size:9, currentPath-cost:20
Frontier-size:9, currentPath-cost:26
Frontier-size:8, currentPath-cost:26
Frontier-size:9, currentPath-cost:12
Frontier-size:9, currentPath-cost:26
Frontier-size:9, currentPath-cost:25
Frontier-size:9, currentPath-cost:24
Frontier-size:9, currentPath-cost:26
Frontier-size:9, currentPath-cost:25
Frontier-size:8, currentPath-cost:27
Frontier-size:8, currentPath-cost:27
Frontier-size:8, currentPath-cost:13
Frontier-size:9, currentPath-cost:21
Frontier-size:9, currentPath-cost:27
Frontier-size:10, currentPath-cost:14
Frontier-size:10, currentPath-cost:28
Frontier-size:10, currentPath-cost:13
Frontier-size:10, currentPath-cost:29
Frontier-size:10, currentPath-cost:30
Frontier-size:10, currentPath-cost:31
Frontier-size:10, currentPath-cost:32
Frontier-size:11, currentPath-cost:14
Frontier-size:11, currentPath-cost:33
Frontier-size:12, currentPath-cost:27
Frontier-size:11, currentPath-cost:28
Frontier-size:11, currentPath-cost:22
Frontier-size:11, currentPath-cost:15
Frontier-size:10, currentPath-cost:26
Frontier-size:10, currentPath-cost:15
Frontier-size:9, currentPath-cost:14
Frontier-size:9, currentPath-cost:22
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:23
Frontier-size:8, currentPath-cost:23
Frontier-size:9, currentPath-cost:28
Frontier-size:10, currentPath-cost:15
Frontier-size:9, currentPath-cost:28
Frontier-size:9, currentPath-cost:16
Frontier-size:8, currentPath-cost:16
Frontier-size:7, currentPath-cost:15
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:16
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:24
Frontier-size:7, currentPath-cost:30
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:31
Frontier-size:7, currentPath-cost:17
Frontier-size:7, currentPath-cost:32
Frontier-size:6, currentPath-cost:16
Frontier-size:6, currentPath-cost:33
Frontier-size:6, currentPath-cost:34
Frontier-size:6, currentPath-cost:35
Frontier-size:6, currentPath-cost:36
Frontier-size:6, currentPath-cost:37
Frontier-size:6, currentPath-cost:36
Frontier-size:6, currentPath-cost:38
Frontier-size:6, currentPath-cost:25
Frontier-size:5, currentPath-cost:30
Frontier-size:5, currentPath-cost:17
Frontier-size:5, currentPath-cost:18
Frontier-size:5, currentPath-cost:18
Frontier-size:5, currentPath-cost:19
Frontier-size:5, currentPath-cost:26
Frontier-size:5, currentPath-cost:37
Frontier-size:5, currentPath-cost:39
Frontier-size:5, currentPath-cost:38
Frontier-size:5, currentPath-cost:40
Frontier-size:5, currentPath-cost:20
Frontier-size:5, currentPath-cost:19
Frontier-size:6, currentPath-cost:27
Frontier-size:7, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:8, currentPath-cost:20
Frontier-size:8, currentPath-cost:30
Frontier-size:9, currentPath-cost:21
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:39
Frontier-size:9, currentPath-cost:22
Frontier-size:9, currentPath-cost:28
Frontier-size:9, currentPath-cost:21
Frontier-size:9, currentPath-cost:29
Frontier-size:9, currentPath-cost:22
Frontier-size:9, currentPath-cost:30
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:31
Frontier-size:8, currentPath-cost:22
Frontier-size:8, currentPath-cost:42
Frontier-size:8, currentPath-cost:29
Frontier-size:8, currentPath-cost:43
Frontier-size:8, currentPath-cost:23
Frontier-size:10, currentPath-cost:44
Frontier-size:9, currentPath-cost:21
Frontier-size:11, currentPath-cost:45
Frontier-size:11, currentPath-cost:45
Frontier-size:12, currentPath-cost:46
Frontier-size:12, currentPath-cost:46
Frontier-size:13, currentPath-cost:46
Frontier-size:14, currentPath-cost:47
Frontier-size:14, currentPath-cost:47
Frontier-size:14, currentPath-cost:47
Frontier-size:15, currentPath-cost:48
Frontier-size:17, currentPath-cost:48
Frontier-size:16, currentPath-cost:48
Frontier-size:17, currentPath-cost:49
Frontier-size:17, currentPath-cost:49
Frontier-size:18, currentPath-cost:50
Frontier-size:18, currentPath-cost:50
                  xx                  xx      xx          xx  xx  xx  xx  xx              xx  xx  xx      xx  xx      xx        x
xxxx  xxxxxxxxxxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  xx  xx  xxxxxxxxxx  xx  xxxxxxxxxx  xxxxxxxxxx  xxxxxxxxxxxxxxxxxxx
  xx  xx      xx          xx  xx      xx          xx      xx                  xx      xx              xx  xx              xx    x
  xx  xxxxxx  xx  xxxxxx  xx  xx  xxxxxx  xxxxxx  xx  xx  xxxxxxxxxxxxxxxxxx  xx  xxxxxx  xx          xx  xxxxxxxxxxxxxx  xx  xxx
  xx      xx  xx      xx  xx  xx          xx  xx  xx  xx  xx      xx      xx      xx                                  xx  xx  xxx
  xxxxxx  xx  xxxxxx  xx  xx  xxxxxxxxxxxxxx  xx  xx  xxxxxx  xx  xx  xx  xxxxxxxxxx  xxxxxxxxxxxxxxxxxxxxxxxxxx  xxxxxx  xx  xxx
  xx      xx      xx  xx  xx  xx  xx      xx  xx              xx      xx  xx      xx      xx              xx      xx      xx  xxx
  xx  xxxxxx  xx  xxxxxx  xx  xx  xx  xxxxxx  xxxxxxxxxxxxxxxxxx  xxxxxx  xx  xxxxxxxxxx  xxxxxxxxxxxxxx  xx  xx  xx  xxxxxx  xxx
  xx  xx      xx  xx      xx  xx  xx      xx  xx      xxxxxxxxxx  xx          xx      xx              xx  xx  xx      xxxxxx  xxx
  xx  xx  xxxxxx  xx  xxxxxx  xx  xxxxxx  xx  xx  xx  xxxxxxxxxx  xx  xx      xx  xxxxxxxxxxxxxxxxxx  xx  xx  xxxxxxxxxxxxxx  xxx
      xx  xx  xx      xx      xx          xx  xx  xx          xx  xx  xx      xx                      xx      xx          xx  xxx
xxxxxxxx  xx  xxxxxxxxxx  xxxxxx  xxxxxx  xxxxxx  xxxxxxxxxx  xxxxxx  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  xx  xxxxxx  xxxxxx  xxxxxxx
          xx          xx  xx      |||1    xx      xx          xx          xx              xx      xx  xx              xx      xxx
xxxxxxxx  xxxxxxxxxx  xx  xx      |       xx  xxxxxx  xxxxxxxxxx  xxxxxx  xx  xxxxxxxxxx  xx  xx  xxxxxxxxxxxxxxxxxx  xxxxxx  xxx
                  xx      xx     ||       xx  xx      xx  xx          xx              xx  xx  xx  xx          xx      xx      xxx
  xxxxxxxxxxxxxx  xxxxxxxxxx   $||        xx  xx  xxxxxx  xx  xxxxxxxxxxxxxx  xxxxxx  xx  xx  xx  xx  xxxxxxxxxx  xxxxxx  xxxxxxx
          xx      xx                      xx  xx      xx  xx          xxxxxx  xx      xx  xx  xx  xx  xx      xx      xx  xxxxxxx
xxxxxxxx  xxxxxxxxxx  xx  xx            xxxxxxxxxxxx  xx  xxxxxxxxxx  xxxxxx  xxxxxx  xx  xxxxxx  xx  xx  xx  xxxxxx  xx  xxxxxxx
          xx      xx  xx  xx          xx      xx                  xx      xx      xx  xx          xx      xx      xx  xx  xx    x
  xxxxxxxxxx  xx  xx  xxxxxxxxxx  xx  xx  xx  xx              xxxxxxxxxx  xxxxxx  xx  xxxxxxxxxxxxxxxxxx  xxxxxx  xxxxxx  xx  xxx
              xx      xx          xx      xx                          xx  xx      xx  xx              xx      xx  xx      xx  xxx
  xxxxxx  xxxxxxxxxxxxxx  xxxxxxxxxxxxxxxxxxxxxxxxxx          xxxxxx  xx  xx  xxxxxx  xxxxxxxxxxxxxx  xxxxxx  xx  xx  xxxxxxxxxxx
      xx      xx          xx  xx                  xx              xx  xx  xx  xx  xx  xx                  xx  xx  xx          xxx
xxxx  xxxxxxxxxx  xxxxxxxxxx  xx  xxxxxx  xxxxxx  xx          xx  xx  xx  xx  xx  xx  xx  xxxxxxxxxx  xx  xx  xx  xxxxxx  xx  xxx
  xx  xx      xx                  xx  xx  xx  xx  xx          xx          xx      xx      xx          xx  xx  xx  xx      xx    x
  xxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxx  xx  xx  xx  xx  xx      xxxxxxxxxxxxxxxxxxxxxx  xxxxxx  xxxxxxxxxx  xx  xx  xxxxxxxxxx  xxx
          xx  xx      xx      xxxxxx  xx      xx                                  xx  xx  xx          xx  xx  xx      xx      xxx
xxxxxxxxxxxx  xx  xx  xx  xx  xxxxxx  xxxxxxxxxxxxxx                      xxxxxx  xx  xx  xxxxxxxxxx  xx  xx  xxxxxx  xxxxxxxxxxx
          xx  xx  xx      xx  xx      xx                                  xx      xx      xx          xx      xxxxxx      xx    x
xxxxxxxxxxxx  xx  xx  xxxxxx  xx  xxxxxx  xxxxxxxxxx                      xx  xxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxxxxxx  xx  xxx
          xx  xx  xx      xx  xx          xx  xx                          xx  xx      xx  xx  xx                          xx    x
          xx  xxxxxx  xx  xx  xxxxxx  xxxxxx  xx  xx                      xx  xxxxxx  xxxxxx  xxxxxx  xxxxxxxxxxxxxxxxxxxxxx    x
          xx  xx      xx  xx  xx              xx  xx                      xx  xx          xx      xx                  xx        x
  xxxxxx  xx  xx  xxxxxxxxxx  xx  xxxxxxxxxxxxxx  xx                      xx  xx  xxxxxx  xxxxxx  xxxxxxxxxxxxxxxxxxxxxx  xx  xxx
      xx  xx      xx          xx      xx      xx  xx                      xx          xx      xx          xx      xx      xx  xxx
xxxx  xxxxxxxxxxxxxx  xxxxxxxxxx  xx  xx  xx  xx  xx                      xxxxxxxxxxxxxxxxxxxxxxxxxx  xx  xx  xx  xx  xxxxxx  xxx
  xx          xx  xx  xx          xx  xx  xx      xx                                      xx      xx  xx  xx  xx  xx      xx    x
  xxxxxxxxxx  xx  xx  xx  xxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxx  xxxxxxxxxxxxxxxxxxxxxxxxxx  xx  xx  xx  xxxxxx  xx  xxxxxx  xxxxxxx
  xx          xx      xx      xx      xx  xx              xx      xx                  xx  xx  xx  xx          xx          xx    x
xxxx  xxxxxx  xx  xxxxxxxxxxxxxx  xxxxxx  xx  xxxxxxxxxx  xx      xx  xxxxxxxxxxxxxx  xx  xx  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  xxx
      xx      xx      xx      xx  xx  xx      xx      xx          xx      xx      xx  xx  xx      xx      xxxxxx      xx  xx  xxx
  xxxxxxxxxxxxxxxxxx  xx  xx  xx  xx  xxxxxxxxxx  xx  xxxxxx  xx  xxxxxx  xx  xx  xx  xx  xxxxxx  xx  xx  xxxxxx  xx  xx  xx  xxx
          xx          xx  xx      xx          xx  xx          xx      xx      xx  xx  xx      xx      xx  xx      xx      xx  xxx
xxxxxxxx  xx  xxxxxx  xx  xxxxxxxxxxxxxx  xxxxxx  xxxxxxxxxxxxxx  xxxxxxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxx  xx  xx  xxxxxx  xx  xxx
      xx  xx      xx  xx          xx  xx      xx  xx          xx                  xx                  xx      xx  xx  xx      xxx
  xx  xx  xxxxxx  xxxxxxxxxxxxxx  xx  xxxxxx  xx  xx  xxxxxx  xxxxxxxxxxxxxx  xxxxxxxxxx  xxxxxxxxxx  xxxxxxxxxx  xx  xxxxxxxxxxx
  xx  xx  xx      xx          xx  xx      xx      xx  xx          xx  xx              xx      xx  xx  xx      xx  xx      xx  xxx
  xxxxxx  xx  xxxxxx  xxxxxxxxxx  xxxxxx  xxxxxx  xx  xx  xxxxxx  xx  xx  xxxxxxxxxx  xxxxxx  xx  xx  xx  xxxxxx  xx  xx  xx  xxx
      xx  xx          xx              xx      xx      xx  xx  xx  xx              xx      xx      xx  xx          xx  xx  xx  xxx
xxxx  xx  xx  xx  xxxxxxxxxx  xxxxxx  xxxxxx  xxxxxxxxxx  xx  xx  xxxxxxxxxx  xxxxxxxxxxxxxxxxxxxxxx  xxxxxxxxxxxxxxxxxx  xx  xxx
      xx  xx  xx  xx          xxO xx              xx      xx  xx          xx                      xx  xx      xx      xx  xx  xxx
  xxxxxx  xx  xx  xx  xxxxxx  xx| xx  xxxxxx  xx  xx  xxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  xx  xx  xx  xx  xx  xx  xx  xxx
      xx  xx  xx  xx  xx  xx  xx| xx      xx  xx          xx      xx                          xx  xx      xx  xx  xx      xx    x
xxxx  xx  xx  xxxxxx  xx  xx  xx| xx  xx  xxxxxxxxxxxxxx  xxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxx  xx  xxxxxxxxxx  xx  xxxxxxxxxxxxxxx
          xx  xx      xx      xx| xx  xx          xx      xx      xx              xx          xx      xx      xx                x
xxxxxxxxxxxx  xx  xx  xxxxxxxxxx| xx  xxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxxx
  xx      xx  xx  xx  xx      2|| xx      xx      xx  xx      xx          xx  xx  xx      xx          xx              xx        x
  xx  xxxxxx  xx  xx  xx  xxxxxxxxxxxxxx  xxxxxxxxxx  xxxxxx  xxxxxx  xxxxxx  xx  xx  xx  xx  xxxxxxxxxxxxxxxxxxxxxx  xx        x
  xx  xx      xx  xx  xx                  xx      xx      xx      xx          xx      xx  xx      xx ||||||||||||||||||||       x
  xx  xx  xxxxxx  xx  xxxxxxxxxxxxxxxxxxxxxx  xx  xxxxxx  xxxxxx  xxxxxxxxxxxxxxxxxxxxxx  xx  xxxxxx |xxxxxxxxxxxxxx    ||       
          xx  xx  xx  xx                  xx  xx  xx          xx      xx          xx      xx      xx |||||||||xx         §       
          xx  xx  xx  xx              xx  xxxxxx  xx  xx  xx  xxxxxx  xx  xxxxxx  xx  xxxxxxxxxx  xxxxxx  xx Oxx  xx            x
          xx  xx  xx  xx              xx  xx      xx  xx  xx  xx  xx  xx  xx                  xx  xx  xx  xx  xx                x
          xx  xx  xx  xx              xx  xx  xxxxxxxxxx  xx  xx  xx  xx  xx          xx  xx  xx  xx  xx  xx  xxxxxx  xxxxxx    x
Frontier-size:17, currentPath-cost:51
1 solutions found, 322 paths added.
Enter 'q' to terminate search
### <----- :output end ----->
§>
##5.2.3
our Search goes through all possibiltes, doesnt find a soloution and then terminates.
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
### <----- :output end ----->
§>
##5.2.5
Due to Multiple path pruning and circle Detection we dont have as many soloutions as you might have imagined. however we are still able to find a lot of different soloutions.
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
Frontier-size:10, currentPath-cost:9
Frontier-size:10, currentPath-cost:9
Frontier-size:11, currentPath-cost:9
Frontier-size:11, currentPath-cost:9
Frontier-size:10, currentPath-cost:9
Frontier-size:10, currentPath-cost:10
Frontier-size:11, currentPath-cost:10
Frontier-size:12, currentPath-cost:10
Frontier-size:12, currentPath-cost:10
Frontier-size:13, currentPath-cost:10
Frontier-size:12, currentPath-cost:10
Frontier-size:13, currentPath-cost:10
Frontier-size:13, currentPath-cost:10
Frontier-size:13, currentPath-cost:10
Frontier-size:13, currentPath-cost:10
Frontier-size:14, currentPath-cost:11
Frontier-size:15, currentPath-cost:11
Frontier-size:15, currentPath-cost:11
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x 1|$     x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x      §|   x
x  O|2 x   O||||   x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:14, currentPath-cost:11
Frontier-size:16, currentPath-cost:11
Frontier-size:16, currentPath-cost:11
Frontier-size:16, currentPath-cost:11
Frontier-size:17, currentPath-cost:11
Frontier-size:16, currentPath-cost:11
Frontier-size:16, currentPath-cost:11
Frontier-size:16, currentPath-cost:11
Frontier-size:15, currentPath-cost:11
Frontier-size:15, currentPath-cost:11
Frontier-size:14, currentPath-cost:11
Frontier-size:15, currentPath-cost:12
Frontier-size:14, currentPath-cost:12
Frontier-size:14, currentPath-cost:12
Frontier-size:15, currentPath-cost:12
Frontier-size:15, currentPath-cost:12
Frontier-size:16, currentPath-cost:12
Frontier-size:15, currentPath-cost:12
Frontier-size:14, currentPath-cost:12
Frontier-size:14, currentPath-cost:12
Frontier-size:16, currentPath-cost:12
Frontier-size:16, currentPath-cost:12
Frontier-size:16, currentPath-cost:12
Frontier-size:16, currentPath-cost:12
Frontier-size:16, currentPath-cost:12
Frontier-size:17, currentPath-cost:13
Frontier-size:17, currentPath-cost:13
Frontier-size:18, currentPath-cost:13
Frontier-size:18, currentPath-cost:13
Frontier-size:17, currentPath-cost:13
Frontier-size:16, currentPath-cost:13
Frontier-size:15, currentPath-cost:13
Frontier-size:14, currentPath-cost:13
Frontier-size:14, currentPath-cost:13
Frontier-size:15, currentPath-cost:13
Frontier-size:16, currentPath-cost:13
Frontier-size:15, currentPath-cost:13
Frontier-size:14, currentPath-cost:13
Frontier-size:13, currentPath-cost:13
Frontier-size:12, currentPath-cost:13
Frontier-size:13, currentPath-cost:13
Frontier-size:14, currentPath-cost:14
Frontier-size:13, currentPath-cost:14
Frontier-size:12, currentPath-cost:14
Frontier-size:11, currentPath-cost:14
Frontier-size:10, currentPath-cost:14
Frontier-size:10, currentPath-cost:14
Frontier-size:9, currentPath-cost:14
Frontier-size:10, currentPath-cost:14
Frontier-size:9, currentPath-cost:14
Frontier-size:9, currentPath-cost:14
Frontier-size:10, currentPath-cost:14
Frontier-size:11, currentPath-cost:14
Frontier-size:11, currentPath-cost:14
Frontier-size:11, currentPath-cost:15
Frontier-size:10, currentPath-cost:15
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x       x xxxxx    x
x 1|$     x        x
x       x x  xxxxxxx
x  xx xxxxx        x
x      x      §||| x
x  O|2 x   O|||||| x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:9, currentPath-cost:15
Frontier-size:11, currentPath-cost:15
Frontier-size:11, currentPath-cost:15
Frontier-size:11, currentPath-cost:15
Frontier-size:11, currentPath-cost:15
Frontier-size:11, currentPath-cost:15
Frontier-size:11, currentPath-cost:15
Frontier-size:12, currentPath-cost:15
Frontier-size:13, currentPath-cost:15
Frontier-size:14, currentPath-cost:15
Frontier-size:14, currentPath-cost:16
Frontier-size:15, currentPath-cost:16
Frontier-size:15, currentPath-cost:16
Frontier-size:15, currentPath-cost:16
Frontier-size:15, currentPath-cost:16
Frontier-size:16, currentPath-cost:16
Frontier-size:17, currentPath-cost:16
Frontier-size:19, currentPath-cost:16
Frontier-size:19, currentPath-cost:16
Frontier-size:20, currentPath-cost:16
Frontier-size:20, currentPath-cost:16
Frontier-size:20, currentPath-cost:16
Frontier-size:21, currentPath-cost:16
Frontier-size:20, currentPath-cost:16
Frontier-size:20, currentPath-cost:17
Frontier-size:21, currentPath-cost:17
Frontier-size:20, currentPath-cost:17
Frontier-size:20, currentPath-cost:17
Frontier-size:19, currentPath-cost:17
Frontier-size:19, currentPath-cost:17
Frontier-size:18, currentPath-cost:17
Frontier-size:17, currentPath-cost:17
Frontier-size:19, currentPath-cost:17
Frontier-size:21, currentPath-cost:17
Frontier-size:22, currentPath-cost:17
Frontier-size:22, currentPath-cost:17
Frontier-size:22, currentPath-cost:17
Frontier-size:22, currentPath-cost:17
Frontier-size:21, currentPath-cost:17
Frontier-size:20, currentPath-cost:17
Frontier-size:19, currentPath-cost:17
Frontier-size:18, currentPath-cost:17
Frontier-size:19, currentPath-cost:17
Frontier-size:18, currentPath-cost:17
Frontier-size:17, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:19, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:17, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:17, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:17, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:17, currentPath-cost:18
Frontier-size:18, currentPath-cost:18
Frontier-size:17, currentPath-cost:18
Frontier-size:17, currentPath-cost:19
Frontier-size:17, currentPath-cost:19
Frontier-size:17, currentPath-cost:19
Frontier-size:17, currentPath-cost:19
Frontier-size:16, currentPath-cost:19
Frontier-size:15, currentPath-cost:19
Frontier-size:14, currentPath-cost:19
Frontier-size:13, currentPath-cost:19
Frontier-size:13, currentPath-cost:19
Frontier-size:13, currentPath-cost:19
Frontier-size:13, currentPath-cost:19
Frontier-size:14, currentPath-cost:19
Frontier-size:14, currentPath-cost:19
Frontier-size:14, currentPath-cost:19
Frontier-size:14, currentPath-cost:19
Frontier-size:14, currentPath-cost:19
Frontier-size:13, currentPath-cost:19
Frontier-size:13, currentPath-cost:20
Frontier-size:13, currentPath-cost:20
Frontier-size:13, currentPath-cost:20
Frontier-size:13, currentPath-cost:20
Frontier-size:13, currentPath-cost:20
Frontier-size:13, currentPath-cost:20
Frontier-size:12, currentPath-cost:20
Frontier-size:12, currentPath-cost:20
Frontier-size:12, currentPath-cost:20
Frontier-size:12, currentPath-cost:20
Frontier-size:12, currentPath-cost:20
Frontier-size:11, currentPath-cost:20
Frontier-size:11, currentPath-cost:20
Frontier-size:10, currentPath-cost:21
Frontier-size:9, currentPath-cost:21
Frontier-size:9, currentPath-cost:21
Frontier-size:9, currentPath-cost:21
Frontier-size:8, currentPath-cost:21
Frontier-size:7, currentPath-cost:21
Frontier-size:8, currentPath-cost:21
Frontier-size:8, currentPath-cost:21
Frontier-size:7, currentPath-cost:21
Frontier-size:6, currentPath-cost:21
Frontier-size:6, currentPath-cost:21
Frontier-size:6, currentPath-cost:22
Frontier-size:5, currentPath-cost:22
Frontier-size:4, currentPath-cost:22
Frontier-size:3, currentPath-cost:22
Frontier-size:3, currentPath-cost:22
Frontier-size:2, currentPath-cost:22
Frontier-size:2, currentPath-cost:23
Frontier-size:1, currentPath-cost:23
Frontier-size:1, currentPath-cost:24
3 solutions found, 256 paths added.
Enter 'q' to terminate BreadthFirstSearch and start DepthFirstSearch
Press Enter to continue BFS.

x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:8, currentPath-cost:34
Frontier-size:11, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:11, currentPath-cost:36
Frontier-size:12, currentPath-cost:37
Frontier-size:13, currentPath-cost:38
Frontier-size:14, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:13, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:13, currentPath-cost:42
Frontier-size:12, currentPath-cost:43
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:38
Frontier-size:10, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:11, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:11, currentPath-cost:42
Frontier-size:12, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:12, currentPath-cost:42
Frontier-size:12, currentPath-cost:43
Frontier-size:11, currentPath-cost:44
Frontier-size:10, currentPath-cost:41
Frontier-size:12, currentPath-cost:38
Frontier-size:15, currentPath-cost:39
Frontier-size:15, currentPath-cost:40
Frontier-size:17, currentPath-cost:41
Frontier-size:17, currentPath-cost:42
Frontier-size:18, currentPath-cost:43
Frontier-size:19, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:17, currentPath-cost:45
Frontier-size:18, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:17, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:47
Frontier-size:16, currentPath-cost:42
Frontier-size:17, currentPath-cost:43
Frontier-size:18, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:21, currentPath-cost:46
Frontier-size:22, currentPath-cost:47
Frontier-size:22, currentPath-cost:48
Frontier-size:22, currentPath-cost:49
Frontier-size:22, currentPath-cost:50
Frontier-size:22, currentPath-cost:51
Frontier-size:22, currentPath-cost:52
Frontier-size:22, currentPath-cost:53
Frontier-size:23, currentPath-cost:54
Frontier-size:24, currentPath-cost:55
Frontier-size:24, currentPath-cost:56
Frontier-size:24, currentPath-cost:57
Frontier-size:23, currentPath-cost:58
Frontier-size:23, currentPath-cost:56
Frontier-size:22, currentPath-cost:57
Frontier-size:21, currentPath-cost:55
Frontier-size:20, currentPath-cost:48
Frontier-size:19, currentPath-cost:47
Frontier-size:18, currentPath-cost:47
Frontier-size:17, currentPath-cost:46
Frontier-size:16, currentPath-cost:45
Frontier-size:15, currentPath-cost:44
Frontier-size:14, currentPath-cost:42
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:39
Frontier-size:9, currentPath-cost:39
Frontier-size:8, currentPath-cost:35
Frontier-size:7, currentPath-cost:25
Frontier-size:8, currentPath-cost:24
Frontier-size:9, currentPath-cost:25
Frontier-size:9, currentPath-cost:26
Frontier-size:9, currentPath-cost:27
Frontier-size:9, currentPath-cost:28
Frontier-size:9, currentPath-cost:29
Frontier-size:9, currentPath-cost:30
Frontier-size:9, currentPath-cost:31
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    ||||||||   |||x
x    |  xxx ||||| |x
x   ||  x xxxxx |||x
x 1 $     x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:8, currentPath-cost:34
Frontier-size:11, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:11, currentPath-cost:36
Frontier-size:12, currentPath-cost:37
Frontier-size:13, currentPath-cost:38
Frontier-size:14, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:13, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:13, currentPath-cost:42
Frontier-size:12, currentPath-cost:43
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:38
Frontier-size:10, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:11, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:11, currentPath-cost:42
Frontier-size:12, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:12, currentPath-cost:42
Frontier-size:12, currentPath-cost:43
Frontier-size:11, currentPath-cost:44
Frontier-size:10, currentPath-cost:41
Frontier-size:12, currentPath-cost:38
Frontier-size:15, currentPath-cost:39
Frontier-size:15, currentPath-cost:40
Frontier-size:17, currentPath-cost:41
Frontier-size:17, currentPath-cost:42
Frontier-size:18, currentPath-cost:43
Frontier-size:19, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:17, currentPath-cost:45
Frontier-size:18, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:17, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:47
Frontier-size:16, currentPath-cost:42
Frontier-size:17, currentPath-cost:43
Frontier-size:18, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:21, currentPath-cost:46
Frontier-size:22, currentPath-cost:47
Frontier-size:22, currentPath-cost:48
Frontier-size:22, currentPath-cost:49
Frontier-size:22, currentPath-cost:50
Frontier-size:22, currentPath-cost:51
Frontier-size:22, currentPath-cost:52
Frontier-size:22, currentPath-cost:53
Frontier-size:23, currentPath-cost:54
Frontier-size:24, currentPath-cost:55
Frontier-size:24, currentPath-cost:56
Frontier-size:24, currentPath-cost:57
Frontier-size:23, currentPath-cost:58
Frontier-size:23, currentPath-cost:56
Frontier-size:22, currentPath-cost:57
Frontier-size:21, currentPath-cost:55
Frontier-size:20, currentPath-cost:48
Frontier-size:19, currentPath-cost:47
Frontier-size:18, currentPath-cost:47
Frontier-size:17, currentPath-cost:46
Frontier-size:16, currentPath-cost:45
Frontier-size:15, currentPath-cost:44
Frontier-size:14, currentPath-cost:42
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:39
Frontier-size:9, currentPath-cost:39
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:26
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:8, currentPath-cost:27
Frontier-size:8, currentPath-cost:28
Frontier-size:8, currentPath-cost:29
Frontier-size:8, currentPath-cost:30
Frontier-size:8, currentPath-cost:31
Frontier-size:8, currentPath-cost:32
Frontier-size:8, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    ||||||||   |||x
x    |  xxx ||||| |x
x   ||  x xxxxx||||x
x 1 $     x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:7, currentPath-cost:34
Frontier-size:10, currentPath-cost:34
Frontier-size:10, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:12, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:12, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:12, currentPath-cost:42
Frontier-size:11, currentPath-cost:43
Frontier-size:10, currentPath-cost:39
Frontier-size:9, currentPath-cost:38
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:10, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:11, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:11, currentPath-cost:40
Frontier-size:11, currentPath-cost:41
Frontier-size:11, currentPath-cost:42
Frontier-size:11, currentPath-cost:43
Frontier-size:10, currentPath-cost:44
Frontier-size:9, currentPath-cost:41
Frontier-size:11, currentPath-cost:38
Frontier-size:14, currentPath-cost:39
Frontier-size:14, currentPath-cost:40
Frontier-size:16, currentPath-cost:41
Frontier-size:16, currentPath-cost:42
Frontier-size:17, currentPath-cost:43
Frontier-size:18, currentPath-cost:44
Frontier-size:18, currentPath-cost:45
Frontier-size:17, currentPath-cost:46
Frontier-size:16, currentPath-cost:45
Frontier-size:17, currentPath-cost:44
Frontier-size:16, currentPath-cost:45
Frontier-size:16, currentPath-cost:45
Frontier-size:17, currentPath-cost:46
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:47
Frontier-size:15, currentPath-cost:42
Frontier-size:16, currentPath-cost:43
Frontier-size:17, currentPath-cost:44
Frontier-size:18, currentPath-cost:45
Frontier-size:20, currentPath-cost:46
Frontier-size:21, currentPath-cost:47
Frontier-size:21, currentPath-cost:48
Frontier-size:21, currentPath-cost:49
Frontier-size:21, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:21, currentPath-cost:52
Frontier-size:21, currentPath-cost:53
Frontier-size:22, currentPath-cost:54
Frontier-size:23, currentPath-cost:55
Frontier-size:23, currentPath-cost:56
Frontier-size:23, currentPath-cost:57
Frontier-size:22, currentPath-cost:58
Frontier-size:22, currentPath-cost:56
Frontier-size:21, currentPath-cost:57
Frontier-size:20, currentPath-cost:55
Frontier-size:19, currentPath-cost:48
Frontier-size:18, currentPath-cost:47
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:46
Frontier-size:15, currentPath-cost:45
Frontier-size:14, currentPath-cost:44
Frontier-size:13, currentPath-cost:42
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:39
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:28
Frontier-size:6, currentPath-cost:29
Frontier-size:8, currentPath-cost:18
Frontier-size:8, currentPath-cost:19
Frontier-size:8, currentPath-cost:20
Frontier-size:8, currentPath-cost:21
Frontier-size:8, currentPath-cost:22
Frontier-size:8, currentPath-cost:23
Frontier-size:8, currentPath-cost:24
Frontier-size:8, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:8, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    ||||||||      x
x    |  xxx |||||  x
x   ||  x xxxxx |  x
x 1 $     x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:7, currentPath-cost:28
Frontier-size:10, currentPath-cost:28
Frontier-size:10, currentPath-cost:29
Frontier-size:10, currentPath-cost:30
Frontier-size:11, currentPath-cost:31
Frontier-size:12, currentPath-cost:32
Frontier-size:13, currentPath-cost:33
Frontier-size:12, currentPath-cost:34
Frontier-size:12, currentPath-cost:34
Frontier-size:12, currentPath-cost:35
Frontier-size:12, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:10, currentPath-cost:33
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:29
Frontier-size:9, currentPath-cost:30
Frontier-size:10, currentPath-cost:31
Frontier-size:10, currentPath-cost:32
Frontier-size:11, currentPath-cost:33
Frontier-size:11, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:11, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:9, currentPath-cost:35
Frontier-size:11, currentPath-cost:32
Frontier-size:14, currentPath-cost:33
Frontier-size:14, currentPath-cost:34
Frontier-size:16, currentPath-cost:35
Frontier-size:16, currentPath-cost:36
Frontier-size:17, currentPath-cost:37
Frontier-size:18, currentPath-cost:38
Frontier-size:18, currentPath-cost:39
Frontier-size:17, currentPath-cost:40
Frontier-size:16, currentPath-cost:39
Frontier-size:17, currentPath-cost:38
Frontier-size:16, currentPath-cost:39
Frontier-size:16, currentPath-cost:39
Frontier-size:17, currentPath-cost:40
Frontier-size:16, currentPath-cost:41
Frontier-size:15, currentPath-cost:41
Frontier-size:15, currentPath-cost:36
Frontier-size:16, currentPath-cost:37
Frontier-size:17, currentPath-cost:38
Frontier-size:18, currentPath-cost:39
Frontier-size:20, currentPath-cost:40
Frontier-size:21, currentPath-cost:41
Frontier-size:21, currentPath-cost:42
Frontier-size:21, currentPath-cost:43
Frontier-size:21, currentPath-cost:44
Frontier-size:21, currentPath-cost:45
Frontier-size:21, currentPath-cost:46
Frontier-size:21, currentPath-cost:47
Frontier-size:22, currentPath-cost:48
Frontier-size:23, currentPath-cost:49
Frontier-size:23, currentPath-cost:50
Frontier-size:23, currentPath-cost:51
Frontier-size:22, currentPath-cost:52
Frontier-size:22, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:20, currentPath-cost:49
Frontier-size:19, currentPath-cost:42
Frontier-size:18, currentPath-cost:41
Frontier-size:17, currentPath-cost:41
Frontier-size:16, currentPath-cost:40
Frontier-size:15, currentPath-cost:39
Frontier-size:14, currentPath-cost:38
Frontier-size:13, currentPath-cost:36
Frontier-size:12, currentPath-cost:34
Frontier-size:11, currentPath-cost:34
Frontier-size:10, currentPath-cost:34
Frontier-size:9, currentPath-cost:33
Frontier-size:8, currentPath-cost:33
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:19
Frontier-size:8, currentPath-cost:20
Frontier-size:8, currentPath-cost:21
Frontier-size:8, currentPath-cost:22
Frontier-size:8, currentPath-cost:23
Frontier-size:8, currentPath-cost:24
Frontier-size:8, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:8, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    ||||||||      x
x    |  xxx |||||  x
x   ||  x xxxxx||  x
x 1 $     x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:7, currentPath-cost:28
Frontier-size:10, currentPath-cost:28
Frontier-size:10, currentPath-cost:29
Frontier-size:10, currentPath-cost:30
Frontier-size:11, currentPath-cost:31
Frontier-size:12, currentPath-cost:32
Frontier-size:13, currentPath-cost:33
Frontier-size:12, currentPath-cost:34
Frontier-size:12, currentPath-cost:34
Frontier-size:12, currentPath-cost:35
Frontier-size:12, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:10, currentPath-cost:33
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:29
Frontier-size:9, currentPath-cost:30
Frontier-size:10, currentPath-cost:31
Frontier-size:10, currentPath-cost:32
Frontier-size:11, currentPath-cost:33
Frontier-size:11, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:11, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:9, currentPath-cost:35
Frontier-size:11, currentPath-cost:32
Frontier-size:14, currentPath-cost:33
Frontier-size:14, currentPath-cost:34
Frontier-size:16, currentPath-cost:35
Frontier-size:16, currentPath-cost:36
Frontier-size:17, currentPath-cost:37
Frontier-size:18, currentPath-cost:38
Frontier-size:18, currentPath-cost:39
Frontier-size:17, currentPath-cost:40
Frontier-size:16, currentPath-cost:39
Frontier-size:17, currentPath-cost:38
Frontier-size:16, currentPath-cost:39
Frontier-size:16, currentPath-cost:39
Frontier-size:17, currentPath-cost:40
Frontier-size:16, currentPath-cost:41
Frontier-size:15, currentPath-cost:41
Frontier-size:15, currentPath-cost:36
Frontier-size:16, currentPath-cost:37
Frontier-size:17, currentPath-cost:38
Frontier-size:18, currentPath-cost:39
Frontier-size:20, currentPath-cost:40
Frontier-size:21, currentPath-cost:41
Frontier-size:21, currentPath-cost:42
Frontier-size:21, currentPath-cost:43
Frontier-size:21, currentPath-cost:44
Frontier-size:21, currentPath-cost:45
Frontier-size:21, currentPath-cost:46
Frontier-size:21, currentPath-cost:47
Frontier-size:22, currentPath-cost:48
Frontier-size:23, currentPath-cost:49
Frontier-size:23, currentPath-cost:50
Frontier-size:23, currentPath-cost:51
Frontier-size:22, currentPath-cost:52
Frontier-size:22, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:20, currentPath-cost:49
Frontier-size:19, currentPath-cost:42
Frontier-size:18, currentPath-cost:41
Frontier-size:17, currentPath-cost:41
Frontier-size:16, currentPath-cost:40
Frontier-size:15, currentPath-cost:39
Frontier-size:14, currentPath-cost:38
Frontier-size:13, currentPath-cost:36
Frontier-size:12, currentPath-cost:34
Frontier-size:11, currentPath-cost:34
Frontier-size:10, currentPath-cost:34
Frontier-size:9, currentPath-cost:33
Frontier-size:8, currentPath-cost:33
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:21
Frontier-size:8, currentPath-cost:22
Frontier-size:9, currentPath-cost:23
Frontier-size:10, currentPath-cost:24
Frontier-size:11, currentPath-cost:25
Frontier-size:11, currentPath-cost:26
Frontier-size:11, currentPath-cost:27
Frontier-size:11, currentPath-cost:28
Frontier-size:10, currentPath-cost:29
Frontier-size:9, currentPath-cost:26
Frontier-size:8, currentPath-cost:25
Frontier-size:7, currentPath-cost:24
Frontier-size:6, currentPath-cost:23
Frontier-size:5, currentPath-cost:19
Frontier-size:4, currentPath-cost:18
Frontier-size:3, currentPath-cost:5
Frontier-size:2, currentPath-cost:2
Frontier-size:1, currentPath-cost:2
Frontier-size:1, currentPath-cost:2
Frontier-size:2, currentPath-cost:3
Frontier-size:2, currentPath-cost:4
Frontier-size:2, currentPath-cost:5
Frontier-size:2, currentPath-cost:6
Frontier-size:2, currentPath-cost:7
Frontier-size:2, currentPath-cost:8
Frontier-size:2, currentPath-cost:9
Frontier-size:2, currentPath-cost:10
Frontier-size:3, currentPath-cost:11
Frontier-size:3, currentPath-cost:12
Frontier-size:3, currentPath-cost:13
Frontier-size:3, currentPath-cost:14
Frontier-size:3, currentPath-cost:15
Frontier-size:4, currentPath-cost:16
Frontier-size:5, currentPath-cost:17
Frontier-size:6, currentPath-cost:18
Frontier-size:6, currentPath-cost:19
Frontier-size:6, currentPath-cost:20
Frontier-size:6, currentPath-cost:21
Frontier-size:6, currentPath-cost:22
Frontier-size:6, currentPath-cost:23
Frontier-size:6, currentPath-cost:24
Frontier-size:6, currentPath-cost:25
xxxxxxxxxxxxxxxxxxxx
x    |||||||       x
x    |  xxx|||||   x
x    |  x xxxxx|   x
x 1 $|    x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:26
Frontier-size:8, currentPath-cost:26
Frontier-size:8, currentPath-cost:27
Frontier-size:8, currentPath-cost:28
Frontier-size:9, currentPath-cost:29
Frontier-size:10, currentPath-cost:30
Frontier-size:11, currentPath-cost:31
Frontier-size:10, currentPath-cost:32
Frontier-size:10, currentPath-cost:32
Frontier-size:10, currentPath-cost:33
Frontier-size:10, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:8, currentPath-cost:31
Frontier-size:7, currentPath-cost:30
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:28
Frontier-size:8, currentPath-cost:29
Frontier-size:8, currentPath-cost:30
Frontier-size:9, currentPath-cost:31
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:8, currentPath-cost:34
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:7, currentPath-cost:33
Frontier-size:9, currentPath-cost:30
Frontier-size:12, currentPath-cost:31
Frontier-size:12, currentPath-cost:32
Frontier-size:13, currentPath-cost:33
Frontier-size:13, currentPath-cost:34
Frontier-size:14, currentPath-cost:35
Frontier-size:15, currentPath-cost:36
Frontier-size:17, currentPath-cost:37
Frontier-size:19, currentPath-cost:38
Frontier-size:20, currentPath-cost:39
Frontier-size:20, currentPath-cost:40
Frontier-size:20, currentPath-cost:41
Frontier-size:20, currentPath-cost:42
Frontier-size:20, currentPath-cost:43
Frontier-size:20, currentPath-cost:44
Frontier-size:20, currentPath-cost:45
Frontier-size:21, currentPath-cost:46
Frontier-size:22, currentPath-cost:47
Frontier-size:22, currentPath-cost:48
Frontier-size:22, currentPath-cost:49
Frontier-size:21, currentPath-cost:50
Frontier-size:21, currentPath-cost:48
Frontier-size:20, currentPath-cost:49
Frontier-size:19, currentPath-cost:47
Frontier-size:18, currentPath-cost:40
Frontier-size:17, currentPath-cost:39
Frontier-size:16, currentPath-cost:39
Frontier-size:15, currentPath-cost:38
Frontier-size:14, currentPath-cost:38
Frontier-size:13, currentPath-cost:37
Frontier-size:12, currentPath-cost:36
Frontier-size:13, currentPath-cost:34
Frontier-size:14, currentPath-cost:35
Frontier-size:15, currentPath-cost:36
Frontier-size:15, currentPath-cost:37
Frontier-size:14, currentPath-cost:38
Frontier-size:13, currentPath-cost:37
Frontier-size:13, currentPath-cost:36
Frontier-size:13, currentPath-cost:37
Frontier-size:14, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:35
Frontier-size:10, currentPath-cost:32
Frontier-size:9, currentPath-cost:32
Frontier-size:8, currentPath-cost:32
Frontier-size:7, currentPath-cost:31
Frontier-size:6, currentPath-cost:31
Frontier-size:5, currentPath-cost:27
Frontier-size:6, currentPath-cost:19
Frontier-size:7, currentPath-cost:20
Frontier-size:8, currentPath-cost:21
Frontier-size:9, currentPath-cost:22
Frontier-size:9, currentPath-cost:23
Frontier-size:9, currentPath-cost:24
Frontier-size:9, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:8, currentPath-cost:23
Frontier-size:8, currentPath-cost:24
Frontier-size:8, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:7, currentPath-cost:27
Frontier-size:6, currentPath-cost:22
Frontier-size:5, currentPath-cost:21
Frontier-size:4, currentPath-cost:20
Frontier-size:4, currentPath-cost:18
Frontier-size:4, currentPath-cost:19
Frontier-size:4, currentPath-cost:20
Frontier-size:4, currentPath-cost:21
Frontier-size:4, currentPath-cost:22
Frontier-size:4, currentPath-cost:23
Frontier-size:4, currentPath-cost:24
Frontier-size:4, currentPath-cost:25
Frontier-size:4, currentPath-cost:26
Frontier-size:4, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    |||||||       x
x    |  xxx|||||   x
x    |  x xxxxx||  x
x 1 $|    x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:3, currentPath-cost:28
Frontier-size:6, currentPath-cost:28
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:7, currentPath-cost:31
Frontier-size:8, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:7, currentPath-cost:37
Frontier-size:6, currentPath-cost:33
Frontier-size:5, currentPath-cost:32
Frontier-size:5, currentPath-cost:29
Frontier-size:5, currentPath-cost:30
Frontier-size:6, currentPath-cost:31
Frontier-size:6, currentPath-cost:32
Frontier-size:7, currentPath-cost:33
Frontier-size:7, currentPath-cost:34
Frontier-size:7, currentPath-cost:35
Frontier-size:6, currentPath-cost:36
Frontier-size:7, currentPath-cost:34
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:7, currentPath-cost:37
Frontier-size:6, currentPath-cost:38
Frontier-size:5, currentPath-cost:35
Frontier-size:7, currentPath-cost:32
Frontier-size:10, currentPath-cost:33
Frontier-size:10, currentPath-cost:34
Frontier-size:11, currentPath-cost:35
Frontier-size:11, currentPath-cost:36
Frontier-size:12, currentPath-cost:37
Frontier-size:13, currentPath-cost:38
Frontier-size:15, currentPath-cost:39
Frontier-size:17, currentPath-cost:40
Frontier-size:18, currentPath-cost:41
Frontier-size:18, currentPath-cost:42
Frontier-size:18, currentPath-cost:43
Frontier-size:18, currentPath-cost:44
Frontier-size:18, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:18, currentPath-cost:47
Frontier-size:19, currentPath-cost:48
Frontier-size:20, currentPath-cost:49
Frontier-size:20, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:19, currentPath-cost:52
Frontier-size:19, currentPath-cost:50
Frontier-size:18, currentPath-cost:51
Frontier-size:17, currentPath-cost:49
Frontier-size:16, currentPath-cost:42
Frontier-size:15, currentPath-cost:41
Frontier-size:14, currentPath-cost:41
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:38
Frontier-size:11, currentPath-cost:36
Frontier-size:12, currentPath-cost:37
Frontier-size:13, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:39
Frontier-size:11, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:41
Frontier-size:10, currentPath-cost:41
Frontier-size:9, currentPath-cost:37
Frontier-size:8, currentPath-cost:34
Frontier-size:7, currentPath-cost:34
Frontier-size:6, currentPath-cost:34
Frontier-size:5, currentPath-cost:33
Frontier-size:4, currentPath-cost:33
Frontier-size:3, currentPath-cost:29
Frontier-size:5, currentPath-cost:17
Frontier-size:6, currentPath-cost:18
Frontier-size:6, currentPath-cost:19
Frontier-size:6, currentPath-cost:20
Frontier-size:6, currentPath-cost:21
Frontier-size:5, currentPath-cost:22
Frontier-size:5, currentPath-cost:19
Frontier-size:5, currentPath-cost:20
Frontier-size:5, currentPath-cost:21
Frontier-size:6, currentPath-cost:22
Frontier-size:6, currentPath-cost:23
Frontier-size:6, currentPath-cost:24
Frontier-size:6, currentPath-cost:25
Frontier-size:7, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:28
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:6, currentPath-cost:31
Frontier-size:6, currentPath-cost:32
Frontier-size:6, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    |||||||    |||x
x    |  xxx|||||| |x
x    |  x xxxxx   |x
x 1 $|    x |||||||x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:38
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:8, currentPath-cost:38
Frontier-size:9, currentPath-cost:39
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:8, currentPath-cost:42
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:44
Frontier-size:7, currentPath-cost:41
Frontier-size:9, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:19, currentPath-cost:46
Frontier-size:20, currentPath-cost:47
Frontier-size:20, currentPath-cost:48
Frontier-size:20, currentPath-cost:49
Frontier-size:20, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:20, currentPath-cost:52
Frontier-size:20, currentPath-cost:53
Frontier-size:21, currentPath-cost:54
Frontier-size:22, currentPath-cost:55
Frontier-size:22, currentPath-cost:56
Frontier-size:22, currentPath-cost:57
Frontier-size:21, currentPath-cost:58
Frontier-size:21, currentPath-cost:56
Frontier-size:20, currentPath-cost:57
Frontier-size:19, currentPath-cost:55
Frontier-size:18, currentPath-cost:48
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:12, currentPath-cost:44
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:15, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:13, currentPath-cost:44
Frontier-size:13, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:47
Frontier-size:12, currentPath-cost:47
Frontier-size:11, currentPath-cost:43
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:40
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:39
Frontier-size:5, currentPath-cost:35
Frontier-size:7, currentPath-cost:23
Frontier-size:6, currentPath-cost:24
Frontier-size:7, currentPath-cost:24
Frontier-size:7, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:7, currentPath-cost:31
Frontier-size:7, currentPath-cost:32
Frontier-size:7, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    |||||||    |||x
x    |  xxx|||||| |x
x    |  x xxxxx  ||x
x 1 $|    x |||||| x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:6, currentPath-cost:34
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:10, currentPath-cost:37
Frontier-size:11, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:11, currentPath-cost:40
Frontier-size:11, currentPath-cost:41
Frontier-size:11, currentPath-cost:42
Frontier-size:10, currentPath-cost:43
Frontier-size:9, currentPath-cost:39
Frontier-size:8, currentPath-cost:38
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:9, currentPath-cost:38
Frontier-size:10, currentPath-cost:39
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:10, currentPath-cost:43
Frontier-size:9, currentPath-cost:44
Frontier-size:8, currentPath-cost:41
Frontier-size:10, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:14, currentPath-cost:41
Frontier-size:14, currentPath-cost:42
Frontier-size:15, currentPath-cost:43
Frontier-size:16, currentPath-cost:44
Frontier-size:18, currentPath-cost:45
Frontier-size:20, currentPath-cost:46
Frontier-size:21, currentPath-cost:47
Frontier-size:21, currentPath-cost:48
Frontier-size:21, currentPath-cost:49
Frontier-size:21, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:21, currentPath-cost:52
Frontier-size:21, currentPath-cost:53
Frontier-size:22, currentPath-cost:54
Frontier-size:23, currentPath-cost:55
Frontier-size:23, currentPath-cost:56
Frontier-size:23, currentPath-cost:57
Frontier-size:22, currentPath-cost:58
Frontier-size:22, currentPath-cost:56
Frontier-size:21, currentPath-cost:57
Frontier-size:20, currentPath-cost:55
Frontier-size:19, currentPath-cost:48
Frontier-size:18, currentPath-cost:47
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:46
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:45
Frontier-size:13, currentPath-cost:44
Frontier-size:14, currentPath-cost:42
Frontier-size:15, currentPath-cost:43
Frontier-size:16, currentPath-cost:44
Frontier-size:16, currentPath-cost:45
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:45
Frontier-size:14, currentPath-cost:44
Frontier-size:14, currentPath-cost:45
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:47
Frontier-size:13, currentPath-cost:47
Frontier-size:12, currentPath-cost:43
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:35
Frontier-size:5, currentPath-cost:25
Frontier-size:6, currentPath-cost:24
Frontier-size:7, currentPath-cost:25
Frontier-size:7, currentPath-cost:26
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:7, currentPath-cost:31
Frontier-size:7, currentPath-cost:32
Frontier-size:7, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    |||||||    |||x
x    |  xxx|||||| |x
x    |  x xxxxx |||x
x 1 $|    x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:6, currentPath-cost:34
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:10, currentPath-cost:37
Frontier-size:11, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:11, currentPath-cost:40
Frontier-size:11, currentPath-cost:41
Frontier-size:11, currentPath-cost:42
Frontier-size:10, currentPath-cost:43
Frontier-size:9, currentPath-cost:39
Frontier-size:8, currentPath-cost:38
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:9, currentPath-cost:38
Frontier-size:10, currentPath-cost:39
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:10, currentPath-cost:43
Frontier-size:9, currentPath-cost:44
Frontier-size:8, currentPath-cost:41
Frontier-size:10, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:14, currentPath-cost:41
Frontier-size:14, currentPath-cost:42
Frontier-size:15, currentPath-cost:43
Frontier-size:16, currentPath-cost:44
Frontier-size:18, currentPath-cost:45
Frontier-size:20, currentPath-cost:46
Frontier-size:21, currentPath-cost:47
Frontier-size:21, currentPath-cost:48
Frontier-size:21, currentPath-cost:49
Frontier-size:21, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:21, currentPath-cost:52
Frontier-size:21, currentPath-cost:53
Frontier-size:22, currentPath-cost:54
Frontier-size:23, currentPath-cost:55
Frontier-size:23, currentPath-cost:56
Frontier-size:23, currentPath-cost:57
Frontier-size:22, currentPath-cost:58
Frontier-size:22, currentPath-cost:56
Frontier-size:21, currentPath-cost:57
Frontier-size:20, currentPath-cost:55
Frontier-size:19, currentPath-cost:48
Frontier-size:18, currentPath-cost:47
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:46
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:45
Frontier-size:13, currentPath-cost:44
Frontier-size:14, currentPath-cost:42
Frontier-size:15, currentPath-cost:43
Frontier-size:16, currentPath-cost:44
Frontier-size:16, currentPath-cost:45
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:45
Frontier-size:14, currentPath-cost:44
Frontier-size:14, currentPath-cost:45
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:47
Frontier-size:13, currentPath-cost:47
Frontier-size:12, currentPath-cost:43
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:35
Frontier-size:6, currentPath-cost:26
Frontier-size:5, currentPath-cost:27
Frontier-size:5, currentPath-cost:25
Frontier-size:6, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:28
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:6, currentPath-cost:31
Frontier-size:6, currentPath-cost:32
Frontier-size:6, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    |||||||    |||x
x    |  xxx|||||| |x
x    |  x xxxxx||||x
x 1 $|    x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:38
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:8, currentPath-cost:38
Frontier-size:9, currentPath-cost:39
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:8, currentPath-cost:42
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:44
Frontier-size:7, currentPath-cost:41
Frontier-size:9, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:19, currentPath-cost:46
Frontier-size:20, currentPath-cost:47
Frontier-size:20, currentPath-cost:48
Frontier-size:20, currentPath-cost:49
Frontier-size:20, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:20, currentPath-cost:52
Frontier-size:20, currentPath-cost:53
Frontier-size:21, currentPath-cost:54
Frontier-size:22, currentPath-cost:55
Frontier-size:22, currentPath-cost:56
Frontier-size:22, currentPath-cost:57
Frontier-size:21, currentPath-cost:58
Frontier-size:21, currentPath-cost:56
Frontier-size:20, currentPath-cost:57
Frontier-size:19, currentPath-cost:55
Frontier-size:18, currentPath-cost:48
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:12, currentPath-cost:44
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:15, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:13, currentPath-cost:44
Frontier-size:13, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:47
Frontier-size:12, currentPath-cost:47
Frontier-size:11, currentPath-cost:43
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:40
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:39
Frontier-size:5, currentPath-cost:35
Frontier-size:5, currentPath-cost:27
Frontier-size:5, currentPath-cost:28
Frontier-size:4, currentPath-cost:29
Frontier-size:6, currentPath-cost:18
Frontier-size:6, currentPath-cost:19
Frontier-size:6, currentPath-cost:20
Frontier-size:6, currentPath-cost:21
Frontier-size:6, currentPath-cost:22
Frontier-size:6, currentPath-cost:23
Frontier-size:6, currentPath-cost:24
Frontier-size:6, currentPath-cost:25
Frontier-size:6, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    |||||||       x
x    |  xxx||||||  x
x    |  x xxxxx |  x
x 1 $|    x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:28
Frontier-size:8, currentPath-cost:28
Frontier-size:8, currentPath-cost:29
Frontier-size:8, currentPath-cost:30
Frontier-size:9, currentPath-cost:31
Frontier-size:10, currentPath-cost:32
Frontier-size:11, currentPath-cost:33
Frontier-size:10, currentPath-cost:34
Frontier-size:10, currentPath-cost:34
Frontier-size:10, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:8, currentPath-cost:33
Frontier-size:7, currentPath-cost:32
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:8, currentPath-cost:31
Frontier-size:8, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:8, currentPath-cost:38
Frontier-size:7, currentPath-cost:35
Frontier-size:9, currentPath-cost:32
Frontier-size:12, currentPath-cost:33
Frontier-size:12, currentPath-cost:34
Frontier-size:13, currentPath-cost:35
Frontier-size:13, currentPath-cost:36
Frontier-size:14, currentPath-cost:37
Frontier-size:15, currentPath-cost:38
Frontier-size:17, currentPath-cost:39
Frontier-size:19, currentPath-cost:40
Frontier-size:20, currentPath-cost:41
Frontier-size:20, currentPath-cost:42
Frontier-size:20, currentPath-cost:43
Frontier-size:20, currentPath-cost:44
Frontier-size:20, currentPath-cost:45
Frontier-size:20, currentPath-cost:46
Frontier-size:20, currentPath-cost:47
Frontier-size:21, currentPath-cost:48
Frontier-size:22, currentPath-cost:49
Frontier-size:22, currentPath-cost:50
Frontier-size:22, currentPath-cost:51
Frontier-size:21, currentPath-cost:52
Frontier-size:21, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:19, currentPath-cost:49
Frontier-size:18, currentPath-cost:42
Frontier-size:17, currentPath-cost:41
Frontier-size:16, currentPath-cost:41
Frontier-size:15, currentPath-cost:40
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:39
Frontier-size:12, currentPath-cost:38
Frontier-size:13, currentPath-cost:36
Frontier-size:14, currentPath-cost:37
Frontier-size:15, currentPath-cost:38
Frontier-size:15, currentPath-cost:39
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:39
Frontier-size:13, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:12, currentPath-cost:41
Frontier-size:11, currentPath-cost:37
Frontier-size:10, currentPath-cost:34
Frontier-size:9, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:7, currentPath-cost:33
Frontier-size:6, currentPath-cost:33
Frontier-size:5, currentPath-cost:29
Frontier-size:5, currentPath-cost:19
Frontier-size:6, currentPath-cost:20
Frontier-size:6, currentPath-cost:21
Frontier-size:6, currentPath-cost:22
Frontier-size:6, currentPath-cost:23
Frontier-size:6, currentPath-cost:24
Frontier-size:6, currentPath-cost:25
Frontier-size:6, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    |||||||       x
x    |  xxx||||||  x
x    |  x xxxxx||  x
x 1 $|    x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:28
Frontier-size:8, currentPath-cost:28
Frontier-size:8, currentPath-cost:29
Frontier-size:8, currentPath-cost:30
Frontier-size:9, currentPath-cost:31
Frontier-size:10, currentPath-cost:32
Frontier-size:11, currentPath-cost:33
Frontier-size:10, currentPath-cost:34
Frontier-size:10, currentPath-cost:34
Frontier-size:10, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:8, currentPath-cost:33
Frontier-size:7, currentPath-cost:32
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:8, currentPath-cost:31
Frontier-size:8, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:8, currentPath-cost:38
Frontier-size:7, currentPath-cost:35
Frontier-size:9, currentPath-cost:32
Frontier-size:12, currentPath-cost:33
Frontier-size:12, currentPath-cost:34
Frontier-size:13, currentPath-cost:35
Frontier-size:13, currentPath-cost:36
Frontier-size:14, currentPath-cost:37
Frontier-size:15, currentPath-cost:38
Frontier-size:17, currentPath-cost:39
Frontier-size:19, currentPath-cost:40
Frontier-size:20, currentPath-cost:41
Frontier-size:20, currentPath-cost:42
Frontier-size:20, currentPath-cost:43
Frontier-size:20, currentPath-cost:44
Frontier-size:20, currentPath-cost:45
Frontier-size:20, currentPath-cost:46
Frontier-size:20, currentPath-cost:47
Frontier-size:21, currentPath-cost:48
Frontier-size:22, currentPath-cost:49
Frontier-size:22, currentPath-cost:50
Frontier-size:22, currentPath-cost:51
Frontier-size:21, currentPath-cost:52
Frontier-size:21, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:19, currentPath-cost:49
Frontier-size:18, currentPath-cost:42
Frontier-size:17, currentPath-cost:41
Frontier-size:16, currentPath-cost:41
Frontier-size:15, currentPath-cost:40
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:39
Frontier-size:12, currentPath-cost:38
Frontier-size:13, currentPath-cost:36
Frontier-size:14, currentPath-cost:37
Frontier-size:15, currentPath-cost:38
Frontier-size:15, currentPath-cost:39
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:39
Frontier-size:13, currentPath-cost:38
Frontier-size:13, currentPath-cost:39
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:12, currentPath-cost:41
Frontier-size:11, currentPath-cost:37
Frontier-size:10, currentPath-cost:34
Frontier-size:9, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:7, currentPath-cost:33
Frontier-size:6, currentPath-cost:33
Frontier-size:5, currentPath-cost:29
Frontier-size:5, currentPath-cost:21
Frontier-size:6, currentPath-cost:22
Frontier-size:7, currentPath-cost:23
Frontier-size:8, currentPath-cost:24
Frontier-size:9, currentPath-cost:25
Frontier-size:9, currentPath-cost:26
Frontier-size:9, currentPath-cost:27
Frontier-size:9, currentPath-cost:28
Frontier-size:9, currentPath-cost:29
Frontier-size:8, currentPath-cost:30
Frontier-size:7, currentPath-cost:26
Frontier-size:6, currentPath-cost:25
Frontier-size:5, currentPath-cost:24
Frontier-size:4, currentPath-cost:23
Frontier-size:3, currentPath-cost:19
Frontier-size:2, currentPath-cost:18
Frontier-size:2, currentPath-cost:12
Frontier-size:3, currentPath-cost:13
Frontier-size:2, currentPath-cost:14
Frontier-size:2, currentPath-cost:14
Frontier-size:2, currentPath-cost:15
Frontier-size:3, currentPath-cost:16
Frontier-size:4, currentPath-cost:17
Frontier-size:5, currentPath-cost:18
Frontier-size:5, currentPath-cost:19
Frontier-size:5, currentPath-cost:20
Frontier-size:5, currentPath-cost:21
Frontier-size:5, currentPath-cost:22
Frontier-size:5, currentPath-cost:23
Frontier-size:5, currentPath-cost:24
Frontier-size:5, currentPath-cost:25
xxxxxxxxxxxxxxxxxxxx
x    ||||||||      x
x    |  xxx ||||   x
x    |  x xxxxx|   x
x 1 $|    x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:4, currentPath-cost:26
Frontier-size:7, currentPath-cost:26
Frontier-size:7, currentPath-cost:27
Frontier-size:7, currentPath-cost:28
Frontier-size:8, currentPath-cost:29
Frontier-size:9, currentPath-cost:30
Frontier-size:10, currentPath-cost:31
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:7, currentPath-cost:31
Frontier-size:6, currentPath-cost:30
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:8, currentPath-cost:31
Frontier-size:8, currentPath-cost:32
Frontier-size:8, currentPath-cost:33
Frontier-size:7, currentPath-cost:34
Frontier-size:8, currentPath-cost:32
Frontier-size:8, currentPath-cost:33
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:6, currentPath-cost:33
Frontier-size:8, currentPath-cost:30
Frontier-size:11, currentPath-cost:31
Frontier-size:11, currentPath-cost:32
Frontier-size:12, currentPath-cost:33
Frontier-size:12, currentPath-cost:34
Frontier-size:13, currentPath-cost:35
Frontier-size:14, currentPath-cost:36
Frontier-size:16, currentPath-cost:37
Frontier-size:18, currentPath-cost:38
Frontier-size:19, currentPath-cost:39
Frontier-size:19, currentPath-cost:40
Frontier-size:19, currentPath-cost:41
Frontier-size:19, currentPath-cost:42
Frontier-size:19, currentPath-cost:43
Frontier-size:19, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:20, currentPath-cost:46
Frontier-size:21, currentPath-cost:47
Frontier-size:21, currentPath-cost:48
Frontier-size:21, currentPath-cost:49
Frontier-size:20, currentPath-cost:50
Frontier-size:20, currentPath-cost:48
Frontier-size:19, currentPath-cost:49
Frontier-size:18, currentPath-cost:47
Frontier-size:17, currentPath-cost:40
Frontier-size:16, currentPath-cost:39
Frontier-size:15, currentPath-cost:39
Frontier-size:14, currentPath-cost:38
Frontier-size:13, currentPath-cost:38
Frontier-size:12, currentPath-cost:37
Frontier-size:11, currentPath-cost:36
Frontier-size:12, currentPath-cost:34
Frontier-size:13, currentPath-cost:35
Frontier-size:14, currentPath-cost:36
Frontier-size:14, currentPath-cost:37
Frontier-size:13, currentPath-cost:38
Frontier-size:12, currentPath-cost:37
Frontier-size:12, currentPath-cost:36
Frontier-size:12, currentPath-cost:37
Frontier-size:13, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:35
Frontier-size:9, currentPath-cost:32
Frontier-size:8, currentPath-cost:32
Frontier-size:7, currentPath-cost:32
Frontier-size:6, currentPath-cost:31
Frontier-size:5, currentPath-cost:31
Frontier-size:4, currentPath-cost:27
Frontier-size:5, currentPath-cost:19
Frontier-size:6, currentPath-cost:20
Frontier-size:7, currentPath-cost:21
Frontier-size:8, currentPath-cost:22
Frontier-size:8, currentPath-cost:23
Frontier-size:8, currentPath-cost:24
Frontier-size:7, currentPath-cost:25
Frontier-size:7, currentPath-cost:23
Frontier-size:7, currentPath-cost:24
Frontier-size:7, currentPath-cost:25
Frontier-size:7, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
Frontier-size:5, currentPath-cost:22
Frontier-size:4, currentPath-cost:21
Frontier-size:3, currentPath-cost:20
Frontier-size:3, currentPath-cost:18
Frontier-size:3, currentPath-cost:19
Frontier-size:3, currentPath-cost:20
Frontier-size:3, currentPath-cost:21
Frontier-size:3, currentPath-cost:22
Frontier-size:3, currentPath-cost:23
Frontier-size:3, currentPath-cost:24
Frontier-size:3, currentPath-cost:25
Frontier-size:3, currentPath-cost:26
Frontier-size:3, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    ||||||||      x
x    |  xxx ||||   x
x    |  x xxxxx||  x
x 1 $|    x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:2, currentPath-cost:28
Frontier-size:5, currentPath-cost:28
Frontier-size:5, currentPath-cost:29
Frontier-size:5, currentPath-cost:30
Frontier-size:6, currentPath-cost:31
Frontier-size:7, currentPath-cost:32
Frontier-size:8, currentPath-cost:33
Frontier-size:7, currentPath-cost:34
Frontier-size:7, currentPath-cost:34
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:6, currentPath-cost:37
Frontier-size:5, currentPath-cost:33
Frontier-size:4, currentPath-cost:32
Frontier-size:4, currentPath-cost:29
Frontier-size:4, currentPath-cost:30
Frontier-size:5, currentPath-cost:31
Frontier-size:5, currentPath-cost:32
Frontier-size:6, currentPath-cost:33
Frontier-size:6, currentPath-cost:34
Frontier-size:6, currentPath-cost:35
Frontier-size:5, currentPath-cost:36
Frontier-size:6, currentPath-cost:34
Frontier-size:6, currentPath-cost:35
Frontier-size:6, currentPath-cost:36
Frontier-size:6, currentPath-cost:37
Frontier-size:5, currentPath-cost:38
Frontier-size:4, currentPath-cost:35
Frontier-size:6, currentPath-cost:32
Frontier-size:9, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:10, currentPath-cost:35
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:12, currentPath-cost:38
Frontier-size:14, currentPath-cost:39
Frontier-size:16, currentPath-cost:40
Frontier-size:17, currentPath-cost:41
Frontier-size:17, currentPath-cost:42
Frontier-size:17, currentPath-cost:43
Frontier-size:17, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:17, currentPath-cost:46
Frontier-size:17, currentPath-cost:47
Frontier-size:18, currentPath-cost:48
Frontier-size:19, currentPath-cost:49
Frontier-size:19, currentPath-cost:50
Frontier-size:19, currentPath-cost:51
Frontier-size:18, currentPath-cost:52
Frontier-size:18, currentPath-cost:50
Frontier-size:17, currentPath-cost:51
Frontier-size:16, currentPath-cost:49
Frontier-size:15, currentPath-cost:42
Frontier-size:14, currentPath-cost:41
Frontier-size:13, currentPath-cost:41
Frontier-size:12, currentPath-cost:40
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:39
Frontier-size:9, currentPath-cost:38
Frontier-size:10, currentPath-cost:36
Frontier-size:11, currentPath-cost:37
Frontier-size:12, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:39
Frontier-size:10, currentPath-cost:38
Frontier-size:10, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:9, currentPath-cost:41
Frontier-size:8, currentPath-cost:37
Frontier-size:7, currentPath-cost:34
Frontier-size:6, currentPath-cost:34
Frontier-size:5, currentPath-cost:34
Frontier-size:4, currentPath-cost:33
Frontier-size:3, currentPath-cost:33
Frontier-size:2, currentPath-cost:29
Frontier-size:4, currentPath-cost:17
Frontier-size:5, currentPath-cost:18
Frontier-size:5, currentPath-cost:19
Frontier-size:5, currentPath-cost:20
Frontier-size:4, currentPath-cost:21
Frontier-size:4, currentPath-cost:19
Frontier-size:4, currentPath-cost:20
Frontier-size:4, currentPath-cost:21
Frontier-size:5, currentPath-cost:22
Frontier-size:5, currentPath-cost:23
Frontier-size:5, currentPath-cost:24
Frontier-size:5, currentPath-cost:25
Frontier-size:6, currentPath-cost:26
Frontier-size:5, currentPath-cost:27
Frontier-size:5, currentPath-cost:27
Frontier-size:5, currentPath-cost:28
Frontier-size:5, currentPath-cost:29
Frontier-size:5, currentPath-cost:30
Frontier-size:5, currentPath-cost:31
Frontier-size:5, currentPath-cost:32
Frontier-size:5, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    ||||||||   |||x
x    |  xxx ||||| |x
x    |  x xxxxx   |x
x 1 $|    x |||||||x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:4, currentPath-cost:34
Frontier-size:7, currentPath-cost:34
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:9, currentPath-cost:38
Frontier-size:10, currentPath-cost:39
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:8, currentPath-cost:43
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:38
Frontier-size:6, currentPath-cost:35
Frontier-size:6, currentPath-cost:36
Frontier-size:7, currentPath-cost:37
Frontier-size:7, currentPath-cost:38
Frontier-size:8, currentPath-cost:39
Frontier-size:8, currentPath-cost:40
Frontier-size:8, currentPath-cost:41
Frontier-size:7, currentPath-cost:42
Frontier-size:8, currentPath-cost:40
Frontier-size:8, currentPath-cost:41
Frontier-size:8, currentPath-cost:42
Frontier-size:8, currentPath-cost:43
Frontier-size:7, currentPath-cost:44
Frontier-size:6, currentPath-cost:41
Frontier-size:8, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:12, currentPath-cost:42
Frontier-size:13, currentPath-cost:43
Frontier-size:14, currentPath-cost:44
Frontier-size:16, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:19, currentPath-cost:47
Frontier-size:19, currentPath-cost:48
Frontier-size:19, currentPath-cost:49
Frontier-size:19, currentPath-cost:50
Frontier-size:19, currentPath-cost:51
Frontier-size:19, currentPath-cost:52
Frontier-size:19, currentPath-cost:53
Frontier-size:20, currentPath-cost:54
Frontier-size:21, currentPath-cost:55
Frontier-size:21, currentPath-cost:56
Frontier-size:21, currentPath-cost:57
Frontier-size:20, currentPath-cost:58
Frontier-size:20, currentPath-cost:56
Frontier-size:19, currentPath-cost:57
Frontier-size:18, currentPath-cost:55
Frontier-size:17, currentPath-cost:48
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:47
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:46
Frontier-size:12, currentPath-cost:45
Frontier-size:11, currentPath-cost:44
Frontier-size:12, currentPath-cost:42
Frontier-size:13, currentPath-cost:43
Frontier-size:14, currentPath-cost:44
Frontier-size:14, currentPath-cost:45
Frontier-size:13, currentPath-cost:46
Frontier-size:12, currentPath-cost:45
Frontier-size:12, currentPath-cost:44
Frontier-size:12, currentPath-cost:45
Frontier-size:13, currentPath-cost:46
Frontier-size:12, currentPath-cost:47
Frontier-size:11, currentPath-cost:47
Frontier-size:10, currentPath-cost:43
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:40
Frontier-size:7, currentPath-cost:40
Frontier-size:6, currentPath-cost:39
Frontier-size:5, currentPath-cost:39
Frontier-size:4, currentPath-cost:35
Frontier-size:6, currentPath-cost:23
Frontier-size:5, currentPath-cost:24
Frontier-size:6, currentPath-cost:24
Frontier-size:6, currentPath-cost:25
Frontier-size:7, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:28
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:6, currentPath-cost:31
Frontier-size:6, currentPath-cost:32
Frontier-size:6, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    ||||||||   |||x
x    |  xxx ||||| |x
x    |  x xxxxx  ||x
x 1 $|    x |||||| x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:38
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:8, currentPath-cost:38
Frontier-size:9, currentPath-cost:39
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:8, currentPath-cost:42
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:44
Frontier-size:7, currentPath-cost:41
Frontier-size:9, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:19, currentPath-cost:46
Frontier-size:20, currentPath-cost:47
Frontier-size:20, currentPath-cost:48
Frontier-size:20, currentPath-cost:49
Frontier-size:20, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:20, currentPath-cost:52
Frontier-size:20, currentPath-cost:53
Frontier-size:21, currentPath-cost:54
Frontier-size:22, currentPath-cost:55
Frontier-size:22, currentPath-cost:56
Frontier-size:22, currentPath-cost:57
Frontier-size:21, currentPath-cost:58
Frontier-size:21, currentPath-cost:56
Frontier-size:20, currentPath-cost:57
Frontier-size:19, currentPath-cost:55
Frontier-size:18, currentPath-cost:48
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:12, currentPath-cost:44
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:15, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:13, currentPath-cost:44
Frontier-size:13, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:47
Frontier-size:12, currentPath-cost:47
Frontier-size:11, currentPath-cost:43
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:40
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:39
Frontier-size:5, currentPath-cost:35
Frontier-size:4, currentPath-cost:25
Frontier-size:5, currentPath-cost:24
Frontier-size:6, currentPath-cost:25
Frontier-size:6, currentPath-cost:26
Frontier-size:6, currentPath-cost:27
Frontier-size:6, currentPath-cost:28
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:6, currentPath-cost:31
Frontier-size:6, currentPath-cost:32
Frontier-size:6, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    ||||||||   |||x
x    |  xxx ||||| |x
x    |  x xxxxx |||x
x 1 $|    x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:5, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:9, currentPath-cost:37
Frontier-size:10, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:40
Frontier-size:10, currentPath-cost:41
Frontier-size:10, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:39
Frontier-size:7, currentPath-cost:38
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:8, currentPath-cost:38
Frontier-size:9, currentPath-cost:39
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:8, currentPath-cost:42
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:9, currentPath-cost:43
Frontier-size:8, currentPath-cost:44
Frontier-size:7, currentPath-cost:41
Frontier-size:9, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:40
Frontier-size:13, currentPath-cost:41
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:17, currentPath-cost:45
Frontier-size:19, currentPath-cost:46
Frontier-size:20, currentPath-cost:47
Frontier-size:20, currentPath-cost:48
Frontier-size:20, currentPath-cost:49
Frontier-size:20, currentPath-cost:50
Frontier-size:20, currentPath-cost:51
Frontier-size:20, currentPath-cost:52
Frontier-size:20, currentPath-cost:53
Frontier-size:21, currentPath-cost:54
Frontier-size:22, currentPath-cost:55
Frontier-size:22, currentPath-cost:56
Frontier-size:22, currentPath-cost:57
Frontier-size:21, currentPath-cost:58
Frontier-size:21, currentPath-cost:56
Frontier-size:20, currentPath-cost:57
Frontier-size:19, currentPath-cost:55
Frontier-size:18, currentPath-cost:48
Frontier-size:17, currentPath-cost:47
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:46
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:12, currentPath-cost:44
Frontier-size:13, currentPath-cost:42
Frontier-size:14, currentPath-cost:43
Frontier-size:15, currentPath-cost:44
Frontier-size:15, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:45
Frontier-size:13, currentPath-cost:44
Frontier-size:13, currentPath-cost:45
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:47
Frontier-size:12, currentPath-cost:47
Frontier-size:11, currentPath-cost:43
Frontier-size:10, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:40
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:39
Frontier-size:5, currentPath-cost:35
Frontier-size:5, currentPath-cost:26
Frontier-size:4, currentPath-cost:27
Frontier-size:4, currentPath-cost:25
Frontier-size:5, currentPath-cost:26
Frontier-size:5, currentPath-cost:27
Frontier-size:5, currentPath-cost:28
Frontier-size:5, currentPath-cost:29
Frontier-size:5, currentPath-cost:30
Frontier-size:5, currentPath-cost:31
Frontier-size:5, currentPath-cost:32
Frontier-size:5, currentPath-cost:33
xxxxxxxxxxxxxxxxxxxx
x    ||||||||   |||x
x    |  xxx ||||| |x
x    |  x xxxxx||||x
x 1 $|    x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:4, currentPath-cost:34
Frontier-size:7, currentPath-cost:34
Frontier-size:7, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:9, currentPath-cost:38
Frontier-size:10, currentPath-cost:39
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:40
Frontier-size:9, currentPath-cost:41
Frontier-size:9, currentPath-cost:42
Frontier-size:8, currentPath-cost:43
Frontier-size:7, currentPath-cost:39
Frontier-size:6, currentPath-cost:38
Frontier-size:6, currentPath-cost:35
Frontier-size:6, currentPath-cost:36
Frontier-size:7, currentPath-cost:37
Frontier-size:7, currentPath-cost:38
Frontier-size:8, currentPath-cost:39
Frontier-size:8, currentPath-cost:40
Frontier-size:8, currentPath-cost:41
Frontier-size:7, currentPath-cost:42
Frontier-size:8, currentPath-cost:40
Frontier-size:8, currentPath-cost:41
Frontier-size:8, currentPath-cost:42
Frontier-size:8, currentPath-cost:43
Frontier-size:7, currentPath-cost:44
Frontier-size:6, currentPath-cost:41
Frontier-size:8, currentPath-cost:38
Frontier-size:11, currentPath-cost:39
Frontier-size:11, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:12, currentPath-cost:42
Frontier-size:13, currentPath-cost:43
Frontier-size:14, currentPath-cost:44
Frontier-size:16, currentPath-cost:45
Frontier-size:18, currentPath-cost:46
Frontier-size:19, currentPath-cost:47
Frontier-size:19, currentPath-cost:48
Frontier-size:19, currentPath-cost:49
Frontier-size:19, currentPath-cost:50
Frontier-size:19, currentPath-cost:51
Frontier-size:19, currentPath-cost:52
Frontier-size:19, currentPath-cost:53
Frontier-size:20, currentPath-cost:54
Frontier-size:21, currentPath-cost:55
Frontier-size:21, currentPath-cost:56
Frontier-size:21, currentPath-cost:57
Frontier-size:20, currentPath-cost:58
Frontier-size:20, currentPath-cost:56
Frontier-size:19, currentPath-cost:57
Frontier-size:18, currentPath-cost:55
Frontier-size:17, currentPath-cost:48
Frontier-size:16, currentPath-cost:47
Frontier-size:15, currentPath-cost:47
Frontier-size:14, currentPath-cost:46
Frontier-size:13, currentPath-cost:46
Frontier-size:12, currentPath-cost:45
Frontier-size:11, currentPath-cost:44
Frontier-size:12, currentPath-cost:42
Frontier-size:13, currentPath-cost:43
Frontier-size:14, currentPath-cost:44
Frontier-size:14, currentPath-cost:45
Frontier-size:13, currentPath-cost:46
Frontier-size:12, currentPath-cost:45
Frontier-size:12, currentPath-cost:44
Frontier-size:12, currentPath-cost:45
Frontier-size:13, currentPath-cost:46
Frontier-size:12, currentPath-cost:47
Frontier-size:11, currentPath-cost:47
Frontier-size:10, currentPath-cost:43
Frontier-size:9, currentPath-cost:40
Frontier-size:8, currentPath-cost:40
Frontier-size:7, currentPath-cost:40
Frontier-size:6, currentPath-cost:39
Frontier-size:5, currentPath-cost:39
Frontier-size:4, currentPath-cost:35
Frontier-size:4, currentPath-cost:27
Frontier-size:4, currentPath-cost:28
Frontier-size:3, currentPath-cost:29
Frontier-size:5, currentPath-cost:18
Frontier-size:5, currentPath-cost:19
Frontier-size:5, currentPath-cost:20
Frontier-size:5, currentPath-cost:21
Frontier-size:5, currentPath-cost:22
Frontier-size:5, currentPath-cost:23
Frontier-size:5, currentPath-cost:24
Frontier-size:5, currentPath-cost:25
Frontier-size:5, currentPath-cost:26
Frontier-size:5, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    ||||||||      x
x    |  xxx |||||  x
x    |  x xxxxx |  x
x 1 $|    x |||||  x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:4, currentPath-cost:28
Frontier-size:7, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:8, currentPath-cost:31
Frontier-size:9, currentPath-cost:32
Frontier-size:10, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:7, currentPath-cost:33
Frontier-size:6, currentPath-cost:32
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:7, currentPath-cost:31
Frontier-size:7, currentPath-cost:32
Frontier-size:8, currentPath-cost:33
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:7, currentPath-cost:38
Frontier-size:6, currentPath-cost:35
Frontier-size:8, currentPath-cost:32
Frontier-size:11, currentPath-cost:33
Frontier-size:11, currentPath-cost:34
Frontier-size:12, currentPath-cost:35
Frontier-size:12, currentPath-cost:36
Frontier-size:13, currentPath-cost:37
Frontier-size:14, currentPath-cost:38
Frontier-size:16, currentPath-cost:39
Frontier-size:18, currentPath-cost:40
Frontier-size:19, currentPath-cost:41
Frontier-size:19, currentPath-cost:42
Frontier-size:19, currentPath-cost:43
Frontier-size:19, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:19, currentPath-cost:46
Frontier-size:19, currentPath-cost:47
Frontier-size:20, currentPath-cost:48
Frontier-size:21, currentPath-cost:49
Frontier-size:21, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:20, currentPath-cost:52
Frontier-size:20, currentPath-cost:50
Frontier-size:19, currentPath-cost:51
Frontier-size:18, currentPath-cost:49
Frontier-size:17, currentPath-cost:42
Frontier-size:16, currentPath-cost:41
Frontier-size:15, currentPath-cost:41
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:38
Frontier-size:12, currentPath-cost:36
Frontier-size:13, currentPath-cost:37
Frontier-size:14, currentPath-cost:38
Frontier-size:14, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:11, currentPath-cost:41
Frontier-size:10, currentPath-cost:37
Frontier-size:9, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:7, currentPath-cost:34
Frontier-size:6, currentPath-cost:33
Frontier-size:5, currentPath-cost:33
Frontier-size:4, currentPath-cost:29
Frontier-size:4, currentPath-cost:19
Frontier-size:5, currentPath-cost:20
Frontier-size:5, currentPath-cost:21
Frontier-size:5, currentPath-cost:22
Frontier-size:5, currentPath-cost:23
Frontier-size:5, currentPath-cost:24
Frontier-size:5, currentPath-cost:25
Frontier-size:5, currentPath-cost:26
Frontier-size:5, currentPath-cost:27
xxxxxxxxxxxxxxxxxxxx
x    ||||||||      x
x    |  xxx |||||  x
x    |  x xxxxx||  x
x 1 $|    x ||||   x
x       x x |xxxxxxx
x  xx xxxxx ||     x
x      x     |§    x
x  1 2 x   2       x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:4, currentPath-cost:28
Frontier-size:7, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:7, currentPath-cost:30
Frontier-size:8, currentPath-cost:31
Frontier-size:9, currentPath-cost:32
Frontier-size:10, currentPath-cost:33
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:34
Frontier-size:9, currentPath-cost:35
Frontier-size:9, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:7, currentPath-cost:33
Frontier-size:6, currentPath-cost:32
Frontier-size:6, currentPath-cost:29
Frontier-size:6, currentPath-cost:30
Frontier-size:7, currentPath-cost:31
Frontier-size:7, currentPath-cost:32
Frontier-size:8, currentPath-cost:33
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:7, currentPath-cost:36
Frontier-size:8, currentPath-cost:34
Frontier-size:8, currentPath-cost:35
Frontier-size:8, currentPath-cost:36
Frontier-size:8, currentPath-cost:37
Frontier-size:7, currentPath-cost:38
Frontier-size:6, currentPath-cost:35
Frontier-size:8, currentPath-cost:32
Frontier-size:11, currentPath-cost:33
Frontier-size:11, currentPath-cost:34
Frontier-size:12, currentPath-cost:35
Frontier-size:12, currentPath-cost:36
Frontier-size:13, currentPath-cost:37
Frontier-size:14, currentPath-cost:38
Frontier-size:16, currentPath-cost:39
Frontier-size:18, currentPath-cost:40
Frontier-size:19, currentPath-cost:41
Frontier-size:19, currentPath-cost:42
Frontier-size:19, currentPath-cost:43
Frontier-size:19, currentPath-cost:44
Frontier-size:19, currentPath-cost:45
Frontier-size:19, currentPath-cost:46
Frontier-size:19, currentPath-cost:47
Frontier-size:20, currentPath-cost:48
Frontier-size:21, currentPath-cost:49
Frontier-size:21, currentPath-cost:50
Frontier-size:21, currentPath-cost:51
Frontier-size:20, currentPath-cost:52
Frontier-size:20, currentPath-cost:50
Frontier-size:19, currentPath-cost:51
Frontier-size:18, currentPath-cost:49
Frontier-size:17, currentPath-cost:42
Frontier-size:16, currentPath-cost:41
Frontier-size:15, currentPath-cost:41
Frontier-size:14, currentPath-cost:40
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:39
Frontier-size:11, currentPath-cost:38
Frontier-size:12, currentPath-cost:36
Frontier-size:13, currentPath-cost:37
Frontier-size:14, currentPath-cost:38
Frontier-size:14, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:39
Frontier-size:12, currentPath-cost:38
Frontier-size:12, currentPath-cost:39
Frontier-size:13, currentPath-cost:40
Frontier-size:12, currentPath-cost:41
Frontier-size:11, currentPath-cost:41
Frontier-size:10, currentPath-cost:37
Frontier-size:9, currentPath-cost:34
Frontier-size:8, currentPath-cost:34
Frontier-size:7, currentPath-cost:34
Frontier-size:6, currentPath-cost:33
Frontier-size:5, currentPath-cost:33
Frontier-size:4, currentPath-cost:29
Frontier-size:4, currentPath-cost:21
Frontier-size:5, currentPath-cost:22
Frontier-size:6, currentPath-cost:23
Frontier-size:7, currentPath-cost:24
Frontier-size:8, currentPath-cost:25
Frontier-size:8, currentPath-cost:26
Frontier-size:8, currentPath-cost:27
Frontier-size:8, currentPath-cost:28
Frontier-size:7, currentPath-cost:29
Frontier-size:6, currentPath-cost:26
Frontier-size:5, currentPath-cost:25
Frontier-size:4, currentPath-cost:24
Frontier-size:3, currentPath-cost:23
Frontier-size:2, currentPath-cost:19
Frontier-size:1, currentPath-cost:18
11896 solutions found, 735779 paths added.
Enter 'q' to terminate SearchDemo
§>
§>
### <----- :output end ----->
##5.2.6
Using the portal distance:
### <----- output: ----->
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:7, currentPath-cost:2
Frontier-size:9, currentPath-cost:3
Frontier-size:9, currentPath-cost:3
Frontier-size:10, currentPath-cost:4
Frontier-size:12, currentPath-cost:5
Frontier-size:11, currentPath-cost:3
Frontier-size:12, currentPath-cost:4
Frontier-size:12, currentPath-cost:2
Frontier-size:13, currentPath-cost:4
Frontier-size:14, currentPath-cost:3
Frontier-size:16, currentPath-cost:5
Frontier-size:15, currentPath-cost:4
Frontier-size:15, currentPath-cost:2
Frontier-size:16, currentPath-cost:5
Frontier-size:17, currentPath-cost:3
Frontier-size:18, currentPath-cost:3
Frontier-size:17, currentPath-cost:3
Frontier-size:17, currentPath-cost:4
Frontier-size:17, currentPath-cost:4
Frontier-size:16, currentPath-cost:6
Frontier-size:15, currentPath-cost:5
Frontier-size:18, currentPath-cost:6
Frontier-size:18, currentPath-cost:6
Frontier-size:18, currentPath-cost:6
Frontier-size:19, currentPath-cost:7
Frontier-size:18, currentPath-cost:7
Frontier-size:18, currentPath-cost:7
xxxxxxxxxxxxxxxxxxxx
x                  x
x       xxx        x
x 1     x xxxxx    x
x ||$     x        x
x       x x  xxxxxxx
x  xx xxxxx     O  x
x     Ox      §||  x
x     2x g         x
xxxxxxxxxxxxxxxxxxxx
Frontier-size:17, currentPath-cost:8
1 solutions found, 46 paths added.
Enter 'q' to terminate search
§>
### <----- :output end ----->
using the normal manhatten distance:
### <----- output: ----->
Frontier-size:1, currentPath-cost:0
Frontier-size:4, currentPath-cost:1
Frontier-size:6, currentPath-cost:2
Frontier-size:6, currentPath-cost:2
Frontier-size:8, currentPath-cost:3
Frontier-size:8, currentPath-cost:3
Frontier-size:10, currentPath-cost:4
Frontier-size:10, currentPath-cost:4
Frontier-size:10, currentPath-cost:5
Frontier-size:9, currentPath-cost:5
Frontier-size:11, currentPath-cost:5
Frontier-size:12, currentPath-cost:6
Frontier-size:13, currentPath-cost:6
Frontier-size:12, currentPath-cost:7
Frontier-size:11, currentPath-cost:4
Frontier-size:13, currentPath-cost:7
Frontier-size:15, currentPath-cost:8
Frontier-size:16, currentPath-cost:8
Frontier-size:17, currentPath-cost:9
Frontier-size:17, currentPath-cost:9
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
Frontier-size:16, currentPath-cost:10
1 solutions found, 35 paths added.
Enter 'q' to terminate search
§>
### <----- :output end ----->