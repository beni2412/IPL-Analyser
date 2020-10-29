package com.cg.IPLAnalyser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cg.ipl.dto.IPLBatsmen;
import com.cg.ipl.dto.IPLBowler;
import com.cg.ipl.dto.IPLException;
import com.cg.ipl.service.IPLAnalyser;

public class IPLAnalyserTest {
	
	public String BOWLERS_CSV_FILE = "./FactsheetMostWkts.csv";
	public String BATSMEN_CSV_FILE = "./FactsheetMostRuns.csv";
	public List<IPLBatsmen> batsmenList = null;
	public List<IPLBowler> bowlersList = null;
	public IPLAnalyser ipl;
	
	public IPLAnalyserTest() {
		ipl = new IPLAnalyser();
		
	}
	@Test
	public void givenNumberOfEntriesInACSVFile_ShouldReturnExactlytheSameWhileReading()
			throws IPLException {
		try {
			bowlersList = ipl.readData(BOWLERS_CSV_FILE, "BOWLERS");
			Assert.assertEquals(99, bowlersList.size());
			batsmenList = ipl.readData(BATSMEN_CSV_FILE, "BATSMEN");
			Assert.assertEquals(101, batsmenList.size());
		} catch (IPLException e) {
		}

	}
}
