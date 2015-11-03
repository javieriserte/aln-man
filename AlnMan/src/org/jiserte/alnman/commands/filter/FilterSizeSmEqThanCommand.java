package org.jiserte.alnman.commands.filter;

import java.io.InputStream;
import java.io.PrintStream;

import org.jiserte.bioseq.filtersequences.FilterSequence;
import org.jiserte.bioseq.filtersequences.FilterSequenceSmallerThan;

import cmdGA2.NoArgumentOption;
import cmdGA2.SingleArgumentOption;

/**
 * Filter sequences whose lengths is smaller or equal than a threshold value.
 * 
 * @author javier iserte
 *
 */
public class FilterSizeSmEqThanCommand extends FilterCommand<SingleArgumentOption<Integer>> {

	public FilterSizeSmEqThanCommand(InputStream inputstream, PrintStream output, SingleArgumentOption<Integer> option, NoArgumentOption invertFiler) {
		
		super(inputstream, output, option, invertFiler);
		
	}

	public void getFilter() {
		Integer size = this.getOption().getValue();
		
		if (size != null) {
		
			FilterSequence filter = new FilterSequenceSmallerThan(size);
			
			this.filter = filter;
		
		} else {
			
			this.filter = null;
			
		}
	}


}
