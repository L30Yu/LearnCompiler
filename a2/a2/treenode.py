class Node:

    def __init__(self, entry=None, left=None, right=None):
        if not entry:
            value = None
        else:
            value = ' ' + entry.type + ',' +entry.value+' '
        self.entry = value
        self.token = entry
        self.left = left
        self.right = right

    def __repr__(self): # used by the interpreter
        args = repr(self.entry)
        if self.left or self.right:
            args += ', {0}, {1}'.format(repr(self.left), repr(self.right))
        return 'Node({0})'.format(args)

    def __str__(self): # used by print() and str()
        return tree_string(self)

    def posorder(self):
        print
        return postorder(self)


jumpCount = 1
#post order traverse the tree to generate code
def postorder(tree):
    global jumpCount

    type1 = ['ADD','SUB','MUL','DIV']
    jumpStack = []

    def recurse(node):
        global  jumpCount
        if not node:
            return

        # prepare IF or WHILE statement
        tmp = None

        # prepare for condition loop
        if node.token.type == 'IFSTMT' and node.entry == ' IF,if ':
            tmp = node
        elif node.token.type == 'IFSTMT' and node.entry == ' IFSTMT,IFSTMT ':
            tmp = node
        elif node.token.type == 'WHILE':
            tmp = node
            newJump = 'L'+str(jumpCount)
            jumpCount += 1
            jumpStack.append(newJump)
            print '\n'+newJump+':'

        recurse(node.left)

        if tmp!=None and tmp.right == node.right and node.entry in [' IF,if ',' WHILE,while ']:
            if tmp.left.token.type == 'ID':
                if tmp.left.left == None and tmp.left.right == None:
                    print '\trPUSH '+tmp.left.token.value
            newJump = 'L'+str(jumpCount)
            jumpCount += 1
            jumpStack.append(newJump)
            print '\tcJUMP '+newJump

        # before right node, prepare for THEN ELSE DO
        if tmp!= None and tmp ==node and node.token.type == 'IFSTMT' and node.entry == ' IFSTMT,IFSTMT ' and node.left.token.type == 'THEN':
            lastJump = jumpStack.pop()
            newJump = 'L'+str(jumpCount)
            jumpCount += 1
            jumpStack.append(newJump)
            print '\tJUMP '+newJump
            print '\n'+lastJump+':'
        # elif tmp!= None and tmp.right == node and node.token.type == 'DO':
        #     lastJump2Back = jumpStack.pop()
        #     lastJump = jumpStack.pop()
        #     print '\tJUMP '+lastJump
        #     jumpStack.append(lastJump2Back)



        recurse(node.right)

        if tmp!= None and tmp ==node and node.token.type == 'IFSTMT' and node.entry == ' IFSTMT,IFSTMT ' and node.right.token.type == 'ELSE':
            lastJump = jumpStack.pop()
            # newJump = 'L'+str(jumpCount)
            # jumpCount += 1
            # jumpStack.append(newJump)
            # print '\tJUMP '+newJump
            print '\n'+lastJump+':'
        elif tmp!= None and tmp ==node and node.token.type == 'WHILE':
            lastJump2Back = jumpStack.pop()
            lastJump = jumpStack.pop()
            print '\tJUMP '+lastJump
            # jumpStack.append(lastJump2Back)
            print '\n'+lastJump2Back+':'

        if node.token.type in type1:

            if node.left and node.left.token:
                if node.left.token.type == 'NUM':
                    print '\tcPUSH '+node.left.token.value
                elif node.left.token.type == 'ID':
                    print '\trPUSH '+node.left.token.value

            if node.right and node.right.token:
                if node.right.token.type == 'NUM':
                    print '\tcPUSH '+node.right.token.value
                elif node.right.token.type == 'ID':
                    print '\trPUSH '+node.right.token.value

            if node.left and node.right:
                print '\tOP2 '+node.token.value
            elif node.left or node.right:
                print '\tOP1 '+node.token.value

        elif node.token.type == 'ASSIGN':
            if node.right and node.right.token:
                if node.right.token.type == 'NUM':
                    print '\tcPUSH '+node.right.token.value
                elif node.right.token.type == 'ID':
                    print '\trPUSH '+node.right.token.value
            if node.left and node.left.token:
                if node.left.token.type == 'ID':
                    print '\tLOAD '+node.left.token.value

        elif node.token.type == 'WRITE':
            if node.left and node.left.token:
                if node.left.token.type == 'ID':
                    print '\trPUSH '+node.left.token.value
            print '\tPRINT'

        elif node.token.type == 'INPUT':
            if node.left and node.left.token:
                if node.left.token.type == 'ID':
                    print '\tREAD '+node.left.token.value

        # elif node.token.type == 'IF':


    recurse(tree)
    print
    # print jumpStack
    return

def tree_string(tree):
    return "\n".join(tree_block(tree)[0])

def tree_block(tree):
    """Returns a list of strings, each string being
    one line in a rectangle of text representing the
    tree.
    Also returns the index in the string which is
    centered above the tree's root.

    num_width: The width of the widest number in the tree (100 => 3)
    """
    #If no children, just return string
    if tree.left is None and tree.right is None:
        return [str(tree.entry)], len(str(tree.entry))//2
    num_width = len(str(tree.entry)) #Width of this tree's entry
    #If only right child:
    if tree.left is None:
        r_block, r_cent = tree_block(tree.right)
        #Add left padding if necessary
        if r_cent < num_width*3/2:
            padding = ' '*((num_width*3)//2-r_cent)
            r_cent += ((num_width*3)//2-r_cent) #Record new center
            for line_index in range(len(r_block)):
                r_block[line_index] = padding+r_block[line_index]

        #Generate top two lines
        t_line = str(tree.entry)
        t_line += ' '*(r_cent-len(t_line))
        t_line += ' '*(len(r_block[0])-len(t_line))
        m_line = ' '*r_cent + '\\'
        m_line += ' '*(len(r_block[0])-len(m_line))

        return [t_line, m_line]+r_block, num_width//2
    #If only left child:
    if tree.right is None:
        l_block, l_cent = tree_block(tree.left)
        #Add right padding if necessary
        if len(l_block[0]) < l_cent+1+num_width:
            padding = ' '*(l_cent+1+num_width-len(l_block[0]))
            for line_index in range(len(l_block)):
                l_block[line_index] = l_block[line_index]+padding
        #Generate lines
        t_line = ' '*(l_cent+1)
        t_line += ' '*(len(l_block[0])-l_cent-1-num_width)
        t_line += str(tree.entry)
        m_line = ' '*l_cent+'/'
        m_line += ' '*(len(l_block[0]) - len(m_line))
        return [t_line, m_line]+l_block, len(t_line)-num_width//2
    #Otherwise, has both
    l_block, l_cent = tree_block(tree.left)
    r_block, r_cent = tree_block(tree.right)

    #Pad left block
    spacing = r_cent+len(l_block)-l_cent-2
    padding = ' '*max(1, (spacing-num_width))
    for line_index in range(len(l_block)):
        l_block[line_index] = l_block[line_index]+padding

    #Add left and right blocks
    new_block = []
    for line_index in range(max(len(l_block), len(r_block))):
        new_line = l_block[line_index] if line_index < len(l_block) else ' '*len(l_block[0])
        new_line += r_block[line_index] if line_index < len(r_block) else ' '*len(r_block[0])
        new_block.append(new_line)
    r_cent += len(l_block[0])

    #Generate top lines
    my_cent = (l_cent+r_cent)//2
    t_line = ' '*(l_cent+1)
    t_line += ' '*(my_cent-num_width//2-len(t_line))
    t_line += str(tree.entry)
    t_line += ' '*(r_cent-len(t_line))
    t_line += ' '*(len(new_block[0])-len(t_line))

    m_line = ' '*l_cent + '/'
    m_line += ' '*(r_cent-len(m_line)) + '\\'
    m_line += ' '*(len(new_block[0])-len(m_line))

    return [t_line, m_line]+new_block, my_cent