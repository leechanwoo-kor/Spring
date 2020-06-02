package spring.chap06.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.chap06.model.Address;
import spring.chap06.model.MemberInfo;
import spring.chap06.validator.MemberInfoValidator;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {

	@ModelAttribute("command")
	public MemberInfo formBacking(HttpServletRequest request) {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			mi.setAddress(address);
			return mi;
		} else {
			return new MemberInfo();
		}
	}
	
	private String autoDetectZipcode(String remoteAddr) {
		return "000000";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") MemberInfo memberInfo, BindingResult result) {
		new MemberInfoValidator().validate(memberInfo, result);
		if(result.hasErrors()) {
			return "account/creationForm";
		}
		return "account/created";
	}
}
