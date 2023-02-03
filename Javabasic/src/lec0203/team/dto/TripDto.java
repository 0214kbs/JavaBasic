package lec0203.team.dto;

public class TripDto {
	/** 관광지명 */
	private String touristDestination;
	/** 관광지 도로명주소 */
	private String streetAddress;
	/** 관광지 지번주소 */
	private String lotAddress;
	/** 관광지 위도 */
	private double lat;
	/** 관광지 경도 */
	private double lng;
	/** 관광지 상세설명 */
	private String info;


	public String getTouristDestination() {
		return touristDestination;
	}

	public void setTouristDestination(String touristDestination) {
		this.touristDestination = touristDestination;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLotAddress() {
		return lotAddress;
	}

	public void setLotAddress(String lotAddress) {
		this.lotAddress = lotAddress;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}



	public TripDto(String touristDestination, String streetAddress) {
		super();
		this.touristDestination = touristDestination;
		this.streetAddress = streetAddress;
	}



	public TripDto(String touristDestination, String streetAddress, String lotAddress, double lat, double lng,
			String info) {
		super();
		this.touristDestination = touristDestination;
		this.streetAddress = streetAddress;
		this.lotAddress = lotAddress;
		this.lat = lat;
		this.lng = lng;
		this.info = info;
	}

	@Override
	public String toString() {
		return "TripDto [touristDestination=" + touristDestination + ", streetAddress=" + streetAddress
				+ ", lotAddress=" + lotAddress + ", lat=" + lat + ", lng=" + lng + ", info=" + info + "]";
	}

	
	
}
