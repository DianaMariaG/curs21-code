package ro.fasttrackit.curs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.homework.model.Actor;
import ro.fasttrackit.curs21.homework.model.Movie;
import ro.fasttrackit.curs21.homework.model.MovieRating;
import ro.fasttrackit.curs21.homework.model.Review;
import ro.fasttrackit.curs21.homework.repository.MovieRatingRepository;
import ro.fasttrackit.curs21.homework.repository.MovieRepository;
import ro.fasttrackit.curs21.homework.repository.ReviewRepository;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;

import static ro.fasttrackit.curs21.model.TransactionType.BUY;
import static ro.fasttrackit.curs21.model.TransactionType.SELL;

@SpringBootApplication
public class Curs21CodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Curs21CodeApplication.class, args);
	}

//	@Bean
//		CommandLineRunner atStartup(TransactionRepository repository) {
//		return args -> {
//			repository.saveAll(List.of(
//					new Transaction("cioco",BUY,10),
//					new Transaction("mere",SELL,200),
//					new Transaction("pere",BUY,40)
//			));
//		};
//	}

	@Bean
	CommandLineRunner atStartup (MovieRepository repository,
								 MovieRatingRepository movieRatingRepository,
								 ReviewRepository reviewRepository) {
		MovieRating movieRating1 = new MovieRating(88, "Coco");
		Review review1 = new Review("John","Very good");
	return args -> {
		movieRatingRepository.save(movieRating1);
		reviewRepository.save(review1);
		repository.saveAll(List.of(
				new Movie("Waterfall", 1998),
				new Movie(movieRating1,"Crystal",2000)
//				new Movie(null, List.of(reviewRepository.getById(review1.getId())),"Alfa",1999) //nu merge
//				new Movie (null, null, null, List.of(new Actor("Johnny Depp", 1963)),"Pirates",2010) //nu merge
		));
	};
	}
}
