package org.jiserte.alnman.commands.system;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.jiserte.alnman.FastaAlignmentManipulator;
import org.jiserte.alnman.commands.FastaCommand;

import cmdGA2.NoArgumentOption;

/**
 * Shows the Version number of FastaAlignmentManipulator
 * @author javier
 *
 */
public class VersionCommand extends FastaCommand<NoArgumentOption> {

	public VersionCommand(InputStream inputstream, PrintStream output, 	NoArgumentOption option) {
		
		super(inputstream, output, option);
		
	}

	@Override
	protected List<String> performAction() {
		
		List<String> results = new ArrayList<String>();
		
		results.add(FastaAlignmentManipulator.VERSION);
		
		return results;
		
	}

}
