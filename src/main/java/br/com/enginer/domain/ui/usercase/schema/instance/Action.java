package br.com.enginer.domain.ui.usercase.schema.instance;

/**
 * 
 */
public class Action {

	private String ui;
	private String redirect;
	private String clientMethod;
	private String serverMethod;
	private String param;
	private ActionObject domain;
	private ActionResponse response;
	
	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getClientMethod() {
		return clientMethod;
	}

	public void setClientMethod(String clientMethod) {
		this.clientMethod = clientMethod;
	}

	public String getServerMethod() {
		return serverMethod;
	}

	public void setServerMethod(String serverMethod) {
		this.serverMethod = serverMethod;
	}
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public ActionObject getDomain() {
		return domain;
	}

	public void setDomain(ActionObject domain) {
		this.domain = domain;
	}

	public ActionResponse getResponse() {
		return response;
	}

	public void setResponse(ActionResponse response) {
		this.response = response;
	}
}
