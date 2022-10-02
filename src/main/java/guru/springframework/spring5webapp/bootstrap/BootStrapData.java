package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author MEEO
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("sfg publisher");
        publisher.setCity("st lagos");
        publisher.setState("LG");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: "+publisherRepository.count());


        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123422");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEjb = new Book("J2ee dev with ejb","888388388");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Publisher Number of Books: "+publisher.getBooks().size());
    }
}
