package news.common.util;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class FreemarkerUtils {
    private FreemarkerUtils() {
    }

    private static Configuration config = new Configuration();
    private static Configuration webConfig = new Configuration();

    static {
        config.setObjectWrapper(new DefaultObjectWrapper());
        config.setNumberFormat("#");
        webConfig.setObjectWrapper(new DefaultObjectWrapper());
        webConfig.setNumberFormat("#");
    }

    /**
     * 在freemarker 查找 枚举类型
     *
     * @param enumClass
     * @return
     */
    public static TemplateModel getEnumTemplateModel(Class<?> enumClass) {
        try {
            BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
            TemplateHashModel enumModels = wrapper.getEnumModels();
            return enumModels.get(enumClass.getName());
        } catch (TemplateModelException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 在freemarker 查找 静态类型
     *
     * @param clazz
     * @return
     */
    public static TemplateModel getStaticTemplateModel(Class<?> clazz) {
        try {
            BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
            TemplateHashModel enumModels = wrapper.getStaticModels();
            return enumModels.get(clazz.getName());
        } catch (TemplateModelException e) {
            throw new RuntimeException(e);
        }
    }
}
