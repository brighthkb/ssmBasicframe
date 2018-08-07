package org.apache.jsp.static_.common.verification;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;

public final class verificationCode_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
public static String code="abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
Color getRandColor(int fc,int bc){//ç»å®èå´è·å¾éæºé¢è² 
Random random = new Random(); 
if(fc>255) fc=255; 
if(bc>255) bc=255; 
int r=fc+random.nextInt(bc-fc); 
int g=fc+random.nextInt(bc-fc); 
int b=fc+random.nextInt(bc-fc); 
return new Color(r,g,b); 
} 

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("image/jpeg");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \r\n");
      out.write(" \r\n");
 
//è®¾ç½®é¡µé¢ä¸ç¼å­ 
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
String verType=(String)request.getParameter("verCodeType");
// å¨åå­ä¸­åå»ºå¾è±¡,è®¾ç½®å¾ççæ¾ç¤ºå¤§å° 
int width=60, height=20; 
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
// è·åå¾å½¢ä¸ä¸æ 
Graphics g = image.getGraphics(); 
//çæéæºç±» 
Random random = new Random(); 
// è®¾å®èæ¯è² 
g.setColor(getRandColor(200,250)); 
g.fillRect(0, 0, width, height); 
//è®¾å®å­ä½ 
g.setFont(new Font("Times New Roman",Font.PLAIN,18)); 
//ç»è¾¹æ¡ 
//g.setColor(new Color()); 
//g.drawRect(0,0,width-1,height-1); 
// éæºäº§ç155æ¡å¹²æ°çº¿ï¼ä½¿å¾è±¡ä¸­çè®¤è¯ç ä¸æè¢«å¶å®ç¨åºæ¢æµå° 
g.setColor(getRandColor(160,200)); 
for (int i=0;i<155;i++) 
{ 
int x = random.nextInt(width); 
int y = random.nextInt(height); 
int xl = random.nextInt(12); 
int yl = random.nextInt(12); 
g.drawLine(x,y,x+xl,y+yl); 
}
// åéæºäº§ççè®¤è¯ç (ç±æ°å­åå­æ¯ç»é¿ç) 
String sRand=""; 
for (int i=0;i<4;i++){ 
int rand=random.nextInt(62); 
sRand+=String.valueOf(code.charAt(rand)); 
// å°è®¤è¯ç æ¾ç¤ºå°å¾è±¡ä¸­ 
g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));// è°ç¨å½æ°åºæ¥çé¢è²ç¸åï¼å¯è½æ¯å ä¸ºç§å­å¤ªæ¥è¿ï¼æä»¥åªè½ç´æ¥çæ 
g.drawString(String.valueOf(code.charAt(rand)),13*i+6,16); 
} 
// å°è®¤è¯ç å­å¥SESSION 
session.setAttribute("verifyRandImg_"+verType,sRand); 
// å¾è±¡çæ 
g.dispose(); 
// è¾åºå¾è±¡å°é¡µé¢ 
ImageIO.write(image, "JPEG", response.getOutputStream()); 
out.clear();  
out = pageContext.pushBody();

      out.write(' ');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
