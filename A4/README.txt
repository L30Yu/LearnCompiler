Assignemt 4
Delei Yu, 10061950

Need install jflex

Compile and Run:
1. change directory to A4
2. run "make" 
3. run ./run_parser.sh tests/test1.txt
(make .sh file executable with chmod a+x run_parser.sh)

-----------------------------------------------------------------------------

Sample:

[dyu@localhost A4]$ make
javac -cp java_cup-runtime.jar *java 
[dyu@localhost A4]$ ./run_parser.sh tests/test1.txt
Parsing [tests/test1.txt]
                                                                                                                                                                               
AST:                                                                                                                                                                            
M_prog (                                                                                                                                                                        
        M_block[M_var("x", [], M_int)M_var("y", [], M_int)M_var("a", [], M_bool)                                                                                                
                M_fun("f", ["a"M_int"b"M_int],M_bool,[]                                                                                                                         
                        ,[M_app (M_gt,M_app (M_id ("a",),M_app (M_id ("b",))])                                                                                                  
                M_fun("exp", ["e"M_int"k"M_int],M_bool,[]                                                                                                                       
                        ,[M_app (M_gt,M_app (M_id ("e",),M_app (M_id ("k",))])]                                                                                                 
        ,[M_read ("x")M_read ("y")M_ass ("a",M_app (M_id ("f",M_app (M_id ("y",)M_app (M_id ("x",)))M_app (M_id ("a",)])                                                        
                                                                                                                                                                                
Checking Semantics ...                                                                                                                                                          
Intermediate Representation:   
IPROG (                                                                                                                                                                         
[IFUN                                                                                                                                                                           
        ("FUN1"                                                                                                                                                                 
        ,[]                                                                                                                                                                     
        ,0                                                                                                                                                                      
        ,2                                                                                                                                                                      
        ,[]                                                                                                                                                                     
        ,                                                                                                                                                                       
        ,IRETURN( IAPP(IGT,[ IID(0,-4,[])],[ IID(0,-5,[])]))                                                                                                                    
        )                                                                                                                                                                       
IFUN                                                                                                                                                                            
        ("FUN2"                                                                                                                                                                 
        ,[]                                                                                                                                                                     
        ,0                                                                                                                                                                      
        ,2                                                                                                                                                                      
        ,[]                                                                                                                                                                     
        ,                                                                                                                                                                       
        ,IRETURN( IAPP(IGT,[ IID(0,-4,[])],[ IID(0,-5,[])]))                                                                                                                    
        )                                                                                                                                                                       
]                                                                                                                                                                               
,3                                                                                                                                                                              
,[]                                                                                                                                                                             
,IREAD_I(0,1, [])                                                                                                                                                               
,IREAD_I(0,2, [])                                                                                                                                                               
,IASS(0,3,[], IAPP(ICALL ("FUN1",0), IID(0,2,[]) IID(0,1,[])))                                                                                                                  
,IPRINT_B( IID(0,3,[]))                                                                                                                                                         
,)                                                                                                                                                                              
                                                                                                                                                                                
Semantics are good          
[dyu@localhost A4]$
[dyu@localhost A4]$ ./run_parser.sh tests/test2.txt
Parsing [tests/test2.txt]

AST: 
M_prog (
	M_block[M_var("x", [], M_int)M_var("y", [], M_int)M_var("a", [], M_bool)
		M_fun("f", ["a"M_int"b"M_int],M_bool,[]
			,[M_app (M_gt,M_app (M_id ("a",),M_app (M_id ("b",))])]
	,[M_read ("x")M_read ("y")M_ass ("a",M_app (M_id ("f",M_app (M_id ("y",)M_app (M_id ("x",)))M_app (M_id ("a",)])

Checking Semantics ...
Intermediate Representation: 
IPROG (
[IFUN 
	("FUN1"
	,[]
	,0
	,2
	,[]
	,
	,IRETURN( IAPP(IGT,[ IID(0,-4,[])],[ IID(0,-5,[])]))
	)
]
,3
,[]
,IREAD_I(0,1, [])
,IREAD_I(0,2, [])
,IASS(0,3,[], IAPP(ICALL ("FUN1",0), IID(0,2,[]) IID(0,1,[])))
,IPRINT_B( IID(0,3,[]))
,)

Semantics are good

[dyu@localhost A4]$ ./run_parser.sh tests/test3.txt
Parsing [tests/test3.txt]

AST: 
M_prog (
	M_block[M_var("x", [], M_bool)
		M_fun("f", ["a"M_bool"b"M_bool],M_bool,[]
			,[true])]
	,[M_ass ("x",M_app (M_id ("f",M_app (M_id ("x",)M_app (M_id ("x",)))M_app (M_id ("x",)])

Checking Semantics ...
Intermediate Representation: 
IPROG (
[IFUN 
	("FUN1"
	,[]
	,0
	,2
	,[]
	,
	,IRETURN(IBOOL true)
	)
]
,1
,[]
,IASS(0,1,[], IAPP(ICALL ("FUN1",0), IID(0,1,[]) IID(0,1,[])))
,IPRINT_B( IID(0,1,[]))
,)

Semantics are good
[dyu@localhost A4]$
[dyu@localhost A4]$ ./run_parser.sh tests/test4.txt
Parsing [tests/test4.txt]

AST: 
M_prog (
	M_block[M_var("x", [], M_int)M_var("y", [], M_int)
		M_fun("f", ["a"M_int"b"M_int],M_int,[]
			,[M_app (M_neg 1)])]
	,[M_ass ("f",M_app (M_id ("f",M_app (M_id ("y",)M_app (M_id ("x",)))M_app (M_id ("x",)])

Checking Semantics ...
SymbolException: Symbol Error: "f" is not var
	at SymbolChecker.check_M_stmt(SymbolChecker.java:432)
	at SymbolChecker.check_M_stmt(SymbolChecker.java:418)
	at SymbolChecker.check_M_stmt(SymbolChecker.java:413)
	at SymbolChecker.checkSyntax(SymbolChecker.java:65)
	at parser.main(parser.java:388)
Semantics are not good

