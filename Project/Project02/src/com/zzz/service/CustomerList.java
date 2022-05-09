package com.zzz.service;

import com.zzz.bean.Customer;

/**多个客户构成的数组
 * 提供对客户的增删改查的方法
 * @author zzz
 * @create 2021-01-14 10:52
 */
public class CustomerList {
    private Customer [] customers;
    private int total = 0;

    public CustomerList() {
    }

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
        Customer originCustomer = new Customer("zzz", '男', 18, "13000000000", "zzz@gmail.com");
        customers[0] = originCustomer;
        total++;
    }

    /**
     *此方法为增加一个客户
     * @param customer
     * @return 当添加成功时返回true；添加失败返回false
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }else{
            customers[total] = customer;
            total++;
            return true;
        }
    }

    /**
     * 修改一个索引为index的客户信息
     * @param index 所要修改的客户的编号
     * @param cust 需要替换的客户
     * @return 修改成功返回true；失败返回false。
     */
    public boolean repalceCustomer(int index,Customer cust){
        if(index <= 0 || index > total){
            return false;
        }else{
            customers[index - 1] = cust;
            return true;
        }
    }

    /**
     * 删除一个索引为index的客户
     * @param index 客户的索引
     * @return 当删除成功时，返回true；删除失败，返回false。
     */
    public boolean deleteCustomer(int index) {
        if (index <= 0 || index > total) {
            return false;
        }else{
            for (int i = index; i < total; i++) {
                customers[i - 1] = customers[i];
            }
            customers[total - 1] = null;
            total --;
            return true;
        }
    }

    /**
     * 得到客户信息数组
     * @return 返回一个Customer类型的数组
     */
    public Customer[] getAllCustmor(){
        Customer custs[] = new Customer[total];
        for (int i = 0; i <= total - 1; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 返回指定索引的客户对象
     * @param index 需要返回的客户信息索引
     * @return 一个索引为index的Customer对象，当index不存在时，返回null。
     */
    public Customer getCustomer(int index) {
        if (index <= 0 || index > total ){
            return null;
        }else{
            return customers[index - 1];
        }
    }

    /**
     * 得到数组中元素的个数
     * @return 以int型返回数组中元素的个数
     */
    public int getTotal() {
        return total;
    }

    /*下面是测试代码，不用理会*/
    public static void main(String[] args) {
        CustomerList list = new CustomerList(5);
        Customer customer1 = new Customer("Tom", '男', 23, "12345", "Tom@emial.com");
        boolean b = list.addCustomer(customer1);
        System.out.println(b);
        boolean b1 = list.deleteCustomer(1);
        System.out.println(b1);
        boolean b2 = list.deleteCustomer(1);
        System.out.println(b2);
    }
}