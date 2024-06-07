package FactoryDesignPattern.RealLifeUseCase;

import FactoryDesignPattern.RealLifeUseCase.Components.Button.Button;
import FactoryDesignPattern.RealLifeUseCase.Components.Button.IOSButton;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.Dropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.IOSDropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Menu.Menu;

public class IOSUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return null;
    }

    @Override
    public Dropdown createDropdown() {
        return new IOSDropdown();
    }
}
