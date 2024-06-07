package FactoryDesignPattern.RealLifeUseCase;

import FactoryDesignPattern.RealLifeUseCase.Components.Button.AndroidButton;
import FactoryDesignPattern.RealLifeUseCase.Components.Button.Button;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.AndroidDropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.Dropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return null;
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
