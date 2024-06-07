package FactoryDesignPattern.RealLifeUseCase;

public class Flutter {

     //Non-factory methods
     void refreshUI(){
         System.out.println("Refresh UI");
     }
     void setTheme(){
         System.out.println("Set theme");
     }
     public UIFactory getUIFactory(SupportedPlatforms platform){
        return UIFactoryFactory.getUIFactoryForPlatform(platform);
     }
}
