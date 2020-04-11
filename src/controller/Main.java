package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;

public class Main
{
	public static void main(String[] args) throws SQLException, Exception
	{
		SkillDAO skldao = new SkillDAO();
		PlayerDAO plyrdao = new PlayerDAO();
		
		System.out.println("LIST PLAYERS WITH SKILL");
			
		List<Player> list = new ArrayList<Player>();
		list = plyrdao.getAllPlayers();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(i+1 + " " + list.get(i).getName() + " " + list.get(i).getCountry() + " " + skldao.getSkillBylD(list.get(i).getSkill().getSkillId()));
		}
	}
}
