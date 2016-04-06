CPSC 411 Winter 2016
Assignment 1


Software & System:
Python 2.7.10
PLY (Python Lex) Version 3.8
Windows 10 64-bit
Mac OS X EI Capitan 10.11.3

My Assignment 1 file structure
.
├── Readme.txt
├── Test
│   ├── Test1.txt
│   ├── Test2.txt
│   ├── Test3.txt
│   ├── Test4.txt
│   └── Test5.txt
├── makefile
├── ply
│   └── lex.py
├── tokens.py
└── validatecomms.py

-tokens.py
 use lex to define tokens

-validatecomms.py
 my own function to validate the recursive 
 multi-line comments /*  */

-ply/lex.py
PLY (Python Lex) Version 3.8 by
David M. Beazley (Dabeaz LLC)

==============================================

How to run it:

In command line, enter "make",
tokens.py will run 5 times for each test file

Or, use "python tokens.py [Test File Path]"
[Test File Path] is your testing text file path,
In my case, just Test/Test1.txt

Output:
the output will be specify the TOKEN with value, line number, position

if the program face any Illegal character or Illegal multi line comments, it will stop




