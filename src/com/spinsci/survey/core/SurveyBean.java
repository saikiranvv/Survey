package com.spinsci.survey.core;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SurveyBean {
	@SerializedName("data")
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}



}
