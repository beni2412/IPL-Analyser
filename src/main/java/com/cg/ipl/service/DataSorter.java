package com.cg.ipl.service;

import java.util.Comparator;

import com.cg.ipl.dto.IPLBatsmen;
import com.cg.ipl.dto.IPLBowler;

public class DataSorter {

	public static Comparator<IPLBatsmen> topBattingAvg = Comparator.comparing(IPLBatsmen::getAvg).reversed();

	public static Comparator<IPLBatsmen> topStrikeRate = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();

	public static Comparator<IPLBatsmen> maxFours = Comparator.comparing(IPLBatsmen::getFours).reversed();

	public static Comparator<IPLBatsmen> maxSixes = Comparator.comparing(IPLBatsmen::getSixes).reversed();	
	
	public static Comparator<IPLBatsmen> bestStrikeRateWithBoundaries = Comparator.comparing(IPLBatsmen::getBoundaries).thenComparing(IPLBatsmen::getStrikeRate).reversed();
	
	public static Comparator<IPLBatsmen> bestAvgWithBestStrikeRate = Comparator.comparing(IPLBatsmen::getAvg).thenComparing(IPLBatsmen::getStrikeRate).reversed();
	
	public static Comparator<IPLBatsmen> maxRunsWithBestAvg = Comparator.comparing(IPLBatsmen::getRuns).thenComparing(IPLBatsmen::getAvg).reversed();
	
	public static Comparator<IPLBowler> bestBowlingAvg = Comparator.comparing(IPLBowler::getAvg);
	
	public static Comparator<IPLBowler> bestBowlingStrikeRate = Comparator.comparing(IPLBowler::getStrikeRate);
	
	public static Comparator<IPLBowler> bestBowlingEconomy = Comparator.comparing(IPLBowler::getEconomyRate);
	
	public static Comparator<IPLBowler> bestStrikeRateWith4Wor5W = bestBowlingStrikeRate.thenComparing(bowler -> bowler.getFiveWickets()+bowler.getFourWickets());
	
	}
