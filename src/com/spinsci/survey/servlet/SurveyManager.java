package com.spinsci.survey.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spinsci.survey.core.Question;
import com.spinsci.survey.core.Survey;
import com.spinsci.survey.util.Constants;
import com.spinsci.survey.util.RequestUtil;
import com.spinsci.survey.util.eAction;

/**
 * Servlet implementation class SurveyManager
 */
/*@WebServlet("/survey")*/
public class SurveyManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyManager() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		PrintWriter writer = null;
		try {
			String fileLocation = RequestUtil.getFileLocation(this);
			Survey survey = new Survey(fileLocation);
			writer = response.getWriter();
			writer.print(survey.toJson());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = null;
		String fileLocation = RequestUtil.getFileLocation(this);
		eAction action = eAction.fromString(request
				.getParameter(Constants.ACTION));
		if (eAction.CREATE == action) {
			Question question = RequestUtil.getQuestion(request);
			Survey survey = new Survey(fileLocation);
			survey.addNew(question);

		} else if (eAction.EDIT == action) {
			Question question = RequestUtil.getQuestion(request);
			Survey survey = new Survey(fileLocation);
			survey.update(question);

		} else if (eAction.REMOVE == action) {
			String[] ids = request.getParameterValues(Constants.ID_REMOVE);
			Survey survey = new Survey(fileLocation);
			survey.remove(ids);

		}

		try {
			Survey survey = new Survey(fileLocation);
			writer = response.getWriter();
			writer.print(survey.toJson());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
