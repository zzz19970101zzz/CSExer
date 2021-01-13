package com.zzz.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zzz
 * @create 2021-01-12 17:03
 */
public class FamilyAccount {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isFlag = true;
        int balance= 10000;
        String details ="-----------------当前收支明细记录-----------------\n"+ "收支\t账户金额\t收支金额\t说 明\n";
        while (isFlag) {
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("1 收支明细");
            System.out.println("2 登记收入");
            System.out.println("3 登记支出");
            System.out.println("4 退 出");
            System.out.print("请选择(1-4)：");
            char c = Utility.readMenuSelection();
            switch (c) {
                case '1':
                    System.out.println(details);
                    System.out.println("--------------------------------------------------");

                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int income = Utility.readNumber();
                    System.out.println("本次收入说明：");
                    String s = Utility.readString();
                    balance +=income;
                    details += "收入：\t" + balance + "\t" + income + "\t"+ s + "\n";
                    System.out.println("---------------------登记完成---------------------");

                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int outcome = Utility.readNumber();
                    System.out.println("本次支出说明：");
                    String m = Utility.readString();
                    balance -=outcome;
                    details += "支出：\t" + balance + "\t" + outcome + "\t"+ m + "\n";
                    System.out.println("---------------------登记完成---------------------");

                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    char c1 = Utility.readConfirmSelection();
                    if (c1 == 'Y') {
                        isFlag = false;
                    } else {

                        break;
                    }


            }

        }

    }
//
}
