package FactoryDesignPattern.RealLifeUseCase.Components.Dropdown;

public class WindowsDropdown implements Dropdown{
    @Override
    public void showDropdown() {
        System.out.println("Showing windows dropdown");
    }
}
