import java.util.ArrayList;

public class SymbolChecker {
	

	Node start;
	boolean debug = false;
	String str;
	String tmpS;
	boolean pushToTmpS = false;;
	
	public static int blockCounter;
	
	public SymbolChecker(Node start) {
		this.start = start;
		str = "";
		tmpS += "";
	}

	public boolean checkSyntax() {
		try {
			System.out.println("Checking Semantics ...");
			if (debug) System.out.println("Starting from M_prog");
			SymbolTable st = new SymbolTable("M_prog");
			Node n = (Node)start.children.get(0);
			addToString("IPROG (\n");
			addToString("[");
			st = check_M_decl(st, (Node)n.children.get(0));
			addToString("]\n,");
			addToString(st.num_vars + "\n,[");
			ArrayList<VarSymbol> l = SymbolTable.getArrays(st);
			int i = 0;
			while (i < l.size()) {
				addToString("(");
				addToString(l.get(i).offset + ",");
				for (int j = 0; j < l.get(i).dimentions; j ++) {
					addToString("[");
					addToString(l.get(i).dimensionsIR[j]);
					addToString("]");
				}
				addToString(")");
				i ++;
			}
			addToString("]\n,");
			check_M_stmt(st, (Node)n.children.get(1));
			addToString(")\n");
			
			System.out.println("Intermediate Representation: ");
			System.out.println(str);
		}
		catch(SymbolException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private void addToString(String s) {
		if (s == null || s == "null") return;
		if (!pushToTmpS) str += s;
		else tmpS += s;
	}
	
	private int check_ID(SymbolTable st, String name) throws SymbolException {
		return SymbolTable.getType(st, name);
	}
	
	private int check_Array_Index(SymbolTable st, Node curr_node) throws SymbolException {
		if (debug) System.out.println("Checking array index" + curr_node.name);
		addToString("[");
		int dim = 0;
		Node n = curr_node;
		if (n.children.size() < 1) {
			addToString("]");
			return dim;
		}
		while (n.children.size() > 0) { 
			if (check_M_expr(st, (Node)curr_node.children.get(0)) != sym.INT) throw new SymbolException("Symbol Error: array index must int");
			addToString(",");
			n = (Node)n.children.get(1);
			dim ++;
		}
		addToString("]");
		return dim;
	}
	
	private int check_M_type(Node curr_node) {
		Node n = curr_node;
		if (n.name.equals("M_int")) return sym.INT;
		if (n.name.equals("M_real")) return sym.REAL;
		if (n.name.equals("M_bool")) return sym.BOOL;
		return -1;
	}
	
	private int check_M_expr(SymbolTable st, Node curr_node) throws SymbolException  {
		Node n = curr_node;
		if (n.name.equals("M_ival")) {
			addToString("IINT "+n.children.get(0).toString());
			return sym.INT;
		}
		if (n.name.equals("M_rval")) {
			addToString("IREAL "+n.children.get(0).toString());
			return sym.REAL;
		}
		if (n.name.equals("M_bval")) {
			addToString("IBOOL "+n.children.get(0).toString());
			return sym.BOOL;
		}
		
		if (n.name.equals("M_size")) {
			if (debug) System.out.println("Checking M_size");
			String id = n.children.get(0).toString();
			MySymbol s = SymbolTable.getSymbol(st, id);
			if (! (s instanceof VarSymbol)) throw new SymbolException("Symbol Error: "+id+" is not var");
			VarSymbol v = (VarSymbol)s;
			n = (Node)n.children.get(1);
			int array_dim = 0;
			while (n.children.size() > 0) {
				array_dim ++;
				n = (Node)n.children.get(0);
			}
			if (array_dim == 0) throw new SymbolException("Symbol Error: "+id+" is not an array");
			if (array_dim != v.dimentions) throw new SymbolException("Symbol Error: "+id+" does not have dimension "+array_dim);
			addToString("ISIZE(" + v.level+","+v.offset+","+array_dim+")");
			return sym.INT;
			
		}
		
		if (n.name.equals("M_id")){
			
			String id = n.children.get(0).toString();
			n = (Node)n.children.get(1);
			
			if (n.name.equals("M_fn")) {
				if (debug) System.out.println("Checking M_fn");
				int returnType = SymbolTable.getReturnType(st, id);
				
				FunSymbol s = (FunSymbol)SymbolTable.getSymbol(st, id);
				addToString(" IAPP(ICALL (\""+s.lable+"\","+s.level+"),");
				n = (Node)n.children.get(0);
				int i = 0;
				while (i < s.param_list.size()) {
					if (n.children.size() < 1) throw new SymbolException("Symbol Error: not enough args in function "+id);
					int type = check_M_expr(st, (Node)n.children.get(0));
					if (type != s.getParam(i).getType()) throw new SymbolException("Symbol Error: wrong type args in function "+id);
					n = (Node)n.children.get(1);
					i ++;
				}
				if (n.children.size() > 0) throw new SymbolException("Symbol Error: too many args in function "+id);
				addToString(")");
				return returnType;
			}

			else {
				if (debug) System.out.println("Checking M_id");
				MySymbol s = SymbolTable.getSymbol(st, id);
				if (! (s instanceof VarSymbol)) throw new SymbolException("Symbol Error: "+id+" is not var");
				VarSymbol v = (VarSymbol)s;
				addToString(" IID("+v.level+","+v.offset+",");
				n = (Node)n.children.get(0);
				// variable may be an array
				int dim = check_Array_Index(st, n);
				addToString(")");
				return v.type;
				
			}
		}
		// check add/sub
		if (n.name.equals("M_addop")) {
			if (debug) System.out.println("Checking M_addop");
			boolean savedState = pushToTmpS;
			if (!pushToTmpS) tmpS = "";
			pushToTmpS = true;
			tmpS += " IAPP(";
			if (n.children.get(1).toString().contains("sub")) tmpS += "ISUB,[";
			else tmpS += "IADD,[";
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			tmpS += "],[";
			int type2 = check_M_expr(st, (Node)n.children.get(2));
			tmpS += "])";
			if (type1 == sym.REAL && type2 == sym.REAL) {
				if (n.children.get(1).toString().contains("sub")) tmpS = tmpS.replaceFirst("ISUB", "ISUB_F");
				else tmpS = tmpS.replaceFirst("IADD", "IADD_F");
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return sym.REAL;
			}
			else if (type1 == sym.INT && type2 == sym.INT) {
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return sym.INT;
			}
			else  throw new SymbolException("Symbol Error: ADDOP cannot be used for "+n.toString());
		}
		// check mul/div
		if (n.name.equals("M_mulop")) {
			boolean savedState = pushToTmpS;
			if (!pushToTmpS) tmpS = "";
			pushToTmpS = true;
			tmpS += " IAPP(";
			if (n.children.get(1).toString().contains("div")) tmpS += "IDIV,[";
			else tmpS += "IMUL,[";
			if (debug) System.out.println("Checking M_mulop");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			tmpS += "],[";
			int type2 = check_M_expr(st, (Node)n.children.get(2));
			tmpS += "])";
			if (type1 == sym.REAL && type2 == sym.REAL) {
				if (n.children.get(1).toString().contains("div")) tmpS = tmpS.replaceFirst("IDIV", "IDIV_F");
				else tmpS = tmpS.replaceFirst("IMUL", "IMUL_F");
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return sym.REAL;
			}
			else if (type1 == sym.INT && type2 == sym.INT) {
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return sym.INT;
			}
			else  throw new SymbolException("Symbol Error: MULOP cannot be used for  "+n.toString());
		}
		// check negation
		if (n.name.equals("M_neg")) {
			boolean savedState = pushToTmpS;
			if (!pushToTmpS) tmpS = "";
			pushToTmpS = true;
			tmpS += " IAPP(INEG,[";
			if (debug) System.out.println("Checking M_neg");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			tmpS += "])";
			if (type1 == sym.REAL) {
				tmpS = tmpS.replaceFirst("INEG", "INEGL_F");
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return type1;
			}
			else if (type1 == sym.INT) {
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return type1;
			}
			else throw new SymbolException("Symbol Error: NEGATION cannot be used for "+n.toString());
		}
		// check comparison
		if (n.name.equals("M_comp")) {
			boolean savedState = pushToTmpS;
			if (!pushToTmpS) tmpS = "";
			pushToTmpS = true;
			tmpS += " IAPP(";
			if (n.children.get(1).toString().contains("lt")) tmpS += "ILT,[";
			else if (n.children.get(1).toString().contains("le")) tmpS += "ILE,[";
			else if (n.children.get(1).toString().contains("gt")) tmpS += "IGT,[";
			else if (n.children.get(1).toString().contains("ge")) tmpS += "IGE,[";
			else tmpS += "IEQ,[";
			if (debug) System.out.println("Checking M_comp");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			tmpS += "],[";
			int type2 = check_M_expr(st, (Node)n.children.get(2));
			tmpS += "])";
			if (type1 == sym.REAL && type2 == sym.REAL) {
				if (n.children.get(1).toString().contains("lt")) tmpS = tmpS.replaceFirst("ILT", "ILT_F");
				else if (n.children.get(1).toString().contains("le")) tmpS = tmpS.replaceFirst("ILE", "ILE_F");
				else if (n.children.get(1).toString().contains("gt")) tmpS = tmpS.replaceFirst("IGT", "IGT_F");
				else if (n.children.get(1).toString().contains("ge")) tmpS = tmpS.replaceFirst("IGE", "IGE_F");
				else tmpS = tmpS.replaceFirst("IEQ", "IEQ_F");
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return sym.BOOL;
			}
			else if (type1 == sym.INT && type2 == sym.INT) {
				pushToTmpS = savedState;
				if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
				return sym.BOOL;
			}
			else  throw new SymbolException("Symbol Error: COMPARISION cannot be used for "+n.toString());
		}
		// check NOT
		if (n.name.equals("M_not")) {
			addToString(" IAPP(INOT,[");
			if (debug) System.out.println("Checking M_not");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			addToString("])");
			if (type1 == sym.BOOL) {
				return type1;
			}
			else  throw new SymbolException("Symbol Error: NOT cannot be used for "+n.toString());
		}
		// check OR
		if (n.name.equals("M_or")) {
			addToString(" IAPP(IOR,[");
			if (debug) System.out.println("Checking M_or");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			addToString("],[");
			int type2 = check_M_expr(st, (Node)n.children.get(1));
			addToString("])");
			if (type1 == sym.BOOL && type2 == sym.BOOL) {
				return sym.BOOL;
			}
			else  throw new SymbolException("Symbol Error: OR cannot be used for "+n.toString());
		}
		// check AND
		if (n.name.equals("M_and")) {
			addToString(" IAPP(IAND,[");
			if (debug) System.out.println("Checking M_and");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			addToString("],[");
			int type2 = check_M_expr(st, (Node)n.children.get(1));
			addToString("])");
			if (type1 == sym.BOOL && type2 == sym.BOOL) {
				return sym.BOOL;
			}
			else  throw new SymbolException("Symbol Error: AND cannot be used for "+n.toString());
		}
		// check float
		if (n.name.equals("M_float")) {
			addToString(" IAPP(IFLOAT,[");
			if (debug) System.out.println("Checking M_float");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			addToString("])");
			if (type1 == sym.INT) {
				return sym.FLOAT;
			}
			else  throw new SymbolException("Symbol Error: FLOAT cannot be used for "+n.toString());
		}
		// check floor
		if (n.name.equals("M_floor")) {
			addToString(" IAPP(IFLOOR,[");
			if (debug) System.out.println("Checking M_floor");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			addToString("])");
			if (type1 == sym.FLOAT) {
				return sym.INT;
			}
			else  throw new SymbolException("Symbol Error: FLOOR cannot be used for "+n.toString());
		}
		// check ceil
		if (n.name.equals("M_ceil")) {
			addToString(" IAPP(ICEIL,[");
			if (debug) System.out.println("Checking M_ceil");
			int type1 = check_M_expr(st, (Node)n.children.get(0));
			addToString("])");
			if (type1 == sym.FLOAT) {
				return sym.INT;
			}
			else  throw new SymbolException("Symbol Error: CEIL cannot be used for "+n.toString());
		}
		// if not of the above, check current node's child
		if (n.name.equals("M_expr")) return check_M_expr(st, (Node)n.children.get(0)); 
		if (debug) System.out.println(n);
		throw new SymbolException("Symbol Error: unable to check expr node");
	}
	
	/**
	 * Check M_stmt. curr_node must be one of "M_stmt" non-terminal
	 * @param st SymbolTable
	 * @param curr_node Node
	 * @return int (but this doesn't matter)
	 * @throws SymbolException
	 */
	private int check_M_stmt(SymbolTable st, Node curr_node) throws SymbolException {
		Node n = curr_node;
		// P_body
		if (n.name.equals("P_body")) {
			if (debug) System.out.println("Checking P_body");
			return check_M_stmt(st, (Node)n.children.get(0));
		}
		// P_stmts
		if (n.name.equals("P_stmts")) {
			if (debug) System.out.println("Checking P_stmt");
			check_M_stmt(st, (Node)n.children.get(0));
			addToString("\n");
			if (st.nextLevel != null) addToString("\t");
			addToString(",");
			check_M_stmt(st, (Node)n.children.get(1));
			return 0;
		}
		// Checking Assignment
		if (n.name.equals("M_ass")) {
			if (debug) System.out.println("Checking M_ass");
			addToString("IASS(");
			Node tmpN = (Node)n.children.get(0);
			String id = tmpN.children.get(0).toString();
			MySymbol s = SymbolTable.getSymbol(st, id);
			if (! (s instanceof VarSymbol)) throw new SymbolException("Symbol Error: "+id+" is not var");
			VarSymbol v = (VarSymbol)s;
			addToString(v.level + ","+v.offset+",");
			check_Array_Index(st, (Node)tmpN.children.get(1));
			addToString(",");
			int rightType = check_M_expr(st, (Node)n.children.get(1));
			int leftType = v.type;
			
			if (leftType != rightType) throw new SymbolException("Symbol Error: type mismatch in assignment - "+curr_node.toString());
			addToString(")");
			return 0;
		}
		// Checking while stmt
		if (n.name.equals("M_while")) {
			addToString("ICOND(");
			if (debug) System.out.println("Checking M_while");
			if (check_M_expr(st, (Node)n.children.get(0)) != sym.BOOL)  throw new SymbolException("Symbol Error: while statement expects a bool - "+curr_node.toString());
			addToString(", ");
			check_M_stmt(st, (Node)n.children.get(1));
			addToString(")");
			return 0;
		}
		// Checking read stmt
		if (n.name.equals("M_read")) {
			addToString("IREAD");
			if (debug) System.out.println("Checking M_read");
			n = (Node)n.children.get(0);
			String id = n.children.get(0).toString();
			MySymbol s = SymbolTable.getSymbol(st, id);
			if (! (s instanceof VarSymbol)) throw new SymbolException("Symbol Error: "+id+" is not var");
			VarSymbol v = (VarSymbol)s;
			if (v.type == sym.INT) addToString("_I");
			else if (v.type == sym.REAL) addToString("_F");
			else addToString("_B");
			addToString("("+v.level+","+v.offset+", ");
			check_Array_Index(st, (Node)n.children.get(1));
			addToString(")");
			return 0;
		}
		// Checking if stmt
		if (n.name.equals("M_cond")) {
			if (debug) System.out.println("Checking M_cond");
			addToString("ICOND(");
			if (check_M_expr(st, (Node)n.children.get(0)) != sym.BOOL)  throw new SymbolException("Symbol Error: if statement expects a bool - "+curr_node.toString());
			addToString(", ");
			check_M_stmt(st, (Node)n.children.get(1));
			addToString(", ");
			check_M_stmt(st, (Node)n.children.get(2));
			addToString(")");
			return 0;
		}
		// Checking code block (have its own separate SymbolTable)
		if (n.name.equals("M_stmt_block")) {
			if (debug) System.out.println("Checking M_block");
			addToString("\nIBLOCK(");
			n = (Node)n.children.get(0);
			blockCounter ++;
			SymbolTable blockSt = st.insertST("Block"+blockCounter);
			addToString("\n\t[");
			SymbolTable st1 = check_M_decl(blockSt, (Node)n.children.get(0));
			addToString("]\n\t,");
			addToString(st1.num_vars + "\n\t,");
			addToString(st1.num_args + "\n\t,[");
			ArrayList<VarSymbol> l = SymbolTable.getArrays(st1);
			int i = 0;
			while (i < l.size()) {
				addToString("(");
				addToString(l.get(i).offset + ",");
				for (int j = 0; j < l.get(i).dimentions; j ++) {
					addToString("[");
					addToString(l.get(i).dimensionsIR[j]);
					addToString("]");
				}
				addToString(")");
				i ++;
			}
			addToString("]\n\t,");
			check_M_stmt(st1, (Node)n.children.get(1));
			addToString(")");
			return 0;
		}
		// Checking print
		if (n.name.equals("M_print")) {
			boolean savedState = pushToTmpS;
			if (!pushToTmpS) tmpS = "";
			pushToTmpS = true;
			tmpS += "IPRINT(";
			if (debug) System.out.println("Checking M_print");
			int type = check_M_expr(st, (Node)n.children.get(0));
			tmpS += ")";
			if (type == sym.INT) tmpS = tmpS.replaceFirst("IPRINT", "IPRINT_I");
			else if (type == sym.REAL) tmpS = tmpS.replaceFirst("IPRINT", "IPRINT_F");
			else tmpS = tmpS.replaceFirst("IPRINT", "IPRINT_B");
			pushToTmpS = savedState;
			if (!pushToTmpS) { addToString(tmpS); tmpS = "";}
			return 0;
		}
		// Checking function body (have to make sure the return type matches)
		if (n.name.equals("F_body")) {
			if (debug) System.out.println("Checking F_body");
			String id = st.scope_name;
			check_M_stmt(st, (Node)n.children.get(0));
			addToString("\n\t,"+ "IRETURN(");
			int returnType = check_M_expr(st, (Node)n.children.get(1));
			addToString(")");
			if (returnType != SymbolTable.getReturnType(st, id))  throw new SymbolException("Symbol Error: return type mismatch in function "+id);
			return 0;
		}
		// do nothing on episilon
		if (n.children.size() == 0) return 0;
		throw new SymbolException("Symbol Error: unable to check stmt node");
	}
	
	/**
	 * Insert a var defined in node to symbol table
	 * @param st SymbolTable
	 * @param n Node - must have name "M_var"
	 * @throws SymbolException
	 */
	private void insertVar(SymbolTable st, Node n) throws SymbolException {
		if (debug) System.out.println("Checking M_var");
		String id = n.children.get(0).toString();
		int type = check_M_type((Node)n.children.get(2));
		int dim = 0;
		n = (Node)n.children.get(1);
		ArrayList<String> l = new ArrayList<String>();
		while (n.children.size() > 0) { 
			tmpS = "";
			if (!pushToTmpS) tmpS = "";
			pushToTmpS = true;
			if (check_M_expr(st, (Node)n.children.get(0)) != sym.INT) throw new SymbolException("Symbol Error: array index must int");
			dim ++;
			n = (Node)n.children.get(1);
			pushToTmpS = false;
			l.add(tmpS);
			tmpS = "";
		}
		if (debug) System.out.println("Adding "+id+" to st["+st.scope_name+"]");
		if (debug) System.out.println(st);
		SymbolTable.insertSymbol(st, id, type, dim);
		VarSymbol v = (VarSymbol)SymbolTable.getSymbol(st, id);
		for (int i = 0; i < dim; i ++) v.dimensionsIR[i] = l.get(i);
		if (debug) System.out.println(st);
	}
	
	/**
	 * Insert a fun symbol defined in node n
	 * @param st SymbolTable
	 * @param n Node - must have name "M_fun"
	 * @throws SymbolException
	 */
	private void insertFun(SymbolTable st, Node n) throws SymbolException {
		if (debug) System.out.println("Checking M_fun");
		String name = n.children.get(0).toString();
		int returnType = check_M_type((Node)n.children.get(2));
		if (st.symbols.contains(name)) throw new SymbolException("Symbol Error: "+name+" already declared");
		String fun_lable = "FUN"+SymbolTable.fun_lable_counter;
		FunSymbol s = new FunSymbol(name, fun_lable, returnType);
		SymbolTable.fun_lable_counter ++;		
		// Parsing function params
		Node paramN = (Node)n.children.get(1);
		paramN = (Node)paramN.children.get(0);
		while (paramN.children.size() > 0) {
			if (debug) System.out.println("Checking M_fun params");
			Node next = (Node)paramN.children.get(1);
			paramN = (Node)paramN.children.get(0);
			String id = paramN.children.get(0).toString();
			int type = check_M_type((Node)paramN.children.get(2));
			int dims = 0;
			Node dimN = (Node)paramN.children.get(1);
			while (dimN.children.size() > 0) {
				dims ++;
				dimN = (Node)dimN.children.get(0);
			}
			Param p = new Param(type, dims);
			s.addParam(p);
			paramN = next;
		}
		SymbolTable.insertSymbol(st, s);

	}
	
	/**
	 * Checking M_decl. curr_node must be one of "M_decl" non-terminals
	 * @param st SymbolTable
	 * @return SymbolTable (may or may not be the same as input SymbolTable)
	 * @throws SymbolException 
	 */
	private SymbolTable check_M_decl(SymbolTable st, Node curr_node) throws SymbolException {
		Node n = curr_node;
		// M_decls
		if (n.name.equals("M_decls")) {
			if (debug) System.out.println("Checking M_decls");
			Node declN = (Node)n.children.get(0);
			Node decls = (Node)n.children.get(1);
			declN = (Node)declN.children.get(0);
			// I have to insert all symbols defined in current block first
			// in order to make "mutually recursive functions" work
			if (declN.name == "M_var") {
				if (!st.completed) insertVar(st, declN);
			}
			else {
				if (!st.completed)insertFun(st, declN);
			}
			while (decls.children.size()> 0) {
				declN = (Node)decls.children.get(0);
				decls = (Node)decls.children.get(1);
				declN = (Node)declN.children.get(0);
				if (declN.name == "M_var") {
					if (!st.completed)insertVar(st, declN);
				}
				else {
					if (!st.completed)insertFun(st, declN);
				}
			}
			st.completed = true;
			SymbolTable st1 = check_M_decl(st, (Node)n.children.get(0));
			st1 = check_M_decl(st1, (Node)n.children.get(1));
			return st1;
		}
		// M_var_decl
		if (n.name.equals("M_var_decl")) {
			if (debug) System.out.println("Checking M_var_decl");
			return check_M_decl(st, (Node)n.children.get(0));
		}
		// M_fun_decl
		if (n.name.equals("M_fun_decl")) {
			if (debug) System.out.println("Checking M_fun_decl");
			SymbolTable st1 = check_M_decl(st, (Node)n.children.get(0));
			return st1;
			
		}
		// Function already inserted into symbol table st at this point, now go into the function block
		if (n.name.equals("M_fun")) {
			if (debug) System.out.println("Checking M_fun");
			addToString("IFUN \n\t(");
			String name = n.children.get(0).toString();
			int returnType = check_M_type((Node)n.children.get(2));
			FunSymbol s = (FunSymbol)SymbolTable.getSymbol(st, name);
			String fun_lable = s.lable;
			addToString("\""+fun_lable+"\"\n\t,");
			
			// Each function must have it's own seperate SymbolTable
			SymbolTable funSt = st.insertST(name);
			funSt.return_type = returnType;
			
			// Parsing function params
			Node paramN = (Node)n.children.get(1);
			paramN = (Node)paramN.children.get(0);
			while (paramN.children.size() > 0) {
				if (debug) System.out.println("Checking M_fun params");
				Node next = (Node)paramN.children.get(1);
				paramN = (Node)paramN.children.get(0);
				String id = paramN.children.get(0).toString();
				int type = check_M_type((Node)paramN.children.get(2));
				int dims = 0;
				Node dimN = (Node)paramN.children.get(1);
				while (dimN.children.size() > 0) {
					dims ++;
					dimN = (Node)dimN.children.get(0);
				}
				Param p = new Param(type, dims);
				SymbolTable.insertSymbol(funSt, p, id);
				paramN = next;
			}
			// go inside the function body
			check_F_block(funSt, (Node)n.children.get(3));
			addToString("\n\t)\n");
			return st;
		}
		return st;
		
	}
	
	/**
	 * Check inside function body. curr_node must be "F_block" non-terminal
	 * @param st SymbolTable (must be function's own SymbolTable
	 * @param curr_node Node
	 * @throws SymbolException
	 */
	private void check_F_block(SymbolTable st, Node curr_node) throws SymbolException {
		if (debug) System.out.println("Checking F_block");
		addToString("[");
		st = check_M_decl(st, (Node)curr_node.children.get(0));
		addToString("]\n\t,");
		addToString(st.num_vars + "\n\t,");
		addToString(st.num_args + "\n\t,[");
		ArrayList<VarSymbol> l = SymbolTable.getArrays(st);
		int i = 0;
		while (i < l.size()) {
			addToString("(");
			addToString(l.get(i).offset + ",");
			for (int j = 0; j < l.get(i).dimentions; j ++) {
				addToString("[");
				addToString(l.get(i).dimensionsIR[j]);
				addToString("]");
			}
			addToString(")");
			i ++;
		}
		addToString("]\n\t,");
		check_M_stmt(st, (Node)curr_node.children.get(1));
	}

}
