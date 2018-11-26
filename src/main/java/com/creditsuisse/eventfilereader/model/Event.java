package com.creditsuisse.eventfilereader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String idevent;
	
	@Column(nullable = false)
	private Long duration;
	
	@Column(nullable = true)
	private String eventtype;
	
	@Column(nullable = true)
	private String host;
	
	@Column(nullable = true)
	private boolean alert;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdevent() {
		return idevent;
	}

	public void setIdevent(String idevent) {
		this.idevent = idevent;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alert ? 1231 : 1237);
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((eventtype == null) ? 0 : eventtype.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idevent == null) ? 0 : idevent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (alert != other.alert)
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (eventtype == null) {
			if (other.eventtype != null)
				return false;
		} else if (!eventtype.equals(other.eventtype))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idevent == null) {
			if (other.idevent != null)
				return false;
		} else if (!idevent.equals(other.idevent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", idevent=" + idevent + ", duration=" + duration + ", eventtype=" + eventtype
				+ ", host=" + host + ", alert=" + alert + "]";
	}

	
}
