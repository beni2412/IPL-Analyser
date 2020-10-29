package com.cg.IPLAnalyser;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.ipl.dto.IPLBatsmen;
import com.cg.ipl.dto.IPLBowler;
import com.cg.ipl.dto.IPLException;
import com.cg.ipl.service.DataSorter;
import com.cg.ipl.service.IPLAnalyser;

public class IPLAnalyserTest {

	public String BOWLERS_CSV_FILE = "./FactsheetMostWkts.csv";
	public String BATSMEN_CSV_FILE = "./FactsheetMostRuns.csv";
	public List<IPLBatsmen> batsmenList = null;
	public List<IPLBowler> bowlersList = null;
	public IPLAnalyser iplAnalyser;
	public List<IPLBatsmen> sortedBatsmenList = null;
	public List<IPLBowler> sortedBowlersList = null;

	@Before
	public void initialize() throws IPLException {
		iplAnalyser = new IPLAnalyser();
		bowlersList = iplAnalyser.readData(BOWLERS_CSV_FILE, "BOWLERS");
		batsmenList = iplAnalyser.readData(BATSMEN_CSV_FILE, "BATSMEN");
	}

	@Test
	public void givenNumberOfEntriesInACSVFile_ShouldReturnExactlytheSameWhileReading() throws IPLException {

		Assert.assertEquals(99, bowlersList.size());
		Assert.assertEquals(101, batsmenList.size());

	}
	
	@Test
	public void givenBattingData_ShouldReturnTopBattingAvg() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.topBattingAvg);
		Assert.assertEquals("MS Dhoni", sortedBatsmenList.get(0).getPlayer());
	}
}
