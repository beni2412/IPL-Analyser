package com.cg.ipl.dto;

import com.opencsv.bean.CsvBindByName;

public class IPLBatsmen {
	@CsvBindByName(column = "POS")
	private String position;

	@CsvBindByName(column = "PLAYER")
	private String player;

	@CsvBindByName(column = "Mat")
	private String matches;

	@CsvBindByName(column = "inns")
	private String innings;

	@CsvBindByName(column = "NO")
	private String notOuts;

	@CsvBindByName(column = "Runs")
	private String runs;

	@CsvBindByName(column = "HS")
	private String highestScore;

	@CsvBindByName(column = "Avg")
	private String avg;

	@CsvBindByName(column = "BF")
	private String ballsFaced;

	@CsvBindByName(column = "SR")
	private String strikeRate;

	@CsvBindByName(column = "100")
	private String hundreds;

	@CsvBindByName(column = "50")
	private String fifties;

	@CsvBindByName(column = "4s")
	private String fours;

	@CsvBindByName(column = "6s")
	private String sixes;

	public int getPosition() {
		return Integer.parseInt(position);
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

	public int getNotOuts() {
		return Integer.parseInt(notOuts);
	}

	public int getRuns() {
		return Integer.parseInt(runs);
	}

	public int getHighestScore() {
		return Integer.parseInt(highestScore);
	}

	public double getAvg() {
		if (avg.equals("-"))
			return 0.0;
		return Double.parseDouble(avg);
	}

	public int getBallsFaced() {
		return Integer.parseInt(ballsFaced);
	}

	public double getStrikeRate() {
		return Double.parseDouble(strikeRate);
	}

	public int getHundreds() {
		return Integer.parseInt(hundreds);
	}

	public int getFifties() {
		return Integer.parseInt(fifties);
	}

	public int getFours() {
		return Integer.parseInt(fours);
	}

	public int getSixes() {
		return Integer.parseInt(sixes);
	}
	
	public int getBoundaries() {
		if (sixes.equals("-") || sixes == "")
			sixes = "0";
		if (fours.equals("-") || fours == "")
			fours = "0";
		int boundaries = Integer.parseInt(sixes) + Integer.parseInt(fours);
		return boundaries;
	}

}
