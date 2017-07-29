package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/29.
 */
//16进制转化为10进制数字
import java.util.*;
public class Demo4 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        str = str.substring(2);

            int []num = new int[str.length()];
            for(int i=0;i<str.length();i++) {
                switch (str.charAt(i)) {
                    case '1':
                        num[i] = 1;
                        break;
                    case '2':
                        num[i] = 2;
                        break;
                    case '3':
                        num[i] = 3;
                        break;
                    case '4':
                        num[i] = 4;
                        break;
                    case '5':
                        num[i] = 5;
                        break;
                    case '6':
                        num[i] = 6;
                        break;
                    case '7':
                        num[i] = 7;
                        break;
                    case '8':
                        num[i] = 8;
                        break;
                    case '9':
                        num[i] = 9;
                        break;
                    case 'A':
                        num[i] = 10;
                        break;
                    case 'B':
                        num[i] = 11;
                        break;
                    case 'C':
                        num[i] = 12;
                        break;
                    case 'D':
                        num[i] = 13;
                        break;
                    case 'E':
                        num[i] = 14;
                        break;
                    case 'F':
                        num[i] = 15;
                        break;
                    default:
                        throw new IllegalArgumentException("参数转化异常");
                }
            }
            double sum=0;
            for(int i=num.length-1;i>=0;i--){
                int j=0;
                sum = sum+num[j]*Math.pow(16,i);
                j++;
            }
            System.out.println(sum);
        }


}
