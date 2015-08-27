package com.sample.springmvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.springmvc.service.ProductManager;

@Controller
public class InventoryController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductManager productManager;

	@RequestMapping(value = "/inventory.htm")
	public ModelAndView handleRequestInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * ACA SE CREA LA COOKIE "JSESSIONID", AL OBTENER POR PRIMERA VEZ el
		 * request.getSession().getId()
		 */
		String sessionID = request.getSession().getId();

		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("sessionID", sessionID);
		myModel.put("products", this.productManager.getProducts());

		return new ModelAndView("inventory", "model", myModel);

	}

}