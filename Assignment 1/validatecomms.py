def Evaluate(str):
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
