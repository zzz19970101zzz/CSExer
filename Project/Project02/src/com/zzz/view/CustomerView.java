package com.zzz.view;

import com.zzz.bean.Customer;
import com.zzz.service.CustomerList;
import com.zzz.util.CMUtility;

/**
 * 这是本客户信息软件的代码入口，呈现软件的页面设置和对用户输入输出进行管理
 *
 * @author zzz
 * @create 2021-01-14 11:52
 */
public class CustomerView {
    CustomerList list = new CustomerList(10);

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {

            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println();
            System.out.println("1 添 加 客 户");
            System.out.println("2 修 改 客 户");
            System.out.println("3 删 除 客 户");
            System.out.println("4 客 户 列 表");
            System.out.println("5 退       出");
            System.out.println("请选择(1-5)：");

            char c = CMUtility.readMenuSelection();
            switch (c) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("请确认是否退出（Y/N）：");
                    char c1 = CMUtility.readConfirmSelection();
                    if (c1 == 'Y') {
                        isFlag = false;
                    }
                    break;
            }

        }

    }

    /**
     * 添加客户操作
     */

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(6);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isadded = list.addCustomer(customer);
        if (isadded == true) {
            System.out.println("---------------------添加完成---------------------");
            System.out.println();
        } else {
            System.out.println("-----------------客户已满，添加失败----------------");
            System.out.println();
        }

    }

    /**
     * 修改客户操作
     */
    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        int i = 0;
        while (true) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            i = CMUtility.readInt();
            if (i == -1) {
                System.out.println();
                return;
            } else if (i <= 0 || i > list.getTotal()) {
                System.out.println("输入有误，找不到这个客户！");
                System.out.println();
            } else {
                break;
            }
        }

        Customer customer1 = list.getCustomer(i);
        System.out.print("姓名：");
        String name = CMUtility.readString(6, customer1.getName());
        System.out.print("性别：");
        char gender = CMUtility.readChar(customer1.getGender());
        System.out.print("年龄：");
        int age = CMUtility.readInt(customer1.getAge());
        System.out.print("电话：");
        String phone = CMUtility.readString(11, customer1.getPhone());
        System.out.print("邮箱：");
        String email = CMUtility.readString(30, customer1.getEmail());
        Customer customer = new Customer(name, gender, age, phone, email);
        list.repalceCustomer(i, customer);
        System.out.println("---------------------修改完成---------------------");
        System.out.println();
    }

    /**
     * 删除客户操作
     */
    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        int i = 0;
        while (true) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            i = CMUtility.readInt();
            if (i == -1) {
                System.out.println();
                return;
            } else if (i <= 0 || i > list.getTotal()) {
                System.out.println("输入有误，找不到这个客户！");
            } else {
                break;
            }
        }
        System.out.print("请确认是否删除编号为" + i + "的客户信息（Y/N）：");
        char c = CMUtility.readConfirmSelection();
        if(c == 'Y'){
            list.deleteCustomer(i);
            System.out.println("---------------------删除完成---------------------");
        }
            System.out.println();


    }

    /**
     * 展示所有客户信息
     */
    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t" + "姓名\t" + "性别\t" + "年龄\t" + "电话\t\t\t" + "邮箱");
//        for(Customer cust : list.getAllCustmor()){
//            System.out.println(i + "\t" + cust.getName() + "\t" + cust.getAge() + "\t"
//            + cust.getPhone() + "\t" + cust.getEmail());
//            i++;
//        }
        for (int i = 0; i < list.getAllCustmor().length; i++) {
            Customer[] cust = list.getAllCustmor();
            System.out.println((i + 1)  + "\t\t" + cust[i].getName() + "\t\t" + cust[i].getGender() + "\t\t" + cust[i].getAge() + "\t\t"
                    + cust[i].getPhone() + "\t\t" + cust[i].getEmail());
        }
        System.out.println("--------------------------客户列表完成-------------------------");
        System.out.println();


    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }
}
