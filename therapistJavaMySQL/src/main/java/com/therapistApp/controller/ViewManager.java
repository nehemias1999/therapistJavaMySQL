package com.therapistApp.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import therapist_desktopJavaApp.view.MainFRM;
import therapist_desktopJavaApp.exception.ValidationException;
import therapist_desktopJavaApp.model.dto.in.CityDTOIN;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;
import therapist_desktopJavaApp.view.ShowCalendarPNL;
import therapist_desktopJavaApp.view.ShowConfigurationPNL;
import therapist_desktopJavaApp.view.ShowPatientsPNL;
import therapist_desktopJavaApp.view.SidebarPNL;

public class ViewManager {
	
	private Controller controller;
	
	// Frame principal
	
	private MainFRM mainFRM;
	private final CardLayout cardLayout;
    private final JPanel contentPanel;
	private SidebarPNL sidebarPNL;

	public ViewManager(Controller controller) {
		this.controller = controller;
		this.mainFRM = new MainFRM();
		
		cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
		mainFRM.add(contentPanel, BorderLayout.CENTER);
		
		this.sidebarPNL = new SidebarPNL(cardLayout, contentPanel);
		mainFRM.add(sidebarPNL, BorderLayout.WEST);
		
		registerView("Ver calendario", new ShowCalendarPNL(), "");
		registerView("Ver pacientes", new ShowPatientsPNL(), "");
		registerView("Ver configuracion", new ShowConfigurationPNL(), "");
        
		mainFRM.setVisible(true);
		
	}
			
    public void registerView(String name, JPanel panel, String iconPath) {
        contentPanel.add(panel, name);
        sidebarPNL.addMenuItem(name, iconPath);
    }		
		
	public void showPnlMainMenu() {
		mainFRM.showPanel("MainMenu");
	}

	public void showPnlLoadPatient() {
		mainFRM.showPanel("LoadPatient");
	}
	
	public List<CountryDTOIN> getAllCountriesDTO() {
		return controller.getAllCountriesDTO();
	}
	
	public List<ProvinceDTOIN> getProvincesDTOByCountryId(String countryId) {
		return controller.getProvincesDTOByCountryId(countryId);
	}
		
	public List<CityDTOIN> getCitiesDTOByProvinceId(String provinciaId) {
		return controller.getCitiesDTOByProvinceId(provinciaId);
	}
	
	public void insertPatient(
			String patientDNI, 
			String patientName, 
			String patientLastName, 
			String patientBirthDate, 
			String patientEmail,
			String patientAddress, 
			String patientAddressNumber, 
			String patientAddressFloor, 
			String patientAddressApartment,
			String countryId, 
			String provinceId, 
			String cityId) throws SQLException, ValidationException {
		
		controller.insertPatient(
				patientDNI, 
        		patientName, 
        		patientLastName, 
        		patientBirthDate, 
        		patientEmail, 
        		patientAddress, 
        		patientAddressNumber, 
        		patientAddressFloor, 
        		patientAddressApartment, 
        		countryId, 
        		provinceId, 
        		cityId);
		
	}
	
	public void showPnlViewCalendar() {
		mainFRM.showPanel("ViewCalendar");
	}
	
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
            mainFRM,                    
            message,                 
            "Error",              
            JOptionPane.ERROR_MESSAGE  
        );
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(
            mainFRM,                    
            message,                 
            "Exito",              
            JOptionPane.OK_OPTION
        );
    }
    
    public void showInformationMessage(String message) {
        JOptionPane.showMessageDialog(
            mainFRM,
            message,
            "Información",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
	
}