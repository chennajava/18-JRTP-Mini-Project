/**
 * 
 */
package in.chennait.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.chennait.bindings.ContactForm;
import in.chennait.service.ContactService;

/**
 * @author Chenna
 *
 */
@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		String status = service.saveContact(form);
		return status;
	}

	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts() {
		List<ContactForm> viewContacts = service.viewContacts();
		return viewContacts;
	}

	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		ContactForm editContact = service.editContact(contactId);
		return editContact;
	}

	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		List<ContactForm> deleteContact = service.deleteContact(contactId);
		return deleteContact;
	}
}
