package tr.com.sedatpolat.datastructures.test.graphandtree;

import java.io.Serializable;

/**
 * 
 * @author sedpol
 *
 */
public class Movie implements Comparable<Movie>, Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private Double rate;

	public Movie(int id, String title, double scor) {
		super();
		this.id = id;
		this.title = title;
		this.rate = scor;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public int compareTo(Movie o) {
		return rate.compareTo(o.rate);
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", scor=" + rate + "]";
	}
}
