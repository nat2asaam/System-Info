import java.io.*;
class WinProcess{
	public static void main(String args[]){
		try {
    			String line;
    			//String [][] process_details=null;
    			String [] p_detail;
    			//Process p = Runtime.getRuntime().exec("ps -e");
				Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
    			BufferedReader input =new BufferedReader(new InputStreamReader(p.getInputStream()));
    			int i=0;
    			while ((line = input.readLine()) != null) {
    				/*
    				p_detail=line.split(" ");
    				for(int j=0;j<p_detail.length;j++){
    					//process_details[i][j]=p_detail[j];
    					System.out.println("j="+j+": "+p_detail[j]);
    				}
    				*/
    				i++;
    				if(i>3)
        				System.out.println(line); //<-- Parse data here.
        			
   			 	}
    			input.close();
    			System.out.println("Number of Processes: "+(i-3));
			} catch (Exception err) {
    				err.printStackTrace();
			}
	}
}