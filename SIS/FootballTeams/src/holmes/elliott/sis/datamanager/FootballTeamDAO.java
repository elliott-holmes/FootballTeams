package holmes.elliott.sis.datamanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import holmes.elliott.sis.datastore.DataStore;
import holmes.elliott.sis.model.FootballTeam;

public class FootballTeamDAO {
	
	private final static String SORT_CAPACITY = "capacity";
	private final static Logger LOG = Logger.getLogger(FootballTeamDAO.class.getName());
	
	/**
	 * Adds a football team to the data store
	 * @param newTeam
	 * @return true of succesful addition
	 */
	public boolean addFootballTeam(FootballTeam newTeam){
		LOG.info("Request to add new football team");
		LOG.fine(newTeam.getName());
		DataStore.getInstance().getFootballTeams().put(newTeam.getName(), newTeam);
		if(getFootballTeamByName(newTeam.getName()) == null){
		LOG.fine("Failed to add new team to store for reasons unknown");
			return false;
		}
		LOG.fine("Successfully added team to data store");
		return true;
	}
	
	
	/** 
	 * Returns the football team object based on the name
	 * @param name
	 * @return @FootballTeam
	 */
	public FootballTeam getFootballTeamByName(String name){
		LOG.info("Request to find football team : " + name);
		if (DataStore.getInstance().getFootballTeams().containsKey(name)){
			LOG.fine("Football team found : " + name);
			return DataStore.getInstance().getFootballTeams().get(name);	
		}else{
			LOG.fine("Unable to find football team : " + name);
			return null;
		}
		
	}
	
	/**
	 * Return a list of teams as they have been added to the collection
	 * @return @LinkedList<@FootballTeam>
	 */
	public LinkedList<FootballTeam> getAllTeams(){
		LOG.info("Request to get all teams");
		return new LinkedList<FootballTeam>(DataStore.getInstance().getFootballTeams().values());
	}
	
	/**
	 * Return a list of all teams sorted by the capapcity
	 * @return @LinkedList<@FootballTeam>
	 */
	public List<FootballTeam> getAllTeamsByCapacity(){
		LOG.info("Request to get teams by capacity");
		return getAllTeamsSorted(SORT_CAPACITY);
	}
	
	/**
	 * Sorts the results based on the key by adding a different parameter.
	 * @param sortKey
	 * @return
	 */
	private List<FootballTeam> getAllTeamsSorted(String sortKey){
		List<FootballTeam> returnList = getAllTeams();
				
		Comparator<FootballTeam> ordeComparator;
		switch (sortKey) {
		case (SORT_CAPACITY): 
			ordeComparator = new Comparator<FootballTeam>() {
				public int compare(FootballTeam f1, FootballTeam f2){
					return f2.getStadiumCapacity().compareTo(f1.getStadiumCapacity());
				}
			};
			break;
		default:
			ordeComparator = new Comparator<FootballTeam>() {
				public int compare(FootballTeam f1, FootballTeam f2){
					return f2.getName().compareTo(f1.getName());
				}
			};
			break;
		}
		Collections.sort(returnList, ordeComparator);		
		return returnList;
	}
}
