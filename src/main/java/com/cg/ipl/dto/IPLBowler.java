package com.cg.ipl.dto;

import com.opencsv.bean.CsvBindByName;

public class IPLBowler {
	@CsvBindByName(column = "POS")
	public String pos;

	@CsvBindByName(column = "PLAYER")
	public String player;

	@CsvBindByName(column = "Mat")
	public String matches;

	@CsvBindByName(column = "inns")
	public String innings;

	@CsvBindByName(column = "Ov")
	public String overs;

	@CsvBindByName(column = "Runs")
	public String runs;

	@CsvBindByName(column = "Wkts")
	public String wickets;

	@CsvBindByName(column = "BBI")
	public String bestBowling;

	@CsvBindByName(column = "Avg")
	public String avg;

	@CsvBindByName(column = "Econ")
	public String economyRate;

	@CsvBindByName(column = "SR")
	public String strikeRate;

	@CsvBindByName(column = "4w")
	public String fourWickets;

	@CsvBindByName(column = "5w")
	public String fiveWickets;

	public int getPos() {
		return Integer.parseInt(pos);
	}

	public String getPlayer() {
		return player;
	}

	public int getMatches() {
		return Integer.parseInt(matches);
	}

	public int getInnings() {
		return Integer.parseInt(innings);
	}

	public double getOvers() {
		return Double.parseDouble(overs);
	}

	public int getRuns() {
		return Integer.parseInt(runs);
	}

	public int getWickets() {
		return Integer.parseInt(wickets);
	}

	public int getBestBowling() {
		return Integer.parseInt(bestBowling);
	}

	public double getAvg() {
		if (avg.equals("-"))
			return 100000;
		return Double.parseDouble(avg);
	}

	public double getEconomyRate() {
		return Double.parseDouble(economyRate);
	}

	public double getStrikeRate() {
		if (strikeRate.equals("-"))
			return 0.0;
		return Double.parseDouble(strikeRate);
	}

	public int getFourWickets() {
		return Integer.parseInt(fourWickets);
	}

	public int getFiveWickets() {
		return Integer.parseInt(fiveWickets);
	}
}
