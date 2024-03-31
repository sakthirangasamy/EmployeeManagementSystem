package com.jspiders.emsapplication;

import java.util.Objects;

public class EMPBean
{
		private int id;
		private String name,password,email,country;
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		@Override
		public String toString() {
			return "EMPBean [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country="
					+ country + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(country, email, id, name, password);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EMPBean other = (EMPBean) obj;
			return Objects.equals(country, other.country) && Objects.equals(email, other.email) && id == other.id
					&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
		}
}
