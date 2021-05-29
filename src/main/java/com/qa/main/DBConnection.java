package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.utils.DBConfig;

public class DBConnection {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public DBConnection() throws SQLException {
		con = DriverManager.getConnection(DBConfig.url, DBConfig.user, DBConfig.pw);
	}

	public void create(String name) throws SQLException {
		String sql = "INSERT INTO people (name) VALUES (?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.execute();
	}

	public void readAll() throws SQLException {
		String sql = "SELECT * FROM people";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		if (!rs.next()) {
			System.out.println("Nothing found");
		} else {
			do {
				System.out.println(String.format("ID %d, name %s", rs.getInt("id"), rs.getString("name")));
			} while (rs.next());
		}
	}

	public void readOne(int id) throws SQLException {
		String sql = "SELECT * FROM people where id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		if (!rs.next()) {
			System.out.println("Nothing found");
		} else {
			do {
				System.out.println(String.format("ID %d, name %s", rs.getInt("id"), rs.getString("name")));
			} while (rs.next());
		}
	}

	public void update(int uId, String name) throws SQLException {
		String sql = "UPDATE people set name = ? WHERE id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, uId);
		ps.execute();
	}

	public void delete(int id2) throws SQLException {
		String sql = "DELETE FROM people WHERE id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id2);
		ps.execute();
	}

	public void tearDown() throws SQLException {
		con.close();
	}

}
