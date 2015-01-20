package TOs;

import java.util.Date;

public class Elections {

		private int id;
		private String type;
		private Date election_date;
		
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
