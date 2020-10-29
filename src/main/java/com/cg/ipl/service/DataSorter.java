package com.cg.ipl.service;

import java.util.Comparator;

import com.cg.ipl.dto.IPLBatsmen;

public class DataSorter {

	public static final Comparator<IPLBatsmen> topBattingAvg = Comparator.comparing(IPLBatsmen::getAvg).reversed();
	
	public static final Comparator<IPLBatsmen> topStrikeRate = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();
	
}
