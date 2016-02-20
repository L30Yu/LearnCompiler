import Assignment1.tokens as tokens
import sys
from treenode import Node
# tok = tokens.lexer.token()

# Parser
class ExpressionEvaluator:
    '''
    Implementation of a recursive descent parser. Each method
    implements a single grammar rule. Use the ._accept() method
    to test and accept the current lookahead token. Use the ._expect()
    method to exactly match and discard the next token on on the input
    (or raise a SyntaxError 'Line: '+if it doesn't match ).
    '''

    def parse(self, text):
        tokens.data = text
        tokens.lexer.input(tokens.data)
        global ast

        self.tokens = tokens.lexer
        self.tok = None  # Last symbol consumed
        self.nexttok = None  # Next symbol tokenized
        self._advance()  # Load first lookahead token
        self.vardic = {}

        ast = self.stmt()

        result = str(ast)
        print result
        ast.posorder()
        #print ast.posorder() #this print the tree in post order in a list

    def _advance(self):
        'Advance one token ahead'
        self.tok, self.nexttok = self.nexttok, next(self.tokens, None)

    def _accept(self, toktype):
        'Test and consume the next token if it matches toktype'
        if self.nexttok and self.nexttok.type == toktype:
            self._advance()
            return True
        else:
            return False

    def _expect(self, toktype):
        'Consume next token if it matches toktype or raise SyntaxError'
        if not self._accept(toktype):
            raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + toktype)

    def stmt(self):
        if self._accept('IF'):
            ifstmt = self.tok
            opNode = Node(self.tok)
            opNode.left = self.expr()

            # in order to keep use Binary Tree
            ifstmt.type = 'IFSTMT'
            ifstmt.value = 'IFSTMT'
            opNode.right = Node(ifstmt)
            if not self._accept('THEN'):
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'THEN')
            opNode.right.left = Node(self.tok)
            opNode.right.left.left = self.stmt()
            if not self._accept('ELSE'):
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'ELSE')
            opNode.right.right = Node(self.tok)
            opNode.right.right.left = self.stmt()
            return opNode

        elif self._accept('WHILE'):
            opNode = Node(self.tok)
            opNode.left = self.expr()
            if not self._accept('DO'):
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'DO')
            opNode.right = Node(self.tok)
            opNode.right.left = self.stmt()
            return opNode

        elif self._accept('INPUT'):
            opNode = Node(self.tok)
            if not self._accept('ID'):
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'ID')
            opNode.left = Node(self.tok)
            return opNode

        elif self._accept('ID'):
            idNode = Node(self.tok)
            if not self._accept('ASSIGN'):
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'ASSIGN')

            opNode = Node(self.tok)
            opNode.left = idNode
            opNode.right = self.expr()
            return opNode
        
        elif self._accept('WRITE'):
            opNode = Node(self.tok)
            opNode.left = self.expr()
            return opNode

        elif self._accept('BEGIN'):
            opNode = Node(self.tok)
            tmp = opNode
            tmp.left = self.stmt()
            while tmp.left:

                if not self._accept('SEMICOLON'):
                    raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'SEMICOLON')
                tmp.right = Node(self.tok)
                tmp = tmp.right
                tmp.left = self.stmt()

            if not self._accept('END'):
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected ' + 'END')
            return opNode

        else:
            # raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected IF/WHILE/INPUT/ID/WRITE/BEGIN')
            return None



    def expr(self):
        left = self.term()

        while self._accept('ADD') or self._accept('SUB'):
            opNode = Node(self.tok)
            opNode.left = left
            left = opNode
            opNode.right = self.term()
        return left


    def term(self):
        left = self.factor()
        while self._accept('MUL') or self._accept('DIV'):
            opNode = Node(self.tok)
            opNode.left=left
            left = opNode
            opNode.right=self.factor()
        return left


    def factor(self):
        "factor ::= NUM | ( expr )"
        f = None
        if self._accept('NUM'):
            f = Node(self.tok)
        elif self._accept('LPAR'):
            f = self.expr()
            self._expect('RPAR')

        elif self._accept('SUB'):
            f = Node(self.tok)
            if self._accept('NUM'):
                f.left = Node(self.tok)
            else:
                raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected NUM after SUB')

        elif self._accept('ID'):
            f = Node(self.tok)
            # if not self.vardic.has_key(self.tok.value):
            #     raise SyntaxError('Line: '+'Variable need assi gn value first : '+self.tok.value)
        else:
            raise SyntaxError('Line: ' + str(self.tok.lineno) + ' Expected NUMBER or LPAREN')
        return f



def descent_parser():
    e = ExpressionEvaluator()
    file = open('test.txt', "r+")
    data = file.read()
    print(str(e.parse(data)))

if __name__ == '__main__':
    descent_parser()