package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pie;

public class PieDao {
	
	private Connection connection;
	private final String GET_PIES_QUERY = "SELECT * FROM pies";
	private final String GET_PIE_BY_ID_QUERY = "SELECT * FROM pies WHERE id = ?";
	private final String CREATE_NEW_PIE_QUERY = "INSERT INTO pies(pie_type) VALUES(?)";
	private final String DELETE_PIE_BY_TYPE_QUERY = "DELETE FROM pies WHERE id = ?";
//establish DB connection
	public PieDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Pie> getPies() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_PIES_QUERY).executeQuery();
		List<Pie> pies = new ArrayList<Pie>();
		
		while (rs.next()) {
			pies.add(populatePie(rs.getInt(1), rs.getString(2)));
		}
		
		return pies;
	}
	
	public Pie getPieById(int pieId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PIE_BY_ID_QUERY);
		ps.setInt(1, pieId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePie(rs.getInt(1), rs.getString(2)); 
	}
	
	public void createNewPie(String pieType) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PIE_QUERY);
		ps.setString(1, pieType);
		ps.executeUpdate();
	}
	
	public void deletePieById(int pieId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PIE_BY_TYPE_QUERY);
		ps.setInt(1, pieId);
		ps.executeUpdate();
	}
	
	private Pie populatePie(int pieId, String pieType) {
		return new Pie(pieId, pieType); 
	}

}
