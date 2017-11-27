package mutant.model;

import java.util.List;

public class DNARequest {
	private List<String> dna;

	public DNARequest() {
	}

	public DNARequest(List<String> dna) {
		this.dna = dna;
	}

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DNARequest)) return false;

		DNARequest that = (DNARequest) o;

		return dna.equals(that.dna);
	}

	@Override
	public int hashCode() {
		return dna.hashCode();
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("MutantRequest{");
		sb.append("dna=").append(dna);
		sb.append('}');
		return sb.toString();
	}
}
