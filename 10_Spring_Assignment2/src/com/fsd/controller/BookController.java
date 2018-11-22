package com.fsd.controller;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsd.entity.Book;
import com.fsd.entity.Subject;
import com.fsd.utility.GeneralUtility;

@Controller
public class BookController {

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@RequestParam("bookId") int bookId, Model model) throws IOException {
		Set<Book> foundBooks = new HashSet<>();
		Set<Subject> subjects = new HashSet<>();
		ObjectInputStream oi = GeneralUtility.getObjectInputStream();
		while (true) {
			Object obj;
			try {
				obj = oi.readObject();
				if (obj instanceof Book) {
					foundBooks.add((Book) obj);
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

		Set<Book> foundDeletionBooks = new HashSet<>();
		boolean bookDeleted = false;
		for (Book book : foundBooks) {
			if (book.getBookId() == bookId) {
				foundDeletionBooks.add(book);
				bookDeleted = true;
			}
		}
		foundBooks.removeAll(foundDeletionBooks);

		new FileOutputStream("binary.ser").close();

		ObjectOutputStream out1 = GeneralUtility.getObjectOutputStream();

		for (Book book : foundBooks) {
			out1.writeObject(book);
		}
		for(Subject sub:subjects) {
			out1.writeObject(sub);
		}

		if (bookDeleted) {
			model.addAttribute("message", "Book has been deleted");
		} else {
			model.addAttribute("message", "Book not Found");
		}
		return "deleteBook";
	}

	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public String searchBook(@RequestParam("bookId") int bookId, Model model) throws IOException {
		Set<Book> books = new HashSet<>();
		ObjectInputStream oi = GeneralUtility.getObjectInputStream();
		while (true) {
			Object obj;
			try {
				obj = oi.readObject();
				if (obj instanceof Book) {
					books.add((Book) obj);
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
		

		model.addAttribute("books", books);

		return "searchBook";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@RequestParam("bookId") int bookId, @RequestParam("title") String title,
			@RequestParam("price") double price, @RequestParam("volume") int volume,
			@RequestParam("publishDate") @DateTimeFormat(pattern = "dd/MM/yyyy") Date date,
			@RequestParam("subjectId") int subjectId,
			@RequestParam("subjectTitle") String subjectTitle,
			@RequestParam("durationInHours") int durationInHours, Model model) {
		Book book = new Book();
		book.setBookId(bookId);
		book.setPrice(price);
		book.setPublishDate(date);
		book.setTitle(title);
		book.setVolume(volume);
		System.out.println(book.toString());
		
		Subject subject=new Subject();
		subject.setSubjectId(subjectId);
		subject.setSubTitle(subjectTitle);
		subject.setDurationInHours(durationInHours);
		ObjectOutputStream out = GeneralUtility.getObjectOutputStream();
		try {
			out.writeObject(book);
			out.writeObject(subject);
			model.addAttribute("message", "Book  has been added successfully");
		} catch (IOException e) {
			model.addAttribute("message", "OOP... Something went wrong book has not added");
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "addBook";
	}

}
