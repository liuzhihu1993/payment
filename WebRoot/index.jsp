<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>Java����֧����һ����ѡ��֧������</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  <!-- 
*******************************************************************************
����֧�������ֽ��뷽����1)ֱ�������жԽӡ�2)ͨ���м乫˾��������жԽ�
1)ֱ�������жԽ�
   �ŵ㣺������ֱ�������н��в�����㣬�ʽ����ʽ�Ƚϰ�ȫ
         �ʺ��ʽ������Ƚϴ��(����ÿ�½�����ﵽ��������)����ҵ
   ȱ�㣺�����������Ƚϴ����л᲻������������ϵͳ������ҵҲ��Ҫ����Ӧ�Ķ�
         ������ҵÿ�껹��Ҫ�����н���һ�������Ľӿ�Ӧ�÷�
2)ͨ���м乫˾��������жԽ�
   �ŵ㣺�������������١�����ʹ�õ����м���ҵ�ṩ�Ľ���淶������������ϵͳʱ����Ҫ��ҵ����Ӧ�޸�
         �����м���ҵ�Ľ���淶�����˸ı䣬��ҵ������Ӧ�޸�
         ����ֻ����һ���м���ҵ�Խӣ�����������Ҳ�Ƚϵ�
         �ʺ��ʽ������Ƚ�С��(����ÿ�½������ڼ�ʮ�����µ���С��ҵ)
   ȱ�㣺���������м���ҵ�����ʽ���㣬��Ŀǰ�����м���ҵ����˽�󣬹��ʽ�ȫ�Ǹ�������
********************************************************************************
Ŀǰ�������ıȽϺõ��м�֧����˾
������֧����http://www.beijing.com.cn
           ÿ�꽻��һ���Ľӿ�ʹ�÷ѣ����ӽ��׽���п۳�1%�������ѡ��캢�ӡ��������������̳ǵ���֮
�ױ�֧����http://www.yeepay.com
         ������ѣ�ֻ�ӽ��׽���п۳�1%�������ѡ�ʢ�����������Ͱ��˶�������֮
********************************************************************************
֧�����̣��������£�(�ɲο�//WebRoot//WEB-INF//page//connection.jsp�����)
ͨ��HTTP�ķ�ʽ���ױ�֧�����ط���֧�����󣬼���connection.jsp��ע�Ͳ��ֵĲ��Ի���ʽ���ط�������
�����������GET����POST��ʽ��ҳ��Ӧ����GBK����GB2312����
�ױ�֧�����ض���ҵ���������ݣ�ʹ���û�����Կ����HMAC-MD5
Ȼ������ҵ������HMAC-MD5(������hmac�ֶ��ṩ��ֵ)�Ƚ�
��������ͬ��������ת������������
���û�֧����ɺ��������ػ������û���������ض����ױ�֧������
�����ױ�֧������������������ض�����ҵ�ṩ��urlҳ��(������p8_Url�ṩ��ֵ)
********************************************************************************
 -->
  <body>
    <form action="${pageContext.request.contextPath}/servlet/yeepay/PaymentRequest" method="POST">
  <table align="center" width="600" border="6" cellspacing="0" cellpadding="2">
    <tr>
      <td align="center" colspan="4" bgcolor="#FFD2E9">
        <b>�����ţ�</b><input type="text" name="orderID">    
        <b>Ӧ������</b><input type="text" name="amount" size="6"><b>Ԫ</b>
      </td>
    </tr>
    <tr>
      <td colspan="4"> </td>
    </tr>
    <tr>
      <td colspan="4" bgcolor="#C0C0C0">��ѡ������֧������</td>
    </tr>
    <tr>
        	<td height="25" width="24%"><input type="radio" name="pd_FrpId" value="ICBC-NET">��������</td>
      <td height="25" width="24%"><input type="radio" name="pd_FrpId" value="CMBCHINA-NET">��������</td>
        	<td height="25" width="24%"><input type="radio" name="pd_FrpId" value="ABC-NET">ũҵ����</td>
        	<td height="25" width="28%"><input type="radio" name="pd_FrpId" value="CCB-NET">��������</td>
    </tr>
    <tr>
        	<td height="25"><input type="radio" name="pd_FrpId" value="CEB-NET" >�������</td>
        	<td height="25"><input type="radio" name="pd_FrpId" value="BOCO-NET">��ͨ����</td>
        	<td height="25"><input type="radio" name="pd_FrpId" value="CMBC-NET">��������</td>
        	<td height="25"><input type="radio" name="pd_FrpId" value="SDB-NET">���ڷ�չ����</td>
    </tr>
    <tr>
        	<td height="25"><input type="radio" name="pd_FrpId" value="BCCB-NET">��������</td>
        	<td height="25"><input type="radio" name="pd_FrpId" value="CIB-NET">��ҵ����</td>
        	<td height="25"><input type="radio" name="pd_FrpId" value="ECITIC-NET">��������</td>
        	<td height="25"><input type="radio" name="pd_FrpId" value="SPDB-NET">�ֶ���չ����</td>
    </tr>
    <tr>
      <td colspan="4"> </td>
    </tr>
    <tr>
      <td colspan="4" align="center" bgcolor="#FFDAB5"><input type="submit" value="  ȷ��֧��  "/></td>
    </tr>
  </table>
</form>
  </body>
</html>
