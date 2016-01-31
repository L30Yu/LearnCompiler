# CPSC 411 Winter 2016
# Assignment 1
# Delei Yu
# 10061950
# dyu@ucalgary.ca
#
# validatecomms.py
# validate the recursive multi-line comments /*  */
#

import sys
import re

def evaluatePairs(str):
  stack = []
  pushStr, popStr = "/*", "*/"
  for c in str.split() :
    if c == pushStr :
      stack.append(c)
    elif c == popStr :
      if not len(stack) :
        return False
      else :
        stackTop = stack.pop()

        if stackTop != pushStr :
          return False
    else :
      return False
  return not len(stack)



def evaluate(lexer, leftdata):

        # deal the single line comment % which inside of the multi-line comments

        # replace all /* or */
        def repl(m):
            strtmp = str(m.group())
            if "/*" in strtmp:
                strtmp = strtmp.replace("/*","/#")

            if "*/" in strtmp:
                strtmp = strtmp.replace("*/","#/")
            return strtmp

        # match any % until the \n, then replace with above repl function
        leftdata = re.sub(r"\%.*?\n", repl, leftdata)

        # find all left multi-comments mark and return the positions
        lcomms = [lcomm.start() for lcomm in re.finditer('/\*', leftdata)]
        # find all right multi-comments mark and return the positions
        rcomms = [rcomm.start() for rcomm in re.finditer('\*/', leftdata)]

        # use tmp store all the /* or */ find in the data
        tmp = "/* "
        # count the multi-lines comment mark
        lexer.comm_count += 1
        # store the position of the multi-line comment starting position
        nextPos = []

        # combine left marks and right marks
        ll, rr = 0, 0
        while(ll<len(lcomms) and rr<len(rcomms)):
            if lcomms[ll] < rcomms[rr]:
                tmp += "/* "
                lexer.comm_count += 1
                ll += 1

            else:
                tmp += "*/ "
                lexer.comm_count -= 1
                # if count back to 0, means one completed recursive multi-line comments occure
                if(lexer.comm_count == 0):
                    nextPos.append(lexer.lexpos + 2 + rcomms[rr])
                rr += 1

        # if still has left mark
        while(ll < len(lcomms)):
            tmp += "/* "
            lexer.comm_count += 1

            ll += 1
        # if still has right mark
        while(rr < len(rcomms)):
            tmp += "*/ "
            lexer.comm_count -= 1
            # if count back to 0, means one completed recursive multi-line comments occure
            if(lexer.comm_count == 0):
                nextPos.append(lexer.lexpos + 2 + rcomms[rr])

            rr += 1

        return (tmp,nextPos)
