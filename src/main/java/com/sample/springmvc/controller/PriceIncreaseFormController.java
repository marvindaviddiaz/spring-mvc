package com.sample.springmvc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.springmvc.controller.beans.PriceIncreaseBean;
import com.sample.springmvc.service.ProductManager;

@Controller
@RequestMapping(value = "/price_increase.htm")
public class PriceIncreaseFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductManager productManager;

	/**
	 * El método onSubmit(..) será invocado cuando el usuario envíe del
	 * formulario a través del método POST. El uso de la anotación @Valid
	 * permitirá validar el incremento introducido y volverá a mostrar el
	 * formulario en caso de que éste no sea válido.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid PriceIncreaseBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return "price_increase";
		}
		int increase = bean.getPercentage();
		logger.info("Increasing prices by " + increase + "%.");
		productManager.increasePrice(increase);
		return "redirect:/inventory.htm";
	}

	/**
	 * Metodo que será invocado antes de que el formulario se muestre al usuario
	 * (petición GET) y rellenará el campo con un incremento por defecto de un
	 * 15%
	 */
	@RequestMapping(method = RequestMethod.GET)
	protected PriceIncreaseBean formBackingObject(HttpServletRequest request) throws ServletException {
		PriceIncreaseBean bean = new PriceIncreaseBean();
		bean.setPercentage(15);
		return bean;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

}
