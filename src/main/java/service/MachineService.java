package service;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import beans.Machine;
import beans.Marque;
import connexion.Connexion;
import dao.IDao;

public class MachineService implements IDao<Machine> {

    @Override
    public boolean create(Machine o) {
        String sql = "insert into machine values (null, ?, ?, ?,?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getIdMarque());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean delete(Machine o) {
        String sql = "delete from machine where id  = ?";
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
    public boolean update(Machine o) {

        String sql = "update machine set reference  = ? ,dateAchat = ? , prix = ?, idMarque=? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getIdMarque());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public Machine findById(int id) {
        Machine m = null;
        String sql = "select * from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),rs.getInt("idMarque"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Machine> findAll() {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),rs.getInt("idMarque")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    
    public List<Machine> findAll2() {
    	MarqueService ms = new MarqueService();
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("idMarque"))));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    
    public List<Marque> findAllMarque() {
        List<Marque> marques = new ArrayList<Marque>();

        String sql = "select * from marque";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                marques.add(new Marque(rs.getInt("id"), rs.getString("libelle")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return marques;
    }
    
    public List<Machine> findMachineByReference(String ref) {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where reference =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, ref);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),rs.getInt("idMarque")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<String> findReference() {
        List<String> references = new ArrayList<String>();
        String sql = "select distinct(reference) as ref from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                references.add(rs.getString("ref"));
            }
        } catch (SQLException e) {
            System.out.println("findReference " + e.getMessage());
        }
        return references;
    }
    
    public List<Machine> findMachineByMarque(int idM) {
        List<Machine> machines = new ArrayList<Machine>();
        MarqueService ms = new MarqueService();
        String sql = "select * from machine where idMarque =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setInt(1, idM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("idMarque"))));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findMachineBetweenDate(String d1, String d2) {
    	MarqueService ms = new MarqueService();
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where dateAchat between ? and ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, d1);
            ps.setString(2, d2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("idMarque"))));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    
    public List<Machine> findAll3() {
    	MarqueService ms = new MarqueService();
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select m.id, m.reference, m.idMarque ,count(*) as count from machine m inner join marque ma on m.idMarque=ma.id group by m.idMarque";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"),
                        ms.findById(rs.getInt("idMarque")),rs.getInt("count")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public int countMachine() {
    	MarqueService ms = new MarqueService();
        int count = 0 ;

        String sql = "select count(*) as count from machine ";
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
