package it.unina.IS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


import it.unina.IS.entity.Fiori;

public class FioriDAO {

	
	
	public void createTable() throws SQLException {
		Connection conn = DBManager.getConnection();
		Statement stmt = conn.createStatement();
		String query = "CREATE TABLE FIORI ("
				+ "NOME VARCHAR(30), "
				+ "ORIGINEGEOGRAFICA VARCHAR(30),"
				+ "PREZZO INT,"
				+ "QUANTITA INT,"
				+ "COLORE VARCHAR(30)"
				+ ");";
		
		stmt.executeUpdate(query);
		
	}

	public void dropTable() throws SQLException {
		Connection conn = DBManager.getConnection();
		Statement stmt = conn.createStatement();
		String query = "DROP TABLE FIORI";
		
		stmt.executeUpdate(query);
		
	}

	public Fiori createFiore(Fiori fiore) throws SQLException {
		
		
		Connection conn = DBManager.getConnection();
		String query = "INSERT INTO FIORI VALUES (?,?,?,?,?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(query)){
			
			pstmt.setString(1, fiore.getNome());
			pstmt.setString(2, fiore.getOrigineGeografica());
			pstmt.setInt(3, fiore.getPrezzo());
			pstmt.setInt(4, fiore.getQuantita());
			pstmt.setString(5, fiore.getColore());
			
			pstmt.executeUpdate();
			
		}		
		
		
		System.out.println("Inserimento del fiore '"+fiore.getNome()+"' riuscito \n");
		return fiore;
	}


	public LinkedList<Fiori> readAll() throws SQLException{
		LinkedList<Fiori> fiori = new LinkedList<Fiori>();
		
		Connection conn = DBManager.getConnection();
		String query = "SELECT * FROM FIORI";
		
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			
			
			try(ResultSet result = pstmt.executeQuery()){
				
			
			
				while (result.next()) {
					Fiori tmp= new Fiori();
					tmp.setNome(result.getString(1));
					tmp.setOrigineGeografica(result.getString(2));
					tmp.setPrezzo(result.getInt(3));
					tmp.setQuantita(result.getInt(4));
					tmp.setColore(result.getString(5));

					fiori.add(tmp);

				}

			}
			
		} 
		
		return fiori;
	}

	public void updateFiori(Fiori fiore) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		String query = "UPDATE FIORI SET ORIGINEGEOGRAFICA=?, PREZZO =?, QUANTITA=?, COLORE=? WHERE NOME =? ";
		
		try(PreparedStatement pstmt = conn.prepareStatement(query)){
			
			pstmt.setString(5, fiore.getNome());
			pstmt.setString(1, fiore.getOrigineGeografica());
			pstmt.setInt(2, fiore.getPrezzo());
			pstmt.setInt(3, fiore.getQuantita());
			pstmt.setString(4, fiore.getColore());
			
			pstmt.executeUpdate();
			
		}		

	}
		
		public void deleteFiori (Fiori fiore) throws SQLException{

			Connection conn = DBManager.getConnection();
			String query = "DELETE FROM FIORI WHERE NOME =?";
			
			try(PreparedStatement pstmt=conn.prepareStatement(query)){
				
				pstmt.setString(1, fiore.getNome());
				
				pstmt.executeUpdate();
			}
			
		}
		
		
	}
	

