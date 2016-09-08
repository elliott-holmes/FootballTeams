package holmes.elliott.sis.datamanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import holmes.elliott.sis.datastore.DataStore;
import holmes.elliott.sis.model.FootballTeam;

public class FootballTeamDAO {
	
	private final static String SORT_CAPACITY = "capacity";
	
	
	/**
	 * Adds a football team to the data store
	 * @param newTeam
	 * @return true of succesful addition
	 */
	public boolean addFootballTeam(FootballTeam newTeam){
		
		DataStore.getInstance().getFootballTeams().put(newTeam.getName(), newTeam);
		if(getFootballTeamByName(newTeam.getName()) == null){
			return false;
		}
		return true;
	}
	
	
	/** 
	 * Returns the football team object based on the name
	 * @param name
	 * @return @FootballTeam
	 */
	public FootballTeam getFootballTeamByName(String name){
		return DataStore.getInstance().getFootballTeams().get(name);
	}
	
	/**
	 * Return a list of teams as they have been added to the collection
	 * @return @LinkedList<@FootballTeam>
	 */
	public LinkedList<FootballTeam> getAllTeams(){
		return new LinkedList<FootballTeam>(DataStore.getInstance().getFootballTeams().values());
	}
	
	/**
	 * Return a list of all teams sorted by the capapcity
	 * @return @LinkedList<@FootballTeam>
	 */
	public List<FootballTeam> getAllTeamsByCapacity(){
		return getAllTeamsSorted(SORT_CAPACITY);
	}
	
	
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
