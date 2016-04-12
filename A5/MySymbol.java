public class MySymbol{
	protected String name;
	public int level = 0;

	public MySymbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof String) return name.equals((String)arg0);
		if (arg0 instanceof MySymbol) return name.equals(((MySymbol)arg0).getName());
		return false;
	}
	
	
}
