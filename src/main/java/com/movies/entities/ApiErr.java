package com.movies.entities;

import org.springframework.http.HttpStatus;

public class ApiErr {

		private HttpStatus status;
		private String msg;
		public HttpStatus getStatus() {
			return status;
		}
		public void setStatus(HttpStatus status) {
			this.status = status;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
}
