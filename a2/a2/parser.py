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
    (or raise a SyntaxError if it doesn't match).
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

        ast = self.expr()
        print(ast)

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
            raise SyntaxError('Expected ' + toktype)

    def stmt(self):
        if self._accept('IF'):
            exprval = self.expr()
            self._expect('THEN')
            if exprval:
                stmtval = self.stmt()
            else:
                if(self._accept('ELSE')):
                    stmtval = self.stmt()
            return True
        elif self._accept('WHILE'):
            exprval = self.expr()
            self._expect('DO')
            stmtval = self.stmt()
            return True
        elif self._accept('INPUT'):
            self._expect('ID')
            print "Please input an Integer for "+ self.tok.value +" :"
            n = int(raw_input())
            self.vardic[self.tok.value] = n
            return True
        elif self._accept('ID'):
            idNode = Node(self.tok)
            if self._accept('ASSIGN'):
                opNode = Node(self.tok)
                opNode.left = idNode
                opNode.right = self.expr(opNode)
            return opNode
        
        elif self._accept('WRITE'):
            exprval = self.expr()
            print exprval
            return True
        elif self._accept('BEGIN'):
            while self.stmt():
                self._expect('SEMICOLON')
            self._expect('END')
            return True
        else:
            # raise SyntaxError('Expected IF/WHILE/INPUT/ID/WRITE/BEGIN')
            return False

# Grammar rules follow
    def expr(self):
        left = self.term()

        while self._accept('ADD') or self._accept('SUB'):
            opNode = Node(self.tok)
            opNode.left = left
            print "exp: left = "+left.token.value;
            left = opNode
            print "then exp: left = "+left.token.value;
            opNode.right = self.term()
        return left


    def term(self):
        left = self.factor()
        while self._accept('MUL') or self._accept('DIV'):
            opNode = Node(self.tok)
            opNode.left=left
            print "term: left = "+left.token.value;
            left = opNode
            print "then term: left = "+left.token.value;
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
                raise SyntaxError('Expected NUM after SUB')

        elif self._accept('ID'):
            f = Node(self.tok)
            if not self.vardic.has_key(self.tok.value):
                raise SyntaxError('Variable need assign value first : '+self.tok.value)
        else:
            raise SyntaxError('Expected NUMBER or LPAREN')
        return f



def descent_parser():
    e = ExpressionEvaluator()
    file = open('test.txt', "r+")
    data = file.read()
    print("Finished Result: " + str(e.parse(data)))

if __name__ == '__main__':
    descent_parser()