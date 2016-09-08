package holmes.elliott.sis.datastore;

import java.util.LinkedHashMap;

import holmes.elliott.sis.model.FootballTeam;

public class DataStore {

	private static final DataStore INSTANCE = new DataStore();
	
	/*
	 * Private Constructor to prevent additional instantiation
	 */
	private DataStore(){}
	
	public static DataStore getInstance(){
		return INSTANCE;
	}
	
	private LinkedHashMap<String, FootballTeam> footballTeams;
	
	public LinkedHashMap<String, FootballTeam> getFootballTeams(){
		if (footballTeams==null){
			//first access so instantiate the object
			footballTeams = new LinkedHashMap<String, FootballTeam>();
		}
		return footballTeams;
	}
}
