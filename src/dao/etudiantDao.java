package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.DbConnection;
import metier.etudiant;

public class etudiantDao implements Dao<etudiant> {
	private Connection con = null;
	private String requet = null;
	private Statement stm = null;

	public EtudiantDao() throws SQLException {
		super();
		// Etape 3: Etablire une Connection
		con = DatabaseConnection.getConnection();
		// Etape 4: Créer un conteneur de requête
		stm = con.createStatement();
	}

	@Override
    public Etudiant get(long id) {

        String cmd = "SELECT * FROM etudiants WHERE matricule = " + id + ";";

        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            ResultSet res = st.executeQuery();
            res.next();
            //etud.setId(res.getInt("id"));
            //etud.setName(res.getString("name"));
            return new Etudiant(res.getInt("matricule"), res.getString("nom"));
        } catch (SQLException e) {
            System.out.println(e);
            return new Etudiant((int) id);
        }


    }

	

    @Override
    public List<Etudiant> getAll() {
        String cmd = "SELECT * FROM etudiants;";
        // liste des etudiants
        List<Etudiant> listE = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(cmd);
            // tableau de contenu
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Etudiant e = new Etudiant(res.getInt("matricule"), res.getString("nom"));
                listE.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listE;
    }

    @Override
    public void save(Etudiant t) {
        String cmd = String.format("INSERT INTO etudiants VALUES(%d, '%s');", t.getId(), t.getName());
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
    public void update(Etudiant t, String[] params) {
        String cmd = String.format("UPDATE etudiants SET nom = '%s' WHERE matricule = %d", params[0], t.getId());
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
    public void delete(Etudiant t) {
        String cmd = "DELETE FROM etudiants WHERE matricule = " + t.getId();
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