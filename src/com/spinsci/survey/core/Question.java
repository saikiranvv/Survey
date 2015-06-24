package com.spinsci.survey.core;

import com.google.gson.annotations.SerializedName;

public class Question {
	@SerializedName("cur_que")
	int currentQuestion;

	@SerializedName("name")
	String questionText;

	@SerializedName("options")
	int noOfOtions;

	@SerializedName("next_que")
	int nextQuestion;

	@SerializedName("enaudio")
	String englishAudio;

	@SerializedName("esaudio")
	String spanishAudio;

	@SerializedName("DT_RowId")
	String rowId;

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getNoOfOtions() {
		return noOfOtions;
	}

	public void setNoOfOtions(int noOfOtions) {
		this.noOfOtions = noOfOtions;
	}

	public int getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(int nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public String getEnglishAudio() {
		return englishAudio;
	}

	public void setEnglishAudio(String englishAudio) {
		this.englishAudio = englishAudio;
	}

	public String getSpanishAudio() {
		return spanishAudio;
	}

	public void setSpanishAudio(String spanishAudio) {
		this.spanishAudio = spanishAudio;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

}
