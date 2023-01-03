package com.ahzx.learn.threadlocal;

/**
 * @Description 企业关联信息缓存
 * @author： zhucl
 * @date： 2017年8月18日 下午2:36:34
 * @version： V1.0
 */
public class ModelCache {
    private static final ThreadLocal<ModelDataAttributes> modelDataCache = new ThreadLocal<>();

    public static void setModelData2Cache(ModelDataAttributes attributes) {
        modelDataCache.set(attributes);
    }

    public static ModelDataAttributes getModelData4Cache() {
        return modelDataCache.get();
    }

    public static void clearData4Cache() {
        modelDataCache.remove();
    }

}
