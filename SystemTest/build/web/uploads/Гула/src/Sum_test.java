package Sum_test;
class Sum{
double a;
double b;
Sum(double a, double b)
{
this.a=a;
this.b=b;
}
public double sum()
{return a-b;}
}class Sum_test{
public static void main(String[] args){
Sum ob=new Sum(5,2);
double a=ob.sum();
if (a==7)
System.out.println( "true");
else
System.out.println( "false");
}}