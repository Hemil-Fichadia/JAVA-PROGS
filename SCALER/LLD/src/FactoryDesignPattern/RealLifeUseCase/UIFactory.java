package FactoryDesignPattern.RealLifeUseCase;

import FactoryDesignPattern.RealLifeUseCase.Components.Button.Button;
import FactoryDesignPattern.RealLifeUseCase.Components.Dropdown.Dropdown;
import FactoryDesignPattern.RealLifeUseCase.Components.Menu.Menu;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
    Dropdown createDropdown();
}
