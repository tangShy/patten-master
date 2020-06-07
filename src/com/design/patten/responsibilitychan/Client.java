package com.design.patten.responsibilitychan;

import java.util.Scanner;

/**
 * 职责链模式：解决审批问题
 */
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个价格：");
        float price  = Float.parseFloat(scanner.next());
        //创建一个请求
        PurchaseRequest request = new PurchaseRequest(1, price, 1);

        //创建相关审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("赵主任");
        CollegeApprover collegeApprover = new CollegeApprover("钱院长");
        ViceSchooleMasterApprover viceSchooleMasterApprover = new ViceSchooleMasterApprover("孙副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("李校长");

        //需要将各个审批级别的下一审批人设置好
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchooleMasterApprover);
        viceSchooleMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(request);
//        viceSchooleMasterApprover.processRequest(request);
    }
}
