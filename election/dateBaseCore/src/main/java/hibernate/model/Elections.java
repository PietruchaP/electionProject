package hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "elections")
public class Elections {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column (name="id")
		private int id;
		@Column (name ="election_date")
		private Date election_date;
		@Column (name = "type")
		private String type;
		
		public Elections(){
			
		}
		public Elections(int id){
			this.id = id;
		}
		public Elections(int id, Date date, String type){
			this.id = id;
			this.election_date = date;
			this.type = type;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public Date getElection_date() {
			return election_date;
		}
		public void setElection_date(Date election_date) {
			this.election_date = election_date;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((election_date == null) ? 0 : election_date.hashCode());
			result = prime * result + id;
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			Elections other = (Elections) obj;
			if (election_date == null) {
				if (other.election_date != null)
					return false;
			} else if (!election_date.equals(other.election_date))
				return false;
			if (id != other.id)
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		
}
