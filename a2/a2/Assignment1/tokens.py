# CPSC 411 Winter 2016
# Assignment 1
# Delei Yu
# 10061950
# dyu@ucalgary.ca
#
# tokens.py
# use lex to define tokens
#

import sys
sys.path.insert(0,"../..")
import re
import lex as lex


# my own multi-line comments validation
import validatecomms

# check input arguments and read txt file
# if(len(sys.argv) != 2):
#     print "Please input a testing file path"
#     sys.exit(0)
# file = open(sys.argv[1], "r+")
# data = file.read()
data = ""

# Reserved words
reserved = (
    'IF', 'THEN', 'WHILE', 'DO', 'INPUT', 'ELSE', 'BEGIN','END','WRITE',
    )
# Tokens
tokens = reserved + (
    'ID', 'NUM','ADD','ASSIGN','SUB','MUL','DIV','LPAR','RPAR','SEMICOLON',
    )

# Completely ignored characters
t_ignore           = ' \t\x0c'

# Newlines
def t_NEWLINE(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")

# Operators
t_ADD              = r'\+'
t_SUB              = r'-'
t_MUL              = r'\*'
t_DIV              = r'/'
t_ASSIGN           = r':='
t_LPAR             = r'\('
t_RPAR             = r'\)'
t_SEMICOLON        = r';'

# Identifiers and reserved words
reserved_map = { }
for r in reserved:
    reserved_map[r.lower()] = r

def t_ID(t):
    r'[A-Za-z_][\w_]*'
    t.type = reserved_map.get(t.value,"ID")
    return t

# Integer literal
t_NUM = r'\d+(\d*)?'
# r'\d+(\.\d*)?'), # Integer or decimal number

#  (recursive) multi-line comments left
def t_commentsl(t):
    r'/\*'

    # check if already have all the start position of multi-line comments
    if len(lexer.comm_beyondpos) == 0:

        # split and return the data after the first /*
        leftdata = data.split('/*', 1 )[1]

        # validate the comments marks
        evaluateResult = validatecomms.evaluate(lexer, leftdata)
        # all the comments ending position after evaluate
        lexer.comm_beyondpos = evaluateResult[1]

        # evaluate the pairs of the comment marks
        if not validatecomms.evaluatePairs(evaluateResult[0]):
            print("Illegal multi-line comments")
            sys.exit(0)
        else:
            tmppos = lexer.lexpos
            # set the lexer position to the end of the comments
            lexer.lexpos = lexer.comm_beyondpos[0]
            # calculate the lines inside of this part of comments
            lexer.lineno += data[tmppos : lexer.lexpos].count('\n')
            # delete this used ending position
            del lexer.comm_beyondpos[0]
    else:
        # if already have the comments ending positions, just jump to the end position
        tmppos = lexer.lexpos
        lexer.lexpos = lexer.comm_beyondpos[0]
        lexer.lineno += data[tmppos : lexer.lexpos].count('\n')
        del lexer.comm_beyondpos[0]


# multi-line comments right
def t_commentsr(t):
    r'\*/'

    t.lexer.comm_count -= 1
    # if right of multi-line comments occure first
    if(t.lexer.comm_count < 0):
        print("Illegal multi-line comments")
        sys.exit(0)

# one-line comments % and end with \n
def t_comment(t):
    r'\%(.)*?\n'
    t.lexer.lineno += 1


# only one-line comment mark  % no end of \n
def t_commentonly(t):
    r'\%(.)*?'

def t_error(t):
    print("Illegal character %s" % repr(t.value[0]), t.lexer.lineno)
    sys.exit(0)
    t.lexer.skip(1)

lexer = lex.lex()
# add comments counter in the lexer
lexer.comm_count = 0
# add comments ending position list in the lexer
lexer.comm_beyondpos = []


# Give the lexer input
# lexer.input(data)

# Tokenize
# while True:
#     tok = lexer.token()
#     if not tok:
#         break      # No more input
#     print("TOKEN", tok.type, tok.value, (tok.lineno), (tok.lexpos))
#
#

