package org.jiserte.alnman.commands.filter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.jiserte.alnman.commands.FastaCommand;
import org.jiserte.tmpaddons.filtersequences.FilterSequence;
import org.jiserte.tmpaddons.filtersequences.FilterSequenceBooleanNOT;

import cmdGA2.ArgOption;
import cmdGA2.NoArgumentOption;
import pair.Pair;

public abstract class FilterCommand<Op extends ArgOption<?>> extends FastaCommand<Op> {

	FilterSequence filter;
	NoArgumentOption invertFilter;
	
	public FilterCommand(InputStream inputstream, PrintStream output, Op option, NoArgumentOption invertFilter) {
		super(inputstream, output, option);
		
		this.invertFilter = invertFilter;
		
	}

	@Override
	protected List<String> performAction() {
		
		this.getFilter();
		
		if (invertFilter.isPresent()) filter = new FilterSequenceBooleanNOT(filter);
		
		List<String> results = new ArrayList<String>(); 
		
		List<Pair<String, String>> seqs = this.getSequences();
		
		for (Pair<String, String> pair : seqs) {
			
			if (filter.filter(pair) ) {
				
				results.add(">" + pair.getFirst());
				
				results.add(pair.getSecond());
				
			}
			
		}
		
		return results;
		
	}
	
	protected abstract void getFilter();

}
