package com.spinsci.survey.util;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.spinsci.survey.core.Question;

public class RequestUtil {
	public static Question getQuestion(HttpServletRequest request) {
		String curQue = request.getParameter(Constants.CUR_QUE);
		String enAudio = request.getParameter(Constants.ENAUDIO);
		String esAudio = request.getParameter(Constants.ESAUDIO);
		String rowId = request.getParameter(Constants.ID);
		String questionText = request.getParameter(Constants.NAME);
		String nextQue = request.getParameter(Constants.NEXT_QUE);
		String options = request.getParameter(Constants.OPTIONS);

		Question question = new Question();

		question.setEnglishAudio(enAudio);
		question.setSpanishAudio(esAudio);
		question.setQuestionText(questionText);

		if (curQue != null && curQue.length() > 0)
			question.setCurrentQuestion(Integer.parseInt(curQue));
		if (nextQue != null && nextQue.length() > 0)
			question.setNextQuestion(Integer.parseInt(curQue));
		if (options != null && options.length() > 0)
			question.setNoOfOtions(Integer.parseInt(options));

		if (rowId != null && rowId.length() > 0)
			question.setRowId(rowId);

		return question;
	}

	public static String getFileLocation(HttpServlet servlet) {
		Properties properties = new Properties();
		try {
			properties.load(servlet.getServletContext().getResourceAsStream(
					"/WEB-INF/config.properties"));
			return properties.getProperty("fileLocation");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
