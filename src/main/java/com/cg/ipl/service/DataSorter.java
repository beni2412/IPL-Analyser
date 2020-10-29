package com.cg.ipl.service;

import java.util.Comparator;

import com.cg.ipl.dto.IPLBatsmen;

public class DataSorter {

	public static Comparator<IPLBatsmen> topBattingAvg = Comparator.comparing(IPLBatsmen::getAvg).reversed();

	public static Comparator<IPLBatsmen> topStrikeRate = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();

	public static Comparator<IPLBatsmen> maxFours = Comparator.comparing(IPLBatsmen::getFours).reversed();

	public static Comparator<IPLBatsmen> maxSixes = Comparator.comparing(IPLBatsmen::getSixes).reversed();	
	}
