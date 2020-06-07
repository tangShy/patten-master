package com.design.patten.responsibilitychan;

public class ViceSchooleMasterApprover extends Approver {
    public ViceSchooleMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 30000 && purchaseRequest.getPrice() > 10000) {
            System.out.println("请求编号 id=" + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
