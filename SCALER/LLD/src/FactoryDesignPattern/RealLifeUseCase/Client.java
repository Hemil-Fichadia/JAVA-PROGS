package FactoryDesignPattern.RealLifeUseCase;

import FactoryDesignPattern.RealLifeUseCase.Components.Button.Button;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.Dropdown;

public class Client {
    public static void main(String[] args){
        /* Real life use case of Factory design pattern is for building cross-platform
        languages like Flutter.

        Starting from a simple idea of a button, there will be different kind of button
        implementation in all OS namely ios, Android and windows, so we have a method called createButton()
        which will return a Button which is of type interface means Button is an interface and that will be
        implemented by all OS buttons so createButton() can return Android Button, ios Button or
        windows button.

        Assume there is a Flutter class which have createButton() method which is of return type Button
        which is an interface that is implemented by all Buttons across platform like Android, ios and
        windows. So this createButton(platform) needs to accept platform as a parameter to compare
        the platform type and return corresponding button, there are other kind of components like
        Menu createMenu(platform), Dropdown createDropdown(platform) etc., so due to these components
        containing a lot of if else conditions they are violating SRP and OCP principles so these methods
        are supposed to be implemented in corresponding OS class like windows, Android and ios will
        implement these components on their own way.

        Now these components delivering methods are factory methods and all are present Flutter class
        as there are some other methods like void refreshUI(), void setTheme(), etc these are non-factory
        methods, and Flutter class is supposed to be having only non-factory methods, so we need to create
        separate entity or an interface <<UIFactory>>

        Flutter {
            void refreshUI();
            void setTheme();
            UIFactory getUIFactory(){
                return new UIFactory(platform);
            }
        }
        UIFactory{
            Button createButton(platform);
            Menu createMenu(platform);
            Dropdown createDropdown(platform);
        }
        There are OS specific class like AndroidUIFactory, WindowsUIFactory and IOSUIFactory these all
        implement UIFactory interface so on summoned, class will return corresponding factory. Now just
        like DatabaseFactory we need to get UIFactory object form Flutter class so create a method
        UIFactory getUIFactory() which will returns UIFactory object and this will help in accessing
        corresponding class components like this :-

        Flutter flutter = new Flutter();
        UIFactory uifactory = new flutter.getUIFactory(Android);
        Button button = uifactory.createButton(); <-- this will return Android button
        * */
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.getUIFactory(SupportedPlatforms.ANDROID);

        Button button = uiFactory.createButton();
        button.clickButton();

        Dropdown dropdown = uiFactory.createDropdown();
        dropdown.showDropdown();
    }
}
