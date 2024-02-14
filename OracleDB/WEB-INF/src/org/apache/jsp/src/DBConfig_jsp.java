/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat8
 * Generated at: 2023-12-13 09:48:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.src;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.Map;
import org.json.JSONObject;
import com.genesyslab.studio.backendlogic.GVPHttpRequestProcessor;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import com.genesyslab.studio.backendlogic.BackendLogManager;

public final class DBConfig_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


// Implement this method to execute some server-side logic.
public JSONObject performLogic(JSONObject state, Map<String, String> additionalParams) throws Exception {
     
	JSONObject result = new JSONObject();
	try {
		JSONObject appSession = new JSONObject(state.getString("appSession"));
		String configFileDirectory = getServletConfig().getServletContext().getRealPath("") + "Config";
		Logger debugLogger = BackendLogManager.getLogger(appSession.getString("LoggerName"));
		debugLogger.debug("------- InsertCallInfo.jsp Entry -------");
		try {
			//Request
			JSONObject request = new JSONObject();
			request.put("transName", "InsertCallInfo");
			request.put("transType", "SP");
			request.put("configFilePath", configFileDirectory);
			request.put("request1",appSession.has("ARRIVALTIME") ? appSession.getString("ARRIVALTIME"):"");
			request.put("request2",state.getString("stationNumber").trim());
			//Logging
			debugLogger.debug("Request");
			debugLogger.debug("  ARRIVALTIME	: " + request.getString("request1"));
			debugLogger.debug("  StationNumber: " + request.getString("request2")):
			debugLogger.debug("  ENDTIME		: " +  new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
			//Call DBConnector JAR to InsertCallInfo info
			JSONObject response = new DBManager().dbService(request);
			//Response
			debugLogger.debug("Response");
			if (response != null && "success".equalsIgnoreCase(response.getString("responseStatus"))) {//DB Success
				debugLogger.debug("  InsertCallInfo DB call success");
				appSession.put("Event", "success");
				appSession.put("InsertCallInfoEvent", "true");
			} else { //DB Failure
				debugLogger.error(loggingCommonFormat + "  InsertCallInfo DB call failed");
				if (response == null) {
					debugLogger.error(loggingCommonFormat + "  " + response);
				} else {
					debugLogger.error(loggingCommonFormat + "  ERROR TYPE	: " + response.getString("errorType"));
					debugLogger.error(loggingCommonFormat + "  ERROR MESSAGE: " + response.getString("errorMessage"));
				}
				appSession.put("Event", "failure");
			}
		} catch (Exception ex) { //Log error info
			debugLogger.error(loggingCommonFormat + "  Encountered exception in InsertCallInfo.jsp : " + ex.toString());
			appSession.put("Event", "error");
		}
		debugLogger.debug(loggingCommonFormat + "  Event : " + appSession.getString("Event"));
		debugLogger.debug(loggingCommonFormat + "------- InsertCallInfo.jsp Exit -------");
		debugLogger.debug(loggingCommonFormat + "*********** END OF THE CALL ************");
		result.put("appSession", appSession);
	} catch (Exception e) {
		System.out.println("Exception in InsertCardTransHistory.jsp : " + e.toString());
	}
    return result;
    
};


/* public JSONObject performLogic(JSONObject state, Map<String, String> additionalParams)
{
	return new JSONObject();
} */

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/src/../include/backend.jspf", Long.valueOf(1641391982000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.genesyslab.studio.backendlogic.BackendLogManager");
    _jspx_imports_classes.add("org.json.JSONException");
    _jspx_imports_classes.add("org.json.JSONObject");
    _jspx_imports_classes.add("org.apache.logging.log4j.Logger");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.genesyslab.studio.backendlogic.GVPHttpRequestProcessor");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("application/json;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write(" \r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-cache");
response.addHeader("X-Frame-Options", "DENY");     // Setting the "DENY" Flag on response object to restrict browsers that support this header from allowing embedding web-pages in a frame

Logger logger = BackendLogManager.getLogger("backEnd");
String output = null;

try {
    // process the post data
    GVPHttpRequestProcessor processor = new GVPHttpRequestProcessor(request);
    processor.parseRequest();
    
    // "state" encapsulates the state variable submitted by the VXML page
    JSONObject state = processor.getState();
    
    // additional parameters that were passed in the namelist
    Map<String, String> additionalParams = processor.getAdditionalParams();
    
    // perform the logic
    JSONObject result = performLogic(state, additionalParams);
    
	output = result.toString();
    
    out.print(output);
    logger.info("Output: " + output);
    
} catch (Exception e) {
    
    //Removed the call to 'e.printstacktrace()' as printing the stack trace of an exception is a bad practice.
    
    //String msg = e.getMessage();
    //if (null != msg){
    //	msg = msg.replace('"', '\'');
    //}
    out.print("An error has occured in the custom backend JSP file");
	logger.error("An error has occured in the custom backend JSP file");
}

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}