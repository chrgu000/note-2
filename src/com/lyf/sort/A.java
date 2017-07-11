package com.lyf.sort;

public class A {
	public void sumA(){//执行了1+(n+1)+n+1次=2n+3次
		int i,sum=0,n=100;//执行一次
		for(i=1;i<=n;i++){//执行了n+1次
			sum=sum+i;//执行了n次

		}
		System.out.printf("%d",sum);//执行了一次
	}
	public void sumB(){//执行了1+1+1=3次
		int sum=0,n=100;//执行一次
		sum=(1+n)*n/2;//执行一次
		System.out.printf("%d",sum);//执行了一次
	}
	public void sumC(){
		int i,j,x=0,sum=0,n=100;//执行一次
		for(i=1;i<=n;i++){
			for(j=1;j<=n;j++){
				x++;//执行了n*n次
				sum=sum+x;
			}

		}
		System.out.printf("%d",sum);//执行了一次
	}
	public static void main(String[] args) {
		A a=new A();
		a.sumC();
	}
}
