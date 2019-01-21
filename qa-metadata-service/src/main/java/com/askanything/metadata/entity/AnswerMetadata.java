package com.askanything.metadata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AnswerMetadata {

	@Id
	private int answerId;
	private int voteCount;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	
}
