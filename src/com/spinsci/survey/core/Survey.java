package com.spinsci.survey.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Survey {

	private SurveyBean survey;
	private Gson gson;
	private String fileLoc;

	public Survey(String fileLocation) {
		gson = new GsonBuilder().setPrettyPrinting().create();
		fileLoc = fileLocation;
		try {
			FileReader fileReader = new FileReader(fileLoc);
			BufferedReader buffered = new BufferedReader(fileReader);
			survey = gson.fromJson(buffered, SurveyBean.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addNew(Question question) {
		question.setRowId(UUID.randomUUID().toString());
		survey.getQuestions().add(question);
		commit();

	}

	public void remove(String[] newRowIds) {
		Set<String> idsToRemove = new HashSet<String>();
		for (String id : newRowIds)
			idsToRemove.add(id);

		List<Question> questions = survey.getQuestions();
		Iterator<Question> iterator = questions.iterator();
		while (iterator.hasNext()) {
			Question question = iterator.next();
			if (idsToRemove.contains(question.getRowId()))
				iterator.remove();
		}
		commit();
	}

	public void update(Question question) {
		List<Question> questions = survey.getQuestions();
		String rowId = question.getRowId();
		for (Question que : questions) {
			if (que.getRowId().equals(rowId)) {
				que.setCurrentQuestion(question.getCurrentQuestion());
				que.setEnglishAudio(question.getEnglishAudio());
				que.setSpanishAudio(question.getSpanishAudio());
				que.setQuestionText(question.getQuestionText());
				que.setNextQuestion(question.getNextQuestion());
				que.setNoOfOtions(question.getNoOfOtions());
			}
		}
		commit();

	}

	private void commit() {
		String json = gson.toJson(survey);
		try {
			FileWriter writer = new FileWriter(fileLoc);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return gson.toJson(survey, SurveyBean.class);

	}

	public String toJson() {
		return gson.toJson(survey, SurveyBean.class);

	}

}
