
import java.util.Scanner;
import java.util.Date;
class Parking{
    String no,name;
    Date myObj;
    Parking(){
        name="";
        no="";
    }
}
public class Main
{
    static Parking p[][]=new Parking[3][50];
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("Vehicle parking");
		String pk;
		int i,j;
		char ch;
		for(i=0;i<3;i++){
		    for(j=0;j<50;j++){
		        p[i][j]=new Parking();
		    }
		}
		do{
		    System.out.println("want to park/leave ?");
		    pk=sc.next();
		    if(pk.equals("park")&&isAvailable()){
		        System.out.println("what vehicle ? bike, car, bus or van");
		        String veh=sc.next();
                if(veh.equals("bike")||veh.equals("car")||veh.equals("bus")||veh.equals("van")){
                    System.out.print("vehicle number : ");
		            String no=sc.next();
                    getParking(veh,no);
                }
                else{
                    System.out.println("no parking for this vehicle");
                }
		    }
		    else if(pk.equals("leave")){
		        System.out.println("what vehicle ? bike, car, bus or van");
		        String veh=sc.next();
		        if(veh.equals("bike")||veh.equals("car")||veh.equals("bus")||veh.equals("van")){
                    System.out.print("vehicle number : ");
		            String no=sc.next();
                    leaveParking(veh,no);
                }
		    }
            System.out.println("want to continue? y/n");
            ch=sc.next().charAt(0);
		}while(ch=='y');
	}
	static void getParking(String veh,String no){
		int i,j;
		boolean f=true;
		char ch;
		for(i=0;i<3&&f;i++){
		    for(j=0;j<50&&f;j++){
		        if(p[i][j].no.isEmpty()){
		            p[i][j].no=no;
		            p[i][j].name=veh;
		            p[i][j].myObj=new Date();
		            System.out.println("your parking area is in floor "+(i+1)+" slot "+(j+1)+" on "+p[i][j].myObj);
		            f=false;
		        }
		    }
		}
	}
	static void leaveParking(String veh,String no){
	    int i,j;
	    boolean f=true;
	    for(i=0;i<3&&f;i++){
		    for(j=0;j<50&&f;j++){
		        if(p[i][j].no.equals(no)&&p[i][j].name.equals(veh)){
		            Date ldt=new Date();
		            p[i][j].no="";
		            p[i][j].name="";
		            long diff=Math.abs(ldt.getTime() - p[i][j].myObj.getTime())/(60*60*1000);
		            diff+=1;
		            System.out.println("parking area floor "+(i+1)+" slot "+(j+1)+" is empty\nur parking hours is :"+diff);
		            if(veh.equals("bike")){
		                diff*=20;
		            }
		            else if(veh.equals("car")){
		                diff*=30;
		            }
		            else if(veh.equals("bus")||veh.equals("van")){
		                diff*=50;
		            }
		            System.out.println("ur bill is "+diff);
		            f=false;
		        }
		    }
		}
	}
	static boolean isAvailable(){
	    int i,j;
		boolean f=false;
		for(i=0;i<3;i++){
		    for(j=0;j<50;j++){
		        if(p[i][j].no.isEmpty()){
		            f=true;
		            break;
		        }
		    }
		}
        return f;
	}
}

