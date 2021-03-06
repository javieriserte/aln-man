package org.jiserte.alnman.commands.extraction;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.jiserte.alnman.commands.FastaCommand;

import math.random.FischerYatesShuffle;
import cmdGA2.SingleArgumentOption;
import pair.Pair;

/**
 * Select n sequences selected randomly from an MSA
 * 
 * @author javier
 *
 */
public class PickRandomCommand extends FastaCommand<SingleArgumentOption<Integer>> {
	
	int numberToPick;

	public PickRandomCommand(InputStream inputstream, PrintStream output, SingleArgumentOption<Integer> option) {
		
		super(inputstream, output, option);
		
	}

	@Override
	protected List<String> performAction() {

		List<String> results = new ArrayList<String>();
		
		List<Pair<String, String>> seqs = this.getSequences();

		this.numberToPick = Math.min(this.getOption().getValue(),seqs.size());
		
		if (seqs.size()>0) {
				
			FischerYatesShuffle.shuffle(this.numberToPick, seqs);
				
		}
			
		
		for (int i = 0; i<this.numberToPick; i++) {
			
			Pair<String, String> pair = seqs.get(i);
			
			results.add(">"+ pair.getFirst());
			
			results.add(pair.getSecond());
			
		}
		
		return results;
		
	}

}
