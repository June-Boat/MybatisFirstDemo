package cn.com.mybatis.po;

public class BatchInfo extends Batch {
		private String username;
		private String acno;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getAcno() {
			return acno;
		}
		public void setAcno(String acno) {
			this.acno = acno;
		}
		@Override
		public String toString() {
			return super.toString() +" [username=" + username + ", acno=" + acno  +  "]";
		}
		
		
		
}
