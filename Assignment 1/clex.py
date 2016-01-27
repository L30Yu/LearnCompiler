# ----------------------------------------------------------------------
# clex.py
#
# A lexer for ANSI C.
# ----------------------------------------------------------------------

import sys
sys.path.insert(0,"../..")

import ply.lex as lex



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

comm_count = 0

#  (recursive) multi-line comments
def t_commentsa(t):
    r'/\*'
    comm_count += 1
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
    t.lexer.skip(1)

lexer = lex.lex()


# Test it out
data = '''
3 + %4 * 10
  %+ -20 *2 :=
3 + 4 * 10
  + -20 *2 :=
  if else ifso then30; kk
   /*
     Author:
     Basic /* multi-line comments  with % single line comments should work!
     comments


'''

# Give the lexer some input
lexer.input(data)

# Tokenize
while True:
    tok = lexer.token()
    if not tok:
        break      # No more input
    print(tok)
	#print(tok.type, tok.value, tok.lineno, tok.lexpos)

#if __name__ == "__main__":
#    lex.runmain(lexer)

    



