package repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Database;
import entities.Module;
public class ModuleRepository extends Database{
    
    private final String SQL_INSERT="INSERT INTO `module` (`nomModule`) VALUES (?)";
    private final String SQL_SELECT_ALL="SELECT * FROM `module`";
    
      public void insert(Module module){
        ouvrirConnexion();
        initPrepareStatement(SQL_INSERT);
          try {
             
             //statement.setString(1, professeur.getId());
             statement.setString(1, module.getNomModule());
              executeUpdate();
             fermerConnexion();
          } catch (Exception e) 
           {
            //System.out.println("Erreur de chargement du Driver");
            e.printStackTrace();
           }
          }

        public ArrayList<Module> selectAll() {
        ArrayList<Module> modules = new ArrayList<>();
        ResultSet rs = null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL);
            rs = executeSelect();
            while (rs.next()) {
                Module module = new Module();
                module.setId(rs.getInt("id_module"));
                module.setNomModule(rs.getString("nomModule"));
                modules.add(module);
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
        return modules;
    }
}
