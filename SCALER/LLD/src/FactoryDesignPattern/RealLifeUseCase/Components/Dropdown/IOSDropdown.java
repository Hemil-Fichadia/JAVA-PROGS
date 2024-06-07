package FactoryDesignPattern.RealLifeUseCase.Components.Dropdown;

public class IOSDropdown implements Dropdown{
    @Override
    public void showDropdown() {
        System.out.println("Showing IOS dropdown");
    }
}
