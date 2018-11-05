package news.common.util;

import java.util.Map;

/**
 * 校验结果
 * 
 * @author chad
 *
 */
public class ValidationResult {

	// 校验结果是否有错
	private boolean hasErrors;

	// 校验错误信息
	private Map<String, String> errorMsg;

	public boolean hasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		StringBuilder errormsg = new StringBuilder();
		if (hasErrors()) {
			for (String key : errorMsg.keySet()) {
				errormsg.append("[" + key + "]" + errorMsg.get(key));
			}
		} else {
			errormsg = errormsg.append("success");
		}
		return errormsg.toString();
	}

}
