package com.sczh.systemmanage.utils;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class BarCode2DServlet extends HttpServlet  {
	/**  
     * @Fields serialVersionUID : serialVersionUID
     */
     
    private static final long serialVersionUID = 1L;
    private static final String SIZE = "msize";
    private static final String IMAGETYPE = "JPEG";
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String ordercode = req.getParameter("ordercode");
        String keycode = ordercode;
         
        if (keycode != null && !"".equals(keycode)) {
            ServletOutputStream stream = null;
            try {
                int size=125;
                String msize = req.getParameter(SIZE);
                if (msize != null && !"".equals(msize.trim())) {
                    try{
                        size=Integer.valueOf(msize);
                    } catch (NumberFormatException e) {
                        //TODO output to log
                    }
                }
                stream = resp.getOutputStream();
                QRCodeWriter writer = new QRCodeWriter();
                Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        		hints.put(EncodeHintType.MARGIN, 1);
                BitMatrix m = writer.encode(keycode, BarcodeFormat.QR_CODE, size, size,hints);
                MatrixToImageWriter.writeToStream(m, IMAGETYPE, stream);
            } catch (WriterException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
     
}
