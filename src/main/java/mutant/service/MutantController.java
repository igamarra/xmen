package mutant.service;

import mutant.domain.MutantRecognitionService;
import mutant.model.DNARequest;
import mutant.model.DNASequenceTable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @RequestMapping(value = "/mutant", method = RequestMethod.POST)
    public Boolean mutant(@RequestBody DNARequest dna) {

        // Parse table
        DNASequenceTable sequenceTable = new DNASequenceTable(dna);

        // Perform
        return MutantRecognitionService.isMutant(sequenceTable);
    }
}
