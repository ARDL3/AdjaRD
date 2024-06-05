package services;
import java.util.List;
import entities.Module;
import repositories.ModuleRepository;

public class ModuleService {

    private ModuleRepository moduleRepository=new ModuleRepository();
         public ModuleService() {
    }
        public void addModule(Module module){
            moduleRepository.insert(module);
         }
         public List<Module> listerModules(){
            return moduleRepository.selectAll();
         }
}
