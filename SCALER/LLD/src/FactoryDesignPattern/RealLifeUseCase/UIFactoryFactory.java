package FactoryDesignPattern.RealLifeUseCase;

public class UIFactoryFactory {
    public static UIFactory getUIFactoryForPlatform(SupportedPlatforms platform){
        if(platform.equals(SupportedPlatforms.ANDROID)){
            return new AndroidUIFactory();
        }
        else if(platform.equals(SupportedPlatforms.IOS)){
            return new IOSUIFactory();
        }
        else if(platform.equals(SupportedPlatforms.WINDOWS)){
            return new WindowsUIFactory();
        }
        return null;
    }
}
