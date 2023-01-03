package com.ahzx.learn.scope.work;

import java.util.List;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/2 20:48
 */
public class Temp {

    public static void main(String[] args) {
        String beginDate = "2021-08-31";
        String endDate = "2022-02-28";
        List<Account> resultList = OptimizeBalance.initAccountList();
        OptimizeBalance.process(beginDate, endDate, resultList);
    }
}
