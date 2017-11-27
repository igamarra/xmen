package mutant.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotMutantException extends RuntimeException {
	public NotMutantException() {
		super("The given DNA sequence does not correspond to a mutant");
	}
}
