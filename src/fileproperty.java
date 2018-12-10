import java.io.*;
import java.util.*;

public class fileproperty
{
  
	public static void main(String[] args) throws IOException
  {
	  File file = new File("C:\\Users\\User\\Downloads\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\JavaLab\\CSX-358-HW1-16103087\\HW1-data.txt");
	  
	  String st,pre=null;
	 
    
	  File file1 =new File("C:\\Users\\User\\Downloads\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\JavaLab\\CSX-358-HW1-16103087\\HW1-dataoutput.txt");
	  FileWriter fr = null;
	  BufferedWriter br = null;

	  try{
		  	int count=0,a=0,b=0,c=0,d=0,f=0,max=0;
		  	double tot=0,pct=0;
		  	char grade;
		  	BufferedReader br1 = new BufferedReader(new FileReader(file));
		  	fr = new FileWriter(file1);
		  	br = new BufferedWriter(fr);
		  	br.write("Stdnt Id  Ex  ------- Assignments ---------  Tot  Mi  Fin  CL  Pts  Pct  Gr");
		  	br.newLine();
		  	br.write("--------  --  -----------------------------  ---  --  ---  --  ---  ---  --");
		  	br.newLine();
      
		  	int data[]=new int[15]; //CHECK THIS LATER
		  	while((st=br1.readLine())!=null)
		  	{
		  		count++;
		  		int n=15;
		  		split(data,n,st);
				
				int total=0;
				for(int j=2;j<12;j++)
					total=total+data[j];
				
				int Pts=0;				//Points in report card
				for(int j=1;j<15;j++)
			    	Pts=Pts+data[j];
				
				if(Pts>max) 			//max returns max points scored 
					max=Pts;
				
				pct=((Pts*100)/420);		//pct is percentage
				tot=tot+pct;			//total percentage of class for finding average percentage
				
				if(Math.round(pct)>=90)			//Math.round for rounding off to close numeral
				{grade='A';
				a++;
				}
				else if(Math.round(pct)<90 && Math.round(pct)>=78) {
					grade='B';
					b++;
				}
				else if(Math.round(pct)<78 && Math.round(pct)>=62) {
					grade='C';
					c++;
				}
				else if(Math.round(pct)<62 && Math.round(pct)>=46) {
					grade='D';
					d++;
				}
				else {
					grade='F';
					f++;
				}			
				
				check(data,pre,br);
				
				br.write(data[1]+" ");
				for(int i=2;i<12;i++) {
					if(data[i]/10<1)
						br.write(" "+data[i]+" ");
					else
					    br.write(data[i]+" ");
					}
				br.write(" ");
				br.write(total+"  ");
				br.write(data[12]+"  ");
				br.write(" "+data[13]+"  ");
				if(data[14]/10<1)
					br.write(" "+data[14]+"  ");
				else
					br.write(data[14]+"  ");
				br.write(Math.round(Pts)+"  ");
				br.write(" "+Math.round(pct)+"  ");
				br.write(" "+grade);
				br.newLine();				
			 }

			br.newLine();
			br.write("-----Summary of Report-----");
			br.newLine();
			br.write("Average total point percent of all students: "+tot/count+" %");
			br.newLine();
			br.write("Number of A's = "+a);
			br.newLine();
			br.write("Number of B's = "+b);
			br.newLine();
			br.write("Number of C's = "+c);
			br.newLine();
			br.write("Number of D's = "+d);
			br.newLine();
			br.write("Number of F's = "+f);
			br.newLine();
			br.write("Maximum points = "+max);
		
		    br1.close();
            br.close();
            
		  	
    } 
	  catch(IOException ex) {
          ex.printStackTrace();
      }
	}

	static void split(int data[],int n,String st)
	{
		StringTokenizer token = new StringTokenizer(st);			//allows string to break into tokens in a line
		for(int j=0;j<n;j++)
		{
			String s = token.nextToken();
			data[j]=Integer.parseInt(s);				//convert string to int
		}
	}
	static void check(int indata[], String pre,BufferedWriter wr)
  {
		try {
		 if(indata[0]/10000000<1) {	//to check if roll no if starting with 0
				pre="0"+Integer.toString(indata[0]);			//then we add 0 and add it to roll no converting it to string
				wr.write(pre+"  ");
				}
			else
				wr.write(indata[0]+"  ");
		}
		catch(IOException ex) {
          ex.printStackTrace();
      }
  }

}