package com.vn.datn.service;

import com.vn.datn.dto.MailInfo;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;



import java.io.IOException;


@Service
public interface SendMailService {
	void run();

	void queue(String to, String subject, String body);

	void queue(MailInfo mail);

	void send(MailInfo mail) throws MessagingException, IOException;
}
