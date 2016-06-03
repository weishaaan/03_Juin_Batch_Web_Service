package model;

import java.util.HashMap;
import java.util.Map;

public class BatchDatabase {
    private static Map<Long,Batch> catalogue = new HashMap<Long,Batch>();

    public static Map<Long,Batch> getBatches(){
        return catalogue;
    }
}
