package holmes.elliott.sis.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.sis.datamanager.FootballTeamDAO;
import holmes.elliott.sis.model.FootballTeam;

public class FootballTeamDAOTest {

	
	FootballTeamDAO ftDAO = new FootballTeamDAO();
	
	@Before
	public void setUp() throws Exception {
		//Add A few entries first
		FootballTeam scfc = new FootballTeam();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1883);
		scfc.setName("Stockport County");
		scfc.setCompetition("Non League");
		scfc.setDateOfCreation(cal.getTime());
		scfc.setCity("Stockport");
		scfc.setNumberOfPlayers(19);
		scfc.setOwner("Elliott Holmes");
		scfc.setStadiumCapacity(new BigInteger("12000"));

		FootballTeam mancity = new FootballTeam();
		cal.set(Calendar.YEAR, 2007);
		mancity.setName("Manchester City");
		mancity.setCompetition("Premier League");
		mancity.setDateOfCreation(cal.getTime());
		mancity.setCity("Manchester");
		mancity.setNumberOfPlayers(71);
		mancity.setOwner("Sheikh Mansour");
		mancity.setStadiumCapacity(new BigInteger("42000"));
		
		FootballTeam liverpool = new FootballTeam();
		cal.set(Calendar.YEAR, 1892);
		liverpool.setName("Liverpool");
		liverpool.setCompetition("Premier League");
		liverpool.setDateOfCreation(cal.getTime());
		liverpool.setCity("Liverpool");
		liverpool.setNumberOfPlayers(28);
		liverpool.setOwner("John W. Henry");
		liverpool.setStadiumCapacity(new BigInteger("52000"));
		ftDAO.addFootballTeam(scfc);
		ftDAO.addFootballTeam(mancity);
		ftDAO.addFootballTeam(liverpool);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddFootballTeam() {
		FootballTeam chelsea = new FootballTeam();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2002);
		chelsea.setName("Chelsea");
		chelsea.setCompetition("Premier League");
		chelsea.setDateOfCreation(cal.getTime());
		chelsea.setCity("London");
		chelsea.setNumberOfPlayers(32);
		chelsea.setOwner("Roman Abramohvich");
		chelsea.setStadiumCapacity(new BigInteger("48000"));

		assertTrue(ftDAO.addFootballTeam(chelsea));
	}

	@Test
	public void testGetFootballTeamByName() {
		//should be null as team name is incorrect
		FootballTeam testTeam = ftDAO.getFootballTeamByName("chelsea");
		assertTrue(testTeam == null);
		testTeam = ftDAO.getFootballTeamByName("Chelsea");
		assertTrue(testTeam.getCity().equals("London"));

	}

	@Test
	public void testGetAllTeams() {
		List<FootballTeam> allteams = ftDAO.getAllTeams();
		//should get Stockport, City, Liverpool, Chelsea
		assertTrue(allteams.size() == 4);
		assertTrue(allteams.get(0).getName().equals("Stockport County"));
		assertTrue(allteams.get(1).getName().equals("Manchester City"));
		assertTrue(allteams.get(2).getName().equals("Liverpool"));
		assertTrue(allteams.get(3).getName().equals("Chelsea"));
		
	}

	@Test
	public void testGetAllTeamsByCapacity() {
		List<FootballTeam> allteams = ftDAO.getAllTeamsByCapacity();
		//should get Liverpool, Chelsea, City, Stockport
		assertTrue(allteams.size() == 4);
		assertTrue(allteams.get(0).getName().equals("Liverpool"));
		assertTrue(allteams.get(1).getName().equals("Chelsea"));
		assertTrue(allteams.get(3).getName().equals("Stockport County"));
		//Sorry Couldn't bring myself to put city above stockport.
		assertTrue(allteams.get(2).getName().equals("Manchester City"));
	}

}
