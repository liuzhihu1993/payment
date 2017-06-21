package com.swh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swh.util.ConfigInfo;
import com.swh.util.PaymentUtil;
//���ڷ���֧������
/**
 * ����֧������
 * @see ==============================================================================================
 * @see �����̻�
 * @see p1_MerId=10000432521
 * @see keyValue=8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t
 * @see ==============================================================================================
 * @see ��ʽ�̻��������ײ⣬����ֱ����������ҳ��
 * @see p1_MerId=10001126856
 * @see keyValue=69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl
 * @see ==============================================================================================
 * @see accountCallbackURL=http://127.0.0.1:8088/payment/servlet/yeepay/PaymentResultServlet
 * @see ��ʱ������������ʹ��·���ϵ���ֻҪ��·�ɵ�IPд��ȥ������·��������һ��8088�˿ڵ�ת�����򣬼���
 * @see ==============================================================================================
 */
public class PaymentRequest extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		
		/* //�����̻����̻����
	    String accountID = "10000432521";
	    //�����̻�����Կ
	    String keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";
	    //�����̻����̻�����֧���ɹ���ݵĵ�ַ
	    String accountCallbackURL = "http://127.0.0.1:8088/payment/servlet/yeepay/PaymentResultServlet";
	    */
		
		String orderID = request.getParameter("orderID");//������
		String amount = request.getParameter("amount");//֧�����
		String accountBankID = request.getParameter("pd_FrpId");//��ȡ�û�ѡ���֧������
	
		String accountID = ConfigInfo.getValue("p1_Merid");
		String keyValue = ConfigInfo.getValue("keyValue");
		String accountCallbackURL = ConfigInfo.getValue("merchantCallbackURL");
		
		System.out.println("accountID="+accountID+" keyValue="+keyValue+" accountCallbackURL="+accountCallbackURL);
		
		String businessType = "Buy";  //ҵ�����͡�BuyΪ����֧��
	    String currency = "CNY";      //���ױ��֡�CNYΪ�����
	    String productDesc = "";      //��Ʒ����
	    String productCategory = "";  //��Ʒ����
	    String productID = "";        //��ƷID
	    String addressFlag = "0";     //�ͻ���ַ��0Ϊ����Ҫ��1Ϊ��Ҫ
	    String accountMoreInfo = "";  //�̻���չ��Ϣ
	    String pr_NeedResponse = "0"; //Ӧ�����
	    
	    String md5hmac = PaymentUtil.buildHmac(
	        businessType, accountID, orderID, amount, currency, productID, productCategory,
	        productDesc, accountCallbackURL, addressFlag, accountMoreInfo, accountBankID,
	        pr_NeedResponse, keyValue);
	    
	    request.setAttribute("businessType", businessType);
	    request.setAttribute("accountID", accountID);
	    request.setAttribute("orderID", orderID);
	    request.setAttribute("amount", amount);
	    request.setAttribute("currency", currency);
	    request.setAttribute("productID", productID);
	    request.setAttribute("productCategory", productCategory);
	    request.setAttribute("productDesc", productDesc);
	    request.setAttribute("accountCallbackURL", accountCallbackURL);
	    request.setAttribute("addressFlag", addressFlag);
	    request.setAttribute("accountMoreInfo", accountMoreInfo);
	    request.setAttribute("accountBankID", accountBankID);
	    request.setAttribute("pr_NeedResponse", pr_NeedResponse);
	    request.setAttribute("md5hmac", md5hmac);
	    
	    request.getRequestDispatcher("/WEB-INF/page/connection.jsp").forward(request, response);
	
	}

}
