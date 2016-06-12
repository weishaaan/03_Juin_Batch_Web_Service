package model;

import java.util.HashMap;
import java.util.Map;

public class BatchDatabase {
    private static Map<String,Batch> catalogue = new HashMap<String,Batch>();

    public static Map<String,Batch> getBatches(){
        return catalogue;
    }
}
