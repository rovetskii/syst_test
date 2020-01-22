package Calc_test;
class Calc{
double a;
double b;
Calc(double a, double b)
{
this.a=a;
this.b=b;
}
public double sum()
{return a+b;}
public double r()
{return a-b;}
public double d()
{return a*b;}
public double ch()
{return a/b;}
}




class Calc_test{
public static void main(String[] args){
Calc ob=new Calc(5,2);
double a=ob.sum();
double r=ob.r();
double d=ob.d();
double ch=ob.ch();
if (a==7&r==3&d==10&ch==2.5)
System.out.println("true");
else
System.out.println("false");
}}
