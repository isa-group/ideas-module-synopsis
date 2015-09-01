package es.us.isa.ideas.synopsis.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Utils {

	private static final Logger LOG = Logger.getLogger(Utils.class.getName());

	public static String withoutDoubleQuotes(String s) {
		String str = s;
		if (str.startsWith("\"")) {
			str = str.substring(1, str.length());
		}
		if (str.endsWith("\"")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String withoutQuotes(String s) {
		String str = s;
		if (str.startsWith("\'")) {
			str = str.substring(1, str.length());
		}
		if (str.endsWith("\'")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String encodeEntities(String str) {
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		return str;
	}

	public static String decodeEntities(String str) {
		str = str.replaceAll("&lt;", "<");
		str = str.replaceAll("&gt;", ">");
		return str;
	}

	public static String loadFile(String filePath) {
		// Location of file to read
		File f = new File(filePath);
		FileInputStream is;
		String res = "";
		try {
			is = new FileInputStream(f);
			res = getStringFromInputStream(is);
			is.close();
		} catch (FileNotFoundException e) {
			Utils.LOG.log(Level.WARNING, "loadFile error", e);

		} catch (IOException e) {
			Utils.LOG.log(Level.WARNING, "loadFile error", e);
		}
		return res;
	}

	public static String DOM2String(Document doc) {
		String xmlString = null;
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			// set some options on the transformer
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			// initialize StreamResult with File object to save to file
			StreamResult result = new StreamResult(new StringWriter());
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);

			xmlString = result.getWriter().toString();
		} catch (TransformerConfigurationException e) {
			Utils.LOG.log(Level.WARNING, "DOM2String error", e);
		} catch (IllegalArgumentException
				| TransformerFactoryConfigurationError | TransformerException e) {
			Utils.LOG.log(Level.WARNING, "DOM2String error", e);
		}

		return xmlString;
	}

	public static String getTimestamp() {
		String timestamp;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		timestamp = sdf.format(now);
		return timestamp;
	}

	public static String dateTrasform(Date date) {
		String result;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		result = sdf.format(date);
		return result;
	}

	public static String getStringFromInputStream(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line.replaceAll("	", "\t")).append("\n");
			}
		} catch (IOException e) {
			LOG.log(Level.WARNING, null, e);
		}
		return sb.toString();
	}

	private Utils() {
	}
}
