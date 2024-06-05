package repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Database;
import entities.Cours;

public class CoursRepository extends Database {
    
    private final String SQL_INSERT="INSERT INTO `cours` (`date` ,`HeureD` ,`HeureF`) VALUES (?,?,?)";
    private final String SQL_SELECT_ALL="SELECT * FROM `cours`";
    
      public void insert(Cours cours){
        ouvrirConnexion();
        initPrepareStatement(SQL_INSERT);
          try {
             statement.setDate(1,java.sql.Date.valueOf(cours.getDate()));
             statement.setTime(2, java.sql.Time.valueOf(cours.getHeureD()));
             statement.setTime(3, java.sql.Time.valueOf(cours.getHeureF()));
              executeUpdate();
             fermerConnexion();
          } catch (Exception e) 
           {
            //System.out.println("Erreur de chargement du Driver");
            e.printStackTrace();
           }
          }

        public List<Cours> selectAll() {
        List<Cours> cours = new ArrayList<>();
        ResultSet rs = null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL);
            rs = executeSelect();
            while (rs.next()) {
                Cours cours1 = new Cours();
                cours1.setId(rs.getInt("id_module"));
                cours1.setDate(null);
                cours.add(cours1);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la sélection des classes : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture du ResultSet : " + e.getMessage());
                e.printStackTrace();
            }
            try {
                fermerConnexion();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                e.printStackTrace();
            }
        }
        return cours;
    }
}
