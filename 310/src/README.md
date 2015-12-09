思想：
=====
寻找树中的最长路径，最长路径的中点（一个或者两个）即为所求<br>

步骤：
======
1. 任意寻找一个点为根节点，bfs计算其他节点与该根节点的距离，距离最长的节点u一定是树中最长路径的某个端点<br>
2. 以节点u为根节点，bfs计算其他节点与该根节点的距离，距离最长的节点v一定是树中最长路径的另外一个端点<br>
3. 根据v的bfs前驱，依次遍历，得到树中最长路径，取其中点<br>

备注：
====
计算树中最长路径的长度：<br>
[这里](http://hihocoder.com/problemset/problem/1050) 和 
[这里](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
