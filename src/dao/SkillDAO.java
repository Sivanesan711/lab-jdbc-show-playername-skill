package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	public Skill getSkillBylD(Long id) throws SQLException, Exception
	{
		
		
		Skill skill = null;
		
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		String sql = "select name from skill";
		
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			skill = new Skill(null, sql);
			
			System.out.println(rs.getString("name"));
			skill.setSkillName(rs.getString("name"));
		}
		
		rs.close();
		st.close();
		con.getConnection().close();
		return skill;
		
	}
}
