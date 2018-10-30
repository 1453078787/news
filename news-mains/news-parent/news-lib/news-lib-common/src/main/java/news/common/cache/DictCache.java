package news.common.cache;

import tdh.thunder.base.dict.service.DictService;
import tdh.thunder.common.AppContext;
import tdh.thunder.common.entity.Dict;

import java.util.List;

public class DictCache {
    public static Dict fetch(String parentCode, String dictCode) {
        return AppContext.getBean(DictService.class).fetch(parentCode, dictCode);
    }

    public static String getDictValue(String parentCode, String code, int index) {

        if (0 == index) {
            String value = getDictValue(parentCode, code);
            return null == value ? code : value;
        } else {
            Dict dict = query(parentCode, code);

            if (null == dict) {
                return code;
            }
            switch (index) {
                case 1:
                    return dict.getValue1();
                case 2:
                    return dict.getValue2();
                case 3:
                    return dict.getValue3();
                case 4:
                    return dict.getValue4();
                default:
                    return dict.getValue4();
            }

        }
    }

    public static String getDictValue(String parentCode, String code) {
        return AppContext.getBean(DictService.class).getDictValue(parentCode, code);
    }

    public static List<Dict> listByParentCode(String parentCode) {
        return AppContext.getBean(DictService.class).listByParentCode(parentCode);
    }

    public static Dict query(String parentCode, String code) {
        return AppContext.getBean(DictService.class).query(parentCode, code);
    }
}
