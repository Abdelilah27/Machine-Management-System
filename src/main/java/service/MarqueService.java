package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Marque;
import connexion.Connexion;
import dao.IDao;

public class MarqueService implements IDao<Marque>  {

	@Override
	public boolean create(Marque o) {
		String sql = "insert into marque values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getLibelle());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean delete(Marque o) {
		String sql = "delete from marque where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean update(Marque o) {
		String sql = "update marque set code  = ? ,libelle = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getLibelle());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}
	
	public boolean update(Marque o, int id) {
		String sql = "update marque set code  = ? ,libelle = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getLibelle());
            ps.setInt(3, id);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public Marque findById(int id) {
		Marque m = null;
        String sql = "select * from marque where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Marque(rs.getInt("id"), rs.getString("code"), rs.getString("libelle"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Marque> findAll() {
		List<Marque> marques = new ArrayList<Marque>();

        String sql = "select * from marque";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                marques.add(new Marque(rs.getInt("id"), rs.getString("code"), rs.getString("libelle")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return marques;
	}
	
	
	
	public List<Marque> findMarqueByCode(String code) {
        List<Marque> marques = new ArrayList<Marque>();

        String sql = "select * from marque where code =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                marques.add(new Marque(rs.getInt("id"), rs.getString("code"), rs.getString("libelle")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return marques;
    }
	
	 public List<String> findCode() {
	        List<String> codes = new ArrayList<String>();
	        String sql = "select distinct(code) as co from marque";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                codes.add(rs.getString("co"));
	            }
	        } catch (SQLException e) {
	            System.out.println("findCode " + e.getMessage());
	        }
	        return codes;
	    }
	 
	 public int countMarque() {
	    	MarqueService ms = new MarqueService();
	        int count = 0 ;

	        String sql = "select count(*) as count from marque ";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                count = rs.getInt("count");
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }

	        return count;
	    }

}
