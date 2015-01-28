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
}
