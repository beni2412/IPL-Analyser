package com.cg.ipl.service;

import java.util.Comparator;

import com.cg.ipl.dto.IPLAllRounder;
import com.cg.ipl.dto.IPLBatsmen;
import com.cg.ipl.dto.IPLBowler;

public class DataSorter {

	public static Comparator<IPLBatsmen> topBattingAvg = Comparator.comparing(IPLBatsmen::getAvg).reversed();

	public static Comparator<IPLBatsmen> topStrikeRate = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();

	public static Comparator<IPLBatsmen> maxFours = Comparator.comparing(IPLBatsmen::getFours).reversed();

	public static Comparator<IPLBatsmen> maxSixes = Comparator.comparing(IPLBatsmen::getSixes).reversed();

	public static Comparator<IPLBatsmen> bestStrikeRateWithBoundaries = Comparator.comparing(IPLBatsmen::getBoundaries)
			.thenComparing(IPLBatsmen::getStrikeRate).reversed();

	public static Comparator<IPLBatsmen> bestAvgWithBestStrikeRate = Comparator.comparing(IPLBatsmen::getAvg)
			.thenComparing(IPLBatsmen::getStrikeRate).reversed();

	public static Comparator<IPLBatsmen> maxRunsWithBestAvg = Comparator.comparing(IPLBatsmen::getRuns)
			.thenComparing(IPLBatsmen::getAvg).reversed();

	public static Comparator<IPLBowler> bestBowlingAvg = Comparator.comparing(IPLBowler::getAvg);

	public static Comparator<IPLBowler> bestBowlingStrikeRate = Comparator.comparing(IPLBowler::getStrikeRate);

	public static Comparator<IPLBowler> bestBowlingEconomy = Comparator.comparing(IPLBowler::getEconomyRate);

	public static Comparator<IPLBowler> bestStrikeRateWith4Wor5W = bestBowlingStrikeRate
			.thenComparing(bowler -> bowler.getFiveWickets() + bowler.getFourWickets());

	public static Comparator<IPLBowler> bestBowlingAvgWithBestStrikeRate = bestBowlingAvg
			.thenComparing(IPLBowler::getStrikeRate);

	public static Comparator<IPLBowler> maxWicketsWithBestAvg = Comparator.comparing(IPLBowler::getWickets)
			.thenComparing(bestBowlingAvg).reversed();

	public static Comparator<IPLAllRounder> bestBattingAvgAndBowlingAvg = Comparator
			.comparing(IPLAllRounder::getAverageRuns).thenComparing(IPLAllRounder::getAverageWickets).reversed();

	public static Comparator<IPLAllRounder> bestAllRounder = Comparator
			.comparing(IPLAllRounder::getRuns).thenComparing(IPLAllRounder::getWickets).reversed();
	
	public static Comparator<IPLBatsmen> maxCenturyWithBestAvg = Comparator.comparing(IPLBatsmen::getHundreds)
			.thenComparing(IPLBatsmen::getAvg).reversed();
	
	public static Comparator<IPLBatsmen> zero50AndZero100ButBestAverage= Comparator.comparing(IPLBatsmen::getAvg);
}
