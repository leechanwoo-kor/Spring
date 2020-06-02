package spring.chap06.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.chap06.model.Address;
import spring.chap06.model.MemberInfo;

public class MemberInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberInfo memberInfo = (MemberInfo) target;
		if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
		}
		if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		Address address = memberInfo.getAddress();
		if (address == null) {
			errors.rejectValue("address", "required");
		}
		if (address != null) {
			errors.pushNestedPath("address");
			try {
				if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
					errors.rejectValue("zipcode", "required");
				} else if (address.getZipcode().equals("000000")) {
					errors.rejectValue("zipcode", "isDefaultValue");
				}
				if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
					errors.rejectValue("address1", "required");
				}
				if (address.getAddress2() == null || address.getAddress2().trim().isEmpty()) {
					errors.rejectValue("address2", "required");
				}
			} finally {
				errors.popNestedPath();
			}
		}
	}
}
