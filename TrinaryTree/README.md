This program implements insert, delete operations in a tri-nary tree.

What is a Tri-nary tree ?
-------------------------
Tri-nary tree is very much like a binary-tree , but unlike binary tree,each parent has 3 child nodes instead of two namely left, middle and right children.

Rules:
------
left node values < parent, 
right node values > parent,
Middle node value == parent.

Example :
-------------
If I were to add nodes to a tri-nary tree in following order :
5, 4, 9, 5, 7, 2, 2 
Then the tree would look as below:

          5
         /|\
        4 5 9
       /    /
      2    7
      |
      2

Trivia :
--------
An unary tree is nothing but a list, where each node has only one child.
