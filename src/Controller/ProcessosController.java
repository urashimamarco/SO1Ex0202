package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	
	public ProcessosController(){
		super();
	}
	
	//Retorne o SO em exec na maq.
	public String os(){
		String os = System.getProperty("os.name");
		return "O sistema operacional atual é " + os;
	}
	
	public void readProcess(String process2){
		try {
			Process p = Runtime.getRuntime().exec(process2);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}	
						
			}catch (IOException e) {
			e.printStackTrace();
			}
 	}
	
	public void killProcess(String param){
		String cmdPid = "TASKKILL /PID ";
		String cmdNome = "TASKKILL /IM ";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		
		// May occur an NumberFormatException -> Exception
		try{
			//TASKKILL /PID xxxx
			pid = Integer.parseInt(param);
			buffer.append(cmdPid );
			buffer.append(pid);
		}catch (Exception e){
			//TASKKILL /IM nome do processo.exe
			buffer.append(cmdNome);
			buffer.append(param);
		}
		callProcess(buffer.toString());	
	}

	//Chamar um processo (abrir prog)
	public void callProcess(String buffer){
		try {
				Runtime.getRuntime().exec(buffer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	
}

