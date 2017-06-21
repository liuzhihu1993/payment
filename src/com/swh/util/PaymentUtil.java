package com.swh.util;
/**
 * ֧��������
 */
public class PaymentUtil {
  /**
   * ��֧����������ݣ���������md5-hmac
   *  ���²��������ױ�֧���淶Ҫ���͵ģ��������ǵ�˳���ǹ̶���
   *  �����������в�����ֵ��������Ϊnull��ֻ��Ϊ���ַ�������""
   * @param p0_Cmd          ҵ������
   * @param p1_MerId        �̻����
   * @param p2_Order        �̻�������
   * @param p3_Amt          ֧�����
   * @param p4_Cur          ���ױ���
   * @param p5_Pid          ��ƷID
   * @param p6_Pcat         ��Ʒ����
   * @param p7_Pdesc        ��Ʒ����
   * @param p8_Url          �̻�����֧���ɹ����ݵĵ�ַ
   * @param p9_SAF          �ͻ���ַ
   * @param pa_MP           �̻���չ��Ϣ
   * @param pd_FrpId        ���б���
   * @param pr_NeedResponse Ӧ�����
   * @param keyValue        �̻���Կ
   */
  public static String buildHmac(String p0_Cmd, String p1_MerId,
      String p2_Order, String p3_Amt, String p4_Cur, String p5_Pid,
      String p6_Pcat, String p7_Pdesc, String p8_Url, String p9_SAF,
      String pa_MP, String pd_FrpId, String pr_NeedResponse,
      String keyValue) {
    StringBuffer sb = new StringBuffer();
    sb.append(p0_Cmd);          //ҵ�����͡�Ŀǰ����ʹ�õ�������֧����ҵ�����ͣ�����������Buy
    sb.append(p1_MerId);        //�̻���š�ʹ���ױ�֧��ǰ�����Ϊ���û���Ȼ�������̻���ź���Կ������
    sb.append(p2_Order);        //�̻������š������ǵ�ϵͳ�У����ڸ��ٶ����ĺ���
    sb.append(p3_Amt);          //֧�����
    sb.append(p4_Cur);          //���ױ���
    sb.append(p5_Pid);          //��ƷID����ѡ������Ϣ���Բ��ṩ���ױ�
    sb.append(p6_Pcat);         //��Ʒ���ࡣ��ѡ������Ϣ���Բ��ṩ���ױ�
    sb.append(p7_Pdesc);        //��Ʒ��������ѡ������Ϣ���Բ��ṩ���ױ�
    sb.append(p8_Url);          //�̻�����֧���ɹ����ݵĵ�ַ��Ҳ���ǽ��׽��֪ͨ��ַ
    sb.append(p9_SAF);          //�ͻ���ַ�����Բ��ṩ���ױ�����Ҫ����ֵΪ���ַ�����ע�ⲻ��null
    sb.append(pa_MP);           //�̻���չ��Ϣ�����ᷢ�͸�֧�����أ���֧��������ɺ�����ԭ�����ء��ɲ��ṩ���ױ�����Ҫ����Ϊ���ַ���
    sb.append(pd_FrpId);        //���б��롣�����ױ��Լ��ƶ��ģ����繤�����еı���ΪICBC-NET
    sb.append(pr_NeedResponse); //Ӧ����ơ�Ĭ��Ϊ0��1����
    //0�����ױ�����p8_Urlʱ�õ���ҳ��״̬��200���ͱ�ʾ��ҳ���ѳɹ����յ�����
    //������ճ�����������⣬�����������⣬��ô��ʱ���������ǳɹ��ģ���ʵ���ϳ���û�н��ܵ����ݣ���������¿���ʹ��1Ӧ��
    //1�����ױ�����p8_Urlʱ��ҳ�淵�صĴ����У�û��html���룬��ֻ��һ��success�����ʾ��ҳ���ѳɹ����յ�����
    return DigestUtil.hmacSign(sb.toString(), keyValue);
  }
  
  
  /**
   * ����booleanֵ ������ص�md5��У���md5hmacһֱ�򷵻�true
   * ���²�����˳�򣬶����ױ�֧���淶�涨��
   * @param hmac ֧�����ط����ļ�����֤��
   * @param p1_MerId  �̻����
   * @param r0_Cmd    ҵ������
   * @param r1_Code   ֧�����
   * @param r2_TrxId  �ױ�֧��������ˮ��
   * @param r3_Amt    ֧�����
   * @param r4_Cur    ���ױ���
   * @param r5_Pid    ��Ʒ����
   * @param r6_Order  �̻�������
   * @param r7_Uid    �ױ�֧����ԱID
   * @param r8_MP     �̻���չ��Ϣ
   * @param r9_BType  ���׽����������
   * @param keyValue  ��Կ
   * @return
   */
  public static boolean verifyCallback(String hmac, String p1_MerId,
      String r0_Cmd, String r1_Code, String r2_TrxId, String r3_Amt,
      String r4_Cur, String r5_Pid, String r6_Order, String r7_Uid,
      String r8_MP, String r9_BType, String keyValue) {
    StringBuffer sb = new StringBuffer();
    sb.append(p1_MerId); //�̻���š�����Ϊ""��������Ϊnull
    sb.append(r0_Cmd);   //ҵ������
    sb.append(r1_Code);  //֧�����
    sb.append(r2_TrxId); //�ױ�֧��������ˮ�š��������ױ�֧���Ķ���ϵͳ
    sb.append(r3_Amt);   //֧�����
    sb.append(r4_Cur);   //���ױ���
    sb.append(r5_Pid);   //��Ʒ����
    sb.append(r6_Order); //�̻�������
    sb.append(r7_Uid);   //�ױ�֧����ԱID
    sb.append(r8_MP);    //�̻���չ��Ϣ
    sb.append(r9_BType); //���׽����������
    return hmac.equals(DigestUtil.hmacSign(sb.toString(), keyValue));
  }
}