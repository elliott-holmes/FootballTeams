package holmes.elliott.sis.datastore;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

import holmes.elliott.sis.model.FootballTeam;

public class DataStore {

	private static final DataStore INSTANCE = new DataStore();
	private final static Logger LOG = Logger.getLogger(DataStore.class.getName());
	
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
			LOG.info("Instantiating football team object");
			//first access so instantiate the object
			footballTeams = new LinkedHashMap<String, FootballTeam>();
		}
		LOG.info("Request to get football teams. Current Size : " + footballTeams.size());
		return footballTeams;
	}
}
