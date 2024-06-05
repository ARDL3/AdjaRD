import java.util.List;
import java.util.Scanner;
import entities.Module;
import entities.Cours;
//import entities.Professeur;
import services.CoursService;
import services.ModuleService;
//import services.ProfesseurService;

public class App {
    public static void main(String[] args) throws Exception {
    ModuleService moduleService = new ModuleService();
    //ProfesseurService professeurService = new ProfesseurService();
    CoursService coursService = new CoursService();
    Scanner scanner = new Scanner(System.in);  
    int choix;
        do {
            System.out.println("++++++++GESTION DES COURS++++++++");
            System.out.println("1-Ajouter un Module");
            System.out.println("2-Lister les Modules");
            System.out.println("3-Créer un Cours");
            System.out.println("4-Lister tous les Cours");
            System.out.println("5-Lister les Cours d'un Module et d'un Professeur");
            System.out.println("6-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:

                    Module module = new Module();
                    System.out.println("Entrer le libellé");
                    module.setNomModule(scanner.nextLine());
                    moduleService.addModule(module);
                    break;
                case 2:
                    List<Module> modules = moduleService.listerModules();
                    for (Module m : modules) {
                        System.out.println("id: " + m.getId());
                        System.out.println("Classe: " + m.getNomModule());
                        System.out.println("==================================");
                    }
                    break;
                case 3:
                    Cours cours = new Cours();
                    System.out.println("Entrer un ID");
                    cours.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Entrer la Date");
                        cours.setDate(null);scanner.nextLine();
                        System.out.println("Entrer l'heure de début");
                        cours.setHeureD(null);scanner.nextLine();
                        System.out.println("Entrer l'heure de fin");
                        cours.setHeureF(null);
                        scanner.nextLine();
                        coursService.addCours(cours);
                    
                    break; 
                case 4:
                    List<Cours> courss = coursService.listCours();
                    for (Cours c : courss) {
                        //System.out.println("Nci: " + pr.getNci());
                        System.out.println("Date: " + c.getDate());
                        System.out.println("heure Début: " + c.getHeureD());
                        System.out.println("heure de fin: " + c.getHeureF());
                        System.out.println("==================================");
                    }
                    break;
                case 5:
                   
                    break;
            }
        } while (choix != 6);
        scanner.close();
    }
}
