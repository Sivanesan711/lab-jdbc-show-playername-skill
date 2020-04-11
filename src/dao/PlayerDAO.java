package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO
{
	public List<Player> getAllPlayers() throws SQLException, Exception
	{
		List<Player> list = new ArrayList<Player>();
		Skill skill = null;
		
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		String sql = "select * from player";
		
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			Player player = new Player(null, sql, sql, skill);
			skill = new Skill(null, sql);
			
			player.setPlayerId(rs.getLong("id"));
			player.setName(rs.getString("name"));
			player.setCountry(rs.getString("country"));
			skill.setSkillId(rs.getLong("skill_id"));
			player.setSkill(skill);
			list.add(player);
		}
		
		return list;
		
	}
}
