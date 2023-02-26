package com.WeatherCheck.model;


public class OpencageResponse {
    	private Result[] results;
    	
    	
    	
    	public OpencageResponse(Result[] results) {
			super();
			this.results = results;
		}

		public OpencageResponse() {
			
		}

		public Result[] getResults() {
    		return results;
    	}

        public void setResults(Result[] results) {
        	this.results = results;
    	}


    public static class Result {
    	private Geometry geometry;
    	
    	
    	public Result() {
			
		}
    	
		public Result(Geometry geometry) {
			super();
			this.geometry = geometry;
		}

		public Geometry getGeometry() {
        	return geometry;
    	}

    	public void setGeometry(Geometry geometry) {
        	this.geometry = geometry;
    	}
    }

    public static class Geometry {
    	private double lat;
    	private double lng;
    	
    	
    	public Geometry() {
			
		}
    	
		public Geometry(double lat, double lng) {
			super();
			this.lat = lat;
			this.lng = lng;
		}

		public double getLat() {
        	return lat;
    	}

    	public void setLat(double lat) {
        	this.lat = lat;
    	}

    	public double getLng() {
        	return lng;
    	}

    	public void setLng(double lng) {
        	this.lng = lng;
    	}
    }
}

