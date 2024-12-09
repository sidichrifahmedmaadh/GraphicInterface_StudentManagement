package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.DbConnection;
import metier.departement;

public class departementDao implements Dao<departement> {
	private Connection con = null;
	private String requet = null;
	private Statement stm = null;

	public departementDao() throws SQLException {
		super();
		// Etape 3: Etablire une Connection
		con = DbConnection.getConnection();
		// Etape 4: Créer un conteneur de requête
		stm = con.createStatement();
	}

	@Override
    public departement get(long id) {

        String cmd = "SELECT * FROM departement WHERE matricule = " + id + ";";

        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            ResultSet res = st.executeQuery();
            res.next();
            //etud.setId(res.getInt("id"));
            //etud.setName(res.getString("name"));
            return new departement(res.getInt("matricule"), res.getString("nom"));
        } catch (SQLException e) {
            System.out.println(e);
            return new departement((int) id);
        }


    }

	

    @Override
    public List<departement> getAll() {
        String cmd = "SELECT * FROM departements;";
        // liste des departements
        List<departement> listE = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            // tableau de contenu
            ResultSet res = st.executeQuery();
            while (res.next()) {
                departement e = new departement(res.getInt("matricule"), res.getString("nom"));
                listE.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listE;
    }

    @Override
    public void save(departement t) {
        String cmd = String.format("INSERT INTO departements VALUES(%d, '%s');", t.getId(), t.getName());
        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            int res = st.executeUpdate();
            if (res > 0) System.out.println("Insert Sucess");
            else System.out.println("insert failed");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void update(departement t, String[] params) {
        String cmd = String.format("UPDATE departements SET nom = '%s' WHERE idDep = %d", params[0], t.getId());
        System.out.println("Previous" + t);
        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            int res = st.executeUpdate();
            if (res > 0) System.out.println("Update Succesfull");
            else System.out.println("Update UNsuccesfull");
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Updated" + t);

    }

    @Override
    public void delete(departement t) {
        String cmd = "DELETE FROM departements WHERE matricule = " + t.getId();
        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            int res = st.executeUpdate();
            if (res > 0) System.out.println("DELETE Sucess");
            else System.out.println("DELETE failed");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}