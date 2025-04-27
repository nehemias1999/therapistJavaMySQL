package com.therapistApp.controller;

import java.sql.SQLException;

import com.therapistApp.exception.ValidationException;
import com.therapistApp.model.dto.*;
import com.therapistApp.service.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller2 {

	private ViewController viewController;

	private CityService cityService;
	private PatientService patientService;
	private ConsultationService consultationService;
	
//    private ViewManager viewManager;
    
    public Controller2() {
		this.viewController = new ViewController();

    	this.cityService = new CityService();
		this.patientService = new PatientService();
		this.consultationService = new ConsultationService();

//		this.insertCity(
//				"Olavarria",
//				"8000"
//		);

//		this.insertPatient(
//				"41545496",
//				"Nehemias",
//				"Salazar",
//				"1999-01-21",
//				"2494555928",
//				"nehemias@gmail.com",
//				"7c246d6d-3fef-46fa-a1cb-29c7aa849d82",
//				"cangallo",
//				"564",
//				"",
//				""
//		);

//		this.insertConsultation(
//				"8b26614e-52b3-49f4-9169-d72f7e044fc6",
//				"2025-04-26T14:00:00",
//				"2025-04-26T15:00:00",
//				"SCHEDULED",
//				"C:\\Users\\nsalazar\\Documents\\java",
//				"10000.00",
//				"false"
//		);

    }

	public void init(Stage stage) {
		Scene scene = new Scene(viewController.getRoot(), 1200, 800);
		stage.setTitle("Mi Aplicación de Terapia");
		stage.setScene(scene);
		stage.show();
	}

    public void insertPatient(
    		String patientDNI, 
			String patientName, 
			String patientLastName, 
			String patientBirthDate,
			String patientPhone,
			String patientEmail,
			String cityId,
			String patientAddress, 
			String patientAddressNumber, 
			String patientAddressFloor, 
			String patientAddressApartment
    ) throws SQLException, ValidationException {
        
        if (!patientDNI.matches("\\d{8}")) {
            //viewManager.showErrorMessage("Numero de documento ingresado invalido."); return;
        }
        
        if (patientName.isEmpty() || patientName.length()>50) {
        	//viewManager.showErrorMessage("Nombre ingresado inválido."); return;
        }
        
        if (patientLastName.isEmpty() || patientLastName.length()>50) {
        	//viewManager.showErrorMessage("Apellido ingresado inválido."); return;
        }
        
        if (patientBirthDate.isEmpty()) {
        	//viewManager.showErrorMessage("Fecha de nacimiento ingresada inválida."); return;
        }

		if (patientPhone.isEmpty()) {
			//viewManager.showErrorMessage("Numero de celular ingresado inválido."); return;
		}

        if (!patientEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
        	//viewManager.showErrorMessage("Email ingresado inválido."); return;
        }

		if (cityId.isEmpty()) {
			//viewManager.showErrorMessage("Ciudad ingresada ingresada inválida."); return;
		}
        
        if (patientAddress.isEmpty() || patientAddress.length()>50) {
        	//viewManager.showErrorMessage("Dirección ingresada inválida."); return;
        }
        
        if (patientAddressNumber.isEmpty()) {
        	//viewManager.showErrorMessage("Numero de direccion ingresado inválido."); return;
        }

        patientService.insertPatient(new PatientDTO(
        		patientDNI, 
        		patientName, 
        		patientLastName, 
        		patientBirthDate,
				patientPhone,
        		patientEmail,
				cityId,
        		patientAddress, 
        		patientAddressNumber, 
        		patientAddressFloor, 
        		patientAddressApartment
		));
        
        //viewManager.showSuccessMessage("Paciente ingresado exitosamente.");
        
    }

	public void insertConsultation(
			String patientId,
			String consultationStartDatetime,
			String consultationEndDatetime,
			String consultationStatus,
			String consultationNotePath,
			String consultationAmount,
			String consultationAmountPaid
	) throws SQLException, ValidationException {

		if (patientId.isEmpty()) {
			//viewManager.showErrorMessage("Paciente ingresado invalido."); return;
		}

		if (consultationStartDatetime.isEmpty()) {
			//viewManager.showErrorMessage("fecha de inicio ingresada inválida."); return;
		}

		if (consultationEndDatetime.isEmpty()) {
			//viewManager.showErrorMessage("facha de finalizacion ingresada inválida."); return;
		}

		if (consultationStatus.isEmpty()) {
			//viewManager.showErrorMessage("Estado de la consulta ingresado inválido."); return;
		}

		if (consultationNotePath.isEmpty()) {
			//viewManager.showErrorMessage("Ruta al archivo de notas ingresado inválido."); return;
		}

		if (consultationAmount.isEmpty()) {
			//viewManager.showErrorMessage("Monto ingresado inválido."); return;
		}

		if (consultationAmountPaid.isEmpty()) {
			//viewManager.showErrorMessage("Estado del pago ingresado inválido."); return;
		}

		consultationService.insertConsultation(new ConsultationDTO(
				patientId,
				consultationStartDatetime,
				consultationEndDatetime,
				consultationStatus,
				consultationNotePath,
				consultationAmount,
				consultationAmountPaid
		));

		//viewManager.showSuccessMessage("Consulta ingresada exitosamente.");

	}

	public void insertCity(
			String cityName,
			String cityZIPCode
	) throws SQLException, ValidationException {

		if (cityName.isEmpty()) {
			//viewManager.showErrorMessage("Nombre ingresado invalido."); return;
		}

		if (cityZIPCode.isEmpty()) {
			//viewManager.showErrorMessage("Codigo postal ingresado inválido."); return;
		}

		cityService.insertCity(new CityDTO(
				cityName,
				cityZIPCode
		));

		//viewManager.showSuccessMessage("Ciudad ingresada exitosamente.");

	}
    
}