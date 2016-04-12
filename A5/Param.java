
public class Param {
	private int type;
	private int dimentions;
	
	// getters
	public int getType() {
		return type;
	}

	public int getDimentions() {
		return dimentions;
	}

	public Param(int type, int dim) {
		this.type = type;
		this.dimentions = dim;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Param)) return false;
		Param p = (Param)o;
		return (this.type == p.type && this.dimentions == p.dimentions);
	}

}
