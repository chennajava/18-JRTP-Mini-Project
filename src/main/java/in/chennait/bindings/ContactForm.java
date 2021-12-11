package in.chennait.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long conctNumber;
	private String activeWf;
	private LocalDate createdDate;
	private LocalDate updatedDate;

}
