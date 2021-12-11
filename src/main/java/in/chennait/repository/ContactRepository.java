package in.chennait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.chennait.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
