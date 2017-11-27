package mutant.model;

import java.util.ArrayList;
import java.util.List;

public class DNASequenceTable {

	private final List<String> rows;
	private final List<String> cols;
	private final List<String> firstDiags;
	private final List<String> secondDiags;
	private final int size;

	public DNASequenceTable(DNARequest dna){
		size = dna.getDna().size();
		rows = dna.getDna();
		cols = initializeCols(dna);
		firstDiags = initializeFirstDiags(dna);
		secondDiags = initializeSecondDiags(dna);
	}

	public List<String> getRows() {
		return rows;
	}

	public List<String> getCols() {
		return cols;
	}

	public List<String> getFirstDiags() {
		return firstDiags;
	}

	public List<String> getSecondDiags() {
		return secondDiags;
	}

	public int getSize() {
		return size;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DNASequenceTable)) return false;

		DNASequenceTable that = (DNASequenceTable) o;

		if (size != that.size) return false;
		if (rows != null ? !rows.equals(that.rows) : that.rows != null) return false;
		if (cols != null ? !cols.equals(that.cols) : that.cols != null) return false;
		if (firstDiags != null ? !firstDiags.equals(that.firstDiags) : that.firstDiags != null) return false;
		return secondDiags != null ? secondDiags.equals(that.secondDiags) : that.secondDiags == null;
	}

	@Override
	public int hashCode() {
		int result = rows != null ? rows.hashCode() : 0;
		result = 31 * result + (cols != null ? cols.hashCode() : 0);
		result = 31 * result + (firstDiags != null ? firstDiags.hashCode() : 0);
		result = 31 * result + (secondDiags != null ? secondDiags.hashCode() : 0);
		result = 31 * result + size;
		return result;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("DNASequenceTable{");
		sb.append("rows=").append(rows);
		sb.append(", cols=").append(cols);
		sb.append(", firstDiags=").append(firstDiags);
		sb.append(", secondDiags=").append(secondDiags);
		sb.append(", size=").append(size);
		sb.append('}');
		return sb.toString();
	}

	//------------------------------------------------------------
	// Private methods
	//------------------------------------------------------------

	private List<String> initializeFirstDiags(DNARequest dna) {
		// Get bottom half diagonals
		List <String> res = new ArrayList<>();
		for (int i = getSize() - 1; i > 0; i--) {
			char value[] = new char[getSize() - i + 1];
			for(int j=0, x = i; x < getSize(); j++, x++) {
				value[j] = dna.getDna().get(x).charAt(j);
			}
			res.add(new String(value));
		}

		// Get top half diagonals
		for (int i=0; i < getSize(); i++) {
			char value[] = new char[getSize() - i + 1];
			for(int j=0, x = i; x < getSize(); j++, x++) {
				value[j] = dna.getDna().get(j).charAt(x);
			}
			res.add(new String(value));
		}
		return res;
	}

	private List<String> initializeSecondDiags(DNARequest dna) {
		// Get top half diagonals
		List <String> res = new ArrayList<>();
		for (int k = 0; k < getSize(); k++) {
			char value[] = new char[k + 1];
			for(int j=0; j <= k; j++) {
				int i = k - j;
				value[j] = dna.getDna().get(i).charAt(j);
			}
			res.add(new String(value));
		}

		// Get bottom half diagonals
		for (int k = getSize() - 2; k >= 0; k--) {
			char value[] = new char[k + 1];
			for(int j = 0; j <= k; j++) {
				int i = k - j;
				value[j] = dna.getDna().get(getSize() - j - 1).charAt(getSize() - i - 1);
			}
			res.add(new String(value));
		}
		return res;
	}

	private List<String> initializeCols(DNARequest dna) {
		List <String> res = new ArrayList<>();
		for (int i=0; i < getSize(); i++) {
			char value[] = new char[getSize()];
			for(int j=0; j < getSize(); j++) {
				value[j] = dna.getDna().get(j).charAt(i);
			}
			res.add(new String(value));
		}
		return res;
	}

}
