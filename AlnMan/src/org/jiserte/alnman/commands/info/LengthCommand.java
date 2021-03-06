package org.jiserte.alnman.commands.info;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.jiserte.alnman.commands.FastaCommand;

import cmdGA2.NoArgumentOption;
import pair.Pair;

/**
 * Verifies if all sequences in the alignment has the same length and returns it.
 * Otherwise return 0. 
 * 
 * @author javier
 *
 */
public class LengthCommand extends FastaCommand<NoArgumentOption> {

	public LengthCommand(InputStream inputstream, PrintStream output, NoArgumentOption option) {
	
		super(inputstream, output, option);

	}

	@Override
	protected List<String> performAction() {

		List<String> results = new ArrayList<String>();
		
		List<Pair<String,String>> sequences = this.getSequences();
		
		int[] lens = new int[sequences.size()];
		
		int count=0;
		
		for (Pair<String,String> pair : sequences) {
			
			lens[count++] = pair.getSecond().length();
			
		}

		boolean allEqual = true;

		if (lens.length>1) {
			
			for (int i = 1; allEqual==true && i<lens.length; i++) {
				
				allEqual = allEqual & (lens[i] == lens[i-1]);
				
			}

		}
		
		if (allEqual && lens.length>0) {
			
			results.add(String.valueOf(lens[0]));
			
		} else {

			results.add("0");
			
		}
		
		return results;
	
	}

}
