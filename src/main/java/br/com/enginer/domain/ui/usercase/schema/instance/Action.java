package br.com.enginer.domain.ui.usercase.schema.instance;

/**
 * 
 */
public class Action {

	private String redirect;
	private String clientMethod;
	private String serverMethod;
	private ActionObject domain;

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

	public ActionObject getDomain() {
		return domain;
	}

	public void setDomain(ActionObject domain) {
		this.domain = domain;
	}

}
