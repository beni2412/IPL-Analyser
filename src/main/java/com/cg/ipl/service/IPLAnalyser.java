package com.cg.ipl.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.cg.csvbuilder.CSVBuilderFactory;
import com.cg.csvbuilder.ICSVBuilder;
import com.cg.ipl.dto.*;
import com.cg.ipl.dto.IPLException.ExceptionType;
import com.opencsv.exceptions.CsvException;


public class IPLAnalyser {

	public static List<IPLBatsmen> batsmenList;
	public static List<IPLBowler> bowlersList;

	public IPLAnalyser() {
		batsmenList = null;
		bowlersList = null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> readData(String DATA_FILE, String type) throws IPLException {
		if (!DATA_FILE.contains(".csv")) {
			throw new IPLException(ExceptionType.INVALID_FILE_TYPE,
					"Invalid File Type!! Exception thrown....");
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
				}  catch (CsvException e) {
					throw new IPLException(ExceptionType.INVALID_CLASS_TYPE,
							"Invalid Class Type!! Exception thrown... ");
				}
			} else {
				throw new IPLException(ExceptionType.INVALID_PLAYER_TYPE,
						"Invalid player type!! Exception thrown... ");
			}

		} catch (IOException e) {
			throw new IPLException(ExceptionType.INVALID_FILE_PATH,
					"Invalid file location given!! Exception thrown...");
		}

	}
}