package com.swh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swh.util.ConfigInfo;
import com.swh.util.PaymentUtil;

/** 
 * ��Ӧ����֧����� 
 * @see ============================================================================================== 
 * @see �����̻� 
 * @see p1_MerId=10000432521 
 * @see keyValue=8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t 
 * @see ============================================================================================== 
 * @see ��ʽ�̻��������ײ⣬����ֱ����������ҳ�� 
 * @see p1_MerId=10001126856 
 * @see keyValue=69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl 
 * @see ============================================================================================== 
 */  
public class PaymentResultServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        this.doPost(request, response);  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("GBK");  
          
       /* //�����̻����̼�ID  
        String p1_MerId = "10000432521";  
        //�����̻����̼���Կ  
        String keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";  
        */
        String p1_MerId = ConfigInfo.getValue("p1_Merid");
		String keyValue = ConfigInfo.getValue("keyValue");
        
        String r0_Cmd = request.getParameter("r0_Cmd");      //ҵ������  
        String r1_Code = request.getParameter("r1_Code");    //�ۿ�����1:�ۿ�ɹ�  
        String r2_TrxId = request.getParameter("r2_TrxId");  //�ױ����׶�����  
        String r3_Amt = request.getParameter("r3_Amt");      //�ۿ�����׽������ױ�����ϵͳ��ʵ�ʿۿ���ظ��̻�  
        String r4_Cur = request.getParameter("r4_Cur");      //���ױ��֡������ΪCNY  
        String r5_Pid = request.getParameter("r5_Pid");      //��ƷID  
        String r6_Order = request.getParameter("r6_Order");  //�̻�������  
        String r7_Uid = request.getParameter("r7_Uid");      //�ױ���ԱID  
        String r8_MP = request.getParameter("r8_MP");        //�̻���չ��Ϣ����������д1K���ַ��������׷���ʱ��ԭ������  
        String r9_BType = request.getParameter("r9_BType");  //���׽��֪ͨ���͡�1:���׳ɹ��ص�(������ض���)��2:���׳ɹ�����֪ͨ(��������Ե�ͨѶ)  
        String rb_BankId = request.getParameter("rb_BankId");//֧������
        String rp_PayDate = request.getParameter("rp_PayDate");//������֧��ʱ��ʱ��
        String hmac = request.getParameter("hmac");          //MD5����ǩ��  
          
        boolean result = PaymentUtil.verifyCallback(  
                hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur,  
                r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);  
          
        if (result) {  
            if ("1".equals(r1_Code)) {  
            	//֧���ɹ���Ӧ�ð����ݿ��ж���֧��״̬��Ϊ��֧�����������׳���"����ˢ�㿨"��BUG  
                StringBuffer message = new StringBuffer();  
                message.append("������Ϊ��" + r6_Order + " �Ķ���֧���ɹ���"); 
                message.append("�û�֧����" + r3_Amt + "Ԫ��<br/>");  
                message.append("���׽��֪ͨ���ͣ�");  
                if ("1".equals(r9_BType)) {  
                    message.append("������ض���<br/>");  
                } else if ("2".equals(r9_BType)) {  
                    message.append("�ױ�֧�����غ�̨����֪ͨ��<br/>");  
                }  
                message.append("�ױ�����ϵͳ�еĶ�����Ϊ��" + r2_TrxId);  
                request.setAttribute("message", message);  
            } else {  
                request.setAttribute("message", "�û�֧��ʧ��");  
            }  
        } else {  
            request.setAttribute("message", "������Դ���Ϸ�");  
        }  
          
        request.getRequestDispatcher("/WEB-INF/page/paymentResult.jsp").forward(request, response);  
    }  
}  