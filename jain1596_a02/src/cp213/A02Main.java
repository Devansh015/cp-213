package cp213;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sample testing for Assignment 2.
 *
 * @author David Brown
 * @version 2024-09-01
 */
public class A02Main {
    // Constants
    private static final String LINE = "-".repeat(40);

    /**
     * Test
     *
     * @param args unused
     */
    public static void main(final String[] args) {
	// Sets console I/O to UTF-8 (Required for Windows as of Java 18.)
	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
	System.out.println("Assignment 2 Methods Tests");
	System.out.println();
	testMovie();
    }

    /**
     *
     */
    public static void testMovie() {
	testMovieCompareTo();
	System.out.println("List of genres:");
	System.out.println(Movie.genresMenu());
	System.out.println(LINE);
	System.out.println("New Movie Object:");
	Movie movie = new Movie("Dark City", 1998, "Alex Proyas", 7.8, 0);
	System.out.println(movie);
	System.out.println(LINE);
	System.out.println("Getters for Dark City");
	System.out.println("Title: " + movie.getTitle());
	System.out.println("Year: " + movie.getYear());
	System.out.println("Genre (int): " + movie.getGenre());
	System.out.println("Genre (String): " + movie.genreToName());
	System.out.println("Directory: " + movie.getDirector());
	System.out.println("Rating: " + movie.getRating());
	System.out.println(LINE);
	System.out.println("Get Movie from keyboard:");

	final Scanner keyboard = new Scanner(System.in);
	movie = MovieUtilities.getMovie(keyboard);
	System.out.println();
	System.out.println(movie);
	System.out.println(LINE);
	System.out.println("readFood from string");
	String line = "Dark City|1998|Alex Proyas|7.8|0";
	movie = MovieUtilities.readMovie(line);
	System.out.println(movie);
	System.out.println(LINE);
	System.out.println(LINE);
	System.out.println("Read Movies from file:");
	ArrayList<Movie> movies = null;
	try {
	    final File file = new File("movies.txt");
	    Scanner fileIn = new Scanner(file);
	    movies = MovieUtilities.readMovies(fileIn);
	    fileIn.close();
	} catch (FileNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	for (final Movie m : movies) {
	    System.out.println(m);
	}
	System.out.println(LINE);
	int[] counts = MovieUtilities.genreCounts(movies);
	int n = Movie.GENRES.length;

	for (int i = 0; i < n; i++) {
	    System.out.println(Movie.GENRES[i] + ": " + counts[i]);
	}

	System.out.println(LINE);
	System.out.print("Movie year: ");
	int year = keyboard.nextInt();
	keyboard.nextLine();
	System.out.println();
	System.out.println(LINE);
	ArrayList<Movie> temp = MovieUtilities.getByYear(movies, year);

	for (Movie m : temp) {
	    System.out.println(m);
	}
	System.out.println(LINE);
	System.out.print("Movie rating: ");
	double rating = keyboard.nextDouble();
	keyboard.nextLine();
	System.out.println();
	temp = MovieUtilities.getByRating(movies, rating);

	for (Movie m : temp) {
	    System.out.println(m);
	}
	System.out.println(LINE);
	System.out.println("Movie genre: ");
	int genre = MovieUtilities.readGenre(keyboard);
	System.out.println();
	temp = MovieUtilities.getByGenre(movies, genre);

	for (Movie m : temp) {
	    System.out.println(m);
	}
	System.out.println(LINE);
	System.out.println("Comparisons");
	testMovieCompareTo();
    }

    /**
     *
     * Movie movie = new Movie("Dark City", 1998, "Alex Proyas", 7.8, 0);
     *
     */
    public static void testMovieCompareTo() {
	Movie movie = new Movie("Les Misérables", 1998, "Bille August", 7.4, 2);
	Movie prevMovie = new Movie("Les Misérables", 1978, "Glenn Jordan", 7.3, 2);
	Movie nextMovie = new Movie("Les Misérables", 2019, "Ladj Ly", 7.6, 2);
	Movie firstMovie = new Movie("Ad Astra", 2019, "James Gray", 6.5, 0);
	Movie lastMovie = new Movie("Szechuan Shrimp", 1969, "Costa Gravas", 8.2, 2);

	System.out.println("Compare Les Misérables to itself (expects 0): " + movie.compareTo(movie));
	System.out.println("Compare Les Misérables to Ad Astra (expects > 0): " + movie.compareTo(firstMovie));
	System.out.println("Compare Les Misérables to Z (expects < 0): " + movie.compareTo(lastMovie));
	System.out.println(
		"Compare Les Misérables (1998) to Les Misérables (1978)  (expects > 0): " + movie.compareTo(prevMovie));
	System.out.println(
		"Compare Les Misérables (1998) to Les Misérables (2019) (expects < 0): " + movie.compareTo(nextMovie));
    }

}
