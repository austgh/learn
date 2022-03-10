
package com.ahzx.learn.scope.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/6 7:15
 */
public class OptimizeBalance {
    private static final Logger logger = LoggerFactory.getLogger(OptimizeBalance.class);

    public static void main(String[] args) {
        String beginDate = "2021-08-31";
        String endDate = "2022-02-28";

        List<Account> resultList = initAccountList();
        process(beginDate,endDate,resultList);
    }

    public static void process(String beginDate,String endDate,List<Account> resultList) {
        Set<String> accountSet = countAccounts(resultList);

        Map<String, List<Account>> result = getAccountNoListMap(resultList, accountSet);
        logger.info("result:{}",result);

        int rows = accountSet.size();
        int columns = betweenDays(beginDate, endDate) + 1;
        logger.info("columns:{},rows:{}",columns,rows);
        double[][] data = new double[rows][columns];
        calculateAccountsBalance(beginDate, endDate, columns, data, result);
        calculateEverydayBalance(rows, columns, data);
    }
    /**
     * 计算账户数
     */
    private static Set<String> countAccounts(List<Account> resultList) {
        Set<String> accountSet = new HashSet<>();
        for (Account account : resultList) {
            accountSet.add(account.getAccountNo());
        }
        logger.info(String.valueOf(accountSet));
        return accountSet;
    }

    /**
     * 计算每个账号的每天的余额
     */
    private static void calculateEverydayBalance(int rows, int columns, double[][] data) {
        for (int i = 0; i < rows; i++) {
            StringBuilder builder=new StringBuilder();
            for (int j = 0; j < columns; j++) {
                builder.append("data[").append(i).append("][").append(j).append("]=").append(data[i][j]).append("\t");
            }
            logger.info(builder.toString());
        }
        double total=0;
        int count = 0;
        double[] finalRes = new double[columns];
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                finalRes[i] += data[j][i];
            }
            if(finalRes[i]>0){
                total += finalRes[i];
                count++;
            }
            builder.append("finalRes[").append(i).append("]:").append(finalRes[i]).append("\t");
        }
        logger.info(builder.toString());
        double avg = 0;
        if(count>0){
            avg = total / count;
        }
        logger.info("账号总金额:{},天数:{},日均余额:{}", total, count, avg);
    }

    /**
     * 计算每个账户的日均余额
     */
    private static void calculateAccountsBalance(String beginDate, String endDate, int columns, double[][] data, Map<String,
            List<Account>> result) {
        int row=0;
        String maxLessThanBeginDate = "";
        String handleDate = beginDate;
        for (Map.Entry<String, List<Account>> entry : result.entrySet()) {
            List<Account> tempList = entry.getValue();
            int column = 0;
            for (int j = 0; j < tempList.size(); j++) {
                String accountDate = tempList.get(j).getBalanceDate();
                logger.info("account_date--:{},accountNo:{}", accountDate, entry.getKey());
//                赋值 每次两端都赋值。
                if (handleDate.compareTo(accountDate) <= 0) {
                    //当前日期大于等于开始日期
                    //两个日期差值
                    int days = betweenDays(handleDate, accountDate);
                    if (days == 0) {
                        //只有一个节点
                        data[row][column++] = Double.parseDouble(tempList.get(j).getBalance());
                        continue;
                    }
                    //如果是第一个节点
                    if ("".equals(maxLessThanBeginDate)) {
                        //没有比开始日期小的情况 赋值 从开始赋值到当前节点的前一个,共days次
                        for (int k = 0; k < days; k++) {
                            data[row][column++] = 0;
                        }
                        maxLessThanBeginDate = tempList.get(j).getBalanceDate();
                        System.out.println("缓存第一个日期的值:" + maxLessThanBeginDate);
                    } else {
                        if (column == 0) {
                            if (j == 0) {
                                data[row][column++] = 0;
                            } else {
                                data[row][column++] = Double.parseDouble(tempList.get(j - 1).getBalance());
                            }
                        }
                        //两个日期之间的赋值,days-1次 两端都不含
                        for (int k = 0; k < days - 1; k++) {
                            if (j == 0) {
                                data[row][column++] = 0;
                            } else {
                                data[row][column++] = Double.parseDouble(tempList.get(j - 1).getBalance());
                            }
                        }
                    }
                    //当前节点赋值
                    data[row][column++] = Double.parseDouble(tempList.get(j).getBalance());
                    handleDate = accountDate;
                } else {
                    //当前日期小于开始日期
                    maxLessThanBeginDate = tempList.get(j).getBalanceDate();
                    logger.info("缓存最大的小于开始日期的值:{}",maxLessThanBeginDate);
                }
            }
            //后半段是否处理
            if (handleDate.compareTo(endDate) < 0) {
                for (; column < columns; column++) {
                    data[row][column] = Double.parseDouble(tempList.get(tempList.size() - 1).getBalance());
                }
            }
            row++;
            handleDate = beginDate;
        }
    }

    /**
     * 数据结构：{D3718=[Account{account_no='D3718', balance_date='2021-06-16', balance='228511'},
     * Account{account_no='D3718', balance_date='2021-09-09', balance='0'}]}
     */
    private static Map<String, List<Account>> getAccountNoListMap(List<Account> resultList,
                                                                  Set<String> accountSet) {
        Map<String, List<Account>> result = new HashMap<>(150);
        for (String accountNo : accountSet) {
            List<Account> temp = new ArrayList<>();
            for (Account account : resultList) {
                if (accountNo.equals(account.getAccountNo())) {
                    temp.add(account);
                }
            }
            //排序 升序
            temp.sort(Comparator.comparing(Account::getBalanceDate));
            result.put(accountNo, temp);
        }
        return result;
    }

    /**
     *初始化数据
     */
    public static List<Account> initAccountList() {
        List<Account> list = new ArrayList<>();
        Account account1 = new Account();
        account1.setAccountNo("D3718");
        account1.setBalanceDate("2021-09-09");
        account1.setBalance("0");
        Account account2 = new Account();
        account2.setAccountNo("D3718");
        account2.setBalanceDate("2021-06-16");
        account2.setBalance("228511");
        list.add(account1);
        list.add(account2);
        logger.info(String.valueOf(list));
        return list;
    }

    /**
     * 计算两个日期之间的差
     * 日期格式 yyyy-MM-dd
     */
    public static int betweenDays(String beginDate, String endDate) {
        int days = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(beginDate);
            Date date2 = sdf.parse(endDate);
            days = (int) ((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
}
