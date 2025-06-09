package cp213;

import java.io.PrintStream;

/**
 * Movie class definition.
 *
 * @author your name, id, email here
 * @version 2024-09-01
 */
    /**
     * Instantiates a Movie object.
     *
     * @param title    Movie title.
     * @param year     Year of release.
     * @param director Name of director.
     * @param rating   Rating of 1 - 10 from IMDB.
     * @param genre    Number representing Movie genre.
     */

    public class Movie implements Comparable<Movie> {

        // Constants
        public static final int FIRST_YEAR = 1888;
        public static final String[] GENRES = {
            "science fiction", "fantasy", "drama", "romance", "comedy", 
            "zombie", "action", "historical", "horror", "war", "mystery"
        };
        public static final double MAX_RATING = 10.0;
        public static final double MIN_RATING = 0.0;

        // Attributes
        private String director = "";
        private int genre = -1;
        private double rating = 0;
        private String title = "";
        private int year = 0;

        /**
         * Instantiates a Movie object.
         *
         * @param title    Movie title.
         * @param year     Year of release.
         * @param director Name of director.
         * @param rating   Rating of 1 - 10 from IMDB.
         * @param genre    Number representing Movie genre.
         */
        public Movie(final String title, final int year, final String director, final double rating, final int genre) {
            this.title = title;
            this.year = year;
            this.director = director;
            this.rating = rating;
            this.genre = genre;
        }

        /**
         * Creates a string of movie genres in the format:
         *
         * <pre>
         * 0: science fiction
         * 1: fantasy
         * ...
         * </pre>
         *
         * @return A formatted numbered string of Movie genres.
         */
        public static String genresMenu() {
            StringBuilder menu = new StringBuilder();
            for (int i = 0; i < GENRES.length; i++) {
                menu.append(i).append(": ").append(GENRES[i]).append("\n");
            }
            return menu.toString();
        }

        /**
         * Movies are compared by title, then by year if the titles match. Must ignore
         * case.
         */
        @Override
        public int compareTo(final Movie target) {
            int titleComparison = this.title.compareToIgnoreCase(target.title);
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Integer.compare(this.year, target.year);
        }

        /**
         * Converts a genre integer to a string.
         *
         * @return The string version of the genre number.
         */
        public String genreToName() {
            if (genre >= 0 && genre < GENRES.length) {
                return GENRES[genre];
            }
            return "Unknown Genre";
        }

        // Getters
        public String getDirector() {
            return director;
        }

        public int getGenre() {
            return genre;
        }

        public double getRating() {
            return rating;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        /**
         * Creates a formatted string of Movie key data in the format "title, year". Ex:
         * "Zulu, 1964".
         *
         * @return A Movie key as a string.
         */
        public String key() {
            return String.format("%s, %d", this.title, this.year);
        }

        /**
         * Rating setter.
         *
         * @param rating The new rating.
         */
        public void setRating(final double rating) {
            if (rating >= MIN_RATING && rating <= MAX_RATING) {
                this.rating = rating;
            } else {
                throw new IllegalArgumentException("Rating must be between " + MIN_RATING + " and " + MAX_RATING);
            }
        }

        /**
         * Returns a string in the format:
         *
         * <pre>
         * Title:    title
         * Year:     year
         * Director: director
         * Rating:   rating
         * Genre:    genre
         * </pre>
         */
        @Override
        public String toString() {
            return String.format("Title:    %s%nYear:     %d%nDirector: %s%nRating:   %.1f%nGenre:    %s", 
                                 title, year, director, rating, genreToName());
        }

        /**
         * Writes a single line of movie data to an open PrintStream in the format:
         * title|year|director|rating|genre
         *
         * @param ps Output PrintStream.
         */
        public void write(final PrintStream ps) {
            ps.printf("%s|%d|%s|%.1f|%s%n", 
                      title, year, director, rating, genreToName());
        }
    }
