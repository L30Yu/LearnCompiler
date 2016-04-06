CPSC 411 Winter 2016 Assignment 2


Software & System: Python 2.7.10; PLY (Python Lex) Version 3.8; Windows 10 64-bit; Mac OS X EI Capitan 10.11.3

My Assignment 2 files

Assignment1/	  Generate tokens, from assignment 1

parser.py	      Recursive Descent Parser, take tokens with 1 lookahead to create Abstract Syntax Tree

treenode.py	    Node of the Tree, with code generate and pretty printing functions

TestFiles/	    all my 5 test files and output files, test2.txt will raise syntax error as intended. 

grammar.txt    my translated grammar

==============================================

How to run it:

In command line, enter "make" or ”python parser.py TestFiles/test1.txt”

the Tree and Machine Code will be printed in command, and also output into output_Tree.txt and output_Code.txt

==============================================

Attention:

Tried to test my machine code, but failed, because no much idea how to do that, even you provided an example.

Pretty printing the tree is not easy, the solution in my assignment will make the output has a very long width, so, Close Word Warp and scroll from left to right of the output text would be needed.

Tried to use a list as the child of the Tree Node, but that will super hard to have a solution to pretty print. Now, only using a binary tree to implement the AST. Therefore, my Tree will looks like this: start with BEGIN, then statement in left child, a SEMICOLON in right side to link the next statement.

                   BEGIN,begin                                               
           /                         \                                
     INPUT,input                SEMICOLON,;                           
   /                   /                            \             
 ID,x              ASSIGN,:=                    SEMICOLON,;       
                 /           \                 /            \      
               ID,z        ADD,+         WRITE,write   SEMICOLON,; 
                        /          \         /                           
                      ID,x       MUL,*     ID,z                          
                               /       \                                   
                             NUM,1   NUM,2       

sPUSH - I did not generate this machine code as I have no idea whats that.

Raise Error, will also print Python trace back information.






