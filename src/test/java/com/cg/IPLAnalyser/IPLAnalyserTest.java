package com.cg.IPLAnalyser;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.ipl.dto.IPLAllRounder;
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
	public List<IPLAllRounder> sortedAllRounderList=null;

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
	
	@Test
	public void givenBattingData_ShouldReturnTopStrikeRate() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.topStrikeRate);
		Assert.assertEquals("Ishant Sharma", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_ShouldReturnMaxSixes() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.maxSixes);
		Assert.assertEquals("Andre Russell", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_ShouldReturnMaxFours() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.maxFours);
		Assert.assertEquals("Shikhar Dhawan", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_ShouldReturnBestStrikeRateWithBoundaries() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.bestStrikeRateWithBoundaries);
		Assert.assertEquals("Andre Russell", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_ShouldReturnTopBattingAvgWithBestStrikeRate() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.bestAvgWithBestStrikeRate);
		Assert.assertEquals("MS Dhoni", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_shouldReturnMaxRunWithBestAvg() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.maxRunsWithBestAvg);
		Assert.assertEquals("David Warner ", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnBestBowlingAvg() {
		sortedBowlersList = iplAnalyser.sortBowlingData(bowlersList, DataSorter.bestBowlingAvg);
		Assert.assertEquals("Anukul Roy", sortedBowlersList.get(0).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnBestBowlingStrikeRate() {
		sortedBowlersList = iplAnalyser.sortBowlingData(bowlersList, DataSorter.bestBowlingStrikeRate);
		Assert.assertEquals("Krishnappa Gowtham", sortedBowlersList.get(98).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnBestBowlingEconomy() {
		sortedBowlersList = iplAnalyser.sortBowlingData(bowlersList, DataSorter.bestBowlingEconomy);
		Assert.assertEquals("Shivam Dube", sortedBowlersList.get(0).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnBestBowlingStrikeRateWith4Wor5W() {
		sortedBowlersList = iplAnalyser.sortBowlingData(bowlersList, DataSorter.bestStrikeRateWith4Wor5W);
		Assert.assertEquals("Krishnappa Gowtham", sortedBowlersList.get(98).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnBestBowlingAvgWithBestStrikeRate() {
		sortedBowlersList = iplAnalyser.sortBowlingData(bowlersList, DataSorter.bestBowlingAvgWithBestStrikeRate);
		Assert.assertEquals("Anukul Roy", sortedBowlersList.get(0).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnMaxWicketsWithBestAvg() {
		sortedBowlersList = iplAnalyser.sortBowlingData(bowlersList, DataSorter.maxWicketsWithBestAvg);
		Assert.assertEquals("Imran Tahir", sortedBowlersList.get(0).getPlayer());
	}
	
	@Test
	public void givenAllrounderData_shouldReturnMaxBattingAndBowlingAvg() {
		sortedAllRounderList = iplAnalyser.sortAllRounderData(batsmenList, bowlersList, DataSorter.bestBattingAvgAndBowlingAvg);
		Assert.assertEquals("Andre Russell", sortedAllRounderList.get(0).getPlayer());
	}
	
	@Test
	public void givenAllrounderData_shouldReturnBestAllRounder() {
		sortedAllRounderList = iplAnalyser.sortAllRounderData(batsmenList, bowlersList, DataSorter.bestAllRounder);
		Assert.assertEquals("Andre Russell", sortedAllRounderList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_shouldReturnMaxHunderedsWithBestAvg() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.maxCenturyWithBestAvg);
		Assert.assertEquals("David Warner ", sortedBatsmenList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingData_shouldReturnMaxAvgWithZero50OrZero100() {
		sortedBatsmenList = iplAnalyser.sortBattingData(batsmenList, DataSorter.zero50AndZero100ButBestAverage);
		Assert.assertEquals("Marcus Stoinis", sortedBatsmenList.get(0).getPlayer());
	}
}
