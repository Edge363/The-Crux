package logic;

public class filler {

public static void gcd(double d, double e){
	if(d%e==1||d%e==0){
		System.out.println(d+" mod "+e+" = "+d%e);
		return;
	}
	System.out.println(d+" mod "+e+" = "+d%e);
	gcd(e,d%e);
	
}
public static void squareAndMultiply(int x, int y, int n){
	int z=1;
	String stuff=Integer.toBinaryString(y);

	for(int b=Integer.toBinaryString(y).length()-1;b>=0;b--){
		if(stuff.charAt(b)=='0'){
			System.out.print(z+"*"+z+" mod "+n+"=");
			z=((z^2)%n);
			System.out.println(z);
		}
		else{
			System.out.print(z+"*"+z+"*"+x+" mod "+n+"=");
			z=(((z^2)*x)%n);
			System.out.println(z);
		}
		
	}
}
public static void checker(){
	double e=Math.E;
	for(double k=10000;k<100000000;k++){
	double x = (1-Math.pow(e,((-k)*(k-1)/(999999999.0*2))));
	if(x<.70001&&x>.69999){
		System.out.println(k);
	}
	}
}
public static void main(String[] args){
	gcd(Math.pow(44,117),143.0);
}
}
