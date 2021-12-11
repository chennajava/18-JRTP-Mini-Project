package in.chennait.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.chennait.bindings.ContactForm;
import in.chennait.entities.Contact;
import in.chennait.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {
		// We have received form data binding object as a parameter
		// Repository save(entity) method expected as entity object
		// so that we can copy from form binding object to enitity object
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveWf("Y");
		entity = contactRepo.save(entity);
		if (entity.getContactId() != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {
		// Get all the contact details from DB
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();
		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		// Get Data from DB and edit it
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}

		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		// delete by id and display remaining contact details
		contactRepo.deleteById(contactId);
		// return viewContacts() ;
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();
		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

}
