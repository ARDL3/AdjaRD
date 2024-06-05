package services;

import java.util.List;

import entities.Cours;
import repositories.CoursRepository;

public class CoursService {
    public CoursService() {
    }
    private CoursRepository coursRepository=new CoursRepository();
         public void addClasse(Cours cours){
            coursRepository.insert(cours);
         }
         public List<Cours> listerCours(){
            return coursRepository.selectAll();
         }
        public void addCours(Cours cours) {
            coursRepository.insert(cours);
            }
        public List<Cours> listCours() {
            return coursRepository.selectAll();
           }
        
          
}
