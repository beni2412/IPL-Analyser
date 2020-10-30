package com.cg.ipl.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.csvbuilder.CSVBuilderFactory;
import com.cg.csvbuilder.ICSVBuilder;
import com.cg.ipl.dto.*;
import com.cg.ipl.dto.IPLException.ExceptionType;
import com.opencsv.exceptions.CsvException;

public class IPLAnalyser {

	public static List<IPLBatsmen> batsmenList;
	public static List<IPLBowler> bowlersList;
	DataSorter dataSorter = new DataSorter();

	public IPLAnalyser() {
		batsmenList = null;
		bowlersList = null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> readData(String DATA_FILE, String type) throws IPLException {
		if (!DATA_FILE.contains(".csv")) {
			throw new IPLException(ExceptionType.INVALID_FILE_TYPE, "Invalid File Type!! Exception thrown....");
		}
		try (Reader reader = Files.newBufferedReader(Paths.get(DATA_FILE))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			if (type.equalsIgnoreCase("batsmen")) {
				try {
					batsmenList = csvBuilder.getCSVFileIList(reader, IPLBatsmen.class);
					return (List<T>) batsmenList;
				} catch (CsvException e) {
					throw new IPLException(ExceptionType.INVALID_CLASS_TYPE,
							"Invalid Class Type!! Exception thrown... ");
				}
			} else if (type.equalsIgnoreCase("bowlers")) {
				try {
					bowlersList = csvBuilder.getCSVFileIList(reader, IPLBowler.class);
					return (List<T>) bowlersList;
				} catch (CsvException e) {
					throw new IPLException(ExceptionType.INVALID_CLASS_TYPE,
							"Invalid Class Type!! Exception thrown... ");
				}
			} else {
				throw new IPLException(ExceptionType.INVALID_PLAYER_TYPE, "Invalid player type!! Exception thrown... ");
			}

		} catch (IOException e) {
			throw new IPLException(ExceptionType.INVALID_FILE_PATH,
					"Invalid file location given!! Exception thrown...");
		}

	}

	public List<IPLBatsmen> sortBattingData(List<IPLBatsmen> battingList, Comparator<IPLBatsmen> comparator) {
		if (comparator.equals(DataSorter.zero50AndZero100ButBestAverage)) {
			List<IPLBatsmen> listBatsmen = new ArrayList<IPLBatsmen>();
			for (IPLBatsmen batsman : battingList) {
				if (batsman.getHundreds() == 0 && batsman.getFifties() == 0) {
					listBatsmen.add(batsman);
				}
			}
			Collections.sort(listBatsmen, DataSorter.topBattingAvg);
			return (List<IPLBatsmen>) listBatsmen;
		}
		Collections.sort(battingList, comparator);
		return (List<IPLBatsmen>) battingList;
	}

	public List<IPLBowler> sortBowlingData(List<IPLBowler> bowlingList, Comparator<IPLBowler> comparator) {
		Collections.sort(bowlingList, comparator);
		return (List<IPLBowler>) bowlingList;
	}

	public List<IPLAllRounder> sortAllRounderData(List<IPLBatsmen> battingList, List<IPLBowler> bowlingList,
			Comparator<IPLAllRounder> comparator) {
		List<IPLAllRounder> allRounderList = getAllRounderPlayers(battingList, bowlingList);
		Collections.reverse(allRounderList);
		return (List<IPLAllRounder>) allRounderList.stream().sorted(comparator).collect(Collectors.toList());
	}

	public List<IPLAllRounder> getAllRounderPlayers(List<IPLBatsmen> battingList, List<IPLBowler> bowlingList) {
		List<IPLAllRounder> allRounderList = new ArrayList<>();
		battingList.stream().forEach(batsman -> {
			IPLBowler bowlers = bowlingList.stream()
					.filter(bowler -> bowler.getPlayer().equalsIgnoreCase(batsman.getPlayer())).findFirst()
					.orElse(null);
			if (bowlers != null) {
				allRounderList.add(new IPLAllRounder(batsman.getPlayer(), batsman.getRuns(), bowlers.getWickets(),
						batsman.getAvg(), bowlers.getAvg()));
			}
		});
		return allRounderList;
	}
}