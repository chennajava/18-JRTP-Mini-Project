package in.chennait.service;

import java.util.List;

import in.chennait.bindings.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm form);

	public List<ContactForm> viewContacts();

	public ContactForm editContact(Integer contactId);

	public List<ContactForm> deleteContact(Integer contactId);

}
