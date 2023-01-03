package com.ahzx.learn.threadlocal;

import java.util.List;
import java.util.Map;

public class ModelDataAttributes {

    private Map<String, Object> entInfo; //企业基本信息
    private Map<String, Object> lerepStock; //法人代表股东
    private Map<String, Object> taxInfo; //税务信息

    private List<Map<String, Object>> stockInfo; //股东信息
    private List<Map<String, Object>> natureStocks;//自然人股东
    private List<Map<String, Object>> cmpStocks; //法人股东

    private List<Map<String, Object>> mainStocks; //主要股东
    private List<Map<String, Object>> mainNatureStocks;//主要自然人股东
    private List<Map<String, Object>> mainCmpStocks; //主要法人股东

    private List<Map<String, Object>> manaInfo; //管理人员信息
    private List<Map<String, Object>> otherManas; //其他管理人员

    private List<Map<String, Object>> investedCmp; //法人对外投资的被投资企业信息（投资比例>30%）
    private List<Map<String, Object>> investedLerep; //法人代表对外投资的被投资企业信息(投资比例>30%)
    private List<Map<String, Object>> investedMainStocks;//企业主要股东对外投资的企业信息
    private List<Map<String, Object>> investedEnt; //企业对外投资的被投资企业信息（投资比例>30%）

    private List<Map<String, Object>> cmpUsedName;//企业曾用名

    private Map<String, Object> creditInfo;//个人征信报告编号和企业征信报告编号

    public List<Map<String, Object>> getCmpUsedName() {
        return cmpUsedName;
    }

    public Map<String, Object> getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(Map<String, Object> creditInfo) {
        this.creditInfo = creditInfo;
    }

    public void setCmpUsedName(List<Map<String, Object>> cmpUsedName) {
        this.cmpUsedName = cmpUsedName;
    }

    public List<Map<String, Object>> getInvestedMainStocks() {
        return investedMainStocks;
    }

    public void setInvestedMainStocks(List<Map<String, Object>> investedMainStocks) {
        this.investedMainStocks = investedMainStocks;
    }

    public Map<String, Object> getEntInfo() {
        return entInfo;
    }

    public void setEntInfo(Map<String, Object> entInfo) {
        this.entInfo = entInfo;
    }

    public Map<String, Object> getLerepStock() {
        return lerepStock;
    }

    public void setLerepStock(Map<String, Object> lerepStock) {
        this.lerepStock = lerepStock;
    }

    public Map<String, Object> getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(Map<String, Object> taxInfo) {
        this.taxInfo = taxInfo;
    }

    public List<Map<String, Object>> getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(List<Map<String, Object>> stockInfo) {
        this.stockInfo = stockInfo;
    }

    public List<Map<String, Object>> getMainStocks() {
        return mainStocks;
    }

    public void setMainStocks(List<Map<String, Object>> mainStocks) {
        this.mainStocks = mainStocks;
    }

    public List<Map<String, Object>> getNatureStocks() {
        return natureStocks;
    }

    public void setNatureStocks(List<Map<String, Object>> natureStocks) {
        this.natureStocks = natureStocks;
    }

    public List<Map<String, Object>> getMainNatureStocks() {
        return mainNatureStocks;
    }

    public void setMainNatureStocks(List<Map<String, Object>> mainNatureStocks) {
        this.mainNatureStocks = mainNatureStocks;
    }

    public List<Map<String, Object>> getCmpStocks() {
        return cmpStocks;
    }

    public void setCmpStocks(List<Map<String, Object>> cmpStocks) {
        this.cmpStocks = cmpStocks;
    }

    public List<Map<String, Object>> getMainCmpStocks() {
        return mainCmpStocks;
    }

    public void setMainCmpStocks(List<Map<String, Object>> mainCmpStocks) {
        this.mainCmpStocks = mainCmpStocks;
    }

    public List<Map<String, Object>> getManaInfo() {
        return manaInfo;
    }

    public void setManaInfo(List<Map<String, Object>> manaInfo) {
        this.manaInfo = manaInfo;
    }

    public List<Map<String, Object>> getOtherManas() {
        return otherManas;
    }

    public void setOtherManas(List<Map<String, Object>> otherManas) {
        this.otherManas = otherManas;
    }

    public List<Map<String, Object>> getInvestedCmp() {
        return investedCmp;
    }


    public List<Map<String, Object>> getInvestedEnt() {
        return investedEnt;
    }

    public void setInvestedEnt(List<Map<String, Object>> investedEnt) {
        this.investedEnt = investedEnt;
    }

    public void setInvestedCmp(List<Map<String, Object>> investedCmp) {
        this.investedCmp = investedCmp;
    }

    public List<Map<String, Object>> getInvestedLerep() {
        return investedLerep;
    }

    public void setInvestedLerep(List<Map<String, Object>> investedLerep) {
        this.investedLerep = investedLerep;
    }


    @Override
    public String toString() {
        return "ModelDataAttributes [entInfo=" + entInfo + ", creditInfo=" + creditInfo + ", lerepStock=" + lerepStock + ", taxInfo=" + taxInfo
                + ", stockInfo=" + stockInfo + ", natureStocks=" + natureStocks + ", cmpStocks=" + cmpStocks
                + ", mainStocks=" + mainStocks + ", mainNatureStocks=" + mainNatureStocks + ", mainCmpStocks="
                + mainCmpStocks + ", manaInfo=" + manaInfo + ", otherManas=" + otherManas + ", investedCmp="
                + investedCmp + ", investedLerep=" + investedLerep + ", investedMainStocks=" + investedMainStocks
                + ", cmpUsedName=" + cmpUsedName + "]";
    }

}
