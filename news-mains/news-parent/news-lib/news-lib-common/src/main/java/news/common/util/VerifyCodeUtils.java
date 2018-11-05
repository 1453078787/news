package news.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2014  
 * Company:		上海天地汇
 * Author:		xubinbin
 * Version:		1.0  
 * Created at:	2016年11月14日 上午10:34:59  
 * </pre>
 */
public class VerifyCodeUtils {

	private VerifyCodeUtils() {

	}

	/**
	 * 字符验证码
	 */
	protected final static String VERIFY_STRING = "1234567890abcdefghijklmnopqrstuvwxyz";

	/**
	 * 图片验证码
	 */
	protected final static String IMAGE_VERIFY_STRING = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

	/**
	 * 数字验证码
	 */
	protected final static String VERIFY_NUMBER = "1234567890";

	/**
	 * 图形验证码默认长度
	 */
	public final static int IMAGE_VERIFY_LENGTH = 4;

	/**
	 * 图形验证码图片默认宽度
	 */
	public final static int IMAGE_VERIFY_WIDTH = 200;

	/**
	 * 图形验证码图片默认高度
	 */
	public final static int IMAGE_VERIFY_HEIGHT = 80;

	/**
	 * 其他类型验证码默认长度
	 */
	public final static int DEFAULT_VERIFY_LENGTH = 6;

	/**
	 * 生成随机验证码
	 *
	 * @param codeSequence
	 * @param len
	 * @return
	 */
	private static String getRandomCode(String codeSequence, int len) {
		Random random = new Random();
		StringBuilder verifyCode = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			verifyCode.append(codeSequence.charAt(random.nextInt(codeSequence.length())));
		}
		return verifyCode.toString();
	}

	/**
	 * 生成字符数字混合验证码
	 *
	 * @return
	 */
	public static String getVerifyCode() {
		return getVerifyCode(DEFAULT_VERIFY_LENGTH);
	}

	/**
	 * 生成字符数字混合验证码
	 *
	 * @param len
	 * @return
	 */
	public static String getVerifyCode(int len) {
		return getRandomCode(VERIFY_STRING, len);
	}

	/**
	 * 生成纯数字验证码
	 *
	 * @return
	 */
	public static String getNumberVerifyCode() {
		return getNumberVerifyCode(DEFAULT_VERIFY_LENGTH);
	}

	/**
	 * 生成纯数字验证码
	 *
	 * @param len
	 * @return
	 */
	public static String getNumberVerifyCode(int len) {
		return getRandomCode(VERIFY_NUMBER, len);
	}

	/**
	 * 生成验证码图片
	 *
	 * @param os
	 * @param len
	 * @param w
	 * @param h
	 * @return
	 * @throws IOException
	 */
	public static String getVerifyImage(OutputStream os, int len, int w, int h) throws IOException {
		String verifyCode = getRandomCode(IMAGE_VERIFY_STRING, len);
		Graphics2DUtils.drawImage(verifyCode, os, w, h);
		return verifyCode;
	}

	/**
	 * 生成验证码图片
	 *
	 * @param os
	 * @param len
	 * @return
	 * @throws IOException
	 */
	public static String getVerifyImage(OutputStream os, int len) throws IOException {
		return getVerifyImage(os, len, IMAGE_VERIFY_WIDTH, IMAGE_VERIFY_HEIGHT);
	}

	/**
	 * 生成验证码图片
	 *
	 * @param os
	 * @param w
	 * @param h
	 * @return
	 * @throws IOException
	 */
	public static String getVerifyImage(OutputStream os, int w, int h) throws IOException {
		return getVerifyImage(os, IMAGE_VERIFY_LENGTH, w, h);
	}

	/**
	 * 生成验证码图片
	 *
	 * @param os
	 * @return
	 * @throws IOException
	 */
	public static String getVerifyImage(OutputStream os) throws IOException {
		return getVerifyImage(os, IMAGE_VERIFY_LENGTH, IMAGE_VERIFY_WIDTH, IMAGE_VERIFY_HEIGHT);
	}

	/**
	 * 比较验证码
	 *
	 * @param verifyCode1
	 * @param verifyCode2
	 * @return
	 */
	public static boolean verify(String verifyCode1, String verifyCode2) {
		verifyCode1 = verifyCode1.toLowerCase();
		verifyCode2 = verifyCode2.toLowerCase();
		return verifyCode1.equals(verifyCode2);
	}

	/*public static void main(String[] args) {
		try {
			FileOutputStream os = new FileOutputStream(new File("/Users/maxbin/Desktop/aa.jpg"));
			System.out.println(getVerifyImage(os));
			os.flush();
			os.close();
			System.out.println(getVerifyCode());
			System.out.println(getVerifyCode(8));
			System.out.println(getNumberVerifyCode());
			System.out.println(getNumberVerifyCode(8));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
