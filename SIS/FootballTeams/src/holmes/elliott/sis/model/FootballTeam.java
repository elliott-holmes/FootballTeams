package holmes.elliott.sis.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import holmes.elliott.sis.interfaces.TeamInterface;

public class FootballTeam implements TeamInterface, Serializable {

	private static final long serialVersionUID = 2609951496647053136L;

	private String name;
	private String city;
	private String owner;
	private BigInteger stadiumCapacity;
	private String competition;
	private Integer numberOfPlayers;
	private Date dateOfCreation;
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the stadiumCapacity
	 */
	public BigInteger getStadiumCapacity() {
		return stadiumCapacity;
	}

	/**
	 * @param stadiumCapacity the stadiumCapacity to set
	 */
	public void setStadiumCapacity(BigInteger stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
	}

	/**
	 * @return the competition
	 */
	public String getCompetition() {
		return competition;
	}

	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(String competition) {
		this.competition = competition;
	}

	/**
	 * @return the numberOfPlayers
	 */
	public Integer getNumberOfPlayers() {
		return numberOfPlayers;
	}

	/**
	 * @param numberOfPlayers the numberOfPlayers to set
	 */
	public void setNumberOfPlayers(Integer numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	/**
	 * @return the dateOfCreation
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	/**
	 * @param dateOfCreation the dateOfCreation to set
	 */
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}	
}
