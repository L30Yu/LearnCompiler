# ----------------------------------------------------------------------
# clex.py
#
# A lexer for ANSI C.
# ----------------------------------------------------------------------

import sys
sys.path.insert(0,"../..")

import ply.lex as lex
import re
import validatecomms


#print validatecomms.Evaluate("/* /* */ /* */ /* */")

# Test it out
data = '''
3 + %4 * 10
  %+ -20 *2 :=
3 + 4 * 10
  + -20 *2 :=
  if else ifso then30; kk
   /*
     Author:
     Basic /* multi-l  with % single */line comments should work!
     comments */

    int i = 900;if 0; if1; if 2
    /* /* uuuu*/ kkk*/

    /* /* */i */love 444/* */ kkk


'''


# Reserved words
reserved = (
    'IF', 'THEN', 'WHILE', 'DO', 'INPUT', 'ELSE', 'BEGIN','END','WRITE',
    )

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
t_NUM = r'\d+([uU]|[lL]|[uU][lL]|[lL][uU])?'
# r'\d+(\.\d*)?'), # Integer or decimal number



#  (recursive) multi-line comments left
def t_commentsl(t):
    r'/\*'
    if len(lexer.comm_beyondpos) == 0:
        #print lexer.lexpos
        leftdata = data.split('/*', 1 )[1]

        lcomms = [lcomm.start() for lcomm in re.finditer('/\*', leftdata)]
        #print lcomms
        rcomms = [rcomm.start() for rcomm in re.finditer('\*/', leftdata)]
        #print rcomms
        tmp = "/* "
        lexer.comm_count += 1
        nextPos = []

        ll, rr = 0, 0
        while(ll<len(lcomms) and rr<len(rcomms)):
            if lcomms[ll] < rcomms[rr]:
                tmp += "/* "
                lexer.comm_count += 1

                ll += 1
            else:
                tmp += "*/ "
                lexer.comm_count -= 1

                if(lexer.comm_count == 0):
                    nextPos.append(lexer.lexpos + 2 + rcomms[rr])

                rr += 1

        while(ll < len(lcomms)):
            tmp += "/* "
            lexer.comm_count += 1

            ll += 1

        while(rr < len(rcomms)):
            tmp += "*/ "
            lexer.comm_count -= 1

            if(lexer.comm_count == 0):
                nextPos.append(lexer.lexpos + 2 + rcomms[rr])

            rr += 1

        #print nextPos
        lexer.comm_beyondpos = nextPos

        if not validatecomms.Evaluate(tmp):
            print("Illegal multi-line comments")
            sys.exit(0)
        else:
            lexer.lexpos = lexer.comm_beyondpos[0]
            del lexer.comm_beyondpos[0]
    else:
        lexer.lexpos = lexer.comm_beyondpos[0]
        del lexer.comm_beyondpos[0]


# multi-line comments right
def t_commentsr(t):
    r'\*/'

    t.lexer.comm_count -= 1
    if(t.lexer.comm_count < 0):
        print("Illegal multi-line comments")
        sys.exit(0)

#
# #  (recursive) multi-line comments
# def t_comments(t):
#     r'/\*(.|\n)*?\*/'
#     if(t.value.find('/*') > 1):
#         print "Error Multiple Comments used"
#
#     print("CCCC")
# #    t.lexer.lineno += t.value.count('\n')
#
# #  (recursive) multi-line comments
# def t_commentsb(t):
#     r'/\*(.|\n)*?/\*'
#     if(t.value.find('*/') == -1):
#         print "Error Multiple Comments used"
#
#     print("CCCC")
# #    t.lexer.lineno += t.value.count('\n')



#one-line comments:      %
def t_comment(t):
    r'\%(.)*?\n'
    t.lexer.lineno += 1
    
def t_error(t):
    print("Illegal character %s" % repr(t.value[0]))
    sys.exit(0)
    t.lexer.skip(1)

lexer = lex.lex()
lexer.comm_count = 0
lexer.comm_beyondpos = []

# Give the lexer some input
lexer.input(data)

# Tokenize
while True:
    tok = lexer.token()
    if not tok:
        break      # No more input
    print(tok)




