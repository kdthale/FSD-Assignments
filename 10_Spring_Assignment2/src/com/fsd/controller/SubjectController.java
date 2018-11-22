package com.fsd.controller;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsd.entity.Book;
import com.fsd.entity.Subject;
import com.fsd.utility.GeneralUtility;

@Controller
public class SubjectController {

	@RequestMapping(value = "/deleteSubject", method = RequestMethod.POST)
	public String deleteSubject(@RequestParam("subjectId") int subjectId, Model model) throws IOException {
		Set<Subject> subjects = new HashSet<>();
		Set<Book> books = new HashSet<>();
		Set<Subject> foundSubject=new HashSet<>();
		
		
		ObjectInputStream oi = GeneralUtility.getObjectInputStream();
		while (true) {
			Object obj;
			try {
				obj = oi.readObject();
				if (obj instanceof Book) {
					books.add((Book) obj);
				}
				if(obj instanceof Subject) {
					subjects.add((Subject)obj);
				}
			} catch (EOFException e) {
				break;
			} catch (ClassNotFoundException e) {
				model.addAttribute("message", "OOP... Something went wrong book cannot be deleted");
				e.printStackTrace();
			} catch (IOException e) {
				model.addAttribute("message", "OOP... Something went wrong book has cannot be deleted");
				e.printStackTrace();
			}
		}

		oi.close();
		boolean subjectDeleted = false;
		for(Subject subject:subjects) {
			if(subject.getSubjectId()==subjectId) {
				foundSubject.add(subject);
				subjectDeleted=true;
				break;
			}
		}
		
		subjects.removeAll(foundSubject);
		new FileOutputStream("binary.ser").close();
		ObjectOutputStream out1=GeneralUtility.getObjectOutputStream();
		for(Subject subject:subjects) {
			out1.writeObject(subject);
		}
		for(Book book:books) {
			out1.writeObject(book);
		}
		
		if (subjectDeleted) {
			model.addAttribute("message", "Subject has been deleted");
		} else {
			model.addAttribute("message", "Subject not Found");
		}
		out1.close();
		
		return "deleteSubject";
	}
	
	@RequestMapping(value = "/searchSubject", method = RequestMethod.POST)
	public String searchSubject(@RequestParam("subjectId") int subjectId, Model model) throws IOException {
		Set<Subject> subjects = new HashSet<>();
		ObjectInputStream oi = GeneralUtility.getObjectInputStream();
		while (true) {
			Object obj;
			try {
				obj = oi.readObject();
				if (obj instanceof Subject) {
					subjects.add((Subject) obj);
				}
			} catch (EOFException e) {
				// model.addAttribute("message","OOP... Something went wrong book has not
				// Found");
				break;
			} catch (ClassNotFoundException e) {
				model.addAttribute("message", "OOP... Something went wrong book has not Found");
				e.printStackTrace();
			} catch (IOException e) {
				model.addAttribute("message", "OOP... Something went wrong book has not Found");
				e.printStackTrace();
			}
		}
		
		oi.close();
		
		Subject sub=new Subject();
		for(Subject subject:subjects) {
			if(subject.getSubjectId()==subjectId) {
				sub=subject;
			}
		}

		Set<Subject> foundSubjects = new HashSet<>();
		foundSubjects.add(sub);
		model.addAttribute("subjects", foundSubjects);

		return "searchSubject";
		
	}
	
}
