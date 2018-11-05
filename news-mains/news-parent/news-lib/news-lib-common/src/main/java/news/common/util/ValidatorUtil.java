package news.common.util;

import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author KYLE
 */
public class ValidatorUtil {

	/**
	 * 日志logger
	 */
	// private static Logger logger =
	// LoggerFactory.getLogger(ValidatorUtil.class);

	private ValidatorUtil() {
		super();
	}

	/**
	 * 持有Validator单例, 避免重复创建Validator消耗资源.
	 */
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * 校验对象所有字段
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> ValidationResult validateEntity(T obj) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
		if (CollectionUtils.isNotEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	// public static <T> ValidationResult validateProperty(T obj,String
	// propertyName) {
	// ValidationResult result = new ValidationResult();
	// Set<ConstraintViolation<T>> set =
	// validator.validateProperty(obj,propertyName, Default.class);
	// if (CollectionUtils.isNotEmpty(set)) {
	// result.setHasErrors(true);
	// Map<String, String> errorMsg = new HashMap<String, String>();
	// for (ConstraintViolation<T> cv : set) {
	// errorMsg.put(propertyName, cv.getMessage());
	// }
	// result.setErrorMsg(errorMsg);
	// }
	// return result;
	// }

	/**
	 * 校验对象对应字段
	 * 
	 * @param obj
	 * @param propertyName
	 * @return
	 */
	public static <T> ValidationResult validatePropertys(T obj, String... propertyName) {
		ValidationResult result = new ValidationResult();
		Map<String, String> errorMsg = new HashMap<String, String>();
		for (String string : propertyName) {
			Set<ConstraintViolation<T>> set = validator.validateProperty(obj, string, Default.class);
			if (CollectionUtils.isNotEmpty(set)) {
				result.setHasErrors(true);
				for (ConstraintViolation<T> cv : set) {
					if (errorMsg.containsKey(string)) {
						errorMsg.put(string, errorMsg.get(string) + cv.getMessage());
					} else {
						errorMsg.put(string, cv.getMessage());
					}
				}
				result.setErrorMsg(errorMsg);
			}
		}
		return result;
	}

	/**
	 * 校验对象，不处理异常，自行处理
	 * 
	 * @param obj
	 *            待校验对象
	 * @param groups
	 *            校验组
	 * @return 异常Map
	 * 
	 *         public static <T> Map<String, String> validate(T obj, Class
	 *         <?> ... groups) { Set<ConstraintViolation<T>> set =
	 *         validator.validate(obj, groups); Map<String, String> map =
	 *         Maps.newHashMapWithExpectedSize(set.size());
	 *         for(ConstraintViolation<T> violation: set) {
	 *         map.put(violation.getPropertyPath().toString(),
	 *         violation.getMessage()); } return map; }
	 */

	/**
	 * 校验对象，直接抛出异常
	 * 
	 * @param obj
	 *            待校验对象
	 * @param groups
	 *            校验组
	 * @return 异常Map
	 * @exception ValidatorException
	 * 
	 *                public static <T> Map<String, String> validateAndThrow(T
	 *                obj, Class<?> ... groups) throws ValidatorException {
	 *                Map<String, String> map = validate(obj, groups); if(map !=
	 *                null && !map.isEmpty()) { StringBuffer sb = new
	 *                StringBuffer("对象属性校验失败(" + obj.getClass().getName() +
	 *                "): "); for(String key : map.keySet()) { sb.append(key +
	 *                "-" + map.get(key) + ", "); } String log = sb.toString();
	 *                logger.error(log); throw new
	 *                ValidatorException(Type.SYSTEM_ERR); } return map; }
	 */

	public static void validate(Object obj) throws ValidatorException {
		ValidationResult result = ValidatorUtil.validateEntity(obj);
		if (result.hasErrors()) {
			Map<String, String> map = result.getErrorMsg();

			/*
			 * for (String key : map.keySet()) { throw new
			 * ValidatorException(String.parse("validated [%s] %s", key,
			 * map.get(key))); }
			 */

			Set<Entry<String, String>> entrySet = map.entrySet();
			Iterator<Entry<String, String>> iterator = entrySet.iterator();
			Entry<String, String> next;
			while (iterator.hasNext()) {
				next = iterator.next();
				throw new ValidatorException(String.format("validated [%s] %s", next.getKey(), next.getValue()));
			}
		}
	}

	public static String getErrorMessage(List<ObjectError> errors) {

		StringBuilder sb = new StringBuilder();

		for (ObjectError error : errors) {
			sb.append(error.getDefaultMessage());
			sb.append(",");
		}

		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	public static void checkBlank(JSONObject json, String name) {
		if (!json.containsKey(name) || !StringUtils.isNotBlank(json.getString(name))) {
			throw new ValidatorException("[" + name + "]不能为空");
		}
	}

	public static void checkNull(Object val, String name) {
		if (val == null) {
			throw new ValidatorException("[" + name + "]不能为空");
		}
	}

	public static void checkBlank(String val, String name) {
		if (!StringUtils.isNotBlank(val)) {
			throw new ValidatorException("[" + name + "]不能为空");
		}
	}
}
