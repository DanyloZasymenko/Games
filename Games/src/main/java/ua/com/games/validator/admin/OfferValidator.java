package ua.com.games.validator.admin;

import org.springframework.stereotype.Component;

import ua.com.games.entity.Offer;
import ua.com.games.validator.main.ValidationException;
import ua.com.games.validator.main.Validator;

@Component("offerValidator")
public class OfferValidator implements Validator<Offer>{
	
	@Override
	public void validate(Offer object) throws Exception {
		
		Offer offer = (Offer) object;
		
		if(offer.getName().isEmpty()){
			throw new ValidationException(AdminValidationMessages.EMPTY_OFFER_FIELD);
		}
	
		if(offer.getPrice() < 0){
			throw new ValidationException(AdminValidationMessages.WRONG_PRICE);
		}
		
	}

}
