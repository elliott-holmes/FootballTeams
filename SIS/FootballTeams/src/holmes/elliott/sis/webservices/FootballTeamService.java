package holmes.elliott.sis.webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import holmes.elliott.sis.datamanager.FootballTeamDAO;
import holmes.elliott.sis.model.FootballTeam;

@Path("/Football")
public class FootballTeamService {

	/**
	 * Method to get a team by name
	 * @param team
	 * @return
	 */
	@Path("/getTeam/{team}")
	@GET
	@Produces("application/json")
	public Response getFootballTeamByName(@PathParam("team") String team){
		System.out.println("Retrieving football team : " + team);
		FootballTeamDAO dao = new FootballTeamDAO();
		FootballTeam footballTeam = dao.getFootballTeamByName(team);
		if (footballTeam == null){
			System.out.println("Team by the name of " + team + " could not be found");
			return Response.status(404).build();
		}
		String returnString = new Gson().toJson(footballTeam);
		return Response.status(200).entity(returnString).build();
	}
	
	/**
	 * Method to add a team
	 * @param jsonData
	 * @return
	 */
	@Path("/addTeam")
	@POST
	@Consumes("application/json")
	public Response addFootballTeam(String jsonData){
		try{
			Gson gson = new Gson();
			FootballTeam newTeam = gson.fromJson(jsonData, FootballTeam.class);
			FootballTeamDAO dao = new FootballTeamDAO();
			if (dao.addFootballTeam(newTeam)){
				return Response.status(200).build();				
			}else{
				System.err.println("Error adding football team with JSON : " + jsonData);
			}
		}catch(JsonSyntaxException jse){
			jse.printStackTrace();
		}
		return Response.status(400).build();	
		
	}
	/**
	 * Method to get all the teams
	 * @return
	 */
	@Path("/getTeams")
	@GET
	@Produces("application/json")
	public Response getAllTeams(){
		FootballTeamDAO dao = new FootballTeamDAO();
		List<FootballTeam> footballTeams = dao.getAllTeams();
		String returnString = new Gson().toJson(footballTeams);
		return Response.status(200).entity(returnString).build();
	}
	
	/**
	 * Method to get all the teams sorted by Capacity
	 * @return
	 */
	@Path("/getTeamsByCapacity")
	@GET
	@Produces("application/json")
	public Response getAllTeamsByCapacity(){
		FootballTeamDAO dao = new FootballTeamDAO();
		List<FootballTeam> footballTeams = dao.getAllTeamsByCapacity();
		String returnString = new Gson().toJson(footballTeams);
		return Response.status(200).entity(returnString).build();
	}


}
