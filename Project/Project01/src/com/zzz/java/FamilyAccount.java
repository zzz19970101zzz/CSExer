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
        String details ="-----------------��ǰ��֧��ϸ��¼-----------------\n"+ "��֧\t�˻����\t��֧���\t˵ ��\n";
        while (isFlag) {
            System.out.println("-----------------��ͥ��֧�������-----------------");
            System.out.println("1 ��֧��ϸ");
            System.out.println("2 �Ǽ�����");
            System.out.println("3 �Ǽ�֧��");
            System.out.println("4 �� ��");
            System.out.print("��ѡ��(1-4)��");
            char c = Utility.readMenuSelection();
            switch (c) {
                case '1':
                    System.out.println(details);
                    System.out.println("--------------------------------------------------");

                    break;
                case '2':
                    System.out.print("���������");
                    int income = Utility.readNumber();
                    System.out.println("��������˵����");
                    String s = Utility.readString();
                    balance +=income;
                    details += "���룺\t" + balance + "\t" + income + "\t"+ s + "\n";
                    System.out.println("---------------------�Ǽ����---------------------");

                    break;
                case '3':
                    System.out.print("����֧����");
                    int outcome = Utility.readNumber();
                    System.out.println("����֧��˵����");
                    String m = Utility.readString();
                    balance -=outcome;
                    details += "֧����\t" + balance + "\t" + outcome + "\t"+ m + "\n";
                    System.out.println("---------------------�Ǽ����---------------------");

                    break;
                case '4':
                    System.out.println("ȷ���Ƿ��˳�(Y/N)��");
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
