<%@ page import="kcb.org.json.*" %> <%@ page language="java"
contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%> <%
//************************************************************************** //
���ϸ� : phone_popup2.jsp // - �˾������� // �޴��� ����Ȯ�� ���� ���������� ȣ�� ȭ��
// // ������ // ���� ��ÿ��� ȭ�鿡 �������� �����͸� �����Ͽ� �ֽñ� �ٶ��ϴ�. //
�湮�ڿ��� ����Ʈ�����Ͱ� ����� �� �ֽ��ϴ�.
//************************************************************************** //'
UTF-8 ȯ���� ��� �ּ� ���� + ��ü ������ ��� charset, pageEncoding �� �������ڵ�
���� �ʿ� request.setCharacterEncoding("UTF-8");
/************************************************************************** *
okcert3 �޴��� ����Ȯ�� ���� �Ķ����
**************************************************************************/
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ȸ���� ����Ʈ��, URL
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
String SITE_NAME = "����Ʈ��"; // ��û����Ʈ�� String SITE_URL = "www.test.co.kr";
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' KCB�κ��� �ο����� ȸ�����ڵ�(���̵�) ���� (12�ڸ�)
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
String CP_CD = request.getParameter("CP_CD");; // ȸ�����ڵ�
session.setAttribute("PHONE_CP_CD", CP_CD);
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ���� URL ����
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' opener(popup1)�� �����ΰ� ��ġ�ϵ��� �����ؾ� ��. //' (http://www.test.co.kr��
http://test.co.kr�� �ٸ� ���������� �ν��ϸ�, http �� https�� ��ġ�ؾ� ��) String
RETURN_URL =
"http://"+request.getServerName()+":8080/phone_popup/phone_popup3.jsp";// ����
�Ϸ� �� ���ϵ� URL (������ ���� full path)
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ������û�����ڵ� (���̵� ���� ����)
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
String RQST_CAUS_CD = "00";
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ä�� �ڵ� (���鰡��. �ʿ��� ȸ���翡���� �Է�)
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//String CHNL_CD = request.getParameter("CHNL_CD");
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ���ϸ޽��� (���鰡��. returnUrl���� ���� ���޹ް��� �ϴ� ���� �ִٸ� ����.)
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//String RETURN_MSG = ""; //'
######################################################################## //' #
Ÿ�� �� �˾�URL : �/�׽�Ʈ ��ȯ�� ���� �ʿ� //'
######################################################################## String
target = "PROD"; // �׽�Ʈ="TEST", �="PROD" //String popupUrl = ""; // �׽�Ʈ URL
String popupUrl = "https://safe.ok-name.co.kr/CommonSvl";// � URL
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ���̼��� ����
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
String license = "C:\\okcert3_license\\" + CP_CD + "_IDS_01_" + target +
"_AES_license.dat";
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//' ���񽺸� (������)
//'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
String svcName = "IDS_HS_POPUP_START";
/**************************************************************************
okcert3 ��û ����
**************************************************************************/
JSONObject reqJson = new JSONObject(); reqJson.put("RETURN_URL", RETURN_URL);
reqJson.put("SITE_NAME", SITE_NAME); reqJson.put("SITE_URL", SITE_URL);
reqJson.put("RQST_CAUS_CD", RQST_CAUS_CD); //reqJson.put("CHNL_CD", CHNL_CD);
//reqJson.put("RETURN_MSG", RETURN_MSG); // ������ �Է¹��� ������ �˾�â ����������
������ ��� ��� (���̵� ����) //reqJson.put("IN_TP_BIT", "15");
//reqJson.put("NAME", "ȫ�浿"); //reqJson.put("BIRTHDAY", "19870725");
//reqJson.put("TEL_NO", "01012345678"); //reqJson.put("NTV_FRNR_CD", "F"); //
������ L �ܱ��� F //reqJson.put("SEX_CD", "F"); // ���� M ���� F //' �ŷ��Ϸù�ȣ��
�⺻������ ��� ������ �ڵ� ä���ǰ� ä���� ���� ��������. //' ȸ���簡 ���� ä���ϱ�
���ϴ� ��쿡�� �Ʒ� �ڵ带 �ּ� ���� �� ���. //' �� �ŷ����� �ߺ� ���� String �� �����Ͽ�
�Է�. �ִ����:20 //reqJson.put("TX_SEQ_NO", "123456789012345"); String reqStr =
reqJson.toString();
/**************************************************************************
okcert3 ����
**************************************************************************/
kcb.module.v3.OkCert okcert = new kcb.module.v3.OkCert(); // '************ IBM
JDK ��� ��, �ּ� �����Ͽ� ȣ�� ************ // okcert.setProtocol2type("22"); //
'��ü �� license�� ���ε��ؾ� �� ��쿡�� �ּ� �����Ͽ� ȣ��. (v1.1.7 ���� ���̼�����
������ġ�� key�� �Ͽ� static HashMap���� ����) // okcert.delLicense(license); //'
callOkCert �޼ҵ�ȣ�� : String license ���� path�� ���̼��� �ε� String resultStr =
okcert.callOkCert(target, CP_CD, svcName, license, reqStr); /* // 'OkCert3
���ο��� String license ���� path�� ���̼����� �� �о�� ���(Executable Jar ȯ�� ���
�߻�), // '�޼ҵ� ������ �Ķ���Ϳ� InputStream�� ����Ͽ� ���̼��� �ε� String resultStr =
null; if ( ! okcert.containsLicense(license) ) { // �ε�� ���̼��� ������ HashMap��
���� ��� java.io.InputStream is = new java.io.FileInputStream(license); // ȯ�濡
�°� InputStream �ε� resultStr = okcert.callOkCert(target, CP_CD, svcName,
license, reqStr, is); } else { // �ε�� ���̼��� ������ HashMap�� �ִ� ��� resultStr
= okcert.callOkCert(target, CP_CD, svcName, license, reqStr); } */ JSONObject
resJson = new JSONObject(resultStr); String RSLT_CD =
resJson.getString("RSLT_CD"); String RSLT_MSG = resJson.getString("RSLT_MSG");
//if(resJson.has("TX_SEQ_NO")) String TX_SEQ_NO =
resJson.getString("TX_SEQ_NO"); // �ʿ� �� �ŷ� �Ϸ� ��ȣ �� ���Ͽ� DB���� ���� ó��
String MDL_TKN = ""; boolean succ = false; if ("B000".equals(RSLT_CD) &&
resJson.has("MDL_TKN") ) { MDL_TKN = resJson.getString("MDL_TKN"); succ = true;
} %>

<html>
  <title>KCB �޴��� ����Ȯ�� ���� ���� 2</title>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
    <script type="text/javascript">
      function request() {
        document.form1.action = "<%=popupUrl%>";
        document.form1.method = "post";

        document.form1.submit();
      }
    </script>
  </head>

  <body>
    <form name="form1">
      <!-- ���� ��û ���� -->
      <!--// �ʼ� �׸� -->
      <input
        type="hidden"
        name="tc"
        value="kcb.oknm.online.safehscert.popup.cmd.P931_CertChoiceCmd"
      />
      <!-- ����Ұ�-->
      <input type="hidden" name="cp_cd" value="<%=CP_CD%>" />
      <!-- ȸ�����ڵ� -->
      <input type="hidden" name="mdl_tkn" value="<%=MDL_TKN%>" />
      <!-- ��ū -->
      <input type="hidden" name="target_id" value="" />
      <!-- �ʼ� �׸� //-->
    </form>
  </body>
  <% if (succ) { //������û out.println("
  <script>
    request();
  </script>
  "); } else { //��û ���� �������� ���� out.println("
  <script>
    alert('" + RSLT_CD + " : " + RSLT_MSG + "');
    self.close();
  </script>
  "); } %>
</html>
