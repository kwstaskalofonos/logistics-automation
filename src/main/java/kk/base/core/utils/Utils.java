package kk.base.core.utils;

import java.util.List;
import java.util.Map;

public class Utils {

    public static boolean isEmpty(Object obj) {
        if(obj == null) return true;
        if(obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        } else if (obj instanceof List<?>) {
            return ((List<?>) obj).isEmpty();
        } else if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        return false;
    }
}
