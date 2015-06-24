package com.spinsci.survey.util;

public enum eAction {
	CREATE("create"), EDIT("edit"), REMOVE("remove");
	String action;

	eAction(String action) {
		this.action = action;
	}

	public String toString() {
		return action;
	}

	public static eAction fromString(String text) {
		if (text != null) {
			for (eAction action : eAction.values()) {
				if (text.equalsIgnoreCase(action.action)) {
					return action;
				}
			}
		}
		return null;
	}

}
