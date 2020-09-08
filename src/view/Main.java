package view;

import javax.swing.JOptionPane;

import Controller.ProcessosController;

public class Main {

	public static void main(String[] args) {
		ProcessosController procController = new ProcessosController();
		String os = procController.os();
		System.out.print(os);
		System.out.println("");
		
		String process2 =  "TASKLIST /FO TABLE";
		procController.readProcess(process2);
		
		String param = JOptionPane.showInputDialog("Entre com o nome do processo, ou PID a finalizar.");
		procController.killProcess(param);
	}
}
