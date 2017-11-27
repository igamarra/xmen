package mutant.domain;

import mutant.model.DNASequenceTable;

public class MutantRecognitionService {
	public static Boolean isMutant(DNASequenceTable sequenceTable) {
		if (isMutantSequence(sequenceTable))
			return true;
		else
			throw new NotMutantException();
	}

	private static boolean isMutantSequence(DNASequenceTable sequenceTable) {
		return (sequenceTable.getCols().stream().filter(s -> contains4EqualsLetters(s)).count() +
		sequenceTable.getRows().stream().filter(s -> contains4EqualsLetters(s)).count() +
		sequenceTable.getFirstDiags().stream().filter(s -> contains4EqualsLetters(s)).count() +
		sequenceTable.getSecondDiags().stream().filter(s -> contains4EqualsLetters(s)).count()) > 1;
	}

	private static boolean contains4EqualsLetters(String s) {
		return s.toUpperCase().contains("AAAA") ||
			s.toUpperCase().contains("TTTT") ||
			s.toUpperCase().contains("CCCC") ||
			s.toUpperCase().contains("GGGG");
	}
}
