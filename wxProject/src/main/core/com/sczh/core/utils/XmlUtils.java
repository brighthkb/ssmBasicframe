package com.sczh.core.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

@SuppressWarnings("all")
public class XmlUtils {
	
	protected static Logger log = Logger.getLogger(XmlUtils.class);
	/**
	 * @param args
	 */
	// *利用反射实现javaBean的自动赋值
	public static Object setValue(Object bean, ArrayList<String> pnames,
			ArrayList<String> pvalues) {
		String methodName = "";
		Method method = null;
		Method[] methods = bean.getClass().getDeclaredMethods();
		try {
			for (int i = 0, len = pnames.size(); i < len; i++) {
				methodName = "set"
						+ pnames.get(i).substring(0, 1).toUpperCase()
						+ pnames.get(i).substring(1);
				for (int j = 0, len1 = methods.length; j < len1; j++) {
					Method m = methods[j];
					// 与set相匹配
					if (m.getName().equals(methodName)
							&& (m.getParameterTypes().length == 1)) {
						method = m;
						String type = method.getParameterTypes()[0].getName(); // parameter
						// type
						if (method != null) {
							if (type.equals("java.lang.String")) {
								method.invoke(bean, new Object[] { pvalues.get(i) });
							} else if (type.equals("int")
									|| type.equals("java.lang.Integer")) {
								method.invoke(bean, new Object[] { new Integer(pvalues.get(i)) });
							} else if (type.equals("long")
									|| type.equals("java.lang.Long")) {
								method.invoke(bean, new Object[] {NumberUtils.toLong(pvalues.get(i))});
							} else if (type.equals("boolean")
									|| type.equals("java.lang.Boolean")) {
								method.invoke(bean, new Object[] { Boolean.valueOf(pvalues.get(i)) });
							} else if (type.equals("java.util.Date")) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								try {
									Date date = sdf.parse(pvalues.get(i).toString());
									if (date != null)
										method.invoke(bean, new Object[] { date });
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public static List<Object> xmlToList(String xmlStr, String beanpath) {
		List<Object> list = new ArrayList<Object>();
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
			ArrayList<String> pnames = new ArrayList<String>();
			ArrayList<String> pvalues = new ArrayList<String>();
			Element root = doc.getRootElement();
			Element foo;
			Element foo1;
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				foo = (Element) i.next();
				for (Iterator j = foo.elementIterator(); j.hasNext();) {
					foo1 = (Element) j.next();
					pnames.add(foo1.getName());
					pvalues.add(foo1.getText());
				}
				Object cb = setValue(Class.forName(beanpath).newInstance(),
						pnames, pvalues);
				list.add(cb);
				pnames.clear();
				pvalues.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 解释xml返回当个参数对象
	 * @param xmlStr 字符串XML
	 * @param beanpath  需要转换的对象路径
	 * @param xmlLevel  取xml的层次 默认第一层root
	 * @return
	 */
	public static List<Object> xmlToObject(String xmlStr, String beanpath) {
		List<Object> list = new ArrayList<Object>();
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
			ArrayList<String> pnames = new ArrayList<String>();
			ArrayList<String> pvalues = new ArrayList<String>();
			Element root = doc.getRootElement();
			Element foo;
			Element foo1;
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				foo = (Element) i.next();
				for (Iterator j = foo.elementIterator(); j.hasNext();) {
					foo1 = (Element) j.next();
					pnames.add(foo1.getName());
					pvalues.add(foo1.getText());
				}
				Object cb = setValue(Class.forName(beanpath).newInstance(),
						pnames, pvalues);
				list.add(cb);
				pnames.clear();
				pvalues.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static String beanToXml(List<Object> list)
			throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		java.lang.reflect.Field[] flds;
		String fieldXML;
		Iterator<Object> itor = list.iterator();
		StringBuffer queryXML = new StringBuffer();
		String beanName = getbeanName(list).toLowerCase();
		queryXML.append("<" + beanName + "s>");
		while (itor.hasNext()) {
			Object bean = itor.next();
			flds = bean.getClass().getDeclaredFields();
			fieldXML = getClassFields(flds, bean);
			// if (bean instanceof Calendarbean){
			queryXML.append("<" + beanName + ">");
			queryXML.append(fieldXML);
			queryXML.append("</" + beanName + ">");
			// }
		}
		queryXML.append("</" + beanName + "s>");
		return queryXML.toString();
	}

	public static String beanToXml(Object obj, String headXmlName)
			throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		java.lang.reflect.Field[] flds;
		String fieldXML;
		StringBuffer queryXML = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		queryXML.append("<root>");
		queryXML.append("<" + headXmlName + ">");
		flds = obj.getClass().getDeclaredFields();
		fieldXML = getClassFields(flds, obj);
		// if (bean instanceof Calendarbean){
		queryXML.append(fieldXML);
		// }
		queryXML.append("</" + headXmlName + ">");
		queryXML.append("</root>");
		return queryXML.toString();
	}

	public static String getClassFields(java.lang.reflect.Field[] flds,
			Object bean) throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String xml = "";
		if (flds != null) {
			for (int i = 0; i < flds.length; i++) {
				String getMethod = "get"
						+ flds[i].getName().substring(0, 1).toUpperCase()
						+ flds[i].getName().substring(1);
				Class[] methodParam = null;
				Object[] params = {};
				Object retValue = null;
				// 这里就是调用Bean的get方法，适合写在基类里！！！
				retValue = bean.getClass().getMethod(getMethod, methodParam)
						.invoke(bean, params);
				if(retValue == null){
					// xml = xml+ "<"+StringUtil.nvl(flds[i].getName())+"/>";
					xml = xml + "<" + flds[i].getName() + ">" + "" + "</"+ flds[i].getName() + ">";
				}else{
					xml = xml + "<" + flds[i].getName() + ">" + retValue + "</"
						+ flds[i].getName() + ">";
				}
			}
		}
		return xml;
	}

	public int createXMLFile(String filename, List<Object> list) {
		int returnValue = 0;
		String beanName = getbeanName(list);
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement(beanName + "s");
		Element foo;
		Element foos;
		java.lang.reflect.Field[] flds;
		Iterator<Object> itor = list.iterator();
		try {
			while (itor.hasNext()) {
				Object bean = itor.next();
				flds = bean.getClass().getDeclaredFields();
				if (flds != null) {
					foo = root.addElement(beanName);
					for (int i = 0; i < flds.length; i++) {
						String getMethod = "get"
								+ flds[i].getName().substring(0, 1)
										.toUpperCase()
								+ flds[i].getName().substring(1);
						Class[] methodParam = null;
						Object[] params = {};
						Object retValue = null;
						// 这里就是调用Bean的get方法，很爽哦，适合写在基类里！！！
						retValue = bean.getClass().getMethod(getMethod,
								methodParam).invoke(bean, params);
						if (retValue == null) {
							foos = foo.addElement(flds[i].getName());
						} else {
							foos = foo.addElement(flds[i].getName());
							foos.setText((String) retValue);
						}
					}
				}
			}
			/** 格式化输出,类型IE浏览一样 */
			OutputFormat format = OutputFormat.createPrettyPrint();
			/** 指定XML编码 */
			// format.setEncoding("UTF-8");
			/** 将document中的内容写入文件中 */
			// XMLWriter writer = new XMLWriter(new FileWriter(new
			// File(newfilename)),format);
			// 保证编码为UTF-8，支持中文写入
			// XMLWriter writer = new XMLWriter(new FileOutputStream(new
			// File(newfilename)),format);
			XMLWriter writer = new XMLWriter(
					new FileWriter(new File(filename)), format);
			writer.write(doc);
			writer.close();
			returnValue = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public static String getbeanName(List<Object> list) {
		Iterator<Object> itor = list.iterator();
		String beanName = "Table";
		if (itor.hasNext()) {
			Object bean = itor.next();
			String temp = bean.getClass().getName();
			beanName = temp.substring(temp.lastIndexOf(".") + 1).replaceAll(
					"bean", "");
		}
		return beanName;
	}
	
	/**
	 * 通过xPath方法取节点值，多个节点的时候取list
	 * @param xmlStr
	 * @param xpath
	 * @return
	 */
	public static List<String> getValueByXpath(String xmlStr, String xpath) {
		Document doc = null;
		List<String> list = new ArrayList<String>();
		try {
			doc = DocumentHelper.parseText(xmlStr);
			List<Element> listElement = doc.selectNodes(xpath);
			for(Element el : listElement) {
				list.add(el.getText());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return list;
	}
	
	/**
	 * 通过xPath方法取节点值
	 * @param xmlStr
	 * @param xpath
	 * @return
	 */
	public static String getOneValueByXpath(String xmlStr, String xpath) {
		Document doc = null;
		String retString = "";
		try {
			doc = DocumentHelper.parseText(xmlStr);
			List<Element> listElement = doc.selectNodes(xpath);
			if(listElement != null && listElement.size() > 0) {
				retString = listElement.get(0).getText();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return retString;
	}
	
	public static Document LoadXMLFromString(String xmlString){
		Document xmlDoc = null;
		try {
			xmlDoc = DocumentHelper.parseText(xmlString);
		} catch (DocumentException e) {
			log.error("xml字符串转Document失败", e);
		}
		return xmlDoc;
	}
	
	public static void editElementText(Element element, String strElement, String txtElement){
		Node node = element.selectSingleNode(strElement);
		if(node == null){
			Element e = element.addElement(strElement);
			e.setText(txtElement);
		} else {
			node.setText(txtElement);
		}
	}
	
	public static void editElementAttribute(Element element, String strElement, String attrElement, String txtElement){
		Node node = element.selectSingleNode(strElement);
		if(node == null){
			Element e = element.addElement(strElement);
			e.addAttribute(attrElement, txtElement);
		} else {
			Element e = (Element)node;
			e.addAttribute(attrElement, txtElement);
		}
	}
	
	public static void editElementAttribute(Element element, String attrElement, String txtElement){
		element.addAttribute(attrElement, txtElement);
	}
	
	public static <T> T xml2Object(String xml, Class<T> clazz) {
		if (StringUtils.isNotBlank(xml)) {
			XStream xStream = new XStream(new DomDriver()) {
				// XStream解析xml为bean时，避免xml出现多余字段报错
				@Override
				protected MapperWrapper wrapMapper(MapperWrapper next) {
					return new MapperWrapper(next) {
						@Override
						public boolean shouldSerializeMember(Class definedIn, String fieldName) {
							if (definedIn == Object.class) {
								try {
									return this.realClass(fieldName) != null;
								} catch (Exception e) {
									return false;
								}
							} else {
								return super.shouldSerializeMember(definedIn, fieldName);
							}
						}
					};
				}
			};
			xStream.processAnnotations(clazz);
			// xStream.alias("xml", clazz);
			try {
				return (T) xStream.fromXML(xml);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}

	public static String object2Xml(Object obj) {
		if (obj != null) {
			XStream xStream = new XStream(new DomDriver());
			xStream.processAnnotations(obj.getClass());
			// xStream.alias("xml", obj.getClass());
			try {
				return xStream.toXML(obj);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return "";
	}
	
	public static void main(String args[]) {
		
		String xmlStr="<?xml version='1.0' encoding='utf-8'?><config schema='1.0'></config>";
		Document doc = LoadXMLFromString(xmlStr);
		
		Element root = doc.getRootElement();
		Element app = root.addElement("app");
		//app.addAttribute("id", "" + widgetapp.getWidg
		Element description = app.addElement("description");
		
		XmlUtils.editElementText(description, "type", "napp");
		XmlUtils.editElementText(description, "version", "123");
		XmlUtils.editElementText(description, "entry", "");
		XmlUtils.editElementAttribute(description, "entry", "src", "aaa");
		XmlUtils.editElementText(description, "entry", "uuuuu");
		
		System.out.println(doc.asXML());
	}
}
