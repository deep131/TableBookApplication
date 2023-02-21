package com.example.tablebook;


public class MyData {

    private String resname;
    private String area;
    private Integer resimage;

    public MyData(String movieName, String movieDate, Integer movieImage) {
        this.resname = movieName;
        this.area = movieDate;
        this.resimage = movieImage;
    }



    public String getResName() {
        return resname;
    }

    public void setMovieName(String movieName) {
        this.resname = resname;
    }

    public String getMovieDate() {
        return area;
    }

    public void setMovieDate(String movieDate) {
        this.area = area;
    }

    public Integer getMovieImage() {
        return resimage;
    }

    public void setMovieImage(Integer movieImage) {
        this.resimage = resimage;
    }
}