package FactoryDesignPattern.RealLifeUseCase;

import FactoryDesignPattern.RealLifeUseCase.Components.Button.Button;
import FactoryDesignPattern.RealLifeUseCase.Components.Button.WindowsButton;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.Dropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.WindowsDropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Menu.Menu;

public class WindowsUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return null;
    }

    @Override
    public Dropdown createDropdown() {
        return new WindowsDropdown();
    }
}
